package com.jzhihui.mmmouzhe.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jzhihui.mmmouzhe.R;
import com.jzhihui.mmmouzhe.activity.EditeInfoActivity;

/**
 * Created by 程 on 2016/1/26.
 */
public class WoFragment extends Fragment implements View.OnClickListener {
    View view;
    private RelativeLayout rl_editeInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_wo, container, false);
        initView();
        initListener();
        return view;
    }


    private void initView() {
        rl_editeInfo = (RelativeLayout) view.findViewById(R.id.rl_editeInfo);
    }

    private void initListener() {
        rl_editeInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_editeInfo:
                getActivity().startActivity(new Intent(getActivity().getApplicationContext(), EditeInfoActivity.class));
                break;
        }
    }
}
