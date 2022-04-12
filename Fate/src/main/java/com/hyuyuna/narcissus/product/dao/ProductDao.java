package com.hyuyuna.narcissus.product.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.common.AbstractDao;
import com.hyuyuna.narcissus.common.FileVO;
import com.hyuyuna.narcissus.product.vo.ProductVO;

@Repository("productDao")
public class ProductDao extends AbstractDao {
	
	// 제품 목록
	@SuppressWarnings("unchecked")
	public List<ProductVO> selectAllProduct(ProductVO vo) {
		return (List<ProductVO>)selectList("productDao.selectAllProduct", vo);
	}
	
	// 제품 상세
	public ProductVO selectProduct(int productIdx) {
		return (ProductVO)selectOne("productDao.selectProduct", productIdx);
	}
	
	// 제품 수
	public int productCnt(ProductVO vo) {
		return (Integer)selectOne("productDao.productCnt");
	}
	
	// 제품 첨부파일 목록
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectFileList(int productIdx) {
		return (List<Map<String, Object>>)selectList("productDao.selectFileList", productIdx);
	}
	
	// 제품 첨부파일 정보
	public FileVO selectFileInfo(int fileIdx) {
		return (FileVO)selectOne("productDao.selectFileInfo", fileIdx);
	}

	// 제품 등록
	public void insertProduct(Map<String,Object> map) {
		insert("productDao.insertProduct", map);
	}
	
	// 제품 수정
	public void updateProduct(Map<String,Object> map) {
		insert("productDao.updateProduct", map);
	}

	// 제품 삭제
	public void deleteProduct(int productIdx) {
		delete("productDao.deleteProduct", productIdx);
	}
	
	// 파일 저장
	public void insertFile(Map<String,Object> map) {
		insert("productDao.insertFile", map);
	}
	
	// 파일 삭제
	public void deleteFile(int productIdx) {
		delete("productDao.deleteFile", productIdx);
	}
	
	// 파일 삭제 구분값 입력
	public void deleteFileGbY(Map<String,Object> map) {
		update("productDao.deleteFileGbY", map);
	}
	
	// 파일 삭제 구분값 입력 취소
	public void deleteFileGbN(Map<String,Object> map) {
		update("productDao.deleteFileGbN", map);
	}
	 
}
