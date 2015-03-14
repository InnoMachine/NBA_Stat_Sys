package businessLogic;

import java.util.ArrayList;

import po.GamePO;
import po.PlayerPO;
import po.SinglePerformance;
import po.TeamPerformance;
import vo.PlayerVo;
import database.GameDao;
import database.GameDaoImpl;
import database.PlayerDao;
import database.PlayerDaoImpl;

public class Player_Handler {
	protected PlayerDao playerdao;
	protected GameDao gamedao;
	private ArrayList<PlayerPO> listpo;
	ArrayList<GamePO> gamelist;
	SinglePerformance splist[];
	private PlayerVo[] listvo;
	public Player_Handler()
	{
		playerdao = new PlayerDaoImpl();
		gamedao = new GameDaoImpl();
		listpo  = playerdao.getAllPlayers();
		listvo = new PlayerVo[listpo.size()+1];
		splist = new SinglePerformance[listvo.length];
		gamelist = gamedao.getAllGames();
		setVo();
		loadGames();
		Calculate();
	}
	private void Calculate() 
	{
		for(int i=0;i<splist.length;i++)
		{
			listvo[i].setHitRate(splist[i].getHitNum()/splist[i].getShotNum());
			listvo[i].setThreePointHitRate(splist[i].getThreePointHitNum()/splist[i].getThreePointShotNum());
			listvo[i].setFreeThrowRate(splist[i].getFreeThrowHitNum()/splist[i].getFreeThrowShotNum());
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
			listvo[i].setGmSc(splist[i].getScore()+0.4*(splist[i].getHitNum()+splist[i].getThreePointHitNum())
					-0.7*(splist[i].getShotNum()+splist[i].getThreePointShotNum())-0.4*
					(splist[i].getFreeThrowShotNum()-splist[i].getFreeThrowHitNum())
					+0.7*splist[i].getOffensiveRebound()+0.3*splist[i].getDefensiveRebound()/*splist[i].getsteal()*/
					+0.7*splist[i].getAssistance()+0.7*splist[i].getBlock()-0.4*splist[i].getFoul()-splist[i].getTurnover());
			listvo[i].setTrueHitRate(splist[i].getScore()/(2*(splist[i].getShotNum()+splist[i].getThreePointShotNum()+0.44
					*splist[i].getFreeThrowShotNum())));
			listvo[i].setHitEfficiency((splist[i].getHitNum()+0.5*splist[i].getThreePointHitNum())/splist[i].getShotNum());
			//篮板率等。。。需要时间
			
		}
	}
	private void setVo()
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
	private void loadGames()
	{
		for(int i=0;i<gamelist.size();i++)
		{
			TeamPerformance tpg = gamelist.get(i).getGuestTP();
			TeamPerformance tph = gamelist.get(i).getHomeTP();
			setPerformance(tpg);
			setPerformance(tph);
		}
	}
	private void setPerformance(TeamPerformance tp)
	{
		ArrayList<SinglePerformance> listsp = new ArrayList<SinglePerformance>();//tp.getT
		for(SinglePerformance temp:listsp)
		{
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
				}
			}
		}
	}
}
