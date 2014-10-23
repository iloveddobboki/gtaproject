package kr.ac.sogang.gtasubway.search;

import kr.ac.sogang.gtasubway.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class SearchedSubway extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searched_subway);
		
		StationInfo shinchon = new StationInfo("신촌", 2, 31, 1, 1, new Time(), new Time()), ahyen = new StationInfo("아현", 2, 31, 2, 2, new Time(), new Time());
	
		SearchedSubwayInfo searchedSubway=new SearchedSubwayInfo(shinchon, ahyen, 1000, 10, 2);
		
		setTitle(searchedSubway.departure.stationName+"에서"+searchedSubway.destination.stationName+"으로");
		
		Button btDeparture=(Button)findViewById(R.id.station1), btDestination=(Button)findViewById(R.id.station2);
		
		btDeparture.setText(searchedSubway.departure.stationName);
		btDestination.setText(searchedSubway.destination.stationName);
		
		TextView tvLineStation1, tvDoorStation1, tvWidth1, tvHeight1, tvLineStation2, tvDoorStation2, tvWidth2, tvHeight2, tvArrivalTime, tvDepartureTime, tvTime, tvNumOfStations, tvFare;
		
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.searched_subway, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
