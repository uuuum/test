package com.study.fileuploader;


import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource(name="uploadPath")
	private String uploadPath; // servlet-context.xml �� �����ص� ��� ������
	
	@RequestMapping(value = "/uploader", method = RequestMethod.GET)
	public String home() {
		
		return "uploadForm";
	}
	
	private String uploadFile(String orgName, byte[] file) throws Exception {
		
		UUID uid = UUID.randomUUID(); // ���� �̸��� �ߺ����� �ʵ��� ������ ���� ���ϸ� �տ� �ٿ��� (������ ��)
		String fileName = uid.toString() + "_" + orgName;
		File target = new File(uploadPath, fileName);
		FileCopyUtils.copy(file, target);
		
		return fileName;
		
	}
	
	
	@RequestMapping(value = "/uploader", method = RequestMethod.POST)
	public String fileUpload(MultipartFile file, Model model) throws Exception {
		
		String fileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		
		model.addAttribute("fileName", fileName);
		return "result";
	}
	
	
}
