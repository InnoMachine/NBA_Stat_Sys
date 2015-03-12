package vo;


public class PlayerVo {
	private int number;
	private String position;
	private String height;
	private String weight;
	private String birth;
	private int age;
	private int exp;
	private String school;
	private String ActionImgPath;
	private String PortraitImgPath;
	
	
	private String name;
	private String team;
	//先发场数？莫非是时间最长的5个。。
	private int gameNum;
	private int reboundOverall;
	private int assistance;
	private String time;
	private double hitRate;
	private double threePointHitRate;//三分球命中率
	private double freeThrowRate;
	private int attackingNum;
	private int defensiveNum;
	private int block;               //盖帽数
	private int turnover;            //失误数
	private int foul;                //犯规数
	private int steal;
	private int score;               //总得分
	private int efficiency;          //效率
	private double GmSc;
	private double trueHitRate;
	private double hitEfficiency;
	private double reboundOverallRate;
	private double offensiveReboundRate;
	private double defensiveReboundRate;
	private double assistanceRate;          
	private double blockRate;               
	private double stealRate;
	private double useRate;
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getActionImgPath() {
		return ActionImgPath;
	}
	public void setActionImgPath(String actionImgPath) {
		ActionImgPath = actionImgPath;
	}
	public String getPortraitImgPath() {
		return PortraitImgPath;
	}
	public void setPortraitImgPath(String portraitImgPath) {
		PortraitImgPath = portraitImgPath;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int  getGameNum() {
		return gameNum;
	}
	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double gethitRate() {
		return hitRate;
	}
	public void sethitRate(double hitRate) {
		this.hitRate = hitRate;
	}
	public double getthreePointHitRate() {
		return threePointHitRate;
	}
	public void setthreePointHitRate(double threePointHitRate) {
		this.threePointHitRate = threePointHitRate;
	}
	public double getfreeThrowRate() {
		return freeThrowRate;
	}
	public void setfreeThrowRate(double freeThrowRate) {
		this.freeThrowRate = freeThrowRate;
	}
	public int getAttackingNum() {
		return attackingNum;
	}
	public void setAttackingNum(int attackingNum) {
		this.attackingNum = attackingNum;
	}
	public int getDefensiveNum() {
		return defensiveNum;
	}
	public void setDefensiveNum(int defensiveNum) {
		this.defensiveNum = defensiveNum;
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
	public int getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}
	public double getGmSc() {
		return GmSc;
	}
	public void setGmSc(double GmSc) {
		this.GmSc = GmSc;
	}
	public double getTrueHitRate() {
		return trueHitRate;
	}
	public void setTrueHitRate(double trueHitRate) {
		this.trueHitRate = trueHitRate;
	}
	public double getHitEfficiency() {
		return hitEfficiency;
	}
	public void setHitEfficiency(double hitEfficiency) {
		this.hitEfficiency = hitEfficiency;
	}
	public double getReboundOverallRate() {
		return reboundOverallRate;
	}
	public void setReboundOverallRate(double reboundOverallRate) {
		this.reboundOverallRate = reboundOverallRate;
	}
	public double getOffensiveReboundRate() {
		return offensiveReboundRate;
	}
	public void setOffensiveReboundRate(double offensiveReboundRate) {
		this.offensiveReboundRate = offensiveReboundRate;
	}
	public double getDefensiveReboundRate() {
		return defensiveReboundRate;
	}
	public void setDefensiveReboundRate(double defensiveReboundRate) {
		this.defensiveReboundRate = defensiveReboundRate;
	}
	public double getAssistanceRate() {
		return assistanceRate;
	}
	public void setAssistanceRate(double assistanceRate) {
		this.assistanceRate = assistanceRate;
	}
	public double getBlockRate() {
		return blockRate;
	}
	public void setBlockRate(double blockRate) {
		this.blockRate = blockRate;
	}
	public double getStealRate() {
		return stealRate;
	}
	public void setStealRate(double stealRate) {
		this.stealRate = stealRate;
	}
	public double getUseRate() {
		return useRate;
	}
	public void setUseRate(double useRate) {
		this.useRate = useRate;
	}
	
	
	
}
