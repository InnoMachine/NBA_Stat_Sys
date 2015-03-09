/**
 * puppy
 * 2015年3月9日 上午10:18:17
 * TODO
 */
package database;

import java.util.ArrayList;

import po.Player;

public interface PlayerDao {
	
	public void add(Player player);
	public void update(Player player);
	public void deletePlayerByName(String name);
	public Player getPlayerByName(String name);
	public ArrayList<Player> getAllPlayers();
	
}
