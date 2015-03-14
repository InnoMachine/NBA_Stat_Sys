package businessLogic;

import java.util.ArrayList;
import po.GamePO;
import po.PlayerPO;
import po.SinglePerformance;
import po.TeamPO;
import po.TeamPerformance;
import vo.PlayerVo;
import vo.TeamVo;
import database.GameDao;
import database.GameDaoImpl;
import database.PlayerDao;
import database.PlayerDaoImpl;
import database.TeamDao;

public class Data_Handler {
	private static Data_Handler instance;
	
	protected PlayerDao playerdao;
	protected GameDao gamedao;
	protected TeamDao teamdao;
	private ArrayList<PlayerPO> listpo;
	private ArrayList<TeamPO> teamlistpo;
	private PlayerVo[] listvo;
	private TeamVo[] teamlistvo;
	ArrayList<GamePO> gamelist;
	
	
	
	private Data_Handler()
	{
		playerdao = new PlayerDaoImpl();
		gamedao = new GameDaoImpl();
		listpo  = playerdao.getAllPlayers();
		listvo = new PlayerVo[listpo.size()+1];
		gamelist = gamedao.getAllGames();
		SetPlayerVo();
		SetTeamVo();
		loadGames();
		playerCalculate();
		TeamCalculate();
	}
	private void TeamCalculate() {
		for(int i=0;i<teamlistvo.length;i++)
		{
			teamlistvo[i].setHitRate(teamlistvo[i].getHitNum()/teamlistvo[i].getShotNum());
			teamlistvo[i].setThreePointHitRate(teamlistvo[i].getThreePointHitNum()/teamlistvo[i].getThreePointShotNum());
			teamlistvo[i].setFreeThrowRate(teamlistvo[i].getFreeThrowHitNum()/teamlistvo[i].getFreeThrowShotNum());
			teamlistvo[i].setWinningRate(teamlistvo[i].getWinningNum()/teamlistvo[i].getGameNum());
			teamlistvo[i].setAttackingEfficiency(teamlistvo[i].getScore()/teamlistvo[i].getRoundAttack()*100);
			
			
		}
		
	}
	private void playerCalculate() {
		for(int i=0;i<listvo.length;i++)
		{
			listvo[i].setHitRate(listvo[i].getHitNum()/listvo[i].getShotNum());
			listvo[i].setThreePointHitRate(listvo[i].getThreePointHitNum()/listvo[i].getThreePointShotNum());
			listvo[i].setFreeThrowRate(listvo[i].getFreeThrowHitNum()/listvo[i].getFreeThrowShotNum());
			listvo[i].setBlock(listvo[i].getBlock());
			listvo[i].setTurnover(listvo[i].getTurnover());
			listvo[i].setFoul(listvo[i].getFoul());
			listvo[i].setSteal(listvo[i].getSteal());
			listvo[i].setScore(listvo[i].getScore());
			listvo[i].setEfficiency(listvo[i].getScore()+listvo[i].getBlock()+listvo[i].getReboundOverall()+
					listvo[i].getAssistance()-/*splist[i].getSteal*/listvo[i].getFreeThrowShotNum()-
					listvo[i].getShotNum()+listvo[i].getHitNum()+listvo[i].getFreeThrowHitNum()-listvo[i].getTurnover());
			listvo[i].setGmSc(listvo[i].getScore()+0.4*listvo[i].getHitNum()-0.7*listvo[i].getShotNum()-0.4*
					(listvo[i].getFreeThrowShotNum()-listvo[i].getFreeThrowHitNum())
					+0.7*listvo[i].getAttackingNum()+0.3*listvo[i].getDefensiveNum()/*splist[i].getsteal()*/
					+0.7*listvo[i].getAssistance()+0.7*listvo[i].getBlock()-0.4*listvo[i].getFoul()-listvo[i].getTurnover());
			listvo[i].setTrueHitRate(listvo[i].getScore()/(2*(listvo[i].getShotNum()+listvo[i].getThreePointShotNum()+0.44
					*listvo[i].getFreeThrowShotNum())));
			listvo[i].setHitEfficiency((listvo[i].getHitNum()+0.5*listvo[i].getThreePointHitNum())/listvo[i].getShotNum());
			listvo[i].setReboundOverallRate(listvo[i].getReboundOverall()*(listvo[i].getteamTime()/5)/listvo[i].getTime()
					/(listvo[i].getteamRebound()+listvo[i].getOpReboundAll()));
			listvo[i].setOffensiveReboundRate(listvo[i].getAttackingNum()*(listvo[i].getteamTime()/5)/listvo[i].getTime()
					/(listvo[i].getteamOffensiveRebound()+listvo[i].getOpOffensiveRebound()));
			listvo[i].setDefensiveReboundRate(listvo[i].getDefensiveNum()*(listvo[i].getteamTime()/5)/listvo[i].getTime()
					/(listvo[i].getteamDefensiveRebound()+listvo[i].getOpDefensiveRebound()));
			listvo[i].setAssistanceRate(listvo[i].getAssistance()/(listvo[i].getTime()/(listvo[i].getteamTime()/5)
					*listvo[i].GetteamHitNum()-listvo[i].getHitNum()));
			listvo[i].setStealRate(listvo[i].getSteal()*(listvo[i].getteamTime()/5)/listvo[i].getTime()
					/listvo[i].getOpRoundAttack());
			listvo[i].setBlockRate(listvo[i].getBlock()*(listvo[i].getteamTime()/5)/listvo[i].getTime()
					/listvo[i].getOpTwoPointShotNum());
			listvo[i].setTurnOverRate(listvo[i].getTurnover()+0.44*listvo[i].getFreeThrowShotNum()+listvo[i].getTurnover());;
			listvo[i].setUseRate((listvo[i].getShotNum()+0.44*listvo[i].getFreeThrowShotNum()+listvo[i].getTurnover())
					*(listvo[i].getteamTime()/5)/listvo[i].getTime()/(listvo[i].GetteamShotNum()+
							0.44*listvo[i].getteamFreeThrowNum()+listvo[i].getteamTurnOver()));
			
			
		}
	}
	private void loadGames() {
		for(int i=0;i<gamelist.size();i++)
		{
			TeamPerformance tpg = gamelist.get(i).getGuestTP();
			TeamPerformance tph = gamelist.get(i).getHomeTP();
			teamGameP tgpg=setPerformance(tpg);
			teamGameP tgph=setPerformance(tph);
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
		}
	}
	private void teamVoPSet(teamGameP tgp) {
		for(int i=0;i<teamlistvo.length;i++)
		{
			
			teamlistvo[i].setTime(teamlistvo[i].getTime()+tgp.getTime());
			teamlistvo[i].setHitNum(teamlistvo[i].getHitNum()+tgp.getHitNum());
			teamlistvo[i].setShotNum(teamlistvo[i].getShotNum()+tgp.getShotNum());
			teamlistvo[i].setThreePointHitNum(teamlistvo[i].getThreePointHitNum()+tgp.getThreePointHitNum());
			teamlistvo[i].setThreePointShotNum(teamlistvo[i].getThreePointShotNum()+tgp.getThreePointShotNum());
			teamlistvo[i].setFreeThrowHitNum(teamlistvo[i].getFreeThrowHitNum()+tgp.getFreeThrowHitNum());
			teamlistvo[i].setFreeThrowShotNum(teamlistvo[i].getFreeThrowShotNum()+tgp.getFreeThrowShotNum());
			teamlistvo[i].setOffensiveRebound(teamlistvo[i].getOffensiveRebound()+tgp.getOffensiveRebound());
			teamlistvo[i].setDefensiveRebound(teamlistvo[i].getDefensiveRebound()+tgp.getDefensiveRebound());
			teamlistvo[i].setReboundOverall(teamlistvo[i].getReboundOverall()+tgp.getReboundOverall());
			teamlistvo[i].setAssistance(teamlistvo[i].getAssistance()+tgp.getAssistance());
			teamlistvo[i].setBlock(teamlistvo[i].getBlock()+tgp.getBlock());
			teamlistvo[i].setTurnover(teamlistvo[i].getTurnover()+tgp.getTurnover());
			teamlistvo[i].setFoul(teamlistvo[i].getFoul()+tgp.getFoul());
			teamlistvo[i].setSteal(teamlistvo[i].getSteal()+tgp.getSteal());
			teamlistvo[i].setScore(teamlistvo[i].getScore()+tgp.getScore());
			teamlistvo[i].setWiningNum(teamlistvo[i].getWinningNum()+tgp.getWinning());
			
			teamlistvo[i].setOpDefensiveRebound(teamlistvo[i].getOpDefensiveRebound()+tgp.getOpDefensiveRebound());
			teamlistvo[i].setOpOffensiveRebound(teamlistvo[i].getOpOffensiveRebound()+tgp.getOpOffensiveRebound());
			teamlistvo[i].setOpReboundAll(teamlistvo[i].getOpReboundAll()+tgp.getOpDefensiveRebound()+tgp.getOpOffensiveRebound());
			teamlistvo[i].setOpRoundAttack(teamlistvo[i].getOpRoundAttack()+tgp.getOpRoundAttack());
			teamlistvo[i].setOpScore(teamlistvo[i].getOpScore()+tgp.getOpScore());
			teamlistvo[i].setOpTwoPointShotNum(teamlistvo[i].getOpTwoPointShotNum()+tgp.getOpTwoPointShotNum());
			
		}
		
	}
	private void playerVoPSet(teamGameP tgp) {
		for(PlayerGameP temp:tgp.playerlist)
		{
			for(int i=0;i<listvo.length;i++)
			{
				if(temp.getName().equals(listvo[i].getName()))
				{
					listvo[i].setTime(temp.getTime());
					listvo[i].setHitNum(listvo[i].getHitNum()+temp.getHitNum());
					listvo[i].setShotNum(listvo[i].getShotNum()+temp.getShotNum());
					listvo[i].setThreePointHitNum(listvo[i].getThreePointHitNum()+temp.getThreePointHitNum());
					listvo[i].setThreePointShotNum(listvo[i].getThreePointShotNum()+temp.getThreePointShotNum());
					listvo[i].setFreeThrowHitNum(listvo[i].getFreeThrowHitNum()+temp.getFreeThrowHitNum());
					listvo[i].setFreeThrowShotNum(listvo[i].getFreeThrowShotNum()+temp.getFreeThrowShotNum());
					listvo[i].setAttackingNum(listvo[i].getAttackingNum()+temp.getOffensiveRebound());
					listvo[i].setDefensiveNum(listvo[i].getDefensiveNum()+temp.getDefensiveRebound());
					listvo[i].setReboundOverall(listvo[i].getReboundOverall()+temp.getReboundOverall());
					listvo[i].setAssistance(listvo[i].getAssistance()+temp.getAssistance());
					listvo[i].setSteal(listvo[i].getSteal()+temp.getSteal());
					listvo[i].setBlock(listvo[i].getBlock()+temp.getBlock());
					listvo[i].setTurnover(listvo[i].getTurnover()+temp.getTurnover());
					listvo[i].setFoul(listvo[i].getFoul()+temp.getFoul());
					listvo[i].setScore(listvo[i].getScore()+temp.getScore());
					
					listvo[i].setTeamRoundAttack(listvo[i].getTeamRoundAttack()+tgp.getRoundAttack());
					listvo[i].setteamFreeThrowNum(listvo[i].getteamFreeThrowNum()+tgp.getFreeThrowShotNum());
					listvo[i].setteamShotNum(listvo[i].GetteamShotNum()+tgp.getShotNum());
					listvo[i].setteamHitNum(listvo[i].GetteamHitNum()+tgp.getHitNum());
					listvo[i].setteamTime(listvo[i].getteamTime()+tgp.getTime());
					listvo[i].setteamTurnOver(listvo[i].getteamTurnOver()+tgp.getTurnover());
					listvo[i].setteamRebound(listvo[i].getteamRebound()+tgp.getReboundOverall());
					listvo[i].setteamOffensiveRebound(listvo[i].getteamOffensiveRebound()+tgp.getOffensiveRebound());
					listvo[i].setteamDefensiveRebound(listvo[i].getteamDefensiveRebound()+tgp.getDefensiveRebound());
					listvo[i].setOpDefensiveRebound(listvo[i].getOpDefensiveRebound()+tgp.getOpDefensiveRebound());
					listvo[i].setOpOffensiveRebound(listvo[i].getOpOffensiveRebound()+tgp.getOpOffensiveRebound());
					listvo[i].setOpReboundAll(listvo[i].getOpReboundAll()+tgp.getOpDefensiveRebound()+tgp.getOpOffensiveRebound());
					listvo[i].setOpRoundAttack(listvo[i].getOpRoundAttack()+tgp.getOpRoundAttack());
					listvo[i].setOpTwoPointShotNum(listvo[i].getOpTwoPointShotNum()+tgp.getOpTwoPointShotNum());
					break;
				}
			}
		}
		
	}
	private teamGameP setPerformance(TeamPerformance tp) {
		ArrayList<SinglePerformance> listsp = new ArrayList<SinglePerformance>();//tp.getT
		String abbr = tp.getTeamNameAbbr();
		teamGameP tgp = new teamGameP(abbr);
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
			for(int i=0;i<listvo.length;i++)
			{
				if(temp.getName().equals(listvo[i].getName()))
				{
					PlayerGameP pgp = new PlayerGameP(temp.getName());
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
					tgp.playerlist.add(pgp);
					break;
				}
			}
		}
		return tgp;
		
	}
	public static Data_Handler getInstance()
	{
		if(instance==null)
		{
			instance = new Data_Handler();
		}
		return instance;
	}
	private void SetTeamVo() {
		for(int i=0;i<teamlistpo.size();i++)
		{
			teamlistvo[i].setTeamName(teamlistpo.get(i).getTeamName());
			teamlistvo[i].setAbbreviation(teamlistpo.get(i).getAbbreviation());
			teamlistvo[i].setCity(teamlistpo.get(i).getCity());
			teamlistvo[i].setConference(teamlistpo.get(i).getConference());
			teamlistvo[i].setDivision(teamlistpo.get(i).getDivision());
			teamlistvo[i].setHomeField(teamlistpo.get(i).getHomeField());
			teamlistvo[i].setBirthYear(teamlistpo.get(i).getBirthYear());
			teamlistvo[i].setImgPath(teamlistpo.get(i).getImgPath());
			
			
			teamlistvo[i].setTime(0);
			teamlistvo[i].setHitNum(0);
			teamlistvo[i].setShotNum(0);
			teamlistvo[i].setThreePointHitNum(0);
			teamlistvo[i].setThreePointShotNum(0);
			teamlistvo[i].setFreeThrowHitNum(0);
			teamlistvo[i].setFreeThrowShotNum(0);
			teamlistvo[i].setOffensiveRebound(0);
			teamlistvo[i].setDefensiveRebound(0);
			teamlistvo[i].setReboundOverall(0);
			teamlistvo[i].setAssistance(0);
			teamlistvo[i].setBlock(0);
			teamlistvo[i].setTurnover(0);
			teamlistvo[i].setFoul(0);
			teamlistvo[i].setScore(0);
			teamlistvo[i].setSteal(0);
			teamlistvo[i].setWiningNum(0);
			teamlistvo[i].setOpDefensiveRebound(0);
			teamlistvo[i].setOpOffensiveRebound(0);
			teamlistvo[i].setOpReboundAll(0);
			teamlistvo[i].setOpRoundAttack(0);
			teamlistvo[i].setOpScore(0);
			teamlistvo[i].setOpTwoPointShotNum(0);
			
		}
		
	}
	private void SetPlayerVo() 
	{
		for(int i=0;i<listpo.size();i++)
		{
			listvo[i].setName(listpo.get(i).getName());
			listvo[i].setNumber(listpo.get(i).getNumber());
			listvo[i].setPosition(listpo.get(i).getPosition());
			listvo[i].setHeight(listpo.get(i).getHeight());
			listvo[i].setWeight(listpo.get(i).getWeight());
			listvo[i].setBirth(listpo.get(i).getBirth());
			listvo[i].setAge(listpo.get(i).getAge());
			listvo[i].setExp(listpo.get(i).getExp());
			listvo[i].setSchool(listpo.get(i).getSchool());
			listvo[i].setActionImgPath(listpo.get(i).getActionImgPath());
			listvo[i].setPortraitImgPath(listpo.get(i).getPortraitImgPath());
			
			
			listvo[i].setName(listpo.get(i).getName());
			listvo[i].setTime(0);
			listvo[i].setHitNum(0);
			listvo[i].setShotNum(0);
			listvo[i].setThreePointHitNum(0);
			listvo[i].setThreePointShotNum(0);
			listvo[i].setFreeThrowHitNum(0);
			listvo[i].setFreeThrowShotNum(0);
			listvo[i].setAttackingNum(0);
			listvo[i].setDefensiveNum(0);
			listvo[i].setReboundOverall(0);
			listvo[i].setAssistance(0);
			listvo[i].setBlock(0);
			listvo[i].setTurnover(0);
			listvo[i].setFoul(0);
			listvo[i].setScore(0);
			listvo[i].setSteal(0);
			
			listvo[i].setTeamRoundAttack(0);
			listvo[i].setteamFreeThrowNum(0);
			listvo[i].setteamShotNum(0);
			listvo[i].setteamHitNum(0);
			listvo[i].setteamTime(0);
			listvo[i].setteamTurnOver(0);
			listvo[i].setteamRebound(0);
			listvo[i].setteamOffensiveRebound(0);
			listvo[i].setteamDefensiveRebound(0);
			listvo[i].setOpDefensiveRebound(0);
			listvo[i].setOpOffensiveRebound(0);
			listvo[i].setOpReboundAll(0);
			listvo[i].setOpRoundAttack(0);
			listvo[i].setOpTwoPointShotNum(0);
			
		}
		
	}
	

}

