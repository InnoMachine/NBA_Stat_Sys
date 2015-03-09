/**
 * puppy
 * 2015年3月8日 上午10:53:10
 * TODO
 */
package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import po.Game;
import po.Player;
import po.Team;

public class FileReadTest {


	public static void main(String[] args) {
		new FileReadTest().outputFile("CSEⅢdata/teams/teams");
	}

	public void outputFile(String path){
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(path));
			String data = br.readLine();
			while(data != null){
				System.out.println(data);
				data = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> getFileNameList(String path){
		
		File file = new File(path);
		File[] fileList = file.listFiles();
		int len = fileList.length;
		ArrayList<String> fileNameList = new ArrayList<String>(len);
		System.out.println("the number of files under current path is" + len);
		for(int i = 0; i < len; i ++){
			if(fileList[i].isFile()){
				fileNameList.add(fileList[i].toString());
			}
		}
		return fileNameList;
		
	}
	
	public String getFileContext(String path){
		
		return null;
		
	}
	
	public ArrayList<ArrayList<String>> teamDataSplitor(String context){
		
		return null;
		
	}
	
	public ArrayList<String> playerDataSplitor(String context){
		
		return null;
		
	}
	
	public ArrayList<String> gameDataSplitor(String context){
		
		return null;
		
	}
	
	public ArrayList<Team> makeTeamList(ArrayList<ArrayList<String>> attriList){
		
		return null;
		
	}
	
	public Player makePlayer(ArrayList<String> attriList){
		
		return null;
		
	}
	
	public Game makeGame(ArrayList<String> attriList){
		
		return null;
		
	}

}
