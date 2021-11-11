package com.springboot.kakao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.kakao.model.dto.NoticeDto;

@Mapper
public interface NoticeDao {
	public List<NoticeDto> getNoticeListAll();
	
	public int getNoticeMaxCode();
	public int noticeMstInsert(NoticeDto noticeDto);
	public int noticeDtlInsert(NoticeDto noticeDto);
	
	public NoticeDto getNotice(int notice_code);
	
	public int plusNoticeCount(int notice_code);
	
	public int noticeMstDelete(int notice_code);
	public int noticeDtlDelete(int notice_code);
	
	public int noticeUpdate(NoticeDto noticeDto);
}
