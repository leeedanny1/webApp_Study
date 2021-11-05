package com.kakao.web.index.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kakao.web.db.DBConnectionMgr;
import com.kakao.web.index.model.dto.User;

public class UserDaoImpl implements UserDao{
	private DBConnectionMgr pool;
	
	public UserDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}
	
	@Override
	public User getUser(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		User user = null;
		
		try {
			con = pool.getConnection();
			sql = "select * from user_mst where user_email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			user = new User();
			user.setId(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setName(rs.getString(3));
			user.setPhone(rs.getString(4));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
	}
}








