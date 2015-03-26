package database;

import java.util.ArrayList;

import po.PlayerPO;
import po.SinglePerformance;

public class Test {

	public static void main(String[] args) {

//		String name = "Blake Griffin";
		PlayerDao pd = new PlayerDaoImpl();
//		System.out.println(pd.getPlayerByName(name).getSeasonSinglePerformance().size());
		int i = 1;
//		for(SinglePerformance sp: pd.getPlayerByName(name).getSeasonSinglePerformance()){
//			System.out.print(sp.toString());
//			System.out.println("--------" + (i ++));
//		}
		ArrayList<Double> list = new ArrayList<Double>();
		for(PlayerPO p: pd.getAllPlayers()){
			double score = 0;
			double num = 0;
			double avg = 0;
			
			for (SinglePerformance sp: p.getSeasonSinglePerformance()){
				if(sp != null){
					score += sp.getScore();
					num ++;
					avg = score / num;
				}
			}
			System.out.println(p.getName() + "==========" + avg);
			list.add(avg);
		}
		double max = 0;
		for(double item: list){
			if(item > max){
				max = item;
			}
		}
		System.out.println(max);
	}

}
