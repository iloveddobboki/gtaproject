package kr.ac.sogang.gtasubway.search;

import java.io.Serializable;

public class SearchedSubwayInfo implements Serializable{
	StationInfo departure, destination;
	//환승역 있으면?  -- int stations 만큼 동적으로 할당 생싕즤
	int fare, time;//걸리는 시간
	int numOfStations;
	
	public SearchedSubwayInfo(StationInfo departure, StationInfo destination, int fare, int time, int numOfStations){
		this.departure=departure;
		this.destination=destination;
		this.fare=fare;
		this.time=time;
		this.numOfStations=numOfStations;
	}
}
