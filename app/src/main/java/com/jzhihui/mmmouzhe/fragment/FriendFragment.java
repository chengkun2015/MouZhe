package com.jzhihui.mmmouzhe.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jzhihui.mmmouzhe.R;

import io.rong.imkit.RongIM;
import io.rong.imkit.utils.BitmapUtil;


/**
 * Created by 程 on 2016/2/17.
 */
public class FriendFragment extends Fragment {


    View view;//根视图
    private Button btn_friend;


    public static FriendFragment instance = null;

    public static FriendFragment getInstance() {
        if (instance == null) {
            instance = new FriendFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_friend, container, false);
        btn_friend = (Button) view.findViewById(R.id.btn_friend);
        btn_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (RongIM.getInstance() != null) {
                    RongIM.getInstance().startPrivateChat(getActivity(), "10010", "私人聊天");
                }
            }
        });
        return view;
    }


}

