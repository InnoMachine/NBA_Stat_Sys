package businessLogic;

import java.util.ArrayList;

import vo.TeamVo;

public class Team_Handler {
	private Data_Handler data_handler;
	private TeamVo[] teamlistvo;
	private ArrayList<TeamVo> arrlistvo;
	
	
	public Team_Handler()
	{
		data_handler = Data_Handler.getInstance();
		teamlistvo = data_handler.getTeams();
		arrlistvo = new ArrayList<TeamVo>();
		ChangeToArrayList();
	}

	private void ChangeToArrayList() {
		for(int i=0;i<teamlistvo.length;i++)
		{
			arrlistvo.add(teamlistvo[i]);
		}
	}
	
	public TeamVo getTeamByAbbr(String abbr) {
		for(TeamVo temp:arrlistvo)
		{
			if(abbr.equals(temp.getAbbreviation()))
			{
				return temp;
			}
		}
		return null;
	}
	
	public ArrayList<TeamVo> getAllTeam() {
		
		return arrlistvo;
	}

	public ArrayList<TeamVo> sortTeamBy(String option) {
		
		if(option.equals("teamName")){
			String a[][] = new String [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getTeamName();
				a[i][1] = i+"";
			}
			HeapSortByString.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[Integer.parseInt(a[i][1])]);
			}
			return templist;
		}else if(option.equals("GameNum")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getGameNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("hitNum")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getHitNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("shotNum")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("threePointHitNum")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getThreePointHitNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("threePointShotNum")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getThreePointShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("freeThrowHitNum")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getFreeThrowHitNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("freeThrowShotNum")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getFreeThrowShotNum();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("offensiveRebound")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getOffensiveRebound();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("defensiveRebound")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getDefensiveRebound();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}
		else if(option.equals("reboundOverall")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getReboundOverall();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("assistance")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getAssistance();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("steal")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getSteal();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("block")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getBlock();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("turnover")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getTurnover();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("foul")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getFoul();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("score")){
			int a[][] = new int [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getScore();
				a[i][1] = i;
			}
			HeapSortByInt.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[a[i][1]]);
			}
			return templist;
		}else if(option.equals("hitRate")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getHitRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("threePointHitRate")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getThreePointHitRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("freeThrowRate")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getFreeThrowRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("winningRate")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getWinningRate();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("roundAttack")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getRoundAttack();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("attackingEfficiency")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getAttackingEfficiency();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("defensiveEfficiency")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getDefensiveEfficiency();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("reboundEfficiency")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getReboundEfficiency();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("stealEfficiency")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getStealEfficiency();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}else if(option.equals("assistanceEfficiency")){
			double a[][] = new double [teamlistvo.length][2]; 
			for(int i=0;i<teamlistvo.length;i++)
			{
				a[i][0] = teamlistvo[i].getAssistanceEfficiency();
				a[i][1] = i;
			}
			HeapSortByDouble.heapSort(a);
			ArrayList<TeamVo> templist = new ArrayList<TeamVo>();
			for(int i=0;i<teamlistvo.length;i++)
			{
				templist.add(teamlistvo[(int)a[i][1]]);
			}
			return templist;
		}
		return null;
	}
	
	
}
