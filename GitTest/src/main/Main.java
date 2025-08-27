package main;



import controller.UserController;
import gameVIew.gameView;
import model.UserDAO;

public class Main {

	public static void main(String[] args) {
        //UserDAO dao = new UserDAO();
        //gameView view = new gameView();
        //UserController controller = new UserController(view, dao);
        //controller.startgame();
		
		
		
		
		
				new UserController(new gameView(), new UserDAO()).startgame();
		  }

	}


