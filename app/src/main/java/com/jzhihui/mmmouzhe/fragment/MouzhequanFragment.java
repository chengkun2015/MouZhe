package com.jzhihui.mmmouzhe.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jzhihui.mmmouzhe.R;

/**
 * Created by 程 on 2016/1/26.
 */
public class MouzhequanFragment extends Fragment {
    View view;//根视图

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mouzhequan, container, false);



        return view;
    }
}
