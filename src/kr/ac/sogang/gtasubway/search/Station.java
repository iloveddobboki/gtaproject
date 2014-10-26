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
	
	public Station(String mIcon, String mStation, String mLine1, String mLine2){
		this.mIcon=mIcon;
		this.mStation=mStation;
		this.mLine1=mLine1;
		this.mLine2=mLine2;
	}
	public Station(Station station){
		this.mIcon=station.mIcon;
		this.mStation=station.mStation;
		this.mLine1=station.mLine1;
		this.mLine2=station.mLine2;
	}
}
