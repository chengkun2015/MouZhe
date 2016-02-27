package com.jzhihui.mmmouzhe.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jzhihui.mmmouzhe.R;


/**
 * Created by 程 on 2016/2/26.
 */
public class EducationFragment extends Fragment {
    View view;//根视图



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_education, container, false);

        return view;
    }
}
