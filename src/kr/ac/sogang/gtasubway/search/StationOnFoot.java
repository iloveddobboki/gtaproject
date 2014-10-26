package kr.ac.sogang.gtasubway.search;

import kr.ac.sogang.gtasubway.R;
import kr.ac.sogang.gtasubway.R.id;
import kr.ac.sogang.gtasubway.R.layout;
import kr.ac.sogang.gtasubway.R.menu;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class StationOnFoot extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_station_on_foot);
		WebView webView1 = (WebView)findViewById(R.id.webView1);
		webView1.loadUrl("file:///android_asset/file.jpg");
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
