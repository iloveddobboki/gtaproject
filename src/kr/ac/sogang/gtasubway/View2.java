package kr.ac.sogang.gtasubway;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class View2 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

    	// 레이아웃은 여기에
        View rootView = inflater.inflate(R.layout.fragment_main2, container, false);

        // FindViewById나 이런 하고싶은걸 다 여기에 넣으면 될 것 같아용!

        return rootView;
    }
}
