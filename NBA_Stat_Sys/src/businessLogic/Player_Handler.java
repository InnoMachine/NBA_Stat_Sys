package businessLogic;

import java.util.ArrayList;



import vo.PlayerVo;

public class Player_Handler {
	private Data_Handler data_handler;
	private ArrayList<PlayerVo> listvo;
	
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
		}else if(option.equals("hitRate")){
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
			double a[][] = new double [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getEfficiency();
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
	
	public ArrayList<PlayerVo> filterPlayersBy(String position, String div, String option)
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
		
		if(option.equals("score")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getScore();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getScore()){
				templist.add(listvo.get(a[i][1]));
				i++;
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
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getReboundOverall()){
				templist.add(listvo.get(a[i][1]));
				i++;
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
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getAssistance()){
				templist.add(listvo.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("weighted")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getWeighted();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getWeighted()){
				templist.add(listvo.get(a[i][1]));
				i++;
			}		
			return templist;
		}
		else if(option.equals("block")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getBlock();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getBlock()){
				templist.add(listvo.get(a[i][1]));
				i++;
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
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getSteal()){
				templist.add(listvo.get(a[i][1]));
				i++;
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
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getFoul()){
				templist.add(listvo.get(a[i][1]));
				i++;
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
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getTime()){
				templist.add(listvo.get(a[i][1]));
				i++;
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
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getEfficiency()){
				templist.add(listvo.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("shotNum")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getShotNum()){
				templist.add(listvo.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("threePointShotNum")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getThreePointShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getThreePointShotNum()){
				templist.add(listvo.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("freeThrowShotNum")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getFreeThrowShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getFreeThrowShotNum()){
				templist.add(listvo.get(a[i][1]));
				i++;
			}		
			return templist;
		}else if(option.equals("twoTenNum")){
			int a[][] = new int [listvo.size()][2]; 
			for(int i=0;i<listvo.size();i++)
			{
				a[i][0] = listvo.get(i).getTwoTenNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo.get(a[i][1]));
			}
			int i =50;
			while(a[i][0]==templist.get(49).getTwoTenNum()){
				templist.add(listvo.get(a[i][1]));
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
	
}
