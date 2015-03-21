package database;

public class AutoDataImport {

	public static void main(String[] args) {

		GameDao gd = new GameDaoImpl();
		System.out.println(gd.getAllGames().size());
		
	}

}
