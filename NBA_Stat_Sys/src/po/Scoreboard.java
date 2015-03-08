/**
 * puppy
 * 2015年3月8日 下午3:35:14
 * TODO
 */
package po;

public class Scoreboard {

	private int guestScore;
	private int homeScore;
	
	public String toString(){
		return guestScore + "-" + homeScore;
	}
	
	public int getGuestScore() {
		return guestScore;
	}
	public void setGuestScore(int guestScore) {
		this.guestScore = guestScore;
	}
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	
}
