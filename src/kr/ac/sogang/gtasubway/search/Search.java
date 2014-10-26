package kr.ac.sogang.gtasubway.search;

import java.util.ArrayList;

import kr.ac.sogang.gtasubway.R;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Search extends Fragment{
	
	private ArrayList<Station> mSearchListData=new ArrayList<Station>();
	
	int startId=-1, endId=-1, clickedId=-1;
//	String[] tmpStations= {"신촌","이대","아현","충정로"};
	StationInfo shinchon = new StationInfo("신촌", 2, 31, 1, 1,200/*어쩔*/,159), 
			ihwa = new StationInfo("이대", 2, 31, 2, 2, 202, 201),
			ahyen = new StationInfo("아현", 2, 31, 3, 3, 204, 203),
			choongjeongro = new StationInfo("아현", 2, 31, 3, 3, 206, 205);
			
	
	
	ArrayList<StationInfo> sdf = new ArrayList<StationInfo>();
	
	 
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	// 레이아웃은 여기에
        View rootView = inflater.inflate(R.layout.search_layout, container, false);
        
        // FindViewById나 이런 하고싶은걸 다 여기에 넣으면 될 것 같아용!
        mSearchListData= new ArrayList<Station>();
		mSearchListData.add(new Station(null,"신촌","2","_"));
		mSearchListData.add(new Station(null,"이대","2","_"));
		mSearchListData.add(new Station(null,"아현","2","_"));
		mSearchListData.add(new Station(null,"충정로","2","_"));

		ListView mListView;
		
        mListView = (ListView)rootView.findViewById(R.id.searchlistView);
        ListAdapter mAdapter = new ListViewAdapter(inflater, mSearchListData);
        mListView.setAdapter(mAdapter);
        
        mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				clickedId=position;
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());//?			
				builder.setTitle(mSearchListData.get(position).mStation);
				builder.setItems(new CharSequence[]{"출발역","도착역","역정보 보기","역무원에게 전화걸기"}, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						/*출발역 도착역 저장*/
						switch(which){
						case 0 : 
							if(startId!=clickedId)
								startId=clickedId;
							else
								startId=-1;
							break;
						case 1 :
							if(endId!=clickedId)
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
						
						/*출발역 도착역 설정에 따른 보여주기, 전환*/
						if(startId!=-1)
						{
							if(endId!=-1){
								if(startId!=endId)
								{
									Intent search_subway=new Intent(getActivity(), SearchedSubway.class);
									/*출발역과 도착역 */
									
									search_subway.putExtra("searchedInfo",new SearchedSubwayInfo(shinchon, shinchon, 1000, 10, 2));
								
									startActivity(search_subway);
								}
									
								else
									getActivity().setTitle("걸어가"); // 출발역과 도착역이 같을때
							}
							else
								getActivity().setTitle(startId+"출발");
								
						}
						else if(endId!=-1)
							getActivity().setTitle(endId+"도착");
						else
							getActivity().setTitle("GtaSubway");
				
					}
				});
				builder.show();
				
			}
		});
        
        
        return rootView;
    }
    
	
	
	
	
}
