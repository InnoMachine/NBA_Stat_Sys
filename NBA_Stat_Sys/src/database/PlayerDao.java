/**
 * puppy
 * 2015年3月9日 上午10:18:17
 * TODO
 */
package database;

import java.util.ArrayList;

import po.PlayerPO;

public interface PlayerDao {
	
	public void add(PlayerPO player);
	public void update(PlayerPO player);
	public void deletePlayerByName(String name);
	public PlayerPO getPlayerByName(String name);
	public ArrayList<PlayerPO> getAllPlayers();
	
}
