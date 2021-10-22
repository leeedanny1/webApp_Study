package com.kakao.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kakao.web.db.DBConnectionMgr;

public class SignInDaoImpl implements SignInDao {

	private DBConnectionMgr pool = null;
	
	public SignInDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}
	
	
	@Override
	public int signIn(String login_id, String login_password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int flag = 3;
	
		try {
			con = pool.getConnection();
			sql = "select count(um.user_email), count(ud.user_password) "
					+ "from user_mst um left outer join user_mst ud "
					+ "on(ud.user_email = um.user_email and ud.user_password = ?) "
					+ "where um.user_email = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login_password);
			pstmt.setString(2, login_id);
			
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
