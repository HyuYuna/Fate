package com.hyuyuna.narcissus.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyuyuna.narcissus.common.SessionManager;
import com.hyuyuna.narcissus.service.ProductService;
import com.hyuyuna.narcissus.vo.FileVO;
import com.hyuyuna.narcissus.vo.ProductVO;
import com.hyuyuna.narcissus.vo.ReplyVO;

@Controller
public class ProductController {
	
	@Resource(name="productService")
	ProductService service;
	
	@Autowired
	private SessionManager sessionManager;
	
	
	@RequestMapping(value="/productForm.do")
	public String fileForm(Model model) throws Exception {
		return "product/product_reg.main";
	}
	
	@RequestMapping(value = "/productList.do")
	public String fileList(ProductVO vo, Model model) throws Exception {
		List<ProductVO> list = service.selectAllProduct(vo);
		int cnt = service.productCnt(vo);
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("list", list);
		
		return "product/product_list.main";
	}
	
	@RequestMapping(value="deleteFile.do")
	public void deleteFile(HttpServletRequest request,
				@RequestParam("filename") String filename) {
		String realPath = request.getSession().getServletContext().getRealPath("/upfile/");
		File file = new File(realPath+ "/" + filename);
		file.delete();
	}
	
	@RequestMapping(value="/deleteProduct.do")
	public String deleteFile(ProductVO vo, HttpServletRequest request) {
			
		int serial = vo.getSerial();
		String realPath = request.getSession().getServletContext().getRealPath("/upfile/");
		
		
			String fname = request.getParameter("fname");
			File file = new File(realPath+ "/"+ fname);
			file.delete();
			System.out.println(realPath+fname);
		
		service.deleteProduct(serial);
		
		return "redirect:productList.do";

	}
	
	@RequestMapping(value="/productView.do")
	public String memberFileView(ProductVO vo, Model model) throws Exception {
		
		ProductVO detail = service.selectProduct(vo.getSerial());
		
		List<Map<String,Object>> map = service.selectFileList(vo.getSerial());
		
		model.addAttribute("detail", detail);
		model.addAttribute("map", map);
		model.addAttribute("replyVO", new ReplyVO());
		
		return "product/product_view.main";
	}
		
	@RequestMapping(value="/productDtl.do")
	public String Filedetail(ProductVO vo, Model model) throws Exception {

		ProductVO detail = service.selectProduct(vo.getSerial());
		
		List<Map<String,Object>> map = service.selectFileList(vo.getSerial());
		
		model.addAttribute("detail", detail);
		model.addAttribute("map", map);
		
		return "product/product_dtl.main";
	}
	
	@RequestMapping(value="/productInsert.do")
	public String productInsert(@RequestParam Map<String,Object> map, HttpServletRequest request) throws Exception  {
		
		service.insertProduct(map, request);
		
		return "redirect:productList.do";
	}
	
	@RequestMapping(value="/productUpdate.do")
	public String fileUpdate(@RequestParam Map<String,Object> map, HttpServletRequest request) throws Exception  {
		
		service.updateProduct(map, request);
		
		return "redirect:productList.do";
	}
	
	@RequestMapping(value="/downloadFile.do")
	public void downloadFile(HttpServletResponse response, @RequestParam("num") int num ) throws Exception {
		
		FileVO file = service.selectFileInfo(num);
		String storedFileName = file.getStoredFileName();
		String originalFileName  = file.getOriginalFileName();
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\Fate\\github\\files\\"+storedFileName));
		
		response.setContentType("application/octet-stream"); 
		response.setContentLength(fileByte.length); 
		
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";"); 
		response.setHeader("Content-Transfer-Encoding", "binary"); 
		
		response.getOutputStream().write(fileByte); 
		response.getOutputStream().flush(); 
		response.getOutputStream().close(); 
		
	}
	

}
