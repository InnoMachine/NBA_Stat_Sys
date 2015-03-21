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
import database.TeamDaoImpl;

public class Data_Handler {
	private static Data_Handler instance;
	
	protected PlayerDao playerdao;
	protected GameDao gamedao;
	protected TeamDao teamdao;
	private ArrayList<PlayerPO> listpo;
	private ArrayList<TeamPO> teamlistpo;
	private ArrayList<PlayerVo> listvo;
	private ArrayList<TeamVo> teamlistvo;
	private ArrayList<GamePO> gamelist;
	
	
	
	private Data_Handler()
	{
		playerdao = new PlayerDaoImpl();
		gamedao = new GameDaoImpl();
		teamdao = new TeamDaoImpl();
		listpo  = playerdao.getAllPlayers();
		teamlistpo = teamdao.getAllTeams();
		listvo = new ArrayList<PlayerVo>();
		teamlistvo = new ArrayList<TeamVo>();
		gamelist = gamedao.getAllGames();
		
		SetPlayerVo();
		SetTeamVo();
		loadGames();
		playerCalculate();
		TeamCalculate();
		PlayerDivisionSet();
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
			temp.setHitRate(temp.getHitNum()/temp.getShotNum());
			temp.setThreePointHitRate(temp.getThreePointHitNum()/temp.getThreePointShotNum());
			temp.setFreeThrowRate(temp.getFreeThrowHitNum()/temp.getFreeThrowShotNum());
			temp.setWinningRate(temp.getWinningNum()/temp.getGameNum());
			temp.setAttackingEfficiency(temp.getScore()/temp.getRoundAttack()*100);
			temp.setDefensiveEfficiency(temp.getOpScore()/temp.getOpRoundAttack()*100);
			temp.setReboundEfficiency(temp.getReboundOverall()/(temp.getReboundOverall()+temp.getOpReboundAll()));
			temp.setStealEfficiency(temp.getSteal()/temp.getOpRoundAttack()*100);
			temp.setAssistanceEfficiency(temp.getAssistance()/temp.getRoundAttack()*100);
			
		}
		
	}
	private void playerCalculate() {
		for(PlayerVo temp:listvo)
		{
			temp.setHitRate(temp.getHitNum()/temp.getShotNum());
			temp.setThreePointHitRate(temp.getThreePointHitNum()/temp.getThreePointShotNum());
			temp.setFreeThrowRate(temp.getFreeThrowHitNum()/temp.getFreeThrowShotNum());
			temp.setBlock(temp.getBlock());
			temp.setTurnover(temp.getTurnover());
			temp.setFoul(temp.getFoul());
			temp.setSteal(temp.getSteal());
			temp.setScore(temp.getScore());
			temp.setEfficiency(temp.getScore()+temp.getBlock()+temp.getReboundOverall()+
					temp.getAssistance()+temp.getSteal()-temp.getFreeThrowShotNum()-
					temp.getShotNum()+temp.getHitNum()+temp.getFreeThrowHitNum()-temp.getTurnover());
			temp.setGmSc(temp.getScore()+0.4*temp.getHitNum()-0.7*temp.getShotNum()-0.4*
					(temp.getFreeThrowShotNum()-temp.getFreeThrowHitNum())
					+0.7*temp.getAttackingNum()+0.3*temp.getDefensiveNum()+temp.getSteal()
					+0.7*temp.getAssistance()+0.7*temp.getBlock()-0.4*temp.getFoul()-temp.getTurnover());
			temp.setTrueHitRate(temp.getScore()/(2*(temp.getShotNum()+temp.getThreePointShotNum()+0.44
					*temp.getFreeThrowShotNum())));
			temp.setHitEfficiency((temp.getHitNum()+0.5*temp.getThreePointHitNum())/temp.getShotNum());
			temp.setReboundOverallRate(temp.getReboundOverall()*(temp.getteamTime()/5)/temp.getTime()
					/(temp.getteamRebound()+temp.getOpReboundAll()));
			temp.setOffensiveReboundRate(temp.getAttackingNum()*(temp.getteamTime()/5)/temp.getTime()
					/(temp.getteamOffensiveRebound()+temp.getOpOffensiveRebound()));
			temp.setDefensiveReboundRate(temp.getDefensiveNum()*(temp.getteamTime()/5)/temp.getTime()
					/(temp.getteamDefensiveRebound()+temp.getOpDefensiveRebound()));
			temp.setAssistanceRate(temp.getAssistance()/(temp.getTime()/(temp.getteamTime()/5)
					*temp.GetteamHitNum()-temp.getHitNum()));
			temp.setStealRate(temp.getSteal()*(temp.getteamTime()/5)/temp.getTime()
					/temp.getOpRoundAttack());
			temp.setBlockRate(temp.getBlock()*(temp.getteamTime()/5)/temp.getTime()
					/temp.getOpTwoPointShotNum());
			temp.setTurnOverRate(temp.getTurnover()+0.44*temp.getFreeThrowShotNum()+temp.getTurnover());;
			temp.setUseRate((temp.getShotNum()+0.44*temp.getFreeThrowShotNum()+temp.getTurnover())
				*(temp.getteamTime()/5)/temp.getTime()/(temp.GetteamShotNum()+
							0.44*temp.getteamFreeThrowNum()+temp.getteamTurnOver()));
			temp.setWeighted(temp.getScore()+temp.getReboundOverall()+temp.getBlock());
			
		}
	}
	private void loadGames() {
		for(int i=0;i<gamelist.size();i++)
		{
			TeamPerformance tpg = gamelist.get(i).getGuestTP();
			TeamPerformance tph = gamelist.get(i).getHomeTP();
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
		}
	}
	private void teamVoPSet(TeamPerformanceInSingleGame tgp) {
		for(int i=0;i<teamlistvo.size();i++)
		{
			
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
			
			teamlistvo.get(i).setOpDefensiveRebound(teamlistvo.get(i).getOpDefensiveRebound()+tgp.getOpDefensiveRebound());
			teamlistvo.get(i).setOpOffensiveRebound(teamlistvo.get(i).getOpOffensiveRebound()+tgp.getOpOffensiveRebound());
			teamlistvo.get(i).setOpReboundAll(teamlistvo.get(i).getOpReboundAll()+tgp.getOpDefensiveRebound()+tgp.getOpOffensiveRebound());
			teamlistvo.get(i).setOpRoundAttack(teamlistvo.get(i).getOpRoundAttack()+tgp.getOpRoundAttack());
			teamlistvo.get(i).setOpScore(teamlistvo.get(i).getOpScore()+tgp.getOpScore());
			teamlistvo.get(i).setOpTwoPointShotNum(teamlistvo.get(i).getOpTwoPointShotNum()+tgp.getOpTwoPointShotNum());
			
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
					break;
				}
			}
		}
		
	}
	private TeamPerformanceInSingleGame setPerformance(TeamPerformance tp) {
		ArrayList<SinglePerformance> listsp = new ArrayList<SinglePerformance>();
		String abbr = tp.getTeamNameAbbr();
		TeamPerformanceInSingleGame tgp = new TeamPerformanceInSingleGame(abbr);
		for(SinglePerformance temp:listsp)
		{
			int k=0;
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
			for(int i=0;i<listvo.size();i++)
			{
				if(temp.getName().equals(listvo.get(i).getName()))
				{
					PlayerPerformanceInSingleGame pgp = new PlayerPerformanceInSingleGame(temp.getName());
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
					}
					tgp.playerlist.add(pgp);
					break;
				}
			}
		}
		return tgp;
		
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
			teamlistvo.add(temp);
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
			
			temp.setName(listpo.get(i).getName());
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
		}		
	}
	public ArrayList<PlayerVo> getPlayers() {
		
		return listvo;
	}
	public ArrayList<TeamVo> getTeams()
	{
		return teamlistvo;
	}

}

