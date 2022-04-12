package com.hyuyuna.narcissus.common;

import java.awt.image.BufferedImage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")
public class FileUtils {
	
	@Value("#{directory['globals.imagesDir']}")
	private String imagesPath;
	
	@Value("#{directory['globals.filesDir']}")
	private String filePath;
	
	// 이미지 목록 및 저장
	public List<Map<String,Object>> parseInsertFileInfo(Map<String,Object> map, HttpServletRequest request) throws Exception{
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null; 
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> listMap = null;
		
		int productIdx = Integer.parseInt(String.valueOf(map.get("productIdx")));
		String requestName = null;
		String fileIdx = null;
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		}
	
		while(iterator.hasNext()){  // haxNext=>true , false값 반환
			multipartFile = multipartHttpServletRequest.getFile(iterator.next()); // next() => 매개변수값 반환
			if(multipartFile.isEmpty() == false){
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = FilenameUtils.getExtension(originalFileName);
				storedFileName =  CommonUtils.getRandomString() + "." + originalFileExtension;
				
				file = new File(filePath +"/" +storedFileName);
				multipartFile.transferTo(file);
				
				String[] exts = {"jpg", "jpeg", "gif", "png", "bmp"};
				
				for (String ext: exts) {
					if(ext.equals(originalFileExtension.toLowerCase())) {
						makeThumbnail(file.getAbsolutePath() ,originalFileName, originalFileExtension);
						break;
					}
				}
				
				listMap = new HashMap<String,Object>();
				listMap.put("IS_NEW", "Y");
				listMap.put("productIdx",productIdx);
				listMap.put("ORIGINAL_FILE_NAME", originalFileName); 
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
			} else {
				requestName = multipartFile.getName();
				fileIdx = "fileIdx"+requestName.substring(requestName.indexOf("_"));
				if(map.containsKey(fileIdx) == true && map.get(fileIdx) != null) {
					listMap = new HashMap<String,Object>();
					listMap.put("IS_NEW" , "N");
					listMap.put("fileIdx", map.get(fileIdx));
					list.add(listMap);
				}
			}
		}
		return list;
	}
	
	// 썸네일 생성
	private void makeThumbnail(String filePath ,String fileName, String fileExt) throws Exception {
		File file = new File(imagesPath);
		
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		BufferedImage srcImg = ImageIO.read(new File(filePath));
		
		
	    int dw = 250;
	    int dh = 250;
		
		int ow = srcImg.getWidth();
		int oh = srcImg.getHeight();
		
		int nw = ow;
		int nh = (ow * dh) / dw;
		
		if (nh > oh) {
			nw = (oh * dw) / dh;
			nh = oh;
		}
		
		if(nh > oh) { 
			nw = (oh * dw) / dh; 
			nh = oh; 
		}
		
		BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);
		
		BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
		
		String thumbName = imagesPath + "/" + "THUMB_" + fileName;
		File thumbFile = new File(thumbName);
		
		ImageIO.write(destImg, fileExt.toLowerCase(), thumbFile);
		
		
	}

}
