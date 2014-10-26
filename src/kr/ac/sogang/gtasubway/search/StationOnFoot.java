package kr.ac.sogang.gtasubway.search;

import kr.ac.sogang.gtasubway.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class StationOnFoot extends Activity {

	StationInfo stationInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_station_on_foot);
		
		Intent intent=getIntent();
		stationInfo = (StationInfo)intent.getSerializableExtra("stationInfo");
		WebView webView1 = (WebView)findViewById(R.id.webView1);
		webView1.loadUrl("file:///android_asset/test_shinchon.JPG");
		webView1.getSettings().setBuiltInZoomControls(true);
		String departure = getIntent().getStringExtra("departure");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.station_on_foot, menu);
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
