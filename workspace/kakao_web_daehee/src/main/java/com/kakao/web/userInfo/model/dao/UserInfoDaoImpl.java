package com.kakao.web.userInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kakao.web.db.DBConnectionMgr;
import com.kakao.web.index.model.dto.User;
import com.kakao.web.userInfo.model.dto.UpdateUserDto;

public class UserInfoDaoImpl implements UserInfoDao {
	private DBConnectionMgr pool = null;
	
	public UserInfoDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}
	
	@Override
	public int updateUserInfo(UpdateUserDto updateUserDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "update user_mst set user_password = ?, user_phone = ? where user_email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateUserDto.getPassword());
			pstmt.setString(2, updateUserDto.getPhone());
			pstmt.setString(3, updateUserDto.getEmail());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return result;
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
}
