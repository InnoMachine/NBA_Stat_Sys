/**
 * puppy
 * 2015年3月8日 上午10:53:10
 * TODO
 */
package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import po.Conference;
import po.Division;
import po.GamePO;
import po.PlayerPO;
import po.TeamPO;

public class DataFileReader {

	private Scanner scanner;

	public static void main(String[] args) {
		
		
	}
	
	public void importGames(){
		System.out.println("Games data imported!");
	}
	
	public void importPlayers(){
		
		DataFileReader dfr = new DataFileReader();
		ArrayList<String> playerInfoFileNameList =  dfr.getFileNameList("CSEdata/players/info");
		for(int i = 0; i < playerInfoFileNameList.size(); i ++){
			
			String playerInfoFileName = playerInfoFileNameList.get(i);
			String originalString = dfr.getOriginalFileString(playerInfoFileName);
			String splitedContent = dfr.splitKeyword(originalString);
			ArrayList<String> playerDataList = dfr.playerDataSplitor(splitedContent);
			PlayerDao playerController = new PlayerDaoImpl();
			playerController.add(dfr.makePlayer(playerDataList));
			
		}
		System.out.println("Players data imported!");
		
	}
	
	public void importTeams(){
		
		ArrayList<TeamPO> teamList = new DataFileReader().makeTeamList(new DataFileReader().teamDataSplitor(new DataFileReader().splitKeyword(new DataFileReader().getOriginalFileString("CSEdata/teams/teams"))));
		TeamDao teamController = new TeamDaoImpl();
		for(int k = 0; k < teamList.size(); k ++){
			teamController.add(teamList.get(k));
		}
		System.out.println("Teams data imported!");
		
	}

	public String getOriginalFileString(String path){
		
	        StringBuffer fileContent = new StringBuffer();  
	        BufferedReader br = null;  
	        try {  
	            br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));  
	            String line = null;
	            if((line = br.readLine()) != null){
	            	fileContent.append(line.trim());
	            }
	            while ((line = br.readLine()) != null) {
	            	fileContent.append("\n");
	                fileContent.append(line.trim());  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
	        finally{ 
	            if(br!=null)  
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }  
	        }  
	        return fileContent.toString();
	        
	}
	
	public String splitKeyword(String originalString){
		
		originalString = originalString.replace("╔", "");//teams
		originalString = originalString.replace("╤", "");
		originalString = originalString.replace("═", "");
		originalString = originalString.replace("╗", "");
		originalString = originalString.replace("║", "");
		originalString = originalString.replace("╚", "");
		originalString = originalString.replace("│", "\n");
		originalString = originalString.replace("╝", "");
		originalString = originalString.replace("╧", "");
		
		originalString = originalString.replace("─", "");//players
		originalString = originalString.replace("┼", "");
		originalString = originalString.replace("╢", "");
		originalString = originalString.replace("╟", "");
		
		String result = new String();
		
		scanner = new Scanner(originalString);
		String line = new String();
		if(scanner.hasNextLine()){
			line = scanner.nextLine();
			result += line.trim();
		}
		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			if(!line.equals("")){
				if(result.equals("")){
					result += line.trim();
				}else{
					result += ("\n" + line.trim());
				}
			}
		}
		return result;
		
	}
	
	public ArrayList<ArrayList<String>> teamDataSplitor(String context){
		
		ArrayList<ArrayList<String>> splitedFullData = new ArrayList<ArrayList<String>>();
		ArrayList<String> splitedSingleData = new ArrayList<String>();
		Scanner scannerFull = new Scanner(context);
		String keyword = new String();
		while(scannerFull.hasNextLine()){
			keyword = scannerFull.nextLine();
			splitedSingleData.add(keyword);
			if(splitedSingleData.size() == 7){
				splitedFullData.add(new ArrayList<String>(splitedSingleData));//reference attentiion!
				splitedSingleData.clear();
			}
		}
		scannerFull.close();
		return splitedFullData;
		
	}
	
	public ArrayList<String> playerDataSplitor(String context){
		
		ArrayList<String> splitedSingleData = new ArrayList<String>();
		Scanner scannerFull = new Scanner(context);
		String keyword = new String();
		while(scannerFull.hasNextLine()){
			scannerFull.nextLine();
			if(scannerFull.hasNextLine()){
				keyword = scannerFull.nextLine();
			}else{
				keyword = null;
			}
			splitedSingleData.add(keyword);
			
			if(splitedSingleData.size() == 9){
				break;
			}
		}
		scannerFull.close();	
		return splitedSingleData;
	}
	
	public ArrayList<String> gameDataSplitor(String context){
		
		return null;
		
	}
	
	public ArrayList<TeamPO> makeTeamList(ArrayList<ArrayList<String>> attriList){
		
		ArrayList<TeamPO> teamList = new ArrayList<TeamPO>();
		TeamPO team;
		for(int i = 0; i < attriList.size(); i ++){
			team = new TeamPO();
			team.setTeamName(attriList.get(i).get(0));
			team.setAbbreviation(attriList.get(i).get(1));
			team.setCity(attriList.get(i).get(2));
			Conference conf = Conference.valueOf(attriList.get(i).get(3).toUpperCase(Locale.ENGLISH));
			team.setConference(conf);
			Division div = Division.valueOf(attriList.get(i).get(4).toUpperCase(Locale.ENGLISH));
			team.setDivision(div);
			team.setHomeField(attriList.get(i).get(5));
			team.setBirthYear(attriList.get(i).get(6));
			team.setImgPath("CSEdata/teams/" + attriList.get(i).get(1) + ".svg");
			teamList.add(team);//reference attention!
		}
		return teamList;
		
	}
	
	public PlayerPO makePlayer(ArrayList<String> attriList){
		
		PlayerPO player;
		String exp;
		player = new PlayerPO();
		player.setName(attriList.get(0));
		player.setNumber(attriList.get(1));
		player.setPosition(attriList.get(2));
		player.setWeight(attriList.get(3));
		player.setHeight(attriList.get(4));
		player.setBirth(attriList.get(5));
		player.setAge(Integer.parseInt(attriList.get(6)));
		exp = attriList.get(7);
		if(DataFileReader.isNum(exp)){//attention! Ognjen
			player.setExp(Integer.parseInt(exp));
		}else{
			player.setExp(0);//to indicate dirty data
		}
		player.setSchool(attriList.get(8));
		player.setActionImgPath("CSEdata/players/action/" + attriList.get(0) + ".png");
		player.setPortraitImgPath("CSEdata/players/portrait/" + attriList.get(0) + ".png");
		return player;
		
	}
	
	
	
	public GamePO makeGame(ArrayList<String> attriList){
		
		return null;
		
	}
	
	public ArrayList<String> getFileNameList(String path){
	
		File file = new File(path);
		File[] fileList = file.listFiles();
		int len = fileList.length;
		ArrayList<String> fileNameList = new ArrayList<String>(len);
		for(int i = 0; i < len; i ++){
			if(fileList[i].isFile()){
				fileNameList.add(fileList[i].toString());
			}
		}
		return fileNameList;
	
	}
	
	public static boolean isNum(String str){
		
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		
	}

}
