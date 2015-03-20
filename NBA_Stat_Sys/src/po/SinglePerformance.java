/**
 * puppy
 * 2015年3月8日 下午3:41:24
 * TODO
 */
package po;

public class SinglePerformance {
	
	private String name;
	private String position;
	private int timeBySeconds;//sudo
	private int hitNum;
	private int shotNum;
	private int threePointHitNum;
	private int threePointShotNum;
	private int freeThrowHitNum;
	private int freeThrowShotNum;
	private int offensiveRebound;
	private int defensiveRebound;
	private int reboundOverall;
	private int assistance;
	private int steal;
	private int block;
	private int turnover;
	private int foul;
	private int score;
	
	public String toString() {
		return null;//sudo
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getTimeBySeconds() {
		return timeBySeconds;
	}
	public void setTimeBySeconds(int timeBySeconds) {
		this.timeBySeconds = timeBySeconds;
	}
	public int getHitNum() {
		return hitNum;
	}
	public void setHitNum(int hitNum) {
		this.hitNum = hitNum;
	}
	public int getShotNum() {
		return shotNum;
	}
	public void setShotNum(int shotNum) {
		this.shotNum = shotNum;
	}
	public int getThreePointHitNum() {
		return threePointHitNum;
	}
	public void setThreePointHitNum(int threePointHitNum) {
		this.threePointHitNum = threePointHitNum;
	}
	public int getThreePointShotNum() {
		return threePointShotNum;
	}
	public void setThreePointShotNum(int threePointShotNum) {
		this.threePointShotNum = threePointShotNum;
	}
	public int getFreeThrowHitNum() {
		return freeThrowHitNum;
	}
	public void setFreeThrowHitNum(int freeThrowHitNum) {
		this.freeThrowHitNum = freeThrowHitNum;
	}
	public int getFreeThrowShotNum() {
		return freeThrowShotNum;
	}
	public void setFreeThrowShotNum(int freeThrowShotNum) {
		this.freeThrowShotNum = freeThrowShotNum;
	}
	public int getOffensiveRebound() {
		return offensiveRebound;
	}
	public void setOffensiveRebound(int offensiveRebound) {
		this.offensiveRebound = offensiveRebound;
	}
	public int getDefensiveRebound() {
		return defensiveRebound;
	}
	public void setDefensiveRebound(int defensiveRebound) {
		this.defensiveRebound = defensiveRebound;
	}
	public int getReboundOverall() {
		return reboundOverall;
	}
	public void setReboundOverall(int reboundOverall) {
		this.reboundOverall = reboundOverall;
	}
	public int getAssistance() {
		return assistance;
	}
	public void setAssistance(int assistance) {
		this.assistance = assistance;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getTurnover() {
		return turnover;
	}
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	public int getFoul() {
		return foul;
	}
	public void setFoul(int foul) {
		this.foul = foul;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public int getSteal() {
		return steal;
	}

	public void setSteal(int steal) {
		this.steal = steal;
	}
	
	public static SinglePerformance makeSP(String spText){
		
		String[] splited = spText.split(";");
		String name = splited[0];
		String position;
		if(splited[1].equals("")){
			position = null;
		}else{
			position = splited[1];
		}
		String timeText = splited[2];
		String[] splitedTime = timeText.split(":");
		int timeByText = Integer.parseInt(splitedTime[0])*60 + Integer.parseInt(splitedTime[1]);
		int hitNum = Integer.parseInt(splited[3]);
		int shotNum = Integer.parseInt(splited[4]);
		int threePointHitNum = Integer.parseInt(splited[5]);
		int threePointShotNum = Integer.parseInt(splited[6]);
		int freeThrowHitNum = Integer.parseInt(splited[7]);
		int freeThrowShotNum = Integer.parseInt(splited[8]);
		int offensiveRebound = Integer.parseInt(splited[9]);
		int defensiveRebound = Integer.parseInt(splited[10]);
		int reboundOverall = Integer.parseInt(splited[11]);
		int assistance = Integer.parseInt(splited[12]);
		int steal = Integer.parseInt(splited[13]);
		int block = Integer.parseInt(splited[14]);
		int turnover = Integer.parseInt(splited[15]);
		int foul = Integer.parseInt(splited[16]);
		int score = Integer.parseInt(splited[17]);
		
		SinglePerformance sp = new SinglePerformance();
		sp.setName(name);
		sp.setPosition(position);
		sp.setTimeBySeconds(timeByText);
		sp.setHitNum(hitNum);
		sp.setShotNum(shotNum);
		
		sp.setThreePointHitNum(threePointHitNum);
		sp.setThreePointShotNum(threePointShotNum);
		sp.setFreeThrowHitNum(freeThrowHitNum);
		sp.setFreeThrowShotNum(freeThrowShotNum);
		sp.setOffensiveRebound(offensiveRebound);
		
		sp.setDefensiveRebound(defensiveRebound);
		sp.setReboundOverall(reboundOverall);
		sp.setAssistance(assistance);
		sp.setSteal(steal);
		sp.setBlock(block);
		
		sp.setTurnover(turnover);
		sp.setFoul(foul);
		sp.setScore(score);
		
		return sp;
		
	}
	
}
