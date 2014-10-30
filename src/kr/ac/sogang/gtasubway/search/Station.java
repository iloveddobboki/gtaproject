package kr.ac.sogang.gtasubway.search;

import java.io.Serializable;
import java.util.ArrayList;

import android.R.drawable;
import android.graphics.drawable.Drawable;

public class Station implements Serializable{

	public String mIcon;
	public String map;
	public String mStation;
	public String mLine1;
	public String mLine2;
	public int stationId; // serach 에 있는 mSearchListData에 해당 역이 담겨있는 index 값
	public ArrayList<String> phoneNum = new ArrayList<String>();
	
	public Station(String mIcon,String map, String mStation, String mLine1, String mLine2, int stationId, String phoneNum1){
		this.mIcon=mIcon;
		this.map=map;
		this.mStation=mStation;
		this.mLine1=mLine1;
		this.mLine2=mLine2;
		this.stationId=stationId;
		this.phoneNum.add(phoneNum1);
	}
	
	public Station(String mIcon,String map, String mStation, String mLine1, String mLine2, int stationId, String phoneNum1,String phoneNum2){
	
		this( mIcon, map, mStation, mLine1, mLine2, stationId, phoneNum1);
		this.phoneNum.add(phoneNum2);
		
		
	}

	public Station(String mIcon,String map, String mStation, String mLine1, String mLine2, int stationId,String phoneNum1, String phoneNum2, String phoneNum3){
	
		this( mIcon, map, mStation, mLine1, mLine2, stationId, phoneNum1,phoneNum2);
		this.phoneNum.add(phoneNum3);
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
