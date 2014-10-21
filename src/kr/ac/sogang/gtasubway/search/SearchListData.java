package kr.ac.sogang.gtasubway.search;

import android.graphics.drawable.Drawable;

public class SearchListData {

	public Drawable mIcon;
	public String mStation;
	public String mLine1;
	public String mLine2;
	
	public SearchListData(Drawable mIcon, String mStation, String mLine1, String mLine2){
		this.mIcon=mIcon;
		this.mStation=mStation;
		this.mLine1=mLine1;
		this.mLine2=mLine2;
	}
	
}
