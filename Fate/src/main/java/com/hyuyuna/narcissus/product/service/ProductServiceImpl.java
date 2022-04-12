package com.hyuyuna.narcissus.product.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.common.FileUtils;
import com.hyuyuna.narcissus.common.FileVO;
import com.hyuyuna.narcissus.product.dao.ProductDao;
import com.hyuyuna.narcissus.product.vo.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Resource(name="fileUtils")
	FileUtils fileutils;
	
	@Resource(name="productDao")
	ProductDao dao;
	
	// 제품 목록
	@Override
	public List<ProductVO> selectAllProduct(ProductVO vo){
		return dao.selectAllProduct(vo);
	}
	
	// 제품 상세
	@Override
	public ProductVO selectProduct(int productIdx) throws Exception {
		return dao.selectProduct(productIdx);
	}
	
	// 제품 수
	@Override
	public int productCnt(ProductVO vo) {
		return dao.productCnt(vo);
	}
	
	// 제품 첨부파일 목록
	@Override
	public List<Map<String ,Object>> selectFileList(int productIdx) {
		return dao.selectFileList(productIdx);
	}
	
	// 제품 첨부파일 정보
	@Override
	public FileVO selectFileInfo(int fileIdx) {
		return dao.selectFileInfo(fileIdx);
	}
	
	// 제품 등록
	@Override
	public void insertProduct(Map<String ,Object> map, HttpServletRequest request) throws Exception {
		dao.insertProduct(map);
		
		// 파일 등록
		List<Map<String,Object>> list = fileutils.parseInsertFileInfo(map,request);
		for(int i=0; i<list.size(); i++) {
			// 파일 저장
			dao.insertFile(list.get(i));
		}
	}

	// 제품 수정
	@Override
	public void updateProduct(Map<String,Object> map, HttpServletRequest request) throws Exception {
		dao.updateProduct(map);
		
		// 파일 삭제 구분값 넣기
		dao.deleteFileGbY(map);
		List<Map<String,Object>> list = fileutils.parseInsertFileInfo(map, request);
		Map<String, Object> fileMap = null;
		for (int i=0, size=list.size(); i<size; i++) {
			fileMap = list.get(i);
			if (fileMap.get("IS_NEW").equals("Y")){
				// 파일 저장
				dao.insertFile(fileMap);
			} else {
			//  파일 삭제 구분값 입력 취소
				dao.deleteFileGbN(fileMap);
			}
		}
	}
	
	// 제품 삭제
	@Override
	public void deleteProduct(int productIdx) {
		dao.deleteProduct(productIdx);
		
		//파일 삭제
		dao.deleteFile(productIdx);
	}
	 
}
