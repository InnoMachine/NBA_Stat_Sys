package businessLogic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import po.GameDate;
import po.GamePO;
import po.PlayerPO;
import po.SeasonTracker;
import po.SinglePerformance;
import po.TeamPO;
import po.TeamPerformance;
import vo.GameVo;
import vo.PlayerGames;
import vo.PlayerPerformanceInSingleGame;
import vo.PlayerRecentGames;
import vo.PlayerVo;
import vo.SeasonMult;
import vo.TeamGames;
import vo.TeamPerformanceInSingleGame;
import vo.TeamRecentGames;
import vo.TeamVo;
import vo.TotalInfo;
import dataService.GameDao;
import dataService.GameDaoImpl;
import dataService.PlayerDao;
import dataService.PlayerDaoImpl;
import dataService.SystemDao;
import dataService.SystemDaoImpl;
import dataService.TeamDao;
import dataService.TeamDaoImpl;

public class Data_Handler {
	private static Data_Handler instance;
	
	protected PlayerDao playerdao;
	protected GameDao gamedao;
	protected TeamDao teamdao;
	protected SystemDao systemdao;
	private ArrayList<SeasonMult> seasonlist;
	private ArrayList<PlayerPO> listpo;
	private ArrayList<TeamPO> teamlistpo;
	private ArrayList<PlayerVo> listvo;
	private ArrayList<TeamVo> teamlistvo;
	private ArrayList<GamePO> gamelist;
	private ArrayList<TeamRecentGames> trecgames;
	private ArrayList<PlayerRecentGames> precgames;
	private ArrayList<GameVo> gamevo;
	private ArrayList<PlayerGames> listpg;
	private ArrayList<TeamGames> listtg;
	private SeasonTracker st;
	private TotalInfo ti;
	private TotalInfo teamti;
	private String seasonid = "";
	BigDecimal b;  
    
	public static Data_Handler getInstance()
	{
		if(instance==null)
		{
			instance = new Data_Handler();
		}
		return instance;
	}
	private Data_Handler()
	{
		seasonlist = new ArrayList<SeasonMult>();
		playerdao = new PlayerDaoImpl();
		gamedao = new GameDaoImpl();
		teamdao = new TeamDaoImpl();
		systemdao = new SystemDaoImpl();
		for(int i=0;i<15;i++){
			String season="";
			if(i<9){
				season="0"+i+"-"+"0"+(i+1);
			}
			else if(i==9){
				season="09-10";
			}
			else{
				season=i+"-"+(i+1);
			}
			seasonid = season;
			listpo  = playerdao.getAllPlayers();
			teamlistpo = teamdao.getAllTeams();
			listvo = new ArrayList<PlayerVo>();
			teamlistvo = new ArrayList<TeamVo>();
			gamelist = gamedao.getAllGames(season);
			trecgames = new ArrayList<TeamRecentGames>();
			precgames = new ArrayList<PlayerRecentGames>();
			gamevo = new ArrayList<GameVo>();
			listpg = new ArrayList<PlayerGames>();
			listtg = new ArrayList<TeamGames>();
			ti = new TotalInfo();
			teamti = new TotalInfo();
			st = systemdao.getStById("12-13");
			SetPlayerVo();
			SetTeamVo();
			loadGames();
			PlayerDivisionSet();
			playerCalculate();
			TeamCalculate();
			TotalCalculate();
			SeasonMult sm = new SeasonMult();
			sm.setSeason(season);
			sm.gamevo = gamevo;
			sm.listpg = listpg;
			sm.listvo = listvo;
			sm.teamlistvo = teamlistvo;
			sm.ti = ti;
			sm.teamti =teamti;
			sm.listtg = listtg;
			sm.trecgames = trecgames;
			sm.precgames = precgames;
			seasonlist.add(sm);
		}
		SeasonMult sm = seasonlist.get(13);
		gamevo = sm.gamevo;
		listpg = sm.listpg;
		listvo = sm.listvo;
		listtg = sm.listtg;
		teamlistvo = sm.teamlistvo;
		ti = sm.ti;
		teamti = sm.teamti;
		trecgames = sm.trecgames;
		precgames = sm.precgames;
	}
	
	private void TotalCalculate() {
		if(ti.getGamenum()!=0){
			ti.calcAssistanceField();
			ti.calcFreeRate();
			ti.calcReboundField();
			ti.calcScoreField();
			ti.calcThreeRate();
			ti.calcBlockField();
			ti.calcMinute();
			ti.calcStealField();
			ti.calcTurnoverFied(); 
			ti.calcFoulField();
			ti.calcHitField();
			ti.setGamenumField(new BigDecimal((double)ti.getGamenum()/listvo.size()).
					setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			ti.calcShotField();
			
		}
		if(teamti.getGamenum()!=0){
			teamti.calcAssistanceField();
			teamti.calcFreeRate();
			teamti.calcReboundField();
			teamti.calcScoreField();
			teamti.calcThreeRate();
			teamti.calcBlockField();
			teamti.calcMinute();
			teamti.calcStealField();
			teamti.calcTurnoverFied(); 
			teamti.calcFoulField();
			teamti.calcHitField();
			teamti.setGamenumField((double)teamti.getGamenum()/listvo.size());
			teamti.calcRoundAttackField();
			teamti.calcShotField();
		}
		
	}
	private void PlayerDivisionSet() {
		for(PlayerVo temp:listvo)
		{
			for(int k =0;k<teamlistvo.size();k++)
			{
				if(teamlistvo.get(k).getAbbreviation().equals(temp.getTeam()))
				{
					temp.setDivision(teamlistvo.get(k).getDivision());
					break;
				}
			}
		}
					
		
	}
	
	private void TeamCalculate() {
		for(TeamVo temp:teamlistvo)
		{
			SetTeamRoundAttack(temp);
			if(temp.getRoundAttack()!=0)
			{
				TeamSetHitRate(temp);
				TeamSetThreePointHitRate(temp);
				TeamSetFreeThrowRate(temp);
				TeamSetWinningRate(temp);
				TeamSetAttackingEfficiency(temp);
				TeamSetDefensiveEfficiency(temp);
				TeamSetReboundEfficiency(temp);
				TeamSetOffensiveReboundEfficiency(temp);
				TeamSetDefensiveReboundEfficiency(temp);
				TeamSetStealEfficiency(temp);
				TeamSetAssistanceEfficiency(temp);
				temp.setHitNumField(turnToTwoPoint((double)temp.getHitNum()/temp.getGameNum()));
				temp.setShotNumField(turnToTwoPoint((double)temp.getShotNum()/temp.getGameNum()));
				temp.setThreePointHitNumField(turnToTwoPoint((double)temp.getThreePointHitNum()/temp.getGameNum()));
				temp.setThreePointShotNumField(turnToTwoPoint((double)temp.getThreePointShotNum()/temp.getGameNum()));
				temp.setFreeThrowHitNumField(turnToTwoPoint((double)temp.getFreeThrowHitNum()/temp.getGameNum()));
				temp.setFreeThrowShotNumField(turnToTwoPoint((double)temp.getFreeThrowShotNum()/temp.getGameNum()));
				temp.setOffensiveReboundField(turnToTwoPoint((double)temp.getOffensiveRebound()/temp.getGameNum()));
				temp.setDefensiveReboundField(turnToTwoPoint((double)temp.getDefensiveRebound()/temp.getGameNum()));
				temp.setReboundOverallField(turnToTwoPoint((double)temp.getReboundOverall()/temp.getGameNum()));
				temp.setAssistanceField(turnToTwoPoint((double)temp.getAssistance()/temp.getGameNum()));
				temp.setBlockField(turnToTwoPoint((double)temp.getBlock()/temp.getGameNum()));
				temp.setTurnoverField(turnToTwoPoint((double)temp.getTurnover()/temp.getGameNum()));
				temp.setFoulField(turnToTwoPoint((double)temp.getFoul()/temp.getGameNum()));
				temp.setStealField(turnToTwoPoint((double)temp.getSteal()/temp.getGameNum()));
				temp.setScoreField(turnToTwoPoint((double)temp.getScore()/temp.getGameNum()));
				temp.setRoundAttackField(turnToTwoPoint((double)temp.getRoundAttack()/temp.getGameNum()));
			}
			
		}
		
	}
	
	private void TeamSetDefensiveReboundEfficiency(TeamVo temp) {
		double r = temp.getDefensiveRebound()/(double)(temp.getDefensiveRebound()+temp.getOpOffensiveRebound());
		b = new BigDecimal(r);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setDefensiveReboundEfficiency(f);
	}

	private void TeamSetOffensiveReboundEfficiency(TeamVo temp) {
		double r = temp.getOffensiveRebound()/(double)(temp.getOffensiveRebound()+temp.getDefensiveRebound());
		b = new BigDecimal(r);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setOffensiveReboundEfficiency(f);
	}

	private void SetTeamRoundAttack(TeamVo temp) {
		double r = temp.getRoundAttack();
		b = new BigDecimal(r);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setRoundAttack(f);
	}
	
	private void TeamSetAssistanceEfficiency(TeamVo temp) {
		double r = temp.getAssistance()/(double)temp.getRoundAttack()*100;
		b = new BigDecimal(r);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setAssistanceEfficiency(f);
	}
	
	private void TeamSetStealEfficiency(TeamVo temp) {
		double r = temp.getSteal()/(double)temp.getOpRoundAttack()*100;
		b = new BigDecimal(r);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setStealEfficiency(f);
	}
	
	private void TeamSetReboundEfficiency(TeamVo temp) {
		double r = temp.getReboundOverall()/(double)(temp.getReboundOverall()+temp.getOpReboundAll());
		b = new BigDecimal(r);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setReboundEfficiency(f);
	}
	
	private void TeamSetDefensiveEfficiency(TeamVo temp) {
		double r = temp.getOpScore()/(double)temp.getOpRoundAttack()*100;
		b = new BigDecimal(r);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setDefensiveEfficiency(f);
	}
	
	private void TeamSetAttackingEfficiency(TeamVo temp) {
		double r = 100*(double)temp.getScore()/(double)temp.getRoundAttack();
		if(r!=0)
		{
			b = new BigDecimal(r);
			double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
			temp.setAttackingEfficiency(f);
		}
		else
			temp.setAttackingEfficiency(0);
		
	}
	
	private void TeamSetWinningRate(TeamVo temp) {
		double r = (double)temp.getWinningNum()/(double)temp.getGameNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setWinningRate(f);
		
	}
	
	private void TeamSetFreeThrowRate(TeamVo temp) {
		double r = temp.getFreeThrowHitNum()/(double)temp.getFreeThrowShotNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setFreeThrowRate(f);
		
	}
	
	private void TeamSetThreePointHitRate(TeamVo temp) {
		double r = temp.getThreePointHitNum()/(double)temp.getThreePointShotNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setThreePointHitRate(f);
	}
	
	private void TeamSetHitRate(TeamVo temp) {
		double r = temp.getHitNum()/(double)temp.getShotNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setHitRate(f);
	}
	
	private void playerCalculate() {
		for(PlayerVo temp:listvo)
		{
			
			if(temp.getShotNum()!=0){
				PlayerSetHitRate(temp);
			}else temp.setHitRate(0);
			
			if(temp.getThreePointShotNum()!=0){
				PlayerSetThreePointHitRate(temp);
			}else temp.setThreePointHitRate(0);
			if(temp.getFreeThrowShotNum()!=0){
				PlayerSetFreeThrowRate(temp);
			}else temp.setFreeThrowRate(0);
			
			temp.setBlock(temp.getBlock());
			temp.setTurnover(temp.getTurnover());
			temp.setFoul(temp.getFoul());
			temp.setSteal(temp.getSteal());
			temp.setScore(temp.getScore());
			
			temp.setEfficiency(temp.getScore()+temp.getBlock()+temp.getReboundOverall()+
					temp.getAssistance()+temp.getSteal()-temp.getFreeThrowShotNum()-
					temp.getShotNum()+temp.getHitNum()+temp.getFreeThrowHitNum()-temp.getTurnover());
			
			PlayerSetGmSc(temp);
			
			if(temp.getShotNum()!=0)
				PlayerSetHitEfficiency(temp);
			else temp.setHitEfficiency(0);
			if(temp.getTime()!=0)
			{
				PlayerSetTrueHitRate(temp);
				PlayerSetReboundOverallRate(temp);
				PlayerSetOffensiveReboundRate(temp);
				PlayerSetDefensiveReboundRate(temp);
				PlayerSetAssistanceRate(temp);
				PlayerSetStealRate(temp);
				PlayerSetBlockRate(temp);
				PlayerSetTurnOverRate(temp);
				PalyerSetUseRate(temp);
			}else 
			{
				temp.setTrueHitRate(0);
				temp.setReboundOverallRate(0);
				temp.setOffensiveReboundRate(0);
				temp.setDefensiveReboundRate(0);
				temp.setAssistanceRate(0);
				temp.setStealRate(0);
				temp.setBlockRate(0);
				temp.setTurnOverRate(0);
				temp.setUseRate(0);
			}
			if(temp.getGameNum()!=0)
			{
				temp.setScoreField(turnToTwoPoint((double)temp.getScore()/temp.getGameNum()));
				temp.setAttackingNumField(turnToTwoPoint((double)temp.getAttackingNum()/temp.getGameNum()));
				temp.setDefensiveNumField(turnToTwoPoint((double)temp.getDefensiveNum()/temp.getGameNum()));
				temp.setBlockField(turnToTwoPoint((double)temp.getBlock()/temp.getGameNum()));
				temp.setFoulField(turnToTwoPoint((double)temp.getFoul()/temp.getGameNum()));
				temp.setStealField(turnToTwoPoint((double)temp.getSteal()/temp.getGameNum()));
				temp.setHitNumField(turnToTwoPoint((double)temp.getHitNum()/temp.getGameNum()));
				temp.setReboundOverallField(turnToTwoPoint((double)temp.getReboundOverall()/temp.getGameNum()));
				temp.setShotNumField(turnToTwoPoint((double)temp.getShotNum()/temp.getGameNum()));
				temp.setGmScField(turnToTwoPoint((double)temp.getGmSc()/temp.getGameNum()));
				temp.setTimeField(turnToTwoPoint((double)temp.getTime()/temp.getGameNum()));
				temp.setThreePointHitNumField(turnToTwoPoint((double)temp.getThreePointHitNum()/temp.getGameNum()));
				temp.setThreePointShotNumField(turnToTwoPoint((double)temp.getThreePointShotNum()/temp.getGameNum()));
				temp.setFreeThrowHitNumField(turnToTwoPoint((double)temp.getFreeThrowHitNum()/temp.getGameNum()));
				temp.setFreeThrowShotNumField(turnToTwoPoint((double)temp.getFreeThrowShotNum()/temp.getGameNum()));
				temp.setEfficiencyField(turnToTwoPoint((double)temp.getEfficiency()/temp.getGameNum()));
				temp.setTurnoverField(turnToTwoPoint((double)temp.getTurnover()/temp.getGameNum()));
				temp.setAssistanceField(turnToTwoPoint((double)temp.getAssistance()/temp.getGameNum()));
				
				
			}else
			{
				temp.setScoreField(0);
				temp.setAttackingNumField(0);
				temp.setDefensiveNumField(0);
				temp.setBlockField(0);
				temp.setFoulField(0);
				temp.setStealField(0);
				temp.setHitNumField(0);
				temp.setShotNumField(0);
				temp.setReboundOverallField(0);
				temp.setGmScField(0);
				temp.setTimeField(0);
				temp.setThreePointHitNumField(0);
				temp.setThreePointShotNumField(0);
				temp.setFreeThrowHitNumField(0);
				temp.setFreeThrowShotNumField(0);
				temp.setEfficiencyField(0);

			}
			temp.setWeighted(temp.getScore()+temp.getReboundOverall()+temp.getBlock());
			
		}
	}
	
	private void PalyerSetUseRate(PlayerVo temp) {
		double r = (temp.getShotNum()+0.44*temp.getFreeThrowShotNum()+temp.getTurnover())
				*(temp.getteamTime()/5)/temp.getTime()/(temp.GetteamShotNum()+
						0.44*temp.getteamFreeThrowNum()+temp.getteamTurnOver());
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setUseRate(f);
	}
	
	private void PlayerSetTurnOverRate(PlayerVo temp) {
		double g =(temp.getShotNum()-temp.getThreePointShotNum()+0.44*temp.getFreeThrowShotNum()+temp.getTurnover());
		double r = 0;
		if(g!=0)
			r = temp.getTurnover()/g;
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setTurnOverRate(f);
	}
	
	private void PlayerSetBlockRate(PlayerVo temp) {
		if(temp.getOpTwoPointShotNum()!=0){
			double r = temp.getBlock()*((double)temp.getteamTime()/5)/temp.getTime()
					/(double)temp.getOpTwoPointShotNum();
			b = new BigDecimal(r*100);
			double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
			temp.setBlockRate(f);
		}
		else {
			temp.setBlockRate(0);
		}
	}
	
	private void PlayerSetStealRate(PlayerVo temp) {
		if(temp.getOpRoundAttack()!=0){
			double r = temp.getSteal()*((double)temp.getteamTime()/5)/temp.getTime()
					/(double)temp.getOpRoundAttack();
			b = new BigDecimal(r*100);
			double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
			temp.setStealRate(f);
		}
		else {
			temp.setStealRate(0);
		}
	}
	
	private void PlayerSetAssistanceRate(PlayerVo temp) {
		double r = temp.getAssistance()/((double)temp.getTime()/((double)temp.getteamTime()/5)
				*temp.GetteamHitNum()-temp.getHitNum());
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setAssistanceRate(f);
	}
	
	private void PlayerSetDefensiveReboundRate(PlayerVo temp) {
		double r = temp.getDefensiveNum()*((double)temp.getteamTime()/5)/temp.getTime()
				/(double)(temp.getteamDefensiveRebound()+temp.getOpDefensiveRebound());
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setDefensiveReboundRate(f);
	}
	
	private void PlayerSetOffensiveReboundRate(PlayerVo temp) {
		double s = (double)(temp.getteamOffensiveRebound()+temp.getOpOffensiveRebound());
		double r=0;
		if(s!=0){
			r = temp.getAttackingNum()*((double)temp.getteamTime()/5)/temp.getTime()
					/s;
			b = new BigDecimal(r*100);
			double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
			temp.setOffensiveReboundRate(f);
		}
		else{
			temp.setOffensiveReboundRate(0);
		}
		
	}
	
	private void PlayerSetReboundOverallRate(PlayerVo temp) {
		double r = temp.getReboundOverall()*((double)temp.getteamTime()/5)/temp.getTime()
				/(double)(temp.getteamRebound()+temp.getOpReboundAll());
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setReboundOverallRate(f);
	}
	
	private void PlayerSetHitEfficiency(PlayerVo temp) {
		double r = (temp.getHitNum()+0.5*temp.getThreePointHitNum())/temp.getShotNum();
		b = new BigDecimal(r);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setHitEfficiency(f);
	}
	
	private void PlayerSetTrueHitRate(PlayerVo temp) {
		double g =(double)(2*((double)temp.getShotNum()+temp.getThreePointShotNum()+0.44
				*temp.getFreeThrowShotNum()));
		double r=0;
		if(r!=0)
			r = temp.getScore()/g;
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setTrueHitRate(f);
	}
	
	private void PlayerSetGmSc(PlayerVo temp) {
		double r = (double)temp.getScore()+0.4*temp.getHitNum()-0.7*temp.getShotNum()-0.4*
				(temp.getFreeThrowShotNum()-temp.getFreeThrowHitNum())
				+0.7*temp.getAttackingNum()+0.3*temp.getDefensiveNum()+temp.getSteal()
				+0.7*temp.getAssistance()+0.7*temp.getBlock()-0.4*temp.getFoul()-(double)temp.getTurnover();
		b = new BigDecimal(r);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setGmSc(f);
		
	}
	
	private void PlayerSetFreeThrowRate(PlayerVo temp) {
		double r = temp.getFreeThrowHitNum()/(double)temp.getFreeThrowShotNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setFreeThrowRate(f);
		
	}
	
	private void PlayerSetThreePointHitRate(PlayerVo temp) {
		double r = temp.getThreePointHitNum()/(double)temp.getThreePointShotNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setThreePointHitRate(f);
		
	}
	
	private void PlayerSetHitRate(PlayerVo temp) {
		double r = temp.getHitNum()/(double)temp.getShotNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setHitRate(f);
		
	}
	
	private double turnToTwoPoint(double d)
	{
		b = new BigDecimal(d);
		double f = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();  
		return f;
	}
	
	private void loadGames() {
		for(int i=0;i<gamelist.size();i++)
		{
			if(gamelist.get(i).getGameDate()==null){
				continue;
			}
			GameVo game = new GameVo();
			TeamPerformance tpg = gamelist.get(i).getGuestTP();
			TeamPerformance tph = gamelist.get(i).getHomeTP();
			TeamPerformanceInSingleGame tgpg=setPerformance(tpg);
			TeamPerformanceInSingleGame tgph=setPerformance(tph);
			tgph.setIshome(true);
			tgpg.setIshome(false);
			tgph.setOpTeam(tgpg.getName());
			tgpg.setOpTeam(tgph.getName());
			tgph.setOpTeamP(tgpg.getName());
			tgpg.setOpTeamP(tgph.getName());
			tgpg.setOpDefensiveRebound(tgph.getDefensiveRebound());
			tgpg.setOpOffensiveRebound(tgph.getOffensiveRebound());
			tgpg.setOpTwoPointShotNum(tgph.getShotNum()-tgph.getThreePointShotNum());
			tgpg.setOpScore(tgph.getScore());
			tgpg.CalculateRoundAttack();
			tgph.setOpDefensiveRebound(tgpg.getDefensiveRebound());
			tgph.setOpOffensiveRebound(tgpg.getOffensiveRebound());
			tgph.setOpTwoPointShotNum(tgpg.getShotNum()-tgpg.getThreePointShotNum());
			tgph.setOpScore(tgpg.getScore());
			tgph.CalculateRoundAttack();
			tgph.isWinning();
			tgpg.isWinning();
			tgpg.setOpRoundAttack(tgph.getRoundAttack());
			tgph.setOpRoundAttack(tgpg.getRoundAttack());
			playerVoPSet(tgpg);
			playerVoPSet(tgph);
			teamVoPSet(tgpg);
			teamVoPSet(tgph);
			TGPRateSet(tgph);
			TGPRateSet(tgpg);
			
			CreateGameVo(game,tgpg,tgph,gamelist.get(i));
			gamevo.add(game);
		}
	}
	
	

	private void TGPRateSet(TeamPerformanceInSingleGame tgp) {
//		if(tgp.getGameDate()==null){
//			return;
//		}
		TGPSetFreeThrowRate(tgp);
		TGPSetThreePointHitRate(tgp);
		TGPSetHitRate(tgp);
	}

	private void TGPSetFreeThrowRate(TeamPerformanceInSingleGame temp) {
		if(temp.getFreeThrowShotNum()!=0){
		double r = temp.getFreeThrowHitNum()/(double)temp.getFreeThrowShotNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setFreeThrowRate(f);
		}
		else {
			temp.setFreeThrowRate(0);
		}
		
	}
	
	private void TGPSetThreePointHitRate(TeamPerformanceInSingleGame temp) {
		if(temp.getThreePointShotNum()!=0){
		double r = temp.getThreePointHitNum()/(double)temp.getThreePointShotNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setThreePointHitRate(f);
		}
		else {
			temp.setThreePointHitRate(0);
		}
	}
	
	private void TGPSetHitRate(TeamPerformanceInSingleGame temp) {
		if(temp.getShotNum()!=0){
		double r = temp.getHitNum()/(double)temp.getShotNum();
		b = new BigDecimal(r*100);
		double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		temp.setHitRate(f);
		}
		else {
			temp.setHitRate(0);
		}
	}
	private void CreateGameVo(GameVo vo, TeamPerformanceInSingleGame tgpg,
			TeamPerformanceInSingleGame tgph, GamePO po) {
		vo.setExtratime(po.getExtratime());
		vo.setGameDate(po.getGameDate());
		vo.setGameLabel(po.getGameLabel());
		vo.setGuestTeam(po.getGuestTeam());
		vo.setGuestTP(tgpg);
		vo.setHomeTeam(po.getHomeTeam());
		vo.setHomeTP(tgph);
		vo.setScore1st(po.getScore1st());
		vo.setScore2nd(po.getScore2nd());
		vo.setScore3rd(po.getScore3rd());
		vo.setScore4th(po.getScore4th());
		vo.setScoreOverall(po.getScoreOverall());
		vo.setSeasonId(po.getSeasonId());
		vo.setVersus(po.getVersus());
		tgpg.setGameDate(po.getGameDate());
		tgph.setGameDate(po.getGameDate());
		
		
	}

	private void teamVoPSet(TeamPerformanceInSingleGame tgp) {
		for(int i=0;i<teamlistvo.size();i++)
		{
			if(isTeam(tgp.getName(),teamlistvo.get(i).getAbbreviation()))
			{
				teamlistvo.get(i).setGameNum(teamlistvo.get(i).getGameNum()+1);
				teamlistvo.get(i).setTime(teamlistvo.get(i).getTime()+tgp.getTime());
				teamlistvo.get(i).setHitNum(teamlistvo.get(i).getHitNum()+tgp.getHitNum());
				teamlistvo.get(i).setShotNum(teamlistvo.get(i).getShotNum()+tgp.getShotNum());
				teamlistvo.get(i).setThreePointHitNum(teamlistvo.get(i).getThreePointHitNum()+tgp.getThreePointHitNum());
				teamlistvo.get(i).setThreePointShotNum(teamlistvo.get(i).getThreePointShotNum()+tgp.getThreePointShotNum());
				teamlistvo.get(i).setFreeThrowHitNum(teamlistvo.get(i).getFreeThrowHitNum()+tgp.getFreeThrowHitNum());
				teamlistvo.get(i).setFreeThrowShotNum(teamlistvo.get(i).getFreeThrowShotNum()+tgp.getFreeThrowShotNum());
				teamlistvo.get(i).setOffensiveRebound(teamlistvo.get(i).getOffensiveRebound()+tgp.getOffensiveRebound());
				teamlistvo.get(i).setDefensiveRebound(teamlistvo.get(i).getDefensiveRebound()+tgp.getDefensiveRebound());
				teamlistvo.get(i).setReboundOverall(teamlistvo.get(i).getReboundOverall()+tgp.getReboundOverall());
				teamlistvo.get(i).setAssistance(teamlistvo.get(i).getAssistance()+tgp.getAssistance());
				teamlistvo.get(i).setBlock(teamlistvo.get(i).getBlock()+tgp.getBlock());
				teamlistvo.get(i).setTurnover(teamlistvo.get(i).getTurnover()+tgp.getTurnover());
				teamlistvo.get(i).setFoul(teamlistvo.get(i).getFoul()+tgp.getFoul());
				teamlistvo.get(i).setSteal(teamlistvo.get(i).getSteal()+tgp.getSteal());
				teamlistvo.get(i).setScore(teamlistvo.get(i).getScore()+tgp.getScore());
				teamlistvo.get(i).setWiningNum(teamlistvo.get(i).getWinningNum()+tgp.getWinning());
				teamlistvo.get(i).setRoundAttack(teamlistvo.get(i).getRoundAttack()+tgp.getRoundAttack());
				teamlistvo.get(i).setOpDefensiveRebound(teamlistvo.get(i).getOpDefensiveRebound()+tgp.getOpDefensiveRebound());
				teamlistvo.get(i).setOpOffensiveRebound(teamlistvo.get(i).getOpOffensiveRebound()+tgp.getOpOffensiveRebound());
				teamlistvo.get(i).setOpReboundAll(teamlistvo.get(i).getOpReboundAll()+tgp.getOpDefensiveRebound()+tgp.getOpOffensiveRebound());
				teamlistvo.get(i).setOpRoundAttack(teamlistvo.get(i).getOpRoundAttack()+tgp.getOpRoundAttack());
				teamlistvo.get(i).setOpScore(teamlistvo.get(i).getOpScore()+tgp.getOpScore());
				teamlistvo.get(i).setOpTwoPointShotNum(teamlistvo.get(i).getOpTwoPointShotNum()+tgp.getOpTwoPointShotNum());
				if(tgp.isIshome()){
					teamlistvo.get(i).setFreeThrowShotNumhHome(teamlistvo.get(i).getFreeThrowShotNumhHome()+tgp.getFreeThrowShotNum());
				}
				else {
					teamlistvo.get(i).setFreeThrowShotNumhGuest(teamlistvo.get(i).getFreeThrowShotNumhGuest()+tgp.getFreeThrowShotNum());
				}
				
				teamti.addScore(tgp.getScore());
				teamti.addAssistance(tgp.getAssistance());
				teamti.addFree(tgp.getFreeThrowHitNum());
				teamti.addRebound(tgp.getReboundOverall());
				teamti.addThree(tgp.getThreePointHitNum());
				teamti.addGameNum();
				teamti.addHit(tgp.getHitNum());
				teamti.addBlock(tgp.getBlock());
				teamti.addFreeshot(tgp.getFreeThrowShotNum());
				teamti.addSteal(tgp.getSteal());
				teamti.addThreeshot(tgp.getThreePointShotNum());
				teamti.addTime(tgp.getTime());
				teamti.addTurnover(tgp.getTurnover());
				teamti.addFoul(tgp.getFoul());
				teamti.addRoundAttack(tgp.getRoundAttack());
				teamti.addShot(tgp.getShotNum());
			}
			
		}
		
	}
	
	private void playerVoPSet(TeamPerformanceInSingleGame tgp) {
		for(PlayerPerformanceInSingleGame temp:tgp.playerlist)
		{
			for(int i=0;i<listvo.size();i++)
			{
				if(temp.getName().equals(listvo.get(i).getName()))
				{
					
					listvo.get(i).setTeam(tgp.getName());
					listvo.get(i).setGameNum(listvo.get(i).getGameNum()+1);
					listvo.get(i).setTime(listvo.get(i).getTime()+temp.getTime());
					listvo.get(i).setHitNum(listvo.get(i).getHitNum()+temp.getHitNum());
					listvo.get(i).setShotNum(listvo.get(i).getShotNum()+temp.getShotNum());
					listvo.get(i).setThreePointHitNum(listvo.get(i).getThreePointHitNum()+temp.getThreePointHitNum());
					listvo.get(i).setThreePointShotNum(listvo.get(i).getThreePointShotNum()+temp.getThreePointShotNum());
					listvo.get(i).setFreeThrowHitNum(listvo.get(i).getFreeThrowHitNum()+temp.getFreeThrowHitNum());
					listvo.get(i).setFreeThrowShotNum(listvo.get(i).getFreeThrowShotNum()+temp.getFreeThrowShotNum());
					listvo.get(i).setAttackingNum(listvo.get(i).getAttackingNum()+temp.getOffensiveRebound());
					listvo.get(i).setDefensiveNum(listvo.get(i).getDefensiveNum()+temp.getDefensiveRebound());
					listvo.get(i).setReboundOverall(listvo.get(i).getReboundOverall()+temp.getReboundOverall());
					listvo.get(i).setAssistance(listvo.get(i).getAssistance()+temp.getAssistance());
					listvo.get(i).setSteal(listvo.get(i).getSteal()+temp.getSteal());
					listvo.get(i).setBlock(listvo.get(i).getBlock()+temp.getBlock());
					listvo.get(i).setTurnover(listvo.get(i).getTurnover()+temp.getTurnover());
					listvo.get(i).setFoul(listvo.get(i).getFoul()+temp.getFoul());
					listvo.get(i).setScore(listvo.get(i).getScore()+temp.getScore());
					listvo.get(i).setTwoTenNum(listvo.get(i).getTwoTenNum()+temp.getTwoTenNum());
					listvo.get(i).setFirstOnNum(listvo.get(i).getFirstOnNum()+temp.getFirstOn());
					listvo.get(i).setTeamRoundAttack(listvo.get(i).getTeamRoundAttack()+tgp.getRoundAttack());
					listvo.get(i).setteamFreeThrowNum(listvo.get(i).getteamFreeThrowNum()+tgp.getFreeThrowShotNum());
					listvo.get(i).setteamShotNum(listvo.get(i).GetteamShotNum()+tgp.getShotNum());
					listvo.get(i).setteamHitNum(listvo.get(i).GetteamHitNum()+tgp.getHitNum());
					listvo.get(i).setteamTime(listvo.get(i).getteamTime()+tgp.getTime());
					listvo.get(i).setteamTurnOver(listvo.get(i).getteamTurnOver()+tgp.getTurnover());
					listvo.get(i).setteamRebound(listvo.get(i).getteamRebound()+tgp.getReboundOverall());
					listvo.get(i).setteamOffensiveRebound(listvo.get(i).getteamOffensiveRebound()+tgp.getOffensiveRebound());
					listvo.get(i).setteamDefensiveRebound(listvo.get(i).getteamDefensiveRebound()+tgp.getDefensiveRebound());
					listvo.get(i).setOpDefensiveRebound(listvo.get(i).getOpDefensiveRebound()+tgp.getOpDefensiveRebound());
					listvo.get(i).setOpOffensiveRebound(listvo.get(i).getOpOffensiveRebound()+tgp.getOpOffensiveRebound());
					listvo.get(i).setOpReboundAll(listvo.get(i).getOpReboundAll()+tgp.getOpDefensiveRebound()+tgp.getOpOffensiveRebound());
					listvo.get(i).setOpRoundAttack(listvo.get(i).getOpRoundAttack()+tgp.getOpRoundAttack());
					listvo.get(i).setOpTwoPointShotNum(listvo.get(i).getOpTwoPointShotNum()+tgp.getOpTwoPointShotNum());
				
					ti.addScore(temp.getScore());
					ti.addAssistance(temp.getAssistance());
					ti.addFree(temp.getFreeThrowHitNum());
					ti.addRebound(temp.getReboundOverall());
					ti.addThree(temp.getThreePointHitNum());
					ti.addGameNum();
					ti.addHit(temp.getHitNum());
					ti.addBlock(temp.getBlock());
					ti.addFreeshot(temp.getFreeThrowShotNum());
					ti.addSteal(temp.getSteal());
					ti.addThreeshot(temp.getThreePointShotNum());
					ti.addTime(temp.getTime());
					ti.addTurnover(temp.getTurnover());
					ti.addFoul(temp.getFoul());
					ti.addShot(temp.getShotNum());
					break;
				}
			}
		}
		
	}
	
	private TeamPerformanceInSingleGame setPerformance(TeamPerformance tp) {
		ArrayList<SinglePerformance> listsp = tp.getSpList();
		String abbr = tp.getTeamNameAbbr();
		TeamPerformanceInSingleGame tgp = new TeamPerformanceInSingleGame(abbr);
		int k=0;
		tgp.setGameLabel(tp.getGamelabel());
		for(SinglePerformance temp:listsp)
		{
			
			tgp.setTime(tgp.getTime()+temp.getTimeBySeconds());
			tgp.setHitNum(tgp.getHitNum()+temp.getHitNum());
			tgp.setShotNum(tgp.getShotNum()+temp.getShotNum());
			tgp.setThreePointHitNum(tgp.getThreePointHitNum()+temp.getThreePointHitNum());
			tgp.setThreePointShotNum(tgp.getThreePointShotNum()+temp.getThreePointShotNum());
			tgp.setFreeThrowHitNum(tgp.getFreeThrowHitNum()+temp.getFreeThrowHitNum());
			tgp.setFreeThrowShotNum(tgp.getFreeThrowShotNum()+temp.getFreeThrowShotNum());
			tgp.setOffensiveRebound(tgp.getOffensiveRebound()+temp.getOffensiveRebound());
			tgp.setDefensiveRebound(tgp.getDefensiveRebound()+temp.getDefensiveRebound());
			tgp.setReboundOverall(tgp.getReboundOverall()+temp.getReboundOverall());
			tgp.setAssistance(tgp.getAssistance()+temp.getAssistance());
			tgp.setBlock(tgp.getBlock()+temp.getBlock());
			tgp.setTurnover(tgp.getTurnover()+temp.getTurnover());
			tgp.setFoul(tgp.getFoul()+temp.getFoul());
			tgp.setSteal(tgp.getSteal()+temp.getSteal());
			tgp.setScore(tgp.getScore()+temp.getScore());
			int i=0;
			for(;i<listvo.size();i++)
			{
				if(temp.getName().equals(listvo.get(i).getName()))
				{
					PlayerPerformanceInSingleGame pgp = new PlayerPerformanceInSingleGame(temp.getName());
					pgp.setTeam(tgp.getName());
					pgp.setPosition(temp.getPosition());
					pgp.setGameLabel(tp.getGamelabel());
					pgp.setNumber(listvo.get(i).getNumber());
					pgp.setTime(temp.getTimeBySeconds());
					pgp.setHitNum(pgp.getHitNum()+temp.getHitNum());
					pgp.setShotNum(pgp.getShotNum()+temp.getShotNum());
					pgp.setThreePointHitNum(pgp.getThreePointHitNum()+temp.getThreePointHitNum());
					pgp.setThreePointShotNum(pgp.getThreePointShotNum()+temp.getThreePointShotNum());
					pgp.setFreeThrowHitNum(pgp.getFreeThrowHitNum()+temp.getFreeThrowHitNum());
					pgp.setFreeThrowShotNum(pgp.getFreeThrowShotNum()+temp.getFreeThrowShotNum());
					pgp.setOffensiveRebound(pgp.getOffensiveRebound()+temp.getOffensiveRebound());
					pgp.setDefensiveRebound(pgp.getDefensiveRebound()+temp.getDefensiveRebound());
					pgp.setReboundOverall(pgp.getReboundOverall()+temp.getReboundOverall());
					pgp.setAssistance(pgp.getAssistance()+temp.getAssistance());
					pgp.setSteal(pgp.getSteal()+temp.getSteal());
					pgp.setBlock(pgp.getBlock()+temp.getBlock());
					pgp.setTurnover(pgp.getTurnover()+temp.getTurnover());
					pgp.setFoul(pgp.getFoul()+temp.getFoul());
					pgp.setScore(pgp.getScore()+temp.getScore());
					if(isTwoTen(temp)){
						pgp.setTwoTenNum(1);
					}
					if(k<5)
					{
						pgp.setFirstOn(1);
						k++;
						tgp.AddFirstP(pgp);
					}
					if(tgp.getHighestassist()<temp.getAssistance()){
						tgp.setHighestassist(temp.getAssistance());
						tgp.setHighestassistPlayer(temp.getName());
					}
					if(tgp.getHighestScore()<temp.getScore()){
						tgp.setHighestScore(temp.getScore());
						tgp.setHighestScorePlayer(temp.getName());
					}
					if(tgp.getHighestblock()<temp.getBlock()){
						tgp.setHighestblock(temp.getBlock());
						tgp.setHighestblockPlayer(temp.getName());
					}
					if(tgp.getHighestRebound()<temp.getReboundOverall()){
						tgp.setHighestRebound(temp.getReboundOverall());
						tgp.setHighestReboundPlayer(temp.getName());
					}
					tgp.AddPlayerP(pgp);
					precgames.get(i).AddNewGame(pgp);
					
					listpg.get(i).AddGames(pgp);
					break;
				}
			}
			if(i==listvo.size()){
				PlayerVo vo = createNewVo(temp.getName());
				listvo.add(vo);
				PlayerPerformanceInSingleGame pgp = new PlayerPerformanceInSingleGame(temp.getName());
				pgp.setTeam(tgp.getName());
				pgp.setPosition(temp.getPosition());
				pgp.setGameLabel(tp.getGamelabel());
				pgp.setNumber("");
				pgp.setTime(temp.getTimeBySeconds());
				pgp.setHitNum(pgp.getHitNum()+temp.getHitNum());
				pgp.setShotNum(pgp.getShotNum()+temp.getShotNum());
				pgp.setThreePointHitNum(pgp.getThreePointHitNum()+temp.getThreePointHitNum());
				pgp.setThreePointShotNum(pgp.getThreePointShotNum()+temp.getThreePointShotNum());
				pgp.setFreeThrowHitNum(pgp.getFreeThrowHitNum()+temp.getFreeThrowHitNum());
				pgp.setFreeThrowShotNum(pgp.getFreeThrowShotNum()+temp.getFreeThrowShotNum());
				pgp.setOffensiveRebound(pgp.getOffensiveRebound()+temp.getOffensiveRebound());
				pgp.setDefensiveRebound(pgp.getDefensiveRebound()+temp.getDefensiveRebound());
				pgp.setReboundOverall(pgp.getReboundOverall()+temp.getReboundOverall());
				pgp.setAssistance(pgp.getAssistance()+temp.getAssistance());
				pgp.setSteal(pgp.getSteal()+temp.getSteal());
				pgp.setBlock(pgp.getBlock()+temp.getBlock());
				pgp.setTurnover(pgp.getTurnover()+temp.getTurnover());
				pgp.setFoul(pgp.getFoul()+temp.getFoul());
				pgp.setScore(pgp.getScore()+temp.getScore());
				if(isTwoTen(temp)){
					pgp.setTwoTenNum(1);
				}
				if(k<5)
				{
					pgp.setFirstOn(1);
					k++;
					tgp.AddFirstP(pgp);
				}
				if(tgp.getHighestassist()<temp.getAssistance()){
					tgp.setHighestassist(temp.getAssistance());
					tgp.setHighestassistPlayer(temp.getName());
				}
				if(tgp.getHighestScore()<temp.getScore()){
					tgp.setHighestScore(temp.getScore());
					tgp.setHighestScorePlayer(temp.getName());
				}
				if(tgp.getHighestblock()<temp.getBlock()){
					tgp.setHighestblock(temp.getBlock());
					tgp.setHighestblockPlayer(temp.getName());
				}
				if(tgp.getHighestRebound()<temp.getReboundOverall()){
					tgp.setHighestRebound(temp.getReboundOverall());
					tgp.setHighestReboundPlayer(temp.getName());
				}
				PlayerRecentGames p = new PlayerRecentGames();
				p.setName(temp.getName());
				PlayerGames pg = new PlayerGames(temp.getName());
				listpg.add(pg);
				tgp.AddPlayerP(pgp);
				precgames.add(p);
				precgames.get(i).AddNewGame(pgp);
				
				listpg.get(i).AddGames(pgp);
			}
		}
		if(!tp.getGamelabel().equals("")){
			tgp.setHitRate(tgp.getHitNum()/(double)tgp.getShotNum());
			tgp.setThreePointHitRate(tgp.getThreePointHitNum()/(double)tgp.getThreePointShotNum());
			tgp.setFreeThrowRate(tgp.getFreeThrowHitNum()/(double)tgp.getFreeThrowShotNum());
		}
		for(TeamRecentGames temp:trecgames)
		{
			if(temp.getAbbreviation().equals(abbr))
			{
				temp.AddNewGame(tgp);
			}
		}
		
		for(TeamGames temp:listtg){
			if(isTeam(temp.getName(), abbr)){
				temp.AddGames(tgp);
			}
		}
		return tgp;
		
	}
	private boolean isTeam(String abbr1,String abbr2){
		if(abbr1.equals(abbr2)){
			return true;
		}
		else{
			if(abbr1.equals("PHO")||abbr1.equals("PHX")){
				if(abbr2.equals("PHO")||abbr2.equals("PHX"))
					return true;
				else {
					return false;
				}
			}
			if(abbr1.equals("NOH")||abbr1.equals("NOP")||abbr1.equals("NOK")){
				if(abbr2.equals("NOH")||abbr2.equals("NOP")||abbr2.equals("NOK"))
					return true;
				else {
					return false;
				}
			}
			if(abbr1.equals("CHA")||abbr1.equals("CHH")){
				if(abbr2.equals("CHA")||abbr2.equals("CHH"))
					return true;
				else {
					return false;
				}
			}
			if(abbr1.equals("BKN")||abbr1.equals("NJN")){
				if(abbr2.equals("BKN")||abbr2.equals("NJN"))
					return true;
				else {
					return false;
				}
			}
			return false;
		}
	}
	private PlayerVo createNewVo(String name) {
		PlayerVo temp = new PlayerVo();
		temp.setName(name);
		temp.setNumber("");
		temp.setPosition("");
		temp.setHeight("");
		temp.setWeight("");
		temp.setBirth("");
		temp.setAge(0);
		temp.setExp(0);
		temp.setSchool("");
		temp.setActionImgPath("");
		temp.setPortraitImgPath("");
		temp.setTeam("");
		
		temp.setTime(0);
		temp.setHitNum(0);
		temp.setShotNum(0);
		temp.setThreePointHitNum(0);
		temp.setThreePointShotNum(0);
		temp.setFreeThrowHitNum(0);
		temp.setFreeThrowShotNum(0);
		temp.setAttackingNum(0);
		temp.setDefensiveNum(0);
		temp.setReboundOverall(0);
		temp.setAssistance(0);
		temp.setBlock(0);
		temp.setTurnover(0);
		temp.setFoul(0);
		temp.setScore(0);
		temp.setSteal(0);
		temp.setFirstOnNum(0);
		
		temp.setTeamRoundAttack(0);
		temp.setteamFreeThrowNum(0);
		temp.setteamShotNum(0);
		temp.setteamHitNum(0);
		temp.setteamTime(0);
		temp.setteamTurnOver(0);
		temp.setteamRebound(0);
		temp.setteamOffensiveRebound(0);
		temp.setteamDefensiveRebound(0);
		temp.setOpDefensiveRebound(0);
		temp.setOpOffensiveRebound(0);
		temp.setOpReboundAll(0);
		temp.setOpRoundAttack(0);
		temp.setOpTwoPointShotNum(0);
		temp.setTwoTenNum(0);
		return temp;
	}
	private boolean isTwoTen(SinglePerformance temp) {
		int score = temp.getScore();
		int assistance = temp.getAssistance();
		int block=temp.getBlock();
		int steal = temp.getSteal();
		int rebound = temp.getReboundOverall();
		if((score>=10&&assistance>=10)||(score>=10&&block>=10)||(score>=10&&steal>=10)||
				(score>=10&&rebound>=10)||(block>=10&&assistance>=10)||(steal>=10&&assistance>=10)
				||(rebound>=10&&assistance>=10)||(block>=10&&steal>=10)||
				(block>=10&&rebound>=10)||(steal>=10&&rebound>=10))
		{
			return true;
		}
		else 
			return false;
	}
	
	
	
	private void SetTeamVo() {
		for(int i=0;i<teamlistpo.size();i++)
		{
			
			TeamVo temp = new TeamVo();
			temp.setTeamName(teamlistpo.get(i).getTeamName());
			temp.setAbbreviation(teamlistpo.get(i).getAbbreviation());
			temp.setCity(teamlistpo.get(i).getCity());
			temp.setConference(teamlistpo.get(i).getConference());
			temp.setDivision(teamlistpo.get(i).getDivision());
			temp.setHomeField(teamlistpo.get(i).getHomeField());
			temp.setBirthYear(teamlistpo.get(i).getBirthYear());
			temp.setImgPath(teamlistpo.get(i).getImgPath());
			
			
			temp.setTime(0);
			temp.setHitNum(0);
			temp.setShotNum(0);
			temp.setThreePointHitNum(0);
			temp.setThreePointShotNum(0);
			temp.setFreeThrowHitNum(0);
			temp.setFreeThrowShotNum(0);
			temp.setOffensiveRebound(0);
			temp.setDefensiveRebound(0);
			temp.setReboundOverall(0);
			temp.setAssistance(0);
			temp.setBlock(0);
			temp.setTurnover(0);
			temp.setFoul(0);
			temp.setScore(0);
			temp.setSteal(0);
			temp.setWiningNum(0);
			temp.setOpDefensiveRebound(0);
			temp.setOpOffensiveRebound(0);
			temp.setOpReboundAll(0);
			temp.setOpRoundAttack(0);
			temp.setOpScore(0);
			temp.setOpTwoPointShotNum(0);
			temp.setFreeThrowShotNumhGuest(0);
			temp.setFreeThrowShotNumhHome(0);
			teamlistvo.add(temp);
			
			TeamRecentGames p = new TeamRecentGames();
			p.setName(teamlistpo.get(i).getTeamName());
			p.setAbbreviation(teamlistpo.get(i).getAbbreviation());
			trecgames.add(p);
			TeamGames tg = new TeamGames(teamlistpo.get(i).getAbbreviation());
			listtg.add(tg);
			
		}
		
	}
	private void SetPlayerVo() 
	{
		for(int i=0;i<listpo.size();i++)
		{
			
			PlayerVo temp = new PlayerVo();
			temp.setName(listpo.get(i).getName());
			temp.setNumber(listpo.get(i).getNumber());
			temp.setPosition(listpo.get(i).getPosition());
			temp.setHeight(listpo.get(i).getHeight());
			temp.setWeight(listpo.get(i).getWeight());
			temp.setBirth(listpo.get(i).getBirth());
			temp.setAge(listpo.get(i).getAge());
			temp.setExp(listpo.get(i).getExp());
			temp.setSchool(listpo.get(i).getSchool());
			temp.setActionImgPath(listpo.get(i).getActionImgPath());
			temp.setPortraitImgPath(listpo.get(i).getPortraitImgPath());
			temp.setTeam(listpo.get(i).getCurrentTeam());
			
			temp.setTime(0);
			temp.setHitNum(0);
			temp.setShotNum(0);
			temp.setThreePointHitNum(0);
			temp.setThreePointShotNum(0);
			temp.setFreeThrowHitNum(0);
			temp.setFreeThrowShotNum(0);
			temp.setAttackingNum(0);
			temp.setDefensiveNum(0);
			temp.setReboundOverall(0);
			temp.setAssistance(0);
			temp.setBlock(0);
			temp.setTurnover(0);
			temp.setFoul(0);
			temp.setScore(0);
			temp.setSteal(0);
			temp.setFirstOnNum(0);
			
			temp.setTeamRoundAttack(0);
			temp.setteamFreeThrowNum(0);
			temp.setteamShotNum(0);
			temp.setteamHitNum(0);
			temp.setteamTime(0);
			temp.setteamTurnOver(0);
			temp.setteamRebound(0);
			temp.setteamOffensiveRebound(0);
			temp.setteamDefensiveRebound(0);
			temp.setOpDefensiveRebound(0);
			temp.setOpOffensiveRebound(0);
			temp.setOpReboundAll(0);
			temp.setOpRoundAttack(0);
			temp.setOpTwoPointShotNum(0);
			temp.setTwoTenNum(0);
			listvo.add(temp);
			
			PlayerRecentGames p = new PlayerRecentGames();
			p.setName(listpo.get(i).getName());
			PlayerGames pg = new PlayerGames(temp.getName());
			precgames.add(p);
			listpg.add(pg);
		}		
	}
	public ArrayList<PlayerVo> getPlayers() {
		
		return sortByFamilyName();
	}
	
	public ArrayList<TeamVo> getTeams()
	{
		return teamlistvo;
	}
	
	public ArrayList<TeamPerformanceInSingleGame> getTeamGamesDaily()
	{
		ArrayList<TeamPerformanceInSingleGame> tplist = new ArrayList<TeamPerformanceInSingleGame>();
		GameDate dn = getDateNow();
		for(GameVo temp:gamevo){
			if(temp.getGameDate().compareTo(dn)==0){
				tplist.add(temp.getGuestTP());
				tplist.add(temp.getHomeTP());
			}
		}
		return tplist;
	}
	
	
	
	public ArrayList<PlayerPerformanceInSingleGame> getPlayerGamesDaily()
	{
		ArrayList<PlayerPerformanceInSingleGame> pplist = new ArrayList<PlayerPerformanceInSingleGame>();
		GameDate dn = getDateNow();
		//System.out.println(dn.toString()+"得到当日比赛");
		for(GameVo temp:gamevo){
			if(temp.getGameDate().compareTo(dn)==0){
				for(PlayerPerformanceInSingleGame pp:temp.getGuestTP().getPlayerList()){
					pplist.add(pp);
				}
				for(PlayerPerformanceInSingleGame pp:temp.getHomeTP().getPlayerList()){
					pplist.add(pp);
				}
			}
		}
		return pplist;
		
	}
	
	
	public ArrayList<PlayerRecentGames> getPlayerRecentGames()
	{
		return precgames;
	}
	public ArrayList<TeamRecentGames> getTeamRecentGames(){
		return trecgames;
	}
	public PlayerRecentGames getPlayerRecentPerformance(String name)
	{
		for(PlayerRecentGames temp:precgames){
			if(temp.getName().equals(name)){
				return temp;
			}
		}
		return null;
	}
	public TeamRecentGames getTeamRecentPerformance(String abbr)
	{
		for(TeamRecentGames temp:trecgames){
			if(temp.getAbbreviation().equals(abbr)){
				return temp;
			}
		}
		return null;
	}
	public ArrayList<GameVo> getAllGames(){
		return gamevo;
		
	}

	public void updateData() {
		ArrayList<GamePO> ngs = gamedao.getNewGamePOs();
		for(int i=0;i<ngs.size();i++)
		{
			GameVo game = new GameVo();
			TeamPerformance tpg = ngs.get(i).getGuestTP();
			TeamPerformance tph = ngs.get(i).getHomeTP();
			TeamPerformanceInSingleGame tgpg=setPerformance(tpg);
			TeamPerformanceInSingleGame tgph=setPerformance(tph);
			tgpg.setOpDefensiveRebound(tgph.getDefensiveRebound());
			tgpg.setOpOffensiveRebound(tgph.getOffensiveRebound());
			tgpg.setOpTwoPointShotNum(tgph.getShotNum()-tgph.getThreePointShotNum());
			tgpg.setOpScore(tgph.getScore());
			tgpg.CalculateRoundAttack();
			tgph.setOpDefensiveRebound(tgpg.getDefensiveRebound());
			tgph.setOpOffensiveRebound(tgpg.getOffensiveRebound());
			tgph.setOpTwoPointShotNum(tgpg.getShotNum()-tgpg.getThreePointShotNum());
			tgph.setOpScore(tgpg.getScore());
			tgph.CalculateRoundAttack();
			tgph.isWinning();
			tgpg.isWinning();
			tgpg.setOpRoundAttack(tgph.getRoundAttack());
			tgph.setOpRoundAttack(tgpg.getRoundAttack());
			playerVoPSet(tgpg);
			playerVoPSet(tgph);
			teamVoPSet(tgpg);
			teamVoPSet(tgph);
			TGPRateSet(tgph);
			TGPRateSet(tgpg);
			
			CreateGameVo(game,tgpg,tgph,ngs.get(i));
			gamevo.add(game);
		}
		playerCalculate();
		TeamCalculate();
		TotalCalculate();
	}
	public GameDate getDateNow(){
		//st.setCurrentDate(new GameDate(2015,4,15));
		st.setCurrentDate(new GameDate(2014,4,16));
		//st = systemdao.getStById("12-13");
		return st.getCurrentDate();
	}
	
	public GameDate getNextDate(GameDate date){
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();
		
		Calendar time=Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, year);
		time.set(Calendar.MONTH, month - 1);//count from 0
		int monthLength = time.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(monthLength == day) {
			if(month == 12) {
				year ++;
				month = 1;
			}else {
				month ++;
			}
			day = 1;
		}else{
			day++;
		}
		return new GameDate(year, month, day);
	}

	public PlayerGames getPlayerPerformacne(
			String name) {
		for(PlayerGames temp:listpg){
			if(temp.getName().equals(name)){
				return temp;
			}
		}
		return null;
	}
	public ArrayList<TeamPerformanceInSingleGame> getTeamPerformance(String abbr)
	{
		ArrayList<TeamPerformanceInSingleGame> list = new ArrayList<TeamPerformanceInSingleGame>();
		for(GameVo temp:gamevo){
			if(temp.getGuestTeam().equals(abbr)){
				list.add(temp.getGuestTP());
			}
			if(temp.getHomeTeam().equals(abbr)){
				list.add(temp.getHomeTP());
			}
		}
		return list;
		
	}
	public ArrayList<TeamPerformanceInSingleGame> getTeamPerformance(String abbr,String season)
	{
		ArrayList<TeamPerformanceInSingleGame> tp = new ArrayList<TeamPerformanceInSingleGame>();
		for(SeasonMult sm:seasonlist){
			if(sm.getSeason().equals(season)){
				for(TeamGames temp:sm.listtg){
					if(isTeam(temp.getName(), abbr)){
						tp = temp.getGames();
					}
				}
			}
		}
		return tp;
		
	}
	public TotalInfo getTotalInfo(String season) {
		
		return GetSeason(season).ti;
	}
	
	private SeasonMult GetSeason(String season) {
		for(SeasonMult temp:seasonlist){
			if(temp.getSeason().equals(season)){
				return temp;
			}
		}
		return null;
	}
	public ArrayList<PlayerVo> sortByFamilyName(){
		String a[][] = new String [listvo.size()][2]; 
		for(int i=0;i<listvo.size();i++)
		{
			a[i][0] = getFamilyName(listvo.get(i).getName());
			a[i][1] = i+"";
		}
		HeapSortByString.heapSort(a);
		ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
		for(int i=0;i<listvo.size();i++)
		{
			templist.add(listvo.get(Integer.parseInt(a[i][1])));
		}
		return templist;
		
		
	}
	private String getFamilyName(String name) {
		int index = name.indexOf(" ");
		if(index==-1){
			return name;
		}
		else{
			return name.substring(index+1);
		}
	}
	public ArrayList<TeamVo> getTeamByAbbrA(String abbr) {
		ArrayList<TeamVo> vos = new ArrayList<TeamVo>();
		for(SeasonMult temp:seasonlist){
			for(TeamVo t:temp.teamlistvo){
				if(isTeam(t.getAbbreviation(), abbr)){
					vos.add(t);
				}
			}
		}
		return vos;
	}
	public ArrayList<TotalInfo> getTeamTotalInfos() {
		ArrayList<TotalInfo> vos = new ArrayList<TotalInfo>();
		for(SeasonMult temp:seasonlist){
			vos.add(temp.teamti);
		}
		return vos;
	}
	public ArrayList<TeamGames> getTeamGames(String abbr){
		ArrayList<TeamGames> tgs = new ArrayList<TeamGames>();
		for(SeasonMult temp:seasonlist){
			for(TeamGames t:temp.listtg){
				if(isTeam(t.getName(), abbr)){
					tgs.add(t);
				}
			}
		}
		return tgs;
	}
	public ArrayList<TeamVo> getTeamlist(String seasonid) {
		ArrayList<TeamVo> vos = new ArrayList<TeamVo>();
		for(SeasonMult temp:seasonlist){
			if(temp.getSeason().equals(seasonid)){
				vos = temp.teamlistvo;
			}
		}
		return vos;
	}
	
}

