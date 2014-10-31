package yangsu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Station{

	protected String StationName;
	protected Station_information[] info_by_line;
	public int index;
	private int i = 0; 
	//+ station information etc.
	

	public Station(String name, int index, int linenum, int num) throws IOException{
		
		// TODO Auto-generated constructor stub
		
		StationName = new String(name);
		this.index = index;
		info_by_line = new Station_information[9];
	
		
		//info_by_line[0] = new Station_information(name,linenum);//store StationName
		//i++;
	}
	
	/*public void add_interchange(String name, int num){
	
		
		info_by_line[i] = new Station_information(name,linenum);//store StationName
		i++;
	}*/
	

}