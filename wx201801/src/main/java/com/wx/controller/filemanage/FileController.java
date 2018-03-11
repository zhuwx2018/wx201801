package com.wx.controller.filemanage;


import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wx.system.AppException;

@Controller
@RequestMapping("/fileController")
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	@RequestMapping(method=RequestMethod.GET)
	public String entryFileView(){
		return "fileupload";
	}
	@RequestMapping(value="upload")
	@ResponseBody
	public String upload(@RequestPart("partfile") MultipartFile partfile) throws Exception{
		logger.info("upload file "+partfile);
		partfile.getOriginalFilename();
		try {
			partfile.getInputStream();
			File file = new File("/temp/file/"+partfile.getOriginalFilename());
			if(!file.exists()){
				file.mkdir();
			}
			partfile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new AppException("文件上传失败");
		}
		return "fileupload";
	}
}
