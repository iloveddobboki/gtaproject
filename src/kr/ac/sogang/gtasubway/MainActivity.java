package kr.ac.sogang.gtasubway;

import java.util.ArrayList;

import yangsu.Main;

import kr.ac.sogang.gtasubway.search.Search;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

// Hello World! by Minho Ryang.
// Hello MinhoObba! and JinJyangSue by Yujin Jeong.
// yujinee
public class MainActivity extends Activity implements ActionBar.TabListener {

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);

            // 탭을 추가합시다!
            lists.add(new Tab("검색", new Search()));
            lists.add(new Tab("최근검색", new RecentSearch()));
            lists.add(new Tab("주변역", new Nearby()));
            lists.add(new Tab("설정", new Setting()));
            //lists.add(new Tab("View 3", new View1()));
        }

        
        
        @Override public Fragment getItem(int position) { return lists.get(position).View; }
        @Override public int getCount() { return lists.size(); }
        @Override public CharSequence getPageTitle(int position) { return lists.get(position).Name; }
        
    	class Tab{
    		String Name;
    		Fragment View;
    		public Tab(String Name, Fragment View){
    			this.Name = Name;
    			this.View = View;
    		}
    	}
    	ArrayList<Tab> lists = new ArrayList<Tab>();
    }

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override public void onPageSelected(int position) { actionBar.setSelectedNavigationItem(position); }
        });
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) 
            actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
    
        this.setTitle("GtaSubway");
    
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }


}
