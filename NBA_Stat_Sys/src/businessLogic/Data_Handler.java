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
	SinglePerformance splist[];
	SinglePerformance teamsplist[];
	
	
	
	private Data_Handler()
	{
		playerdao = new PlayerDaoImpl();
		gamedao = new GameDaoImpl();
		listpo  = playerdao.getAllPlayers();
		listvo = new PlayerVo[listpo.size()+1];
		splist = new SinglePerformance[listvo.length];
		gamelist = gamedao.getAllGames();
		SetPlayerVo();
		SetTeamVo();
		loadGames();
		playerCalculate();
		TeamCalculate();
	}
	private void TeamCalculate() {
		for(int i=0;i<teamsplist.length;i++)
		{
			teamlistvo[i].setHitRate(teamsplist[i].getHitNum()/teamsplist[i].getShotNum());
			teamlistvo[i].setThreePointHitRate(teamsplist[i].getThreePointHitNum()/teamsplist[i].getThreePointShotNum());
			teamlistvo[i].setFreeThrowRate(teamsplist[i].getFreeThrowHitNum()/teamsplist[i].getFreeThrowShotNum());
			//listvo[i].setAttackingNum(attackingNum);
			//listvo[i].
			teamlistvo[i].setBlock(teamsplist[i].getBlock());
			teamlistvo[i].setTurnover(teamsplist[i].getTurnover());
			teamlistvo[i].setFoul(teamsplist[i].getFoul());
			//listvo[i].setSteal(splist[i].gets);
			teamlistvo[i].setScore(teamsplist[i].getScore());
			listvo[i].setHitEfficiency((teamsplist[i].getHitNum()+0.5*teamsplist[i].getThreePointHitNum())/teamsplist[i].getShotNum());
			//篮板率等。。。需要时间
			
		}
		
	}
	private void playerCalculate() {
		for(int i=0;i<splist.length;i++)
		{
			listvo[i].sethitRate(splist[i].getHitNum()/splist[i].getShotNum());
			listvo[i].setthreePointHitRate(splist[i].getThreePointHitNum()/splist[i].getThreePointShotNum());
			listvo[i].setfreeThrowRate(splist[i].getFreeThrowHitNum()/splist[i].getFreeThrowShotNum());
			//listvo[i].setAttackingNum(attackingNum);
			//listvo[i].
			listvo[i].setBlock(splist[i].getBlock());
			listvo[i].setTurnover(splist[i].getTurnover());
			listvo[i].setFoul(splist[i].getFoul());
			//listvo[i].setSteal(splist[i].gets);
			listvo[i].setScore(splist[i].getScore());
			listvo[i].setEfficiency(splist[i].getScore()+splist[i].getBlock()+splist[i].getReboundOverall()+
					splist[i].getAssistance()-/*splist[i].getSteal*/splist[i].getFreeThrowShotNum()-
					splist[i].getShotNum()+splist[i].getHitNum()+splist[i].getFreeThrowHitNum()-splist[i].getTurnover());
			listvo[i].setGmSc(splist[i].getScore()+0.4*splist[i].getHitNum()-0.7*splist[i].getShotNum()-0.4*
					(splist[i].getFreeThrowShotNum()-splist[i].getFreeThrowHitNum())
					+0.7*splist[i].getOffensiveRebound()+0.3*splist[i].getDefensiveRebound()/*splist[i].getsteal()*/
					+0.7*splist[i].getAssistance()+0.7*splist[i].getBlock()-0.4*splist[i].getFoul()-splist[i].getTurnover());
			listvo[i].setTrueHitRate(splist[i].getScore()/(2*(splist[i].getShotNum()+splist[i].getThreePointShotNum()+0.44
					*splist[i].getFreeThrowShotNum())));
			listvo[i].setHitEfficiency((splist[i].getHitNum()+0.5*splist[i].getThreePointHitNum())/splist[i].getShotNum());
			//篮板率等。。。需要时间
			
		}
	}
	private void loadGames() {
		for(int i=0;i<gamelist.size();i++)
		{
			TeamPerformance tpg = gamelist.get(i).getGuestTP();
			TeamPerformance tph = gamelist.get(i).getHomeTP();
			teamGameP tgpg=setPerformance(tpg);
			teamGameP tgph=setPerformance(tph);
		}
	}
	private teamGameP setPerformance(TeamPerformance tp) {
		ArrayList<SinglePerformance> listsp = new ArrayList<SinglePerformance>();//tp.getT
		String abbr = tp.getTeamNameAbbr();
		teamGameP tgp = new teamGameP(abbr);
		for(SinglePerformance temp:listsp)
		{
			//listvo[i].setTime(temp.getTime());
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
			tgp.setScore(tgp.getScore()+temp.getScore());
			for(int i=0;i<listvo.length;i++)
			{
				if(temp.getName().equals(listvo[i].getName()))
				{
					//listvo[i].setTime(temp.getTime());
					splist[i].setHitNum(splist[i].getHitNum()+temp.getHitNum());
					splist[i].setShotNum(splist[i].getShotNum()+temp.getShotNum());
					splist[i].setThreePointHitNum(splist[i].getThreePointHitNum()+temp.getThreePointHitNum());
					splist[i].setThreePointShotNum(splist[i].getThreePointShotNum()+temp.getThreePointShotNum());
					splist[i].setFreeThrowHitNum(splist[i].getFreeThrowHitNum()+temp.getFreeThrowHitNum());
					splist[i].setFreeThrowShotNum(splist[i].getFreeThrowShotNum()+temp.getFreeThrowShotNum());
					splist[i].setOffensiveRebound(splist[i].getOffensiveRebound()+temp.getOffensiveRebound());
					splist[i].setDefensiveRebound(splist[i].getDefensiveRebound()+temp.getDefensiveRebound());
					splist[i].setReboundOverall(splist[i].getReboundOverall()+temp.getReboundOverall());
					splist[i].setAssistance(splist[i].getAssistance()+temp.getAssistance());
					splist[i].setBlock(splist[i].getBlock()+temp.getBlock());
					splist[i].setTurnover(splist[i].getTurnover()+temp.getTurnover());
					splist[i].setFoul(splist[i].getFoul()+temp.getFoul());
					splist[i].setScore(splist[i].getScore()+temp.getScore());
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
			
			
			teamsplist[i].setName(teamlistpo.get(i).getAbbreviation());
			//splist[i].setTime(0);
			teamsplist[i].setHitNum(0);
			teamsplist[i].setShotNum(0);
			teamsplist[i].setThreePointHitNum(0);
			teamsplist[i].setThreePointShotNum(0);
			teamsplist[i].setFreeThrowHitNum(0);
			teamsplist[i].setFreeThrowShotNum(0);
			teamsplist[i].setOffensiveRebound(0);
			teamsplist[i].setDefensiveRebound(0);
			teamsplist[i].setReboundOverall(0);
			teamsplist[i].setAssistance(0);
			teamsplist[i].setBlock(0);
			teamsplist[i].setTurnover(0);
			teamsplist[i].setFoul(0);
			teamsplist[i].setScore(0);
			//splist[i].setSteal(0);
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
			
			
			splist[i].setName(listpo.get(i).getName());
			//splist[i].setTime(0);
			splist[i].setHitNum(0);
			splist[i].setShotNum(0);
			splist[i].setThreePointHitNum(0);
			splist[i].setThreePointShotNum(0);
			splist[i].setFreeThrowHitNum(0);
			splist[i].setFreeThrowShotNum(0);
			splist[i].setOffensiveRebound(0);
			splist[i].setDefensiveRebound(0);
			splist[i].setReboundOverall(0);
			splist[i].setAssistance(0);
			splist[i].setBlock(0);
			splist[i].setTurnover(0);
			splist[i].setFoul(0);
			splist[i].setScore(0);
			//splist[i].setSteal(0);
			
		}
		
	}
	

}
