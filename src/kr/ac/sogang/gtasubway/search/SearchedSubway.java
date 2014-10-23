package kr.ac.sogang.gtasubway.search;

import kr.ac.sogang.gtasubway.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SearchedSubway extends Activity {
		StationInfo shinchon = new StationInfo("신촌", 2, 31, 1, 1, new Time()/*어쩔*/, new Time()), ahyen = new StationInfo("아현", 2, 31, 2, 2, new Time(), new Time());
		
		SearchedSubwayInfo searchedSubway=new SearchedSubwayInfo(shinchon, ahyen, 1000, 10, 2);
		TextView tvLineStation1, tvDoorStation1, tvWidth1, tvHeight1, tvLineStation2, tvDoorStation2, tvWidth2, tvHeight2, tvArrivalTime, tvDepartureTime, tvTime, tvNumOfStations, tvFare;
		Button btDeparture, btDestination, btSearchMode;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searched_subway);
		
		
		
		setTitle(searchedSubway.departure.stationName+"에서"+searchedSubway.destination.stationName+"으로");
		/*버튼 텍스트 입력 : 역명*/
		btDeparture=(Button)findViewById(R.id.station1);
		btDestination=(Button)findViewById(R.id.station2);
		btSearchMode = (Button)findViewById(R.id.search_mode);
		
		
		/*텍스트뷰 텍스트 입력 : 호선, 승강장번호,단차, 격차,도착시간, 출발시간, 소요시간, 정차역수, 요금*/
		
		tvLineStation1 = (TextView)findViewById(R.id.line_station1);
		tvDoorStation1 = (TextView)findViewById(R.id.door_station1);
		tvWidth1 = (TextView)findViewById(R.id.width1);
		tvHeight1 = (TextView)findViewById(R.id.height1);
		tvLineStation2 = (TextView)findViewById(R.id.line_station2);
		tvDoorStation2 = (TextView)findViewById(R.id.door_station2);
		tvWidth2 = (TextView)findViewById(R.id.width2);
		tvHeight2 = (TextView)findViewById(R.id.height2);
		tvArrivalTime = (TextView)findViewById(R.id.arrivaltime);
		tvDepartureTime = (TextView)findViewById(R.id.departuretime);
		tvTime = (TextView)findViewById(R.id.time);
		tvNumOfStations = (TextView)findViewById(R.id.numofstations);
		tvFare = (TextView)findViewById(R.id.fare);
		
		setTextAll();
		
		btDeparture.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent itDeparture = new Intent(getApplicationContext(), StationOnFoot.class);
				startActivity(itDeparture);
			}
		});
		
		btDestination.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent itDestinatione = new Intent(getApplicationContext(), StationOnFoot.class);
				startActivity(itDestinatione);
			}
		});

		btSearchMode.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				searchedSubway=new SearchedSubwayInfo(shinchon, shinchon, 1500, 5, 1);
				setTextAll();
				
			}
		});
		
		
	}
	
	void setTextAll(){
		btDeparture.setText(searchedSubway.departure.stationName);
		btDestination.setText(searchedSubway.destination.stationName);

		tvLineStation1.setText(""+searchedSubway.departure.line);
		tvDoorStation1.setText(""+searchedSubway.departure.door);
		tvWidth1.setText(""+searchedSubway.departure.width);
		tvHeight1.setText(""+searchedSubway.departure.height);
		tvLineStation2.setText(""+searchedSubway.destination.line);
		tvDoorStation2.setText(""+searchedSubway.destination.door);
		tvWidth2.setText(""+searchedSubway.destination.width);
		tvHeight2.setText(""+searchedSubway.destination.height);
		tvArrivalTime.setText(/*searchedSubway.destination.arrival.toString()*/"2:00");
		tvDepartureTime.setText(/*searchedSubway.departure.departure.toString()*/"2:10");
		tvTime.setText(""+searchedSubway.time);
		tvNumOfStations.setText(""+searchedSubway.numOfStations);
		tvFare.setText(""+searchedSubway.fare);
	}
}
