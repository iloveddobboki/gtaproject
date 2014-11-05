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
		String n, name, station_num, transfer;
		int i = 0, p, sn;
		
		fp =  new File(lineNum+".txt");
		line_number = new BufferedReader(new FileReader(fp));
		n = line_number.readLine();
		num = Integer.parseInt(n);//the number of stations in lineNum
		
		station = new Station[num];
		for(i = 0; i<num; i++){
			name = line_number.readLine();
			station_num = line_number.readLine();
			sn = Integer.parseInt(station_num);
			n = line_number.readLine();
			p = Integer.parseInt(n);
			transfer = line_number.readLine();

			station[i] = new Station(name,i, lineNum, p,sn, transfer);//store StationName
		}
		
		
		line_number.close();
		
	}
	
	
}
//line[i] => station array
//station.txt
//the number of stations
//station names