package com.hyuyuna.narcissus.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyuyuna.narcissus.common.CommonUtils;
import com.hyuyuna.narcissus.common.SHA256;
import com.hyuyuna.narcissus.common.SessionManager;
import com.hyuyuna.narcissus.service.FateService;
import com.hyuyuna.narcissus.vo.MemberVO;

@Controller
public class FateController {
	
	@Resource(name="fateService")
	private FateService service;
	
	@Autowired
	private SessionManager sessionManager;
	
	@Value("#{directory['globals.filesDir']}")
	private String imagesDir;
	
	 public interface sessionDefine {
		 String loginFate = "HyuYuna";
	 } 
	
	@RequestMapping(value="/main.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String main() {
		
		return "redirect:memberList.do";
		
	}
	
	// 로그인
	@RequestMapping(value="login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login() {
		
		return "login";
		
	}
	
	// 로그아웃
	@RequestMapping(value="/logout.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpServletResponse response, HttpServletRequest request) {
		/*expiredCookie(response, "memberId");
		try {
			sessionManager.expire(request);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:login.do"; 
	}
	
	// 쿠키 만료시간 설정
	private void expiredCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	} 
	
	// 로그인
	@RequestMapping(value="/actionLogin.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(MemberVO vo, ModelMap model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		try {
			String decrypt = SHA256.encrypt(vo.getPwd());
			vo.setCheckPwd(decrypt);
			MemberVO member = service.login(vo);
			if (member == null) {
				model.addAttribute("message","로그인에 실패하였습니다");
				return "redirect:login.do";
			} else {
				/*
				 * Cookie idCookie = new Cookie("memberId", String.valueOf(member.getId()));
				 * response.addCookie(idCookie);
				 */
				/*sessionManager.createSession(member, response);*/
				HttpSession session = request.getSession();
				session.setAttribute("login", member);
				session.setMaxInactiveInterval(3000);
				
				return "redirect:main.do";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "로그인에 실패하였습니다");
			return "redirect:login.do";
		}
		
	}
	
	
	// 회원 가입
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(MemberVO vo) throws Exception {
		
		try {
			String shaPass = SHA256.getSHA256(vo.getPwd());
			vo.setPwd1(shaPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		service.joinUser(vo);
		
		return "redirect:memberList.do";
	}
	
	// 회원 수정
	@RequestMapping(value="/editUser.do")
	public String editUser(MemberVO vo, Model model) throws Exception {

		try {
			String shapass = SHA256.getSHA256(vo.getPwd());
			vo.setPwd1(shapass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		service.editUser(vo);
		
		return "redirect:memberList.do";
	}
	
	// 아이디 중복체크
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		
		int check = service.idCheck(id);
		
		return check;
	}
	
	
	// 이미지 파일 가져오기
	@RequestMapping(value="/getImage.do")
	public void getImage(HttpServletRequest req, HttpSession session, HttpServletResponse res) throws Exception {
		
		String realFile = imagesDir;
		String fileNm = req.getParameter("fileNm");
		fileNm = fileNm.replaceAll("/images/", "");
		
		String ext = fileNm.substring(fileNm.lastIndexOf("."));
		
		String[] exts = new String[] { "jpg", "jpeg", "bmp", "png" };
		
		boolean uploadOK = false;
		for(String a : exts) {
			if(a.equals(ext.substring(1, ext.length()).toLowerCase())) {
				uploadOK = true;
				break;
			}
		}
		
		if(!uploadOK) return;
		
		BufferedOutputStream  out = null;
		InputStream in = null;
		
		try {
			res.setContentType("image/" + ext);
			res.setHeader("Content-Disposition", "inline;filename=" + fileNm);
			File file = new File(realFile + "/" + fileNm);
			if(file.exists()) {
				in = new FileInputStream(file);
				out = new BufferedOutputStream(res.getOutputStream());
				int len;
				byte[] buf = new byte[1024];
				while ((len = in.read(buf)) > 0 ) {
					out.write(buf, 0, len);
				}
			} 
		} catch (Exception e) {
				System.out.println("오류");
		} finally {
			if(out != null){ out.flush(); }
			if(out != null){ out.close(); }
			if(in != null){ in.close(); }
		}
	}
	
	// 첨부파일 업로드
	@RequestMapping(value="/uploadSummernoteImageFile.do", produces = "application/json; charset=utf8", method=RequestMethod.POST)
	@ResponseBody
	public ModelMap uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, ModelMap model)  {
		
		String filePath = imagesDir;
		String originalFileName = multipartFile.getOriginalFilename();
		String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String storedFileName =  CommonUtils.getRandomString() + "." +  originalFileExtension;
		
		File targetFile = new File(filePath + "/"+ storedFileName);
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
			
			model.addAttribute("url", storedFileName);
			model.addAttribute("fileName", originalFileName);
			model.addAttribute("responseCode", "success");
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);
			model.addAttribute("responseCode", "error");
			e.printStackTrace();
		}
		return model;
	}
	
}
