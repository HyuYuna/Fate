package com.hyuyuna.narcissus.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hyuyuna.narcissus.vo.FileVO;
import com.hyuyuna.narcissus.vo.ProductVO;

@Repository("productDao")
public class ProductDao extends AbstractDao {
	

	@SuppressWarnings("unchecked")
	public List<ProductVO> selectAllProduct(ProductVO vo) {
		return (List<ProductVO>)selectList("productDao.selectAllProduct", vo);
	}
	
	public ProductVO selectProduct(int serial) {
		return (ProductVO)selectOne("productDao.selectProduct", serial);
	}
	
	public int productCnt(ProductVO vo) {
		return (Integer)selectOne("productDao.productCnt");
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectFileList(int serial) {
		return (List<Map<String, Object>>)selectList("productDao.selectFileList", serial);
	}
	
	public FileVO selectFileInfo(int num) {
		return (FileVO)selectOne("productDao.selectFileInfo", num);
	}

	public void insertProduct(Map<String,Object> map) {
		insert("productDao.insertProduct", map);
	}
	
	public void updateProduct(Map<String,Object> map) {
		insert("productDao.updateProduct", map);
	}

	public void deleteProduct(int serial) {
		delete("productDao.deleteProduct", serial);
	}
	
	public void deleteFile(int serial) {
		delete("productDao.deleteFile", serial);
	}
	
	public void deleteFileGbY(Map<String,Object> map) {
		update("productDao.deleteFileGbY", map);
	}

	public void deleteFileGbN(Map<String,Object> map) {
		update("productDao.deleteFileGbN", map);
	}
	
	public void insertFile(Map<String,Object> map) {
		insert("productDao.insertFile", map);
	}
	 
}
