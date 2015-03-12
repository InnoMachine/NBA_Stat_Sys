package vo;

import po.Conference;
import po.Division;

public class TeamVo {

	private String teamName;
	private String abbreviation;
	private String city;
	private Conference conference;
	private Division division;
	private String homeField;
	private String birthYear;
	private String imgPath;
	
	private int GameNum;
	private int hitNum;
	private int shotNum;
	private int threePointHitNum;
	private int threePointShotNum;
	private int freeThrowHitNum;
	private int freeThrowShotNum;
	private int offensiveRebound;
	private int defensiveRebound;
	private int reboundOverall;      //篮板数
	private int assistance;          //助攻
	private int block;               //盖帽数
	private int turnover;            //失误数
	private int foul;                //犯规数
	private int steal;
	private int score;               //总得分
	private double hitRate;          //投篮命中率
	private double threePointHitRate;//三分球命中率
	private double freeThrowRate;    //罚球命中率
	private double winningRate;      //胜率
	private double roundAttack;      //进攻回合
	private double attackingEfficiency;//进攻效率
	private double defensiveEfficiency;//防守效率
	private double reboundEfficiency;//篮板效率
	private double stealEfficiency;//没有抢断数据？
	private double assistanceEfficiency;//助攻率
	
	public String getTeamName(){
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Conference getConference() {
		return conference;
	}
	public void setConference(Conference conf) {
		this.conference = conf;
	}
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division div) {
		this.division = div;
	}
	public String getHomeField() {
		return homeField;
	}
	public void setHomeField(String homeField) {
		this.homeField = homeField;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getGameNum() {
		return GameNum;
	}
	public void setGameNum(int GameNum) {
		this.GameNum = GameNum;
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
	public int getSteal() {
		return steal;
	}
	public void setSteal(int steal) {
		this.steal = steal;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getHitRate() {
		return hitRate;
	}
	public void setHitRate(double hitRate) {
		this.hitRate = hitRate;
	}
	public double getThreePointHitRate() {
		return threePointHitRate;
	}
	public void setThreePointHitRate(double threePointHitRate) {
		this.threePointHitRate = threePointHitRate;
	}
	public double getFreeThrowRate() {
		return freeThrowRate;
	}
	public void setFreeThrowRate(double freeThrowRate) {
		this.freeThrowRate = freeThrowRate;
	}
	public double getWinningRate() {
		return winningRate;
	}
	public void setWinningRate(double winningRate) {
		this.winningRate = winningRate;
	}
	public double getRoundAttack() {
		return roundAttack;
	}
	public void setRoundAttack(double roundAttack) {
		this.roundAttack = roundAttack;
	}
	public double getAttackingEfficiency() {
		return attackingEfficiency;
	}
	public void setAttackingEfficiency(double attackingEfficiency) {
		this.attackingEfficiency = attackingEfficiency;
	}
	public double getDefensiveEfficiency() {
		return defensiveEfficiency;
	}
	public void setDefensiveEfficiency(double defensiveEfficiency) {
		this.defensiveEfficiency = defensiveEfficiency;
	}
	public double getReboundEfficiency() {
		return reboundEfficiency;
	}
	public void setReboundEfficiency(double reboundEfficiency) {
		this.reboundEfficiency = reboundEfficiency;
	}
	public double getStealEfficiency() {
		return stealEfficiency;
	}
	public void setStealEfficiency(double stealEfficiency) {
		this.stealEfficiency = stealEfficiency;
	}
	public double getAssistanceEfficiency() {
		return assistanceEfficiency;
	}
	public void setAssistanceEfficiency(double assistanceEfficiency) {
		this.assistanceEfficiency = assistanceEfficiency;
	}
}
