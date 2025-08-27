package controller;

import gameVIew.gameView;
import model.Gamer;
import model.User;
import model.UserDAO;

public class UserController {
	private gameView view;
	private UserDAO dao;
	public UserController(gameView view, UserDAO dao) {
		super();
		this.view = view;
		this.dao = dao;
	}
	public void startgame() {
		while (true) {
			// 메뉴출력
			int input = view.showMenu();
			if (input == 1) {
				Gamer loginVO = dao.login(view.showLogin());
				view.statusLogin(loginVO);
				
			} else if (input == 2) {
				int row = dao.join(view.showJoin());
				view.statusMenu(row, "회원가입");
			} else if (input == 3) {
				break;
			}
	}
	
	

}
}
