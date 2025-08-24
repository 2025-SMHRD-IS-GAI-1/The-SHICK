package ex01GitTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex01 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_1";
			String password = "smhrd1";
			
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO MEMBER VALUES('1234', '1234', '1234', '1234')";
			pstm = conn.prepareStatement(sql);
			pstm.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
 
}
