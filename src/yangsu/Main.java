package yangsu;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

			Line[] line = new Line[9];// line array
			Find find = new Find();
			
		
				line[1] = new Line(2);
				line[3] = new Line(4);
			
				for(int i  = 0; i < line[1].num; i++){
					if(line[1].station[i].numberoflines > 1){
					
						for(int j = 0; j<line[3].num; j++){
								if(line[3].station[j].StationName.equals(line[1].station[i].StationName)){
									line[1].station[i].add_station(line[3].station[j].info_by_line);
									line[3].station[j].add_station(line[1].station[i].info_by_line);
								}// 유진 아~ 예를 들어 2,4호선 환승역 A가 있어 2호선에서 A의 역코드는 201 4호선에선 401 이라고 하면, station.station_num  이 201 이고, station.line ? 에 4호선 역정보가 추가되어있는 station 이 하나 있고, station.station_num 이 401 이고 station.line 에 2호선 역정보가 추가 돼있는, 일케 2개의 station 이 생기는 
						
						}
					}
				}
				
				
			Scanner input = new Scanner(System.in);
			
			System.out.println("start h:");
			int time_h = input.nextInt();
		
			System.out.println("start m:");
			int time_m = input.nextInt();
			
			System.out.println("start : ");
			String departure = input.next();
			
			
			
			Station start = find.FindStation_All_line(departure, line);
			
			if(start == null){
				System.out.println("error");
				return ;
			}
			
			System.out.println("end : ");
			String destination = input.next();
			
			Station end = find.FindStation_All_line(destination, line);

			if(end == null){
				System.out.println("error");
				return ;
			}
			
			
			/*Transfer trans = new Transfer();
			Way way = null;
			
			way = trans.transfer(start, end, time_h, time_m);
			
			if(way == null){
				System.out.println("error");
				return ;
			}
			

			System.out.println("departure:"+way.deph+":"+way.depm);
			System.out.println("destination:"+way.desh+":"+way.desm);
			System.out.println("spent:"+way.sh+":"+way.sm);
			*/
	}

}
