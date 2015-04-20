/**
 * puppy
 * 2015年3月9日 上午10:28:15
 * TODO
 */
package dataService;

import java.util.ArrayList;

import po.GamePO;

public interface GameDao {
	
	public void add(GamePO game);
	
	public void update(GamePO game);
	
	public void deleteGameByLabel(String label);
	
	public GamePO getGameByLabel(String label);
	
	public ArrayList<GamePO> getAllGames();
	
}
