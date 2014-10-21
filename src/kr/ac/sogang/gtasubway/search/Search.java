package kr.ac.sogang.gtasubway.search;

import java.util.ArrayList;

import kr.ac.sogang.gtasubway.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Search extends Fragment{
	
	private ArrayList<SearchListData> mSearchListData;
	
	int clickedId=-1;
	
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
		
				if(clickedId==-1){
					clickedId=position;
					getActivity().setTitle((mSearchListData.get(position)).mStation+"선택되었습니다");
				}
				else{
					if(position==clickedId){
						clickedId=-1;
						getActivity().setTitle("GtaSubway");
					}
					else{
						getActivity().setTitle(
								mSearchListData.get(clickedId).mStation+"에서"+
								mSearchListData.get(position).mStation+"으로 갑니다");
						clickedId=-1;

					}
				}
				
				
			}
		});
        
        
        return rootView;
    }
    
	
	
	
	
}
