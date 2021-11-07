package com.kakao.web.notice.model.dao;

import java.util.List;

import com.kakao.web.notice.model.dto.NoticeDto;

public interface NoticeDao {
	public List<NoticeDto> getNoticeAll();
	public int insertNotice(NoticeDto noticeDto);
	public NoticeDto getNotice(int notice_code);
	public int updateNotice(NoticeDto noticeDto);
	public int deleteNotice(int notice_code);
}
