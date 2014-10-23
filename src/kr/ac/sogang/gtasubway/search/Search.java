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
	
	private ArrayList<SearchListData> mSearchListData;
	
	int startId=-1, endId=-1, clickedId=-1;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	// 레이아웃은 여기에
        View rootView = inflater.inflate(R.layout.search_layout, container, false);
        
        // FindViewById나 이런 하고싶은걸 다 여기에 넣으면 될 것 같아용!
        mSearchListData= new ArrayList<SearchListData>();
		mSearchListData.add(new SearchListData(null,"신촌","2","_"));
		mSearchListData.add(new SearchListData(null,"이대","2","_"));
		mSearchListData.add(new SearchListData(null,"아현","2","_"));
		mSearchListData.add(new SearchListData(null,"충정로","2","_"));

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
									startActivity(new Intent(getActivity(), SearchedSubway.class));
									
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
