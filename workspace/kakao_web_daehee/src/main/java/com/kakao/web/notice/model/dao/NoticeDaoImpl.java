package com.kakao.web.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kakao.web.db.DBConnectionMgr;
import com.kakao.web.notice.model.dto.NoticeDto;

public class NoticeDaoImpl implements NoticeDao{

	private DBConnectionMgr pool;
	
	public NoticeDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}
	
	@Override
	public List<NoticeDto> getNoticeAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;		
		List<NoticeDto> noticeAll = null;
		int index = 1;
		try {
			con = pool.getConnection();
			sql = "select * from notice_mst order by notice_code desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			noticeAll = new ArrayList<NoticeDto>();
			
			while(rs.next()) {
				NoticeDto notice = new NoticeDto();
				notice.setIndex(index);
				notice.setNotice_code(rs.getInt(1));
				notice.setNotice_title(rs.getString(2));
				notice.setNotice_writer(rs.getString(3));
				notice.setNotice_date(rs.getDate(4).toString());
				notice.setNotice_count(rs.getInt(5));
				index++;
				noticeAll.add(notice);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return noticeAll;
	}
	
	@Override
	public int insertNotice(NoticeDto noticeDto) {
		Connection con = null;
		Connection con2 = null;
		Connection con3 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String sql = null;
		int result = 0;
		int maxNoticeCode = 0;
		
		try {
			con = pool.getConnection();
			con2 = pool.getConnection();
			con3 = pool.getConnection();
			
			sql = "select max(notice_code) from notice_mst";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			maxNoticeCode = rs.getInt(1) + 1;
			
			sql = "insert into notice_mst values(?, ?, ?, now(), 0, now(), now())";
			pstmt2 = con2.prepareStatement(sql);
			pstmt2.setInt(1, maxNoticeCode);
			pstmt2.setString(2, noticeDto.getNotice_title());
			pstmt2.setString(3, noticeDto.getNotice_writer());
			result = pstmt2.executeUpdate();
			
			sql = "insert into notice_dtl values(?, ?, now(), now())";
			pstmt3 = con3.prepareStatement(sql);
			pstmt3.setInt(1, maxNoticeCode);
			pstmt3.setString(2, noticeDto.getNotice_content());
			result += pstmt3.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
			pool.freeConnection(con2, pstmt2);
			pool.freeConnection(con3, pstmt3);
		}
		
		
		return result;
	}
	
	@Override
	public NoticeDto getNotice(int notice_code) {
		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		String sql = null;
		NoticeDto noticeDto = null;
		
		try {
			con = pool.getConnection();
			con2 = pool.getConnection();
			
			sql = "update notice_mst set notice_count = notice_count + 1 where notice_code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_code);
			pstmt.executeUpdate();
			
			sql = "select row_number() over(order by nn.notice_code, np.notice_code desc), "
					+ "nm.notice_code, "
					+ "nm.notice_title, "
					+ "nd.notice_content, "
					+ "nm.notice_writer, "
					+ "nm.notice_date, "
					+ "nm.notice_count, "
					+ "nn.notice_code, "
					+ "nn.notice_title, "
					+ "np.notice_code, "
					+ "np.notice_title "
					+ "from "
					+ "notice_mst nm "
					+ "left outer join notice_dtl nd on(nd.notice_code = nm.notice_code) "
					+ "left outer join notice_mst nn on(nn.notice_code > nm.notice_code) "
					+ "left outer join notice_mst np on(np.notice_code < nm.notice_code) "
					+ "where "
					+ "nm.notice_code = ?";
			pstmt2 = con2.prepareStatement(sql);
			pstmt2.setInt(1, notice_code);
			rs = pstmt2.executeQuery();
			
			rs.next();
			noticeDto = new NoticeDto();
			noticeDto.setNotice_code(rs.getInt(2));
			noticeDto.setNotice_title(rs.getString(3));
			noticeDto.setNotice_content(rs.getString(4));
			noticeDto.setNotice_writer(rs.getString(5));
			noticeDto.setNotice_date(rs.getDate(6).toString());
			noticeDto.setNotice_count(rs.getInt(7));
			noticeDto.setNextNotice_code(rs.getInt(8));
			noticeDto.setNextNotice_title(rs.getString(9));
			noticeDto.setPreNotice_code(rs.getInt(10));
			noticeDto.setPreNotice_title(rs.getString(11));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
			pool.freeConnection(con2, pstmt2, rs);
		}
		
		return noticeDto;
	}

	@Override
	public int updateNotice(NoticeDto noticeDto) {
		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			con2 = pool.getConnection();
			
			sql = "update notice_mst set notice_title = ? where notice_code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noticeDto.getNotice_title());
			pstmt.setInt(2, noticeDto.getNotice_code());
			result = pstmt.executeUpdate();
			
			sql = "update notice_dtl set notice_content = ? where notice_code = ?;";
			pstmt2 = con2.prepareStatement(sql);
			pstmt2.setString(1, noticeDto.getNotice_content());
			pstmt2.setInt(2, noticeDto.getNotice_code());
			result += pstmt2.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con2, pstmt2);
			pool.freeConnection(con, pstmt);
		}
		return result;
	}

	@Override
	public int deleteNotice(int notice_code) {
		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			con2 = pool.getConnection();
			
			sql = "delete from notice_mst where notice_code = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_code);
			result = pstmt.executeUpdate();
			
			sql = "delete from notice_dtl where notice_code = ?;";
			pstmt2 = con2.prepareStatement(sql);
			pstmt2.setInt(1, notice_code);
			result += pstmt2.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con2, pstmt2);
			pool.freeConnection(con, pstmt);
		}
		
		return result;
	}
}









