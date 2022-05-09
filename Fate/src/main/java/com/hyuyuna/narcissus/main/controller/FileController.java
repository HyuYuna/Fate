package com.hyuyuna.narcissus.main.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyuyuna.narcissus.common.CommonUtils;
import com.hyuyuna.narcissus.common.SessionManager;
import com.hyuyuna.narcissus.main.service.MainService;

@Controller
public class FileController {
	
	@Resource(name="mainService")
	private MainService service;
	
	@Autowired
	private SessionManager sessionManager;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Value("#{directory['globals.filesDir']}")
	private String imagesDir;
	
	 public interface sessionDefine {
		 String loginMain = "HyuYuna";
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
