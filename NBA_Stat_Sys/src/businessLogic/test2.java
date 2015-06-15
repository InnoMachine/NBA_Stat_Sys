package businessLogic;

import dataService.DataScrawl;

public class test2 {
	public static void main(String args[]){
		for(int i = 2010; i < 2015; i ++) {
			DataScrawl.addGameList(i);
		}
	}
}
