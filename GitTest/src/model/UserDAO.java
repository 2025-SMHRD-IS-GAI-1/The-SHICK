package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_1";
			String password = "smhrd1";
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void getClose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int join(Gamer user) {

		int row = 0;
		try {
			getConn();
			String sql = "INSERT INTO GAMER(ID,PASSWORD,NICKNAME,POINT) VALUES(?, ?, ?, 0)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			psmt.setString(3, user.getNickname());

			
			row = psmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			getClose();
		}
		return row;

	}
	public Gamer login(Gamer user) {
		Gamer loginVo = null;
		try {
		getConn();
		String sql = "SELECT * FROM GAMER WHERE ID = ? AND PASSWORD = ?";
		psmt = conn.prepareStatement(sql);

		psmt.setString(1, user.getId());
		psmt.setString(2, user.getPw());

		rs = psmt.executeQuery();
		while(rs.next()) {
			loginVo = new Gamer();
			loginVo.setId(rs.getString("id"));
			loginVo.setPw(rs.getString("password"));
			loginVo.setNickname(rs.getString("nickname"));
			loginVo.setPoint(rs.getInt("point"));
		}
		} catch(Exception e) {

			e.printStackTrace();

		} finally {
			getClose();
		}
		return loginVo;

	}
	public int update(Gamer user) {
		int row = 0;
		try {
			getConn();
			String sql = "UPDATE GAMER SET NICKNAME = ? WHERE ID = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, user.getNickname());
			psmt.setString(2, user.getId());
			row = psmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {
			getClose();
		}
		return row;
	}
	public void gamestart() {
		
	}
	public int delete(Gamer user) {
		int row = 0;
		try {
			getConn();
			String sql = "DELETE FROM GAMER WHERE ID = ? AND PASSWORD = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, user.getId());
            psmt.setString(2, user.getPw());
			row = psmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;

	}
	
}
