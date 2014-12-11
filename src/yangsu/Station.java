package yangsu;

import java.io.IOException;
import java.util.StringTokenizer;

//이거 읽음 따단
public class Station{

	protected String StationName;
	protected Station_information info_by_line;
	public int index, numberoflines, station_num;
	protected Station_information[] line;
	public int[] trans;
	private int i = 0;
	//+ station information etc.
	

	public Station(String name, int index, int linenum, int n, int code, String transfer) throws IOException{
		
		// TODO Auto-generated constructor stub
		station_num = code;
		numberoflines = n;
		StationName = new String(name);
		this.index = index;
		line = new Station_information[n];
		trans = new int[n];
		////must be token transfer line 
		
		StringTokenizer tmp;
		tmp = new StringTokenizer(transfer);
		for(int f = 0; f<numberoflines; f++ ){
			 trans[f] = Integer.parseInt(tmp.nextToken(" "));
		}
		//
		info_by_line = new Station_information(station_num,linenum);//store StationName //유진 store station_num 하는거 아니얌??? 
		line[0] =  this.info_by_line;	
		i++;
		
	}
	
	
	public void add_station(Station_information a)throws IOException{
		line[i] = a;
		i++;
	}
	

}