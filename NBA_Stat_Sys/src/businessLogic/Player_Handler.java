package businessLogic;

import java.util.ArrayList;

import po.Division;
import vo.PlayerVo;

public class Player_Handler {
	private Data_Handler data_handler;
	private PlayerVo[] listvo;
	private ArrayList<PlayerVo> arrlistvo;
	public Player_Handler()
	{
		data_handler = Data_Handler.getInstance();
		listvo = data_handler.getPlayers();
		arrlistvo = new ArrayList<PlayerVo>();
		ChangeToArrayList();
	}
	private void ChangeToArrayList() {
		for(int i=0;i<listvo.length;i++)
		{
			arrlistvo.add(listvo[i]);
		}
		
	}
	public PlayerVo getPlayerByName(String name) {
		for(int i=0;i<listvo.length;i++)
		{
			if(name.equals(listvo[i].getName()))
			{
				return listvo[i];
			}
		}
		return null;
	}
	public ArrayList<PlayerVo> getAllPlayer() {
		return arrlistvo;
	}
	public ArrayList<PlayerVo> sortPlayerBy(String option) {
		if(option.equals("name")){
			String a[][] = new String [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getName();
				a[i][1] = i+"";
			}
			HeapSortByString.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[Integer.parseInt(a[i][1])]);
			}
			return templist;
		}else if(option.equals("team")){
			String a[][] = new String [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getTeam();
				a[i][1] = i+"";
			}
			HeapSortByString.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[Integer.parseInt(a[i][1])]);
			}
			return templist;
		}else if(option.equals("FirstOnNum")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getFirstOnNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("reboundOverall")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getReboundOverall();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("assistance")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getAssistance();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("hitRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getHitRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("threePointHitRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getThreePointHitRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("freeThrowRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getFreeThrowRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("attackingNum")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getAttackingNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("defensiveNum")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getDefensiveNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("steal")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getSteal();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("block")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getBlock();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("turnover")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getTurnover();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("foul")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getFoul();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("score")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getScore();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("efficiency")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getEfficiency();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("GmSc")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getGmSc();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("trueHitRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getTrueHitRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("hitEfficiency")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getHitEfficiency();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("reboundOverallRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getReboundOverallRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("offensiveReboundRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getOffensiveReboundRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("defensiveReboundRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getDefensiveReboundRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("assistanceRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getAssistanceRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("stealRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getFreeThrowRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("blockRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getBlockRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("turnOverRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getTurnOverRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("useRate")){
			double a[][] = new double [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getUseRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<listvo.length;i++)
			{
				templist.add(listvo[(int)a[i][1]]);
			}
			return templist;
		}
		
		return null;
	}
	public ArrayList<PlayerVo> getPlayersByTeam(String abbr) {
		ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
		for(PlayerVo temp:arrlistvo) 
		{
			if(abbr.equals(temp.getTeam()))
			{
				templist.add(temp);
			}
		}
		return templist;
	}
	
	public ArrayList<PlayerVo> filterPlayersBy(String position, Division div, String option)
	{
		ArrayList<PlayerVo> list = new ArrayList<PlayerVo>();
		for(PlayerVo temp:arrlistvo)
		{
			if(temp.getPosition().equals(position)&&temp.getDivision().equals(div))
			{
				list.add(temp);
			}		
		}
		if(option.equals("score")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getScore();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getScore()){
				templist.add(listvo[a[i][1]]);
				i++;
			}		
			return templist;
		}else if(option.equals("reboundOverall")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getReboundOverall();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getReboundOverall()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("assistance")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getAssistance();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getAssistance()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("weighted")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getWeighted();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getWeighted()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}
		else if(option.equals("block")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getBlock();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getBlock()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("steal")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getSteal();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getSteal()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("foul")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getFoul();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getFoul()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("time")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getTime();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getTime()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("efficiency")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getEfficiency();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getEfficiency()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("shotNum")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getShotNum()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("threePointShotNum")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getThreePointShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getThreePointShotNum()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("freeThrowShotNum")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getFreeThrowShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getFreeThrowShotNum()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}else if(option.equals("twoTenNum")){
			int a[][] = new int [listvo.length][2]; 
			for(int i=0;i<listvo.length;i++)
			{
				a[i][0] = listvo[i].getTwoTenNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<PlayerVo> templist = new ArrayList<PlayerVo>();
			for(int i=0;i<50;i++)
			{
				templist.add(listvo[a[i][1]]);
			}
			int i =50;
			while(a[i][0]==templist.get(49).getTwoTenNum()){
				templist.add(listvo[a[i][1]]);
				i++;
			}	
			return templist;
		}
		return null;
		
	}
	
}
