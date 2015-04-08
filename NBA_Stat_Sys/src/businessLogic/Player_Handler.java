package businessLogic;

import java.math.BigDecimal;
import java.util.ArrayList;









import test.data.PlayerHotInfo;
import vo.PlayerCardVo;
import vo.PlayerPerformanceInSingleGame;
import vo.PlayerRecentGames;
import vo.PlayerVo;

public class Player_Handler {
	private Data_Handler data_handler;
	private ArrayList<PlayerVo> listvo;
	BigDecimal b;  
	public Player_Handler()
	{
		data_handler = Data_Handler.getInstance();
		listvo = data_handler.getPlayers();
	}
	
	public PlayerVo getPlayerByName(String name) {
		for(int i=0;i<listvo.size();i++)
		{
			if(name.equals(listvo.get(i).getName()))
			{
				return listvo.get(i);
			}
		}
		return null;
	}
	public ArrayList<PlayerVo> getAllPlayer() {
		return listvo;
	}
	public ArrayList<PlayerVo> sortPlayerBy(String option) {
		if(option.equals("name")){
			String a[][] = new String [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getName();
				a[i][1] = i+"";
			}
			HeapSortByString.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(Integer.parseInt(a[i][1])));
			}
			return templist;
		}else if(option.equals("team")){
			String a[][] = new String [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getTeam();
				a[i][1] = i+"";
			}
			HeapSortByString.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(Integer.parseInt(a[i][1])));
			}
			return templist;
		}else if(option.equals("time")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getTime();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("timeField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getTimeField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("FirstOnNum")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getFirstOnNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("gameNum")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getGameNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("reboundOverall")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getReboundOverall();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("reboundOverallField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getReboundOverallField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("assistance")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getAssistance();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("assistanceField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getAssistanceField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}
		else if(option.equals("hitRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getHitRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("threePointHitRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getThreePointHitRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("freeThrowRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getFreeThrowRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("attackingNumField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getAttackingNumField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("attackingNum")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getAttackingNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("defensiveNumField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getDefensiveNumField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("defensiveNum")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getDefensiveNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("stealField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getStealField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("steal")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getSteal();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("blockField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getBlockField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("block")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getBlock();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("turnoverField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getTurnoverField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("turnover")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getTurnover();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("foulField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getFoulField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("foul")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getFoul();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("scoreField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getScoreField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("score")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getScore();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			return templist;
		}else if(option.equals("efficiency")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getEfficiency();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("efficiencyField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getEfficiencyField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("GmScField")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getGmScField();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("GmSc")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getGmSc();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("trueHitRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getTrueHitRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("hitEfficiency")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getHitEfficiency();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("reboundOverallRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getReboundOverallRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("offensiveReboundRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getOffensiveReboundRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("defensiveReboundRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getDefensiveReboundRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("assistanceRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getAssistanceRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("stealRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getStealRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("blockRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getBlockRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("turnOverRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getTurnOverRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}else if(option.equals("useRate")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getUseRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(listvo.get((int)a[i][1]));
			}
			return templist;
		}
		
		return null;
	}
	public ArrayList<PlayerVo> getPlayersByTeam(String abbr) {
		ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
		for(PlayerVo temp:listvo) 
		{
			if(abbr.equals(temp.getTeam()))
			{
				templist.add(temp);
			}
		}
		return templist;
	}
	
	public ArrayList<PlayerVo> filterPlayersBy(String position, String div, String option,int n)
	{
		ArrayList<PlayerVo> list = new ArrayList<PlayerVo>();
		if(position.equals("All")&&div.equals("All"))
		{
			list = listvo;
		}
		else if((!position.equals("All"))&&div.equals("All"))
		{
			for(PlayerVo temp:listvo)
			{
				if(isPosition(temp,position))
				{
					list.add(temp);
				}		
			}
		}
		else if((position.equals("All"))&&(!div.equals("All")))
		{
			for(PlayerVo temp:listvo)
			{
				if((temp.getDivision()+"").equals(div))
				{
					list.add(temp);
				}		
			}
		}
		else{
			for(PlayerVo temp:listvo)
			{
				if((temp.getDivision()+"").equals(div)&&isPosition(temp,position))
				{
					list.add(temp);
				}		
			}
		}
		int m=Math.min(n, list.size());
		if(option.equals("score")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getScore();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getScore()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("scoreField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getScoreField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getScoreField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("reboundOverallField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getReboundOverallField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getReboundOverallField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("reboundOverall")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getReboundOverall();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getReboundOverall()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("assistanceField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getAssistanceField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getAssistanceField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("assistance")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getAssistance();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getAssistance()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("turnoverField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getTurnoverField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getTurnoverField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("turnover")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getTurnover();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getAssistance()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("weighted")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getWeighted();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getWeighted()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}
		else if(option.equals("block")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getBlock();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getBlock()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("blockField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getBlockField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getBlockField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("steal")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getSteal();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getSteal()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("stealField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getStealField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getStealField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("foul")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getFoul();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getFoul()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("foulField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getFoulField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getFoulField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("time")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getTime();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getTime()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("timeField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getTimeField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getTimeField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("efficiencyField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getEfficiencyField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getEfficiencyField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("efficiency")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getEfficiency();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getEfficiency()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("shotNumField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getShotNumField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getShotNumField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}
		else if(option.equals("shotNum")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getShotNum()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("threePointShotNumField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getThreePointShotNumField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getThreePointShotNumField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("threePointShotNum")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getThreePointShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getThreePointShotNum()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("freeThrowShotNumField")){
			double a[][] = new double [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				b = new BigDecimal(list.get(i).getFreeThrowShotNumField());
				a[i][0] = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get((int)a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getFreeThrowShotNumField()){
				templist.add(list.get((int)a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("freeThrowShotNum")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getFreeThrowShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getFreeThrowShotNum()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("twoTenNum")){
			int a[][] = new int [list.size()][2]; 
			for(int i=0;i<list.size();i++)
			{
				a[i][0] = list.get(i).getTwoTenNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<m;i++)
			{
				templist.add(list.get(a[i][1]));
			}
			int i =m;
			if(m!=list.size())
			while(a[i][0]==templist.get(m-1).getTwoTenNum()){
				templist.add(list.get(a[i][1]));
				i++;
			}		
			return templist;
		}
		return null;
		
	}
	private boolean isPosition(PlayerVo temp, String position) {
		String p = temp.getPosition();
		if(p.length()==1)
		{
			return p.equals(position);
		}
		else{
			String first = p.substring(0, 1);
			String right = p.substring(2, 3);
			return first.equals(position)||right.equals(position);
		}
		
	}
	
	public ArrayList<PlayerHotInfo> hotPlayerDaily(String option){
		ArrayList<PlayerPerformanceInSingleGame> pplist= data_handler.getPlayerGamesDaily();
		ArrayList<PlayerHotInfo> hotlist = new ArrayList<PlayerHotInfo>();
		if(option.equals("score")){
			int a[][] = new int [pplist.size()][2]; 
			for(int i=0;i<pplist.size();i++)
			{
				a[i][0] = pplist.get(i).getScore();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			for(int i=0;i<pplist.size();i++)
			{
				hotlist.add(CreateHotInfo(pplist.get(a[i][1]),option));
			}
			return hotlist;
		}else if(option.equals("block")){
			int a[][] = new int [pplist.size()][2]; 
			for(int i=0;i<pplist.size();i++)
			{
				a[i][0] = pplist.get(i).getBlock();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			for(int i=0;i<pplist.size();i++)
			{
				hotlist.add(CreateHotInfo(pplist.get(a[i][1]),option));
			}
			return hotlist;
		}else if(option.equals("assistance")){
			int a[][] = new int [pplist.size()][2]; 
			for(int i=0;i<pplist.size();i++)
			{
				a[i][0] = pplist.get(i).getAssistance();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			for(int i=0;i<pplist.size();i++)
			{
				hotlist.add(CreateHotInfo(pplist.get(a[i][1]),option));
			}
			return hotlist;
		}else if(option.equals("steal")){
			int a[][] = new int [pplist.size()][2]; 
			for(int i=0;i<pplist.size();i++)
			{
				a[i][0] = pplist.get(i).getSteal();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			for(int i=0;i<pplist.size();i++)
			{
				hotlist.add(CreateHotInfo(pplist.get(a[i][1]),option));
			}
			return hotlist;
		}else if(option.equals("reboundOverall")){
			int a[][] = new int [pplist.size()][2]; 
			for(int i=0;i<pplist.size();i++)
			{
				a[i][0] = pplist.get(i).getReboundOverall();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			for(int i=0;i<pplist.size();i++)
			{
				hotlist.add(CreateHotInfo(pplist.get(a[i][1]),option));
			}
			return hotlist;
		}
		return null;
		
	}

	private PlayerHotInfo CreateHotInfo(
			PlayerPerformanceInSingleGame pp,String option) {
		PlayerHotInfo temp = new PlayerHotInfo();
		temp.setField(option);
		temp.setName(pp.getName());
		temp.setPosition(pp.getPosition());
		temp.setTeamName(pp.getTeam());
		temp.setUpgradeRate(0);
		if(option.equals("score")){
			temp.setValue(pp.getScore());
		}else if(option.equals("reboundOverall")){
			temp.setValue(pp.getReboundOverall());
		}else if(option.equals("block")){
			temp.setValue(pp.getBlock());
		}else if(option.equals("steal")){
			temp.setValue(pp.getSteal());
		}else if(option.equals("assistance")){
			temp.setValue(pp.getAssistance());
		}
		return null;
	}
	
	public ArrayList<PlayerCardVo> progressFastPlayer(String option){
		CalculateProgress();
		if(option.equals("scoreFieldProgress")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getScoreFieldProgress();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerCardVo> templist = new ArrayList<PlayerCardVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(new PlayerCardVo(listvo.get((int)a[i][1]),option));
			}
			return templist;
		}else if(option.equals("reboundOverallFieldProgress")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getReboundOverallFieldProgress();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerCardVo> templist = new ArrayList<PlayerCardVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(new PlayerCardVo(listvo.get((int)a[i][1]),option));
			}
			return templist;
		}else if(option.equals("assistanceFieldProgress")){
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getAssistanceFieldProgress();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerCardVo> templist = new ArrayList<PlayerCardVo>();
			for(int i=0;i<listvo.size();i++)
			{
				templist.add(new PlayerCardVo(listvo.get((int)a[i][1]),option));
			}
			return templist;
		}
		return null;
	}

	private void CalculateProgress() {
		ArrayList<PlayerRecentGames> recentGames=data_handler.getPlayerRecentGames();
		for(PlayerVo temp:listvo){
			for(PlayerRecentGames recent:recentGames){
				if(temp.getName().equals(recent.getName())){
					int s=0,r=0,a=0;
					ArrayList<PlayerPerformanceInSingleGame> p = recent.getFiveGames();
					for(PlayerPerformanceInSingleGame pp:p){
						s+=pp.getScore();
						r+=pp.getReboundOverall();
						a+=pp.getAssistance();
					}
					temp.setScoreFieldProgress(((double)s/p.size()-temp.getScoreField())/(temp.getScoreField()));
					temp.setAssistanceFieldProgress(((double)a/p.size()-temp.getAssistanceField())/temp.getAssistanceField());
					temp.setReboundOverallFieldProgress(((double)r/p.size()-temp.getReboundOverallField())/temp.getReboundOverallField());
					break;
				}
			}
		}
	}
}
