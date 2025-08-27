package fluttingMasterGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import fluttingMasterPlace.*;
import model.Gamer;


public class Game {
	
	
	public void getConn() {
		try {
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void getClose() {
		try {
			
//			if(rs!=null)rs.close();
//			if(pstm!=null)pstm.close();
//			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void init(Gamer user) {/////////////////////////////////////////////////////////////////////
		//System.out.println(user.getNickname());
		//getConn();
		boolean checker = true;
		Scanner sc = new Scanner(System.in);
		showTitle();
		int textspeed = 50;
		String nextnum = "0";
		int oldpoint = 0;
		System.out.println(user.getNickname()+"님 환영합니다("+user.getPoint()+"호감도 누적)");
		oldpoint = user.getPoint();
		user.setPoint(40);
		System.out.print("당신의 나이를 입력하세요: ");
		String age = sc.next();
		System.out.print("여주인공의 이름을 입력하세요: ");
		String hername = sc.next();

		
		//String replacetemp = "(플레이어이름)은 성장했다";
		//System.out.println(replacetemp);
		//replacetemp = replacetemp.replace("(플레이어이름)", "김수호");
		//System.out.println(replacetemp);
		while(checker) {
			if(nextnum.equals("0") || nextnum.contains("S") || nextnum.equals("Q8")) {
				if(nextnum.contains("S"))
					nextnum = nextnum.substring(1);
				ShortSceneVO scvo = searchScVO(nextnum);
				
				String stemp = scvo.getScripts();
				stemp = stemp.replace("(플레이어)", user.getNickname());
				stemp = stemp.replace("(플레이어나이)", age);
				stemp = stemp.replace("(그녀)", hername);
				printScript(stemp, textspeed);
				
				nextnum = scvo.getNextNum();
				//delay(1000);
				//System.out.println(nextnum.substring(1));
			}else if(nextnum.contains("P") || nextnum.contains("Q")){
				if(nextnum.contains("P"))
						nextnum = nextnum.substring(1);
				//System.out.println("메뉴에서호출:" + nextnum);
				PlaceVO pvo = searchPVO(nextnum);
				//if(pvo==null)System.out.println("널");
				String stemp = pvo.getScripts();
				stemp = stemp.replace("(플레이어)", user.getNickname());
				stemp = stemp.replace("(플레이어나이)", age);
				stemp = stemp.replace("(그녀)", hername);
				printScript(stemp, textspeed);
				System.out.println();
				ArrayList<SelectorVO> list = searchSVO(nextnum);
				int i = 0;
				//System.out.println(list.size());
				int[] arr = new int[list.size()];
				for(SelectorVO svo : list) {
					System.out.print("[" + (i+1) + "]");
					System.out.print(svo.getScripts() + "  " );
					arr[i] = svo.getPoints();
					i++;
				}
				System.out.print("\n당신의 선택은>>>");
				String input = sc.next();
				if(input.equals("1")) {
					nextnum = list.get(0).getNextNum();
					user.setPoint(user.getPoint() + arr[0]);
					
				}else if(input.equals("2")) {
					nextnum = list.get(1).getNextNum();
					user.setPoint(user.getPoint() + arr[1]);
				}else if(input.equals("3")) {
					nextnum = list.get(2).getNextNum();
					user.setPoint(user.getPoint() + arr[2]);
				}else if(input.equals("4")) {
					nextnum = list.get(3).getNextNum();
					user.setPoint(user.getPoint() + arr[3]);
				}else if(input.equals("5")) {
					nextnum = list.get(4).getNextNum();
					user.setPoint(user.getPoint() + arr[4]);
				}else {
					
				}
				
//				System.out.println(user.getPoint());
				//System.out.println(nextnum);
				//delay(1000);
			}else if(nextnum.contains("E")){
				nextnum = nextnum.substring(1);
				EndingVO evo = searchEVO(nextnum);
				
				String stemp = evo.getScripts();
				stemp = stemp.replace("(플레이어)", user.getNickname());
				stemp = stemp.replace("(플레이어나이)", age);
				stemp = stemp.replace("(그녀)", hername);
				printScript(stemp, textspeed);
				
				checker = false;
				user.setPoint(user.getPoint()+oldpoint-40);
				updateUserPoint(user);
			}
			
			if(nextnum.equals("9999")) {
				checker = false;
			}
			//System.out.println(nextnum);

		}//while
		if(nextnum.equals("9999")) {
			if(user.getPoint()<0)user.setPoint(0);
				
			if(user.getPoint()>=0 && user.getPoint()<40) {
				EndingVO evo = searchEVO("801");
				String stemp = evo.getScripts();
				stemp = stemp.replace("(플레이어)", user.getNickname());
				stemp = stemp.replace("(플레이어나이)", age);
				stemp = stemp.replace("(그녀)", hername);
				printScript(stemp, textspeed);
			}else if(user.getPoint()>=40 && user.getPoint()<80) {
				EndingVO evo = searchEVO("802");
				String stemp = evo.getScripts();
				stemp = stemp.replace("(플레이어)", user.getNickname());
				stemp = stemp.replace("(플레이어나이)", age);
				stemp = stemp.replace("(그녀)", hername);
				printScript(stemp, textspeed);
				
			}else if(user.getPoint()>=80 && user.getPoint()<85) {
				EndingVO evo = searchEVO("803");
				String stemp = evo.getScripts();
				stemp = stemp.replace("(플레이어)", user.getNickname());
				stemp = stemp.replace("(플레이어나이)", age);
				stemp = stemp.replace("(그녀)", hername);
				printScript(stemp, textspeed);
				
			}else if(user.getPoint()>=85 && user.getPoint()<100) {
				EndingVO evo = searchEVO("804");
				String stemp = evo.getScripts();
				stemp = stemp.replace("(플레이어)", user.getNickname());
				stemp = stemp.replace("(플레이어나이)", age);
				stemp = stemp.replace("(그녀)", hername);
				printScript(stemp, textspeed);
				
			}else if(user.getPoint()>=100 && user.getPoint()<106) {
				EndingVO evo = searchEVO("805");
				String stemp = evo.getScripts();
				stemp = stemp.replace("(플레이어)", user.getNickname());
				stemp = stemp.replace("(플레이어나이)", age);
				stemp = stemp.replace("(그녀)", hername);
				printScript(stemp, textspeed);
				
				
			}
			//System.out.println(user.getPoint()+"획득");
			user.setPoint(user.getPoint()+oldpoint-40);
			updateUserPoint(user);
		}
		//System.out.println("아무 키나 누르면 종료합니다.");
		//String endkey = sc.nextLine();
		
		//if(endkey!=null)sc.close();
	}///////////////////////////////////////////////////////////////////////////////////////////
	public void updateUserPoint(Gamer u) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_1";
			String password = "smhrd1";
			
			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null) {
				//System.out.println("메소드에서호출:" + pnum);
				String sql = "UPDATE GAMER SET POINT = ? WHERE ID = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, u.getPoint());
				pstm.setString(2, u.getId());
				
				//rs = pstm.executeQuery();
				int row = pstm.executeUpdate();
				//System.out.println(rs.getString("placename"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public PlaceVO searchPVO(String pnum) {
		PlaceVO pv2 = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_1";
			String password = "smhrd1";
			
			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null) {
				//System.out.println("메소드에서호출:" + pnum);
				String sql = "SELECT * FROM PLACE WHERE PLACENUM = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, pnum);
				
				rs = pstm.executeQuery();
				//System.out.println(rs.getString("placename"));
				if(rs!=null)
				if(rs.next()) {
					pv2 = new PlaceVO( );
					pv2.setPlaceNum(rs.getString("placenum"));
					pv2.setPlaceName(rs.getString("placename"));
					pv2.setScripts(rs.getString("scripts"));
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return pv2;
	}
	public EndingVO searchEVO(String ennum) {
		EndingVO evo = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_1";
			String password = "smhrd1";
			
			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null) {
				//System.out.println("메소드에서호출:" + pnum);
				String sql = "SELECT * FROM ENDING WHERE ENDINGNUM = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, ennum);
				
				rs = pstm.executeQuery();
				//System.out.println(rs.getString("placename"));
				if(rs!=null)
					if(rs.next()) {
						evo = new EndingVO( );
						evo.setEndingName(rs.getString("endingnum"));
						evo.setEndingName(rs.getString("endingname"));
						evo.setScripts(rs.getString("scripts"));
						
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return evo;
	}
	public ShortSceneVO searchScVO(String snum) {
		ShortSceneVO sv = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_1";
			String password = "smhrd1";
			
			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null) {
				String sql = "SELECT * FROM SHORTSCENE WHERE SCENENUM = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, snum);
				
				rs = pstm.executeQuery();
				if(rs!=null)
					if(rs.next()) {
						sv = new ShortSceneVO();
						sv.setSceneNum(rs.getString("scenenum"));
						sv.setSceneName(rs.getString("scenename"));
						sv.setScripts(rs.getString("scripts"));
						sv.setNextNum(rs.getString("nextnum"));
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return sv;
	}
	public ArrayList<SelectorVO> searchSVO(String pnum) {
		ArrayList<SelectorVO> list = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_1";
			String password = "smhrd1";
			
			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null) {
				String sql = "SELECT * FROM Selector WHERE PLACENUM = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, pnum);
				
				rs = pstm.executeQuery();
				if(rs!=null) {
					list = new ArrayList<SelectorVO>();
					while(rs.next()) {
						SelectorVO scvo = new SelectorVO( );
						scvo.setPlaceNum(rs.getString("placenum"));
						scvo.setScripts(rs.getString("selectorscript"));
						scvo.setPoints(rs.getInt("points"));
						scvo.setNextNum(rs.getString("NextNum"));
						list.add(scvo);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			getClose();
		}
		return list;
	}
	public  void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {			e.printStackTrace();		}
	}
	public void showTitle() {
		cls();
		System.out.println("♥♥♥나는야 플러팅 마스터♥♥♥");
		delay(300);
		cls();
		System.out.println("     ♥♥♥나는야 플러팅 마스터♥♥♥");
		delay(300);
		cls();
		System.out.println("♥♥♥나는야 플러팅 마스터♥♥♥");
		delay(300);
		cls();
		System.out.println("     ♥♥♥나는야 플러팅 마스터♥♥♥");
		delay(300);
		cls();
		System.out.println("♥♥♥나는야 플러팅 마스터♥♥♥");
		delay(300);
		cls();
		System.out.println("     ♥♥♥나는야 플러팅 마스터♥♥♥");
		delay(300);
	}
	public  void delay(int mill) {
		try {
			Thread.sleep(mill);
		} catch (Exception e) {			e.printStackTrace();		}
	}
	public  void kakaotalk(int mill, String s, boolean rightSide) {
		int crlf = 0;
		if(rightSide)System.out.print("                                   ");
		for(int i = 0 ; i<s.length() ; i++) {
			String tempS = s.substring(i, i+1);
			if(tempS.equals(".")) {
				tempS=".\n";
				if(rightSide)tempS = tempS + "                                   ";
				crlf = 0;
			}
			if(crlf%10==0 && crlf!=0) {
				tempS+="\n";
				if(rightSide)tempS = tempS + "                                   ";
			}
			
			System.out.print(tempS);
			crlf++;
			try {
				Thread.sleep(mill/s.length());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println();
		System.out.println();
	}
	public static void printScript(String s, int mill) {
		int crlf = 0;
		for(int i = 0 ; i<s.length() ; i++) {
			String tempS = s.substring(i, i+1);
			if(tempS.equals(".")) {
				//tempS=".\n";
				crlf = 0;
			}
			//if(crlf%60==0 && crlf!=0)tempS+="\n";
			System.out.print(tempS);
			crlf++;
			try {
				Thread.sleep(mill);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}
