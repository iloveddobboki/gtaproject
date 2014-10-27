package kr.ac.sogang.gtasubway.search;

import java.io.Serializable;

import android.R.drawable;
import android.graphics.drawable.Drawable;

public class Station implements Serializable{

	public String mIcon;
	public String map;
	public String mStation;
	public String mLine1;
	public String mLine2;
	public int stationId; // serach 에 있는 mSearchListData에 해당 역이 담겨있는 index 값
	
	public Station(String mIcon,String map, String mStation, String mLine1, String mLine2, int stationId){
		this.mIcon=mIcon;
		this.map=map;
		this.mStation=mStation;
		this.mLine1=mLine1;
		this.mLine2=mLine2;
		this.stationId=stationId;
	}
	public Station(Station station){
		this.mIcon=station.mIcon;
		this.map=station.map;
		this.mStation=station.mStation;
		this.mLine1=station.mLine1;
		this.mLine2=station.mLine2;
		this.stationId=station.stationId;
	}
}
