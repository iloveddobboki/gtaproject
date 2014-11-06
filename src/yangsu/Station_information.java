import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Station_information {
	
	public String name;
	public int lineNumber;
	public String call_number, address, station_code;
	public TrainNumber_and_Time[] TTA_up, TTA_down, TTA_up_red, TTA_down_red, TTA_up_w, TTA_down_w;
	public int trains_up, trains_down, trains_up_w, trains_down_w, trains_up_red, trains_down_red;
	//+station information
	public Station_information(){
		
	}
	public Station_information(int station_num,  int linenum) throws IOException{//String stationNameup,String stationNamedown, int up, int down)  throws IOException{
		
		
		File fp =  new File("stationinfo\\"+station_num+"info"+linenum+".txt");
		BufferedReader station_in_linenum = new BufferedReader(new FileReader(fp));
		this.name = station_in_linenum.readLine();
		station_code = station_in_linenum.readLine();
		lineNumber = Integer.parseInt(station_in_linenum.readLine());
		call_number = station_in_linenum.readLine();
		address = station_in_linenum.readLine();
	//	trains_up = Integer.parseInt(station_in_linenum.readLine());
	//	trains_down = Integer.parseInt(station_in_linenum.readLine());
	
		
		int tn ,desh ,desm ,deph ,depm;
	
		
		fp =  new File("stationinfo\\"+station_num+linenum+"up.txt");
		BufferedReader time_info = new BufferedReader(new FileReader(fp));
		String time, trainNum;
		int f;
		StringTokenizer tmp;
		
		trains_up = Integer.parseInt(time_info.readLine());
		TTA_up = new TrainNumber_and_Time[trains_up];
		
		for(f = 0; f<trains_up; f++ ){
			
			trainNum = time_info.readLine();
			
			time = time_info.readLine();
			tmp = new StringTokenizer(time);	
			desh = Integer.parseInt(tmp.nextToken(":"));
			desm = Integer.parseInt(tmp.nextToken(":"));
			
			time = time_info.readLine();
			tmp = new StringTokenizer(time);	
			deph = Integer.parseInt(tmp.nextToken(":"));
			depm = Integer.parseInt(tmp.nextToken(":"));
			
				
			TTA_up[f] = new TrainNumber_and_Time(trainNum, deph, depm, desh, desm);
		}
		
		time_info.close();	
		
		
		fp =  new File("stationinfo\\"+station_num+linenum+"down.txt");
		time_info = new BufferedReader(new FileReader(fp));

		trains_down = Integer.parseInt(time_info.readLine());
		TTA_down = new TrainNumber_and_Time[trains_down];
		for(f = 0; f<trains_down; f++ ){
			
			trainNum = time_info.readLine();
			time = time_info.readLine();
			
			tmp = new StringTokenizer(time);	
			desh = Integer.parseInt(tmp.nextToken(":"));
			desm = Integer.parseInt(tmp.nextToken(":"));
			
			time = time_info.readLine();
			tmp = new StringTokenizer(time);	
			deph = Integer.parseInt(tmp.nextToken(":"));
			depm = Integer.parseInt(tmp.nextToken(":"));
				
			TTA_down[f] = new TrainNumber_and_Time(trainNum, deph, depm, desh, desm);
		}
		
		time_info.close();	
		
		
		fp =  new File("stationinfo\\"+station_num+linenum+"up_red.txt");
		time_info = new BufferedReader(new FileReader(fp));

		trains_up_red = Integer.parseInt(time_info.readLine());
		TTA_up_red = new TrainNumber_and_Time[trains_up_red];
		for(f = 0; f<trains_up_red ; f++ ){
			
			trainNum = time_info.readLine();
			time = time_info.readLine();
			
			tmp = new StringTokenizer(time);	
			desh = Integer.parseInt(tmp.nextToken(":"));
			desm = Integer.parseInt(tmp.nextToken(":"));
			
			time = time_info.readLine();
			tmp = new StringTokenizer(time);	
			deph = Integer.parseInt(tmp.nextToken(":"));
			depm = Integer.parseInt(tmp.nextToken(":"));
				
			TTA_up_red[f] = new TrainNumber_and_Time(trainNum, deph, depm, desh, desm);
			
		}
		
		time_info.close();	
		
		fp =  new File("stationinfo\\"+station_num+linenum+"down_red.txt");
		time_info = new BufferedReader(new FileReader(fp));

		trains_down_red = Integer.parseInt(time_info.readLine());
		TTA_down_red = new TrainNumber_and_Time[trains_down_red];
		for(f = 0; f<trains_down_red; f++ ){
			
			trainNum = time_info.readLine();
			time = time_info.readLine();
			
			tmp = new StringTokenizer(time);	
			desh = Integer.parseInt(tmp.nextToken(":"));
			desm = Integer.parseInt(tmp.nextToken(":"));
			
			time = time_info.readLine();
			tmp = new StringTokenizer(time);	
			deph = Integer.parseInt(tmp.nextToken(":"));
			depm = Integer.parseInt(tmp.nextToken(":"));
				
			TTA_down_red[f] = new TrainNumber_and_Time(trainNum, deph, depm, desh, desm);
		}
		
		time_info.close();	
		
		
		fp =  new File("stationinfo\\"+station_num+linenum+"up_w.txt");
		time_info = new BufferedReader(new FileReader(fp));

		trains_up_w = Integer.parseInt(time_info.readLine());
		TTA_up_w = new TrainNumber_and_Time[trains_up_w];
		for(f = 0; f<trains_up_w; f++ ){
			
			trainNum = time_info.readLine();
			time = time_info.readLine();
			
			tmp = new StringTokenizer(time);	
			desh = Integer.parseInt(tmp.nextToken(":"));
			desm = Integer.parseInt(tmp.nextToken(":"));
			
			time = time_info.readLine();
			tmp = new StringTokenizer(time);	
			deph = Integer.parseInt(tmp.nextToken(":"));
			depm = Integer.parseInt(tmp.nextToken(":"));
				
			TTA_up_w[f] = new TrainNumber_and_Time(trainNum, deph, depm, desh, desm);
			
		}
		
		time_info.close();	

		
		fp =  new File("stationinfo\\"+station_num+linenum+"down_w.txt");
		time_info = new BufferedReader(new FileReader(fp));

		trains_down_w = Integer.parseInt(time_info.readLine());
		TTA_down_w = new TrainNumber_and_Time[trains_down_w];
		for(f = 0; f<trains_down_w; f++ ){
			
			trainNum = time_info.readLine();
			time = time_info.readLine();
			
			tmp = new StringTokenizer(time);	
			desh = Integer.parseInt(tmp.nextToken(":"));
			desm = Integer.parseInt(tmp.nextToken(":"));
			
			time = time_info.readLine();
			tmp = new StringTokenizer(time);	
			deph = Integer.parseInt(tmp.nextToken(":"));
			depm = Integer.parseInt(tmp.nextToken(":"));
				
			TTA_down_w[f] = new TrainNumber_and_Time(trainNum, deph, depm, desh, desm);
			
		}
		
		time_info.close();	
		station_in_linenum.close();
			
	}
}
//txt
//desh:desm deph:depm train number