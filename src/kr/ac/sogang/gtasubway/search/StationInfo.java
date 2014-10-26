package kr.ac.sogang.gtasubway.search;

import java.io.Serializable;

import android.text.format.Time;

public class StationInfo  implements Serializable{
	String stationName=new String("");
	int line=0, door=0, width=0, height=0;
	int departure, arrival;
	
	public StationInfo(String stationName, int line, int door,int width, int height, int departure, int arrival){
		
		this.stationName=stationName;//될껄?
		this.line=line;
		this.door=door;
		this.width=width;
		this.height=height;
		this.departure=departure;
		this.arrival=arrival;
	}
}
