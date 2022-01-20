package com.hyuyuna.narcissus.common;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")
public class FileUtils {
	
	private static final String filePath = "C:\\Fate\\github\\files";
	
	public List<Map<String,Object>> parseInsertFileInfo(Map<String,Object> map, HttpServletRequest request) throws Exception{
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null; 
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> listMap = null;
		
		int custno = Integer.parseInt(String.valueOf(map.get("custno")));
		String requestName = null;
		String num = null;
		
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
				
				listMap = new HashMap<String,Object>();
				listMap.put("IS_NEW", "Y");
				listMap.put("custno",custno);
				listMap.put("ORIGINAL_FILE_NAME", originalFileName); 
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
			} else {
				requestName = multipartFile.getName();
				num = "num"+requestName.substring(requestName.indexOf("_"));
				if(map.containsKey(num) == true && map.get(num) != null) {
					listMap = new HashMap<String,Object>();
					listMap.put("IS_NEW" , "N");
					listMap.put("num", map.get(num));
					list.add(listMap);
				}
			}
		}
		return list;
	}

}
