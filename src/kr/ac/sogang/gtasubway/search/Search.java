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
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class Search extends Fragment implements OnQueryTextListener{
	
	private ArrayList<Station> mSearchListData=new ArrayList<Station>();
	private ArrayList<Station> originalSearchListData=new ArrayList<Station>();
	private ArrayList<StationInfo> mSearchedStations=new ArrayList<StationInfo>();
	
	
	int startId=-1, endId=-1, clickedId=-1;

	ListView mListView;
	SearchView searchView;
	ListViewAdapter mAdapter;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
    	mSearchListData= new ArrayList<Station>();
    		mSearchListData.add(new Station(null,null,"청량리","1","_",mSearchListData.size(),"010-9021-6377"));
	 		mSearchListData.add(new Station(null,"test_shinchon.JPG","신촌","2","_",mSearchListData.size(),"010-9021-6377"));
	 		mSearchListData.add(new Station(null,null,"이대","2","_",mSearchListData.size(),"010-9021-6377","010-3238-8681"));
	 		mSearchListData.add(new Station(null,"test_ahyen.JPG","아현","2","_",mSearchListData.size(),"010-9021-6377","010-3238-8681","010-5146-1008"));
	 		mSearchListData.add(new Station(null,"test_choongjeongro.JPG","충정로","2","_",mSearchListData.size(),"010-9021-6377"));
	 		mSearchListData.add(new Station(null,null,"국회의사당","9","_",mSearchListData.size(),"010-9021-6377"));
	 	
	 	
	 	mSearchedStations= new ArrayList<StationInfo>();
	 	
	 		// 레이아웃은 여기에
        View rootView = inflater.inflate(R.layout.search_layout, container, false);
        
        // FindViewById나 이런 하고싶은걸 다 여기에 넣으면 될 것 같아용!
    
		
		
        mListView = (ListView)rootView.findViewById(R.id.searchlistView);
        mAdapter = new ListViewAdapter(inflater, mSearchListData);
        mListView.setAdapter(mAdapter);
        
        searchView=(SearchView)rootView.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
        mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				clickedId=mAdapter.mSearchListData.get(position).stationId;//언제 나 mseachlistdata[0]는 신촌..
				
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());//?			
				builder.setTitle(mAdapter.mSearchListData.get(position).mStation);
				builder.setItems(new CharSequence[]{"출발역","도착역","역정보 보기","역무원에게 전화걸기"}, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						/*출발역 도착역 저장*/
						switch(which){
						case 0 : /*출발역 버튼 클릭*/
							if(startId!=clickedId)//출발역이 지정된 바 없거나, 다른 역이 출발역으로 지정되어 있었을 경우
								startId=clickedId;
							else//이미 해당역이 출발열으로 지정되어있었을 경우
								startId=-1;
							break;
						case 1 :/*도착역 버튼클릭*/
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
							    	mSearchedStations.removeAll(mSearchedStations);
									mSearchedStations.add(new StationInfo(mSearchListData.get(startId),null, 2, 31, 1, 1, 200, 159));
									mSearchedStations.add(new StationInfo(mSearchListData.get(endId),null, 2, 31, 1, 1, 200, 159));
									startId=endId=clickedId=-1;
									getActivity().setTitle("GtaSubway");
							//   
							    
									Intent search_subway=new Intent(getActivity(), SearchedSubway.class);
									/*출발역과 도착역 */	
									search_subway.putExtra("searchedInfo",new SearchedSubwayInfo(mSearchedStations.get(0),mSearchedStations.get(1),  1000, 10, 2));
								
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


	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		mAdapter.getFilter().filter(newText);//?
		mAdapter.notifyDataSetChanged(); //Update my view
		return false;
	}


	@Override
	public boolean onQueryTextSubmit(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
    
	
	
	
	
}
