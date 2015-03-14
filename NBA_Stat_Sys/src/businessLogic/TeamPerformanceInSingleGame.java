package businessLogic;

import java.util.ArrayList;

public class TeamPerformanceInSingleGame {
	private String name;
	private int time;//sudo
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
	private double roundAttack;      //进攻回合
	private int opOffensiveRebound;  //对手进攻篮板
	private int opDefensiveRebound;  //对手防守篮板
	private double opRoundAttack;       //对手进攻回合
	private int opTwoPointShotNum;   //对手两分球出手
	private int opScore;
	private int winning;
	public ArrayList <PlayerPerformanceInSingleGame> playerlist;
	public TeamPerformanceInSingleGame(String name)
	{
		this.name =name;
		time=0;
		hitNum=0;
		shotNum=0;
		threePointHitNum=0;
		threePointShotNum=0;
		freeThrowHitNum=0;
		freeThrowShotNum=0;
		offensiveRebound=0;
		defensiveRebound=0;
		reboundOverall=0;
		assistance=0;
		block=0;
		turnover=0;
		foul=0;
		score=0;
		roundAttack=0;
		opOffensiveRebound=0;
		opDefensiveRebound=0;
		opRoundAttack=0;
		opTwoPointShotNum=0;
	}
	public void CalculateRoundAttack()
	{
		roundAttack = shotNum+0.4*freeThrowShotNum-1.07*
				(offensiveRebound/(offensiveRebound+opDefensiveRebound)*(shotNum-hitNum))+1.07*turnover;
	}
	public void isWinning()
	{
		if(this.score>this.opScore)
		{
			winning = 1;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
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
	public int getSteal() {
		return steal;
	}

	public void setSteal(int steal) {
		this.steal = steal;
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
	public double getRoundAttack() {
		return roundAttack;
	}
	public void setRoundAttack(double roundAttack) {
		this.roundAttack = roundAttack;
	}
	public int getOpOffensiveRebound() {
		return opOffensiveRebound;
	}
	public void setOpOffensiveRebound(int opOffensiveRebound) {
		this.opOffensiveRebound = opOffensiveRebound;
	}
	public int getOpDefensiveRebound() {
		return opDefensiveRebound;
	}
	public void setOpDefensiveRebound(int opDefensiveRebound) {
		this.opDefensiveRebound = opDefensiveRebound;
	}
	public double getOpRoundAttack() {
		return opRoundAttack;
	}
	public void setOpRoundAttack(double opRoundAttack) {
		this.opRoundAttack = opRoundAttack;
	}
	public int getOpTwoPointShotNum() {
		return opTwoPointShotNum;
	}
	public void setOpTwoPointShotNum(int opTwoPointShotNum) {
		this.opTwoPointShotNum = opTwoPointShotNum;
	}
	public int getOpScore() {
		return opScore;
	}
	public void setOpScore(int opScore) {
		this.opScore = opScore;
	}
	public int getWinning() {
		return winning;
	}
	public void setWinning(int winning) {
		this.winning = winning;
	}
	
}
