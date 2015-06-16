package businessLogic;

import java.util.ArrayList;

import dataService.DataScrawl;
import dataService.GameDao;
import dataService.SystemDao;
import dataService.SystemDaoImpl;
import po.GameDate;
import vo.GameVo;
import vo.PlayerCardVo;
import vo.PlayerPerformanceInSingleGame;
import vo.PlayerVo;
import vo.TeamGames;
import vo.TeamPerformanceInSingleGame;
import vo.TeamVo;
import vo.TotalInfo;

public class test {
	
	public static void main(String args[]){
		/*SystemDao dao = new SystemDaoImpl();
		System.out.println(dao.getStById("12-13").getCurrentDate().toString());
		Player_BS p = new Player_BL();
		ArrayList<PlayerVo> cv=p.filterPlayerBy("All", "All", "score");
		for(PlayerVo temp:cv){
			System.out.println(temp.getStealField());
		}*/
		/*Game_BS g = new Game_BL();
		GameDate gd = new GameDate(2012,11,1);
		ArrayList<PlayerPerformanceInSingleGame> gv = g.getGameByLabel("12-13_2012-10-31_DAL-UTA");
		ArrayList<GameVo> gl= g.getGamesByDate("2012-11-12","2012-11-15");
		for(GameVo temp:gl){
			System.out.println(temp.getGameLabel());
			//System.out.println(temp.getHomeTeam());
		}*/
//		Player_BS pb = new Player_BL();
//		ArrayList<PlayerVo> pv = pb.filterPlayerBy("G", "East", "score","");
//		for(PlayerVo temp:pv){
//			System.out.println(temp.getName());
//		}
//		TotalInfo ti = pb.getTotalInfo("11-12");
//		System.out.println(ti.getScoreField());
		Team_BS team_BS = new Team_BL();
		String[] timeValue = { "00-01", "01-02", "02-03", "03-04", "04-05", "05-06",
                "06-07", "07-08", "08-09", "09-10", "10-11", "11-12", "12-13",
                "13-14", "14-15" };
		ArrayList<TeamGames> vos = team_BS.getTeamGames("SAS");
		for(int i=0;i<15;i++){
			ArrayList<TeamPerformanceInSingleGame> tps = vos.get(i).getGames();
			double vm[] = new double[tps.size()]; 
			int p=0;
			for(TeamPerformanceInSingleGame temp:tps){
				double v[]=new double[5];
				for(int k=0;k<5;k++){
					v[k] = temp.getFirstonList().get(k).getScore();
				}
				vm[p]=countFuncs.variance(v);
				p++;
			}
			System.out.println(countFuncs.meanValue(vm));
//			System.out.println(vos.get(0).getAbbreviation());
//			System.out.println(vos.get(1).getAbbreviation());
//			System.out.println(vos.get(2).getAbbreviation());
//			System.out.println(vos.get(3).getAbbreviation());
//			System.out.println(timeValue[i]);
		}
		
		
		
	}
}
