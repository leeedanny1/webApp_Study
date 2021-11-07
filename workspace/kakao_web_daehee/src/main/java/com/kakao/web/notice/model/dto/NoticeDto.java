package com.kakao.web.notice.model.dto;

public class NoticeDto {
	private int index; //순번
	private int notice_code; //공지사항 키값
	private String notice_title;
	private String notice_writer;
	private String notice_date;
	private int notice_count;
	private String notice_content;
	private int preNotice_code; //이전 글 코드
	private String preNotice_title;
	private int nextNotice_code; //다음 글 코드
	private String nextNotice_title;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getNotice_code() {
		return notice_code;
	}
	public void setNotice_code(int notice_code) {
		this.notice_code = notice_code;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_writer() {
		return notice_writer;
	}
	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public int getNotice_count() {
		return notice_count;
	}
	public void setNotice_count(int notice_count) {
		this.notice_count = notice_count;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public int getPreNotice_code() {
		return preNotice_code;
	}
	public void setPreNotice_code(int preNotice_code) {
		this.preNotice_code = preNotice_code;
	}
	public String getPreNotice_title() {
		return preNotice_title;
	}
	public void setPreNotice_title(String preNotice_title) {
		this.preNotice_title = preNotice_title;
	}
	public int getNextNotice_code() {
		return nextNotice_code;
	}
	public void setNextNotice_code(int nextNotice_code) {
		this.nextNotice_code = nextNotice_code;
	}
	public String getNextNotice_title() {
		return nextNotice_title;
	}
	public void setNextNotice_title(String nextNotice_title) {
		this.nextNotice_title = nextNotice_title;
	}
	
	@Override
	public String toString() {
		return "NoticeDto [index=" + index + ", notice_code=" + notice_code + ", notice_title=" + notice_title
				+ ", notice_writer=" + notice_writer + ", notice_date=" + notice_date + ", notice_count=" + notice_count
				+ ", notice_content=" + notice_content + ", preNotice_code=" + preNotice_code + ", preNotice_title="
				+ preNotice_title + ", nextNotice_code=" + nextNotice_code + ", nextNotice_title=" + nextNotice_title
				+ "]";
	}
	
	
	
	
}
