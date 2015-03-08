package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileReadTest {

	private static BufferedReader br;

	public static void main(String[] args) {
		
//		outputFile("CSEⅢdata/matches/13-14_01-01_CHA-LAC");
		ArrayList<String> al = getFileNameList("CSEⅢdata/matches");
		for(int i = 0; i < al.size(); i ++){
			System.out.println(al.get(i));
		}
		System.out.println(al.size());
		
	}
	
	public static void outputFile(String path){
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
	
	public static ArrayList<String> getFileNameList(String path){
		
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

}
