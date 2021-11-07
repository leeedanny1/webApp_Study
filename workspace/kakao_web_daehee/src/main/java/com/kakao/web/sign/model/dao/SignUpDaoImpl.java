package com.kakao.web.sign.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kakao.web.db.DBConnectionMgr;
import com.kakao.web.sign.model.dto.UserDto;

public class SignUpDaoImpl implements SignUpDao {
	
	private DBConnectionMgr pool = null;
	
	public SignUpDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}
	
	@Override
	public int idCheck(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int flag = 2;
		
		try {
			con = pool.getConnection();
			sql = "select count(user_email) from user_mst where user_email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			flag = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return flag;
	}
	
	@Override
	public int phoneNumberCheck(String phone, String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int flag = 0;
		
		try {
			con = pool.getConnection();
			sql = "select count(pm.phone_number), count(um.user_phone) from phonenumber_list_mst pm left outer join user_mst um on(um.user_phone = pm.phone_number) where pm.phone_number = ? and pm.phone_user_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			
			rs.next();
			flag = rs.getInt(1) + rs.getInt(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return flag;
	}
	
	@Override
	public boolean signUp(UserDto userDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			System.out.println(userDto);
			sql = "insert into user_mst values(?, ?, ?, ?, now(), now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userDto.getUser_email());
			pstmt.setString(2, userDto.getUser_password());
			pstmt.setString(3, userDto.getUser_name());
			pstmt.setString(4, userDto.getUser_phone());
			
			pstmt.executeUpdate();
			flag = true;
			
			return flag;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		return flag;
	}
}








