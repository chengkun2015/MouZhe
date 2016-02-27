package com.jzhihui.mmmouzhe.activity;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.jzhihui.mmmouzhe.R;
import com.jzhihui.mmmouzhe.fragment.FriendFragment;
import com.jzhihui.mmmouzhe.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

public class HomeActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private FragmentPagerAdapter mFragmentPagerAdapter;//将tab页面持久保存在内存中

    private Fragment mConversationList;
    private Fragment mConversationFragment = null;
    private List<Fragment> mFragment = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mConversationList = initConversationList();//获取融云会话列表的对象

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mFragment.add(HomeFragment.getInstance());
        mFragment.add(mConversationList);
        mFragment.add(FriendFragment.getInstance()
        );
        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        };
        mViewPager.setAdapter(mFragmentPagerAdapter);
    }

    private Fragment initConversationList() {
        if (mConversationFragment == null) {
            ConversationListFragment listFragment = ConversationListFragment.getInstance();

            Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversationlist")
                    .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话是否聚合显示
                    .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")//群组
                    .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")//讨论组
                    .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false")//公共服务号
                    .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false")//公共服务号
                    .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//系统
                    .build();
            listFragment.setUri(uri);
            return listFragment;
        } else {
            return mConversationFragment;
        }


    }
}
