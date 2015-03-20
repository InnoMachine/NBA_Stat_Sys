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


	public static void main(String[] args) {
		
//		DataFileReader frt = new DataFileReader();
//		System.out.println(frt.getFileContext("CSEdata/teams/teams"));
//		System.out.println(frt.teamDataSplitor(frt.getFileContext("CSEdata/teams/teams")));
		System.out.println("**************************************************");
		System.out.println(new DataFileReader().getOriginalFileString());
		System.out.println("**************************************************");
		System.out.println(new DataFileReader().splitKeyword(new DataFileReader().getOriginalFileString()));
		System.out.println("**************************************************");
		System.out.println(new DataFileReader().teamDataSplitor(new DataFileReader().splitKeyword(new DataFileReader().getOriginalFileString())));
	}

	public String getOriginalFileString(){
		
	        StringBuffer fileContent = new StringBuffer();  
	        BufferedReader br = null;  
	        try {  
	            br = new BufferedReader(new InputStreamReader(new FileInputStream("CSEdata/teams/teams"),"UTF-8"));  
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
	
	public String splitKeyword(String originalString){
		
		
		originalString = originalString.replace("╔", "");
		originalString = originalString.replace("╤", "");
		originalString = originalString.replace("═", "");
		originalString = originalString.replace("╗", "");
		originalString = originalString.replace("║", "");
		originalString = originalString.replace("╚", "");
		originalString = originalString.replace("│", "\n");
		originalString = originalString.replace("╝", "");
		originalString = originalString.replace("╧", "");
		
		String result = new String();
		
		Scanner scanner = new Scanner(originalString);
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			if(line.equals("")){
				
			}else{
				result += (line + "\n");
			}
		}
		
		
		
		
		return result;
		
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
//			System.out.println(line+"-----------------------------thisisline");//
			while(scannerLine.hasNext()){
				next = scannerLine.next();
//				System.out.println(next.length()+" as follow");
				splitedSingleData.add(next);
//				System.out.println("*"+next+"*");
				
			}
			scannerLine.close();
			line = scannerFull.nextLine();
			splitedFullData.add(splitedSingleData);
			splitedSingleData = new ArrayList<String>();
		}
		scannerFull.close();
		System.out.println((int)splitedFullData.get(0).get(0).charAt(0));
		return splitedFullData;
		
	}
	
	public ArrayList<String> playerDataSplitor(String context){
		
		return null;
		
	}
	
	public ArrayList<String> gameDataSplitor(String context){
		
		return null;
		
	}
	
	public ArrayList<TeamPO> makeTeamList(ArrayList<ArrayList<String>> attriList){
		
		ArrayList<TeamPO> teamList = new ArrayList<TeamPO>();
		TeamPO team = new TeamPO();
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
			team.setImgPath("CSEdata/teams/" + attriList.get(i).get(1) + ".svg");
		}
		teamList.add(team);
		return teamList;
		
	}
	
	public PlayerPO makePlayer(ArrayList<String> attriList){
		
		return null;
		
	}
	
	public GamePO makeGame(ArrayList<String> attriList){
		
		return null;
		
	}

}
