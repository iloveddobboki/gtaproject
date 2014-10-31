package yangsu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Line {
	
	public Station[] station;
	public int num;
	
	public Line(){
		
	}
	
	public Line(int lineNum) throws IOException{
		
		File fp;
		BufferedReader line_number;
		String n, name, station_num;
		int i = 0;
		
		fp =  new File(lineNum+".txt");
		line_number = new BufferedReader(new FileReader(fp));
		n = line_number.readLine();
		num = Integer.parseInt(n);//the number of stations in lineNum
		
		station = new Station[num];
		for(i = 0; i<num; i++){
			name = line_number.readLine();
			station_num = line_number.readLine();
			station[i] = new Station(name,i, lineNum, num);//store StationName
		}
		line_number.close();
		
	}
	
	
}
//line[i] => station array
//station.txt
//the number of stations
//station names