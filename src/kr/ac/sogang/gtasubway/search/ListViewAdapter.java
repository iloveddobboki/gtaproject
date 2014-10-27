package kr.ac.sogang.gtasubway.search;

import java.util.ArrayList;

import kr.ac.sogang.gtasubway.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter implements Filterable{
	LayoutInflater inflater;
	ArrayList<Station> mSearchListData;
	ArrayList<Station> originalListData;
	//this is a simple class that filtering the ArrayList of strings used in adapter

	public class filter_here extends Filter{
		
		
	        @Override
	        protected FilterResults performFiltering(CharSequence constraint) {
	            // TODO Auto-generated method stub

	        	
	            FilterResults Result = new FilterResults();
	            // if constraint is empty return the original names
	            if(constraint.length() == 0 ){
	                Result.values = originalListData;
	                Result.count = originalListData.size();
	                return Result;
	            }

	            ArrayList<Station> Filtered_Names = new ArrayList<Station>();
	            String filterString = constraint.toString().toLowerCase();
	            String filterableString;

	            for(int i = 0; i<originalListData.size(); i++){
	                filterableString = originalListData.get(i).mStation;
	                if(filterableString.toLowerCase().contains(filterString)){
	                    Filtered_Names.add(originalListData.get(i));
	                }
	            }
	            Result.values = Filtered_Names;
	            Result.count = Filtered_Names.size();

	            return Result;
	        }

	        @Override
	        protected void publishResults(CharSequence constraint,FilterResults results) {
	            // TODO Auto-generated method stub
	        	 mSearchListData = (ArrayList<Station>) results.values;
	            notifyDataSetChanged();
	        }

	    }
	
	
	public ListViewAdapter(LayoutInflater inflater, ArrayList<Station> mSearchListData){
		super();
		this.inflater=inflater;
		this.originalListData=this.mSearchListData=mSearchListData;
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
	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return new filter_here();
		
		//return filter;
	}
	
}
