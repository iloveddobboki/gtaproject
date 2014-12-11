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
			n = line_number.readLine();      //유진 이게뭐임? 2.txt 파일엔 맨처음에 역 몇개인지 수있고 그다음부턴 역명\n 역번호\n 이러케 써있는거 같은뎅???? 
			p = Integer.parseInt(n);         //유진 이게 예를 들어 1호선, 2호선, 4호선 일케 세게 호선 환승역이면 3이 되는거여?
			transfer = line_number.readLine();  //유진 이게뭐임? 예를 들어 1호선, 2호선, 4호선 일케 세게 호선 환승역이면 "1 2 4" 이런 스트링임? 

			station[i] = new Station(name,i, lineNum, p,sn, transfer);//store StationName
		}
		
		
		line_number.close();
		
	}
	
	
}
//line[i] => station array
//station.txt
//the number of stations
//station names