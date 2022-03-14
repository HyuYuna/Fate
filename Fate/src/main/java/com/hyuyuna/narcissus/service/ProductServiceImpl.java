package com.hyuyuna.narcissus.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hyuyuna.narcissus.common.FileUtils;
import com.hyuyuna.narcissus.dao.MemberDao;
import com.hyuyuna.narcissus.dao.ProductDao;
import com.hyuyuna.narcissus.vo.FileVO;
import com.hyuyuna.narcissus.vo.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Resource(name="fileUtils")
	FileUtils fileutils;
	
	@Resource(name="productDao")
	ProductDao dao;
	
	
	@Override
	public List<ProductVO> selectAllProduct(ProductVO vo){
		return dao.selectAllProduct(vo);
	}
	
	@Override
	public ProductVO selectProduct(int serial) throws Exception {
		return dao.selectProduct(serial);
	}
	
	@Override
	public int productCnt(ProductVO vo) {
		return dao.productCnt(vo);
	}
	
	@Override
	public List<Map<String ,Object>> selectFileList(int serial) {
		return dao.selectFileList(serial);
	}
	
	@Override
	public FileVO selectFileInfo(int num) {
		return dao.selectFileInfo(num);
	}
	
	@Override
	public void insertProduct(Map<String ,Object> map, HttpServletRequest request) throws Exception {
		dao.insertProduct(map);
		
		// 파일 등록
		List<Map<String,Object>> list = fileutils.parseInsertFileInfo(map,request);
		for(int i=0; i<list.size(); i++) {
			dao.insertFile(list.get(i));
		}
	}

	@Override
	public void updateProduct(Map<String,Object> map, HttpServletRequest request) throws Exception {
		dao.updateProduct(map);
		
		// 삭제 구분값 넣기
		dao.deleteFileGbY(map);
		List<Map<String,Object>> list = fileutils.parseInsertFileInfo(map, request);
		Map<String, Object> fileMap = null;
		for (int i=0, size=list.size(); i<size; i++) {
			fileMap = list.get(i);
			if (fileMap.get("IS_NEW").equals("Y")){
				dao.insertFile(fileMap);
			} else {
				dao.deleteFileGbN(fileMap);
			}
		}
	}
	
	@Override
	public void deleteProduct(int serial) {
		dao.deleteProduct(serial);
		
		//파일 삭제
		dao.deleteFile(serial);
	}
	 
}
