package com.hyuyuna.narcissus.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hyuyuna.narcissus.vo.FileVO;
import com.hyuyuna.narcissus.vo.ProductVO;

public interface ProductService {
	
	public List<ProductVO> selectAllProduct(ProductVO vo);
	
	public ProductVO selectProduct(int serial) throws Exception;
	
	public int productCnt(ProductVO vo);
	
	public List<Map<String, Object>> selectFileList(int serial);
	
	public FileVO selectFileInfo(int num);
	
	public void insertProduct(Map<String, Object> map, HttpServletRequest request) throws Exception ;
	
	public void updateProduct(Map<String, Object> map, HttpServletRequest request) throws Exception ;
	
	public void deleteProduct (int custno);

}
