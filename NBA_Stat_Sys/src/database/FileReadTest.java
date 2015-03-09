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
import java.util.Locale;
import java.util.Scanner;

import po.Conference;
import po.Division;
import po.Game;
import po.Player;
import po.Team;

public class FileReadTest {


	public static void main(String[] args) {
		
		FileReadTest frt = new FileReadTest();
		System.out.println(frt.getFileContext("CSEⅢdata/teams/teams"));
		System.out.println(frt.teamDataSplitor(frt.getFileContext("CSEⅢdata/teams/teams")));
		
	}

	public void outputFile(String path){
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(path));
			String data = br.readLine();
			while(data != null){
				data = data.replace('╔', ' ');
				data = data.replace('╤', ' ');
				data = data.replace('═', ' ');
				data = data.replace('╗', ' ');
				data = data.replace('║', ' ');
				data = data.replace('╚', ' ');
				data = data.replace('│', ' ');
				data = data.replace('╝', ' ');
				data = data.replace('╧', ' ');
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
		
		String context = new String();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(path));
			String data = br.readLine();
			while(data != null){
				data = data.replace('╔', '\0');
				data = data.replace('╤', '\0');
				data = data.replace('═', '\0');
				data = data.replace('╗', '\0');
				data = data.replace('║', '\0');
				data = data.replace('╚', '\0');
				data = data.replace('│', '\0');
				data = data.replace('╝', '\0');
				data = data.replace('╧', '\0');
				
				context += (data + "\n");
				data = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return context;
		
	}
	
	public ArrayList<ArrayList<String>> teamDataSplitor(String context){
		
		ArrayList<ArrayList<String>> splitedFullData = new ArrayList<ArrayList<String>>();
		ArrayList<String> splitedSingleData = new ArrayList<String>();
		Scanner scannerFull = new Scanner(context);
		Scanner scannerLine;
		String line = scannerFull.nextLine();
		String next;
		while(scannerFull.hasNextLine()){
			scannerLine = new Scanner(line);
			System.out.println(line+"!!!!!!!!!thisisline");//
			while(scannerLine.hasNext()){
				next = scannerLine.next();
				System.out.println(next.length()+"===============");
				splitedSingleData.add(next);
				System.out.println(next);
			}
			scannerLine.close();
			line = scannerFull.nextLine();
			System.out.println(splitedSingleData.isEmpty());//
			splitedFullData.add(splitedSingleData);
			splitedSingleData = new ArrayList<String>();
		}
		scannerFull.close();
		return splitedFullData;
		
	}
	
	public ArrayList<String> playerDataSplitor(String context){
		
		return null;
		
	}
	
	public ArrayList<String> gameDataSplitor(String context){
		
		return null;
		
	}
	
	public ArrayList<Team> makeTeamList(ArrayList<ArrayList<String>> attriList){
		
		ArrayList<Team> teamList = new ArrayList<Team>();
		Team team = new Team();
		for(int i = 0; i < attriList.size(); i ++){
			team.setTeamName(attriList.get(i).get(0));
			team.setAbbreviation(attriList.get(i).get(1));
			team.setCity(attriList.get(i).get(2));
			Conference conf = Conference.valueOf(attriList.get(i).get(3).toUpperCase(Locale.ENGLISH));
			team.setConference(conf);
			Division div = Division.valueOf(attriList.get(i).get(4).toUpperCase(Locale.ENGLISH));
			team.setDivision(div);
			team.setHomeField(attriList.get(i).get(5));
			team.setBirthYear(attriList.get(i).get(6));
			team.setImgPath("CSEⅢdata/teams/" + attriList.get(i).get(1) + ".svg");
		}
		teamList.add(team);
		return teamList;
		
	}
	
	public Player makePlayer(ArrayList<String> attriList){
		
		return null;
		
	}
	
	public Game makeGame(ArrayList<String> attriList){
		
		return null;
		
	}

}
