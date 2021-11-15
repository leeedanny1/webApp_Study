package com.springboot.kakao.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kakao.model.beans.FileBean;
import com.springboot.kakao.model.dto.NoticeInsertDto;
import com.springboot.kakao.model.dto.NoticeUpdateDto;
import com.springboot.kakao.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeRestController {

	@Autowired
	private NoticeService noticeService;
	
	
	@PostMapping("/insert")
	public String noticeInsert(NoticeInsertDto noticeInsertDto) {
		
		int insertFlag = 0;
		insertFlag = noticeService.noticeInsert(noticeInsertDto);
		
		return Integer.toString(insertFlag);
	}
	
	
//	파일 다운로드
	@GetMapping("/file-download/{originFileName}")
	public byte[] noticeDtlFileDownload(HttpServletResponse response, @PathVariable String originFileName, @RequestParam String tempFileName) {
		
		FileBean fileBean = new FileBean();
		fileBean.setOriginFileName(originFileName);
		fileBean.setTempFileName(tempFileName);
		
		byte[] fileData = noticeService.fileDownload(fileBean);
		
		String encodingOriginFileName = null;
		try {
			encodingOriginFileName = new String(originFileName.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename=\"" + encodingOriginFileName + "\"");
		response.setContentLength(fileData.length);
		
		return fileData;
	}
	
	
	//게시판 수정
	@PutMapping("/update/{code}")
	public String noticeUpdate(@PathVariable int code, NoticeUpdateDto noticeUpdateDto) {
		int updateFlag = 0;
		updateFlag = noticeService.noticeUpdate(noticeUpdateDto);
		
		return Integer.toString(updateFlag);
	}
	
	
}













