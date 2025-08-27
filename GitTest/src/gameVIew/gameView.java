package gameVIew;

import java.util.Scanner;

import fluttingMasterGame.Game;
import model.Gamer;
import model.User;


public class gameView {
	private Scanner sc = new Scanner(System.in);
	
	public int showMenu() {
		System.out.println("==== 회원 관리 시스템====");
		System.out.print("[1]로그인 [2]회원가입 [3]종료");
		int input = sc.nextInt();
		return input;
	}
	public Gamer showLogin() {
		System.out.println("====로그인====");
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("PW 입력 : ");
		String pw = sc.next();
		Gamer user = new Gamer();
		user.setId(id);
		user.setPw(pw);
		return user;
	}
	public void statusLogin(Gamer loginVO) {
		if(loginVO != null) {
			new Game().init(loginVO);
			
		}else {
		    //System.out.println("유저를 찾을 수 없습니다.");
	     }
	}
	public void statusMenu(int row, String menu) {
		  if(row > 0) {	
				System.out.println(menu+" 성공");
			 }  else {
				System.out.println(menu+" 실패");
			 }
	}
	public Gamer showJoin() {
		System.out.println("====회원가입====");
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("PW 입력 : ");
		String pw = sc.next();
		System.out.print("닉네임 입력 : ");
		String nickname = sc.next();
		
		Gamer user = new Gamer();
		user.setId(id);
		user.setPw(pw);
		user.setNickname(nickname);
		
		return user;
	}
	

}
