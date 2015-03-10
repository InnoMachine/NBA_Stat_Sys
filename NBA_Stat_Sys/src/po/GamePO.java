/**
 * puppy
 * 2015年3月8日 下午3:06:02
 * TODO
 */
package po;

public class GamePO {
	
	private String gameLabel;
	private String date;
	private String versus;
	private String guestTeam;
	private String homeTeam;
	private Scoreboard scoreOverall;
	private Scoreboard score1st;
	private Scoreboard score2nd;
	private Scoreboard score3rd;
	private Scoreboard score4th;
	
	private TeamPerformance guestTP;
	private TeamPerformance homeTP;
	
	public String toString() {
		return null;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVersus() {
		return versus;
	}

	public void setVersus(String versus) {
		this.versus = versus;
	}

	public String getGuestTeam() {
		return guestTeam;
	}

	public void setGuestTeam(String guestTeam) {
		this.guestTeam = guestTeam;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Scoreboard getScoreOverall() {
		return scoreOverall;
	}

	public void setScoreOverall(Scoreboard scoreOverall) {
		this.scoreOverall = scoreOverall;
	}

	public Scoreboard getScore1st() {
		return score1st;
	}

	public void setScore1st(Scoreboard score1st) {
		this.score1st = score1st;
	}

	public Scoreboard getScore2nd() {
		return score2nd;
	}

	public void setScore2nd(Scoreboard score2nd) {
		this.score2nd = score2nd;
	}

	public Scoreboard getScore3rd() {
		return score3rd;
	}

	public void setScore3rd(Scoreboard score3rd) {
		this.score3rd = score3rd;
	}

	public Scoreboard getScore4th() {
		return score4th;
	}

	public void setScore4th(Scoreboard score4th) {
		this.score4th = score4th;
	}

	public TeamPerformance getGuestTP() {
		return guestTP;
	}

	public void setGuestTP(TeamPerformance guestTP) {
		this.guestTP = guestTP;
	}

	public TeamPerformance getHomeTP() {
		return homeTP;
	}

	public void setHomeTP(TeamPerformance homeTP) {
		this.homeTP = homeTP;
	}

	public String getGameLabel() {
		return gameLabel;
	}

	public void setGameLabel(String gameLabel) {
		this.gameLabel = gameLabel;
	}
	
	
	
	
}
