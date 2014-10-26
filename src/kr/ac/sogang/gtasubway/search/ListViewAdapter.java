package kr.ac.sogang.gtasubway.search;

import java.util.ArrayList;

import kr.ac.sogang.gtasubway.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter{
	LayoutInflater inflater;
	ArrayList<Station> mSearchListData;
	public ListViewAdapter(LayoutInflater inflater, ArrayList<Station> mSearchListData){
		super();
		this.inflater=inflater;
		this.mSearchListData=mSearchListData;
	}
	@Override
	public int getCount() {
		return mSearchListData.size();
	}

	@Override
	public Object getItem(int position) {
		return mSearchListData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View converView, ViewGroup parent) {
		if(converView==null){				
			converView= inflater.inflate(R.layout.searchlistitem,null);
		}
		
		ImageView iv_icon=(ImageView)converView.findViewById(R.id.mIcon);
		TextView tv_station=(TextView) converView.findViewById(R.id.mStation);
		TextView tv_line1=(TextView) converView.findViewById(R.id.mLine1);
		TextView tv_line2=(TextView) converView.findViewById(R.id.mLine2);
					
		Station mData = mSearchListData.get(position);
		
		tv_station.setText(mData.mStation);
		tv_line1.setText(mData.mLine1);
		tv_line2.setText(mData.mLine2);
		
		return converView;
	}
	
}
