package com.hyuyuna.narcissus.product.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hyuyuna.narcissus.common.FileVO;
import com.hyuyuna.narcissus.product.vo.ProductVO;

public interface ProductService {
	
	// 제품 목록
	public List<ProductVO> selectAllProduct(ProductVO vo);
	
	// 제품 상세
	public ProductVO selectProduct(int serial) throws Exception;
	
	// 제품 수
	public int productCnt(ProductVO vo);
	
	// 제품 첨부파일 목록
	public List<Map<String, Object>> selectFileList(int serial);
	
	// 제품 첨부파일 정보
	public FileVO selectFileInfo(int num);
	
	// 제품 등록
	public void insertProduct(Map<String, Object> map, HttpServletRequest request) throws Exception ;
	
	// 제품 수정
	public void updateProduct(Map<String, Object> map, HttpServletRequest request) throws Exception ;
	
	// 제품 삭제
	public void deleteProduct (int custno);

}
