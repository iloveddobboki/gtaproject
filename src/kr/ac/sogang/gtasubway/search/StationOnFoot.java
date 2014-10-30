package kr.ac.sogang.gtasubway.search;

import kr.ac.sogang.gtasubway.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class StationOnFoot extends Activity {

	StationInfo stationInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_station_on_foot);
		
		Intent intent=getIntent();
		stationInfo = (StationInfo)intent.getSerializableExtra("stationInfo");
		
		
	    
	
		WebView webView1 = (WebView)findViewById(R.id.webView1);
		if(stationInfo.searchedMap==null)
			if(stationInfo.map==null)
				webView1.loadUrl("file:///android_asset/noimage.JPG");
			else
				webView1.loadUrl("file:///android_asset/"+stationInfo.map);
		else
			webView1.loadUrl("file:///android_asset/"+stationInfo.searchedMap);
		
		webView1.getSettings().setBuiltInZoomControls(true);
		
		Button btPhone=(Button) findViewById(R.id.phone);
		btPhone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  //Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-9650-6377"));
				   // startActivity(intent);
				int numOfLines = stationInfo.phoneNum.size();
				if(numOfLines<2)
					startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+stationInfo.phoneNum.get(0))));
				
				else{
					CharSequence[] lines = new CharSequence[numOfLines];
					
					for(int i=0;i<numOfLines;i++)
						lines[i]=stationInfo.phoneNum.get(i);
						
					
					AlertDialog.Builder builder = new AlertDialog.Builder(StationOnFoot.this);//?			getactivity???
					builder.setTitle("역무원에게 전화걸기");
					builder.setItems(lines, new DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+stationInfo.phoneNum.get(which))));
						}
					});
					builder.show();
				}
				
			/*	lines=
				AlertDialog.Builder builder = new AlertDialog.Builder(get);//?			
				builder.setTitle("역무원에게 전화걸기");
				builder.setItems(new CharSequence[]{"출발역","도착역","역정보 보기","역무원에게 전화걸기"}, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						/*출발역 도착역 저장*/
		/*				switch(which){
						case 0 : /*출발역 버튼 클릭*/
		/*					if(startId!=clickedId)//출발역이 지정된 바 없거나, 다른 역이 출발역으로 지정되어 있었을 경우
								startId=clickedId;
							else//이미 해당역이 출발열으로 지정되어있었을 경우
								startId=-1;
							break;
						case 1 :/*도착역 버튼클릭*/
		/*					if(endId!=clickedId)
								endId=clickedId;
							else
								endId=-1;
							break;
						case 2 :
							getActivity().setTitle("구현예정!");
							break;
						case 3 :
							getActivity().setTitle("구현예정!!");
							break;
						}
						*/
						
			}
		});

		
	//	String departure = getIntent().getStringExtra("departure");
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
