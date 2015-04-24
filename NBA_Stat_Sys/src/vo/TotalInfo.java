package vo;

import java.math.BigDecimal;

public class TotalInfo {
	BigDecimal b;
	private int score;
	private int rebound;
	private int assistance;
	private int three;
	private int free;
	private int gamenum;
	private double scoreField;
	private double reboundField;
	private double assistanceField;
	private double threeField;
	private double freeField;
	
	public TotalInfo(){
		score = 0;
		rebound =0;
		assistance=0;
		three=0;
		free=0;
		gamenum=0;
		scoreField=0;
		reboundField =0;
		assistanceField=0;
		assistanceField = 0;
		threeField =0;
		freeField = 0;
				
				
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score){
		this.score+=score;
	}

	public int getRebound() {
		return rebound;
	}

	public void setRebound(int rebound) {
		this.rebound = rebound;
	}
	
	public void addRebound(int r){
		this.rebound+=r;
	}
	public int getAssistance() {
		return assistance;
	}

	public void setAssistance(int assistance) {
		this.assistance = assistance;
	}
	public void addGameNum(){
		this.gamenum++;
	}
	public void addAssistance(int a ){
		this.assistance+=a;
	}
	public int getThree() {
		return three;
	}

	public void setThree(int three) {
		this.three = three;
	}
	public void addThree(int t){
		this.three+=t;
	}
	public int getGamenum() {
		return gamenum;
	}

	public void setGamenum(int gamenum) {
		this.gamenum = gamenum;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}
	public void addFree(int f){
		this.free+=f;
	}
	public double getAssistanceField() {
		return assistanceField;
	}

	public void setAssistanceField(double assistanceField) {
		this.assistanceField = assistanceField;
	}

	public double getThreeField() {
		return threeField;
	}
	public void calcAssistanceField(){
		b = new BigDecimal(this.assistance/this.gamenum);
		this.assistanceField  = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}

	public void setThreeField(double threeField) {
		this.threeField = threeField;
	}

	public void calcThreeField(){
		b = new BigDecimal(this.three/this.gamenum);
		this.threeField  = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
	public double getFreeField() {
		return freeField;
	}

	public void setFreeField(double freeField) {
		this.freeField = freeField;
	}
	public void calcFreeField(){
		b = new BigDecimal(this.free/this.gamenum);
		this.freeField  = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}

	public double getReboundField() {
		return reboundField;
	}

	public void setReboundField(double reboundField) {
		this.reboundField = reboundField;
	}

	public void calcReboundField(){
		b = new BigDecimal(this.rebound/this.gamenum);
		this.reboundField  = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		
	}
	public double getScoreField() {
		return scoreField;
	}

	public void setScoreField(double scoreField) {
		this.scoreField = scoreField;
	}
	
	public void calcScoreField(){
		b = new BigDecimal(this.score/this.gamenum);
		this.scoreField  = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
}
