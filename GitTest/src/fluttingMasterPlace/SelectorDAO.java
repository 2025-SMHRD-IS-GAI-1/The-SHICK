package fluttingMasterPlace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectorDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_1";
			String password = "smhrd1";
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void getClose() {
		try {
			
			if(rs!=null)rs.close();
			if(pstm!=null)pstm.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public PlaceVO searchPVO(String pnum) {
		PlaceVO pv2 = null;
		try {
			if(conn!=null) {
				String sql = "SELECT * FROM PLACE WHERE PLACENUM = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, pnum);
				
				rs = pstm.executeQuery();
				if(rs!=null)
				if(rs.next()) {
					pv2 = new PlaceVO( );
					pv2.setPlaceNum(rs.getString(1));
					pv2.setPlaceName(rs.getString(2));
					pv2.setScripts(rs.getString(3));
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			getClose();
		}
		return pv2;
	}
	
}
