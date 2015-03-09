/**
 * puppy
 * 2015年3月9日 上午10:28:15
 * TODO
 */
package database;

import java.util.ArrayList;

import po.Game;

public interface GameDao {
	
	public void add(Game game);
	public void update(Game game);
	public void deleteGameByLabel(String label);
	public Game getGameByLabel(String label);
	public ArrayList<Game> getAllGames();
	
}
