package com.jzhihui.mmmouzhe.activity;

import android.annotation.TargetApi;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;

import com.jzhihui.mmmouzhe.fragment.JianyueFragment;
import com.jzhihui.mmmouzhe.fragment.MouzhequanFragment;
import com.jzhihui.mmmouzhe.fragment.WoFragment;
import com.jzhihui.mmmouzhe.fragment.XiaoxiFragment;
import com.jzhihui.mmmouzhe.R;
import com.jzhihui.mmmouzhe.utils.MsUtils;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton ib_main_icon1;
    private ImageButton ib_main_icon2;
    private ImageButton ib_main_icon3;
    private ImageButton ib_main_icon4;

    private ImageView iv_contacts;//联系人

    private Fragment mConversationList;

    private Fragment mConversationFragment = null;


    private MouzhequanFragment mouzhequanFragment;
    private JianyueFragment jianyueFragment;
    private XiaoxiFragment xiaoxiFragment;
    private WoFragment woFragment;

    private ImageView iv_dooubleclick;//双击返回顶部
    long firstClickTime = 0;//第一次点击时间
    long secondClickTime = 0;//第二次点击时间

    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
        // 设置默认的Fragment
        setDefaultFragment();
    }


    private void initView() {
        ib_main_icon1 = (ImageButton) findViewById(R.id.ib_main_icon1);
        ib_main_icon2 = (ImageButton) findViewById(R.id.ib_main_icon2);
        ib_main_icon3 = (ImageButton) findViewById(R.id.ib_main_icon3);
        ib_main_icon4 = (ImageButton) findViewById(R.id.ib_main_icon4);
        iv_dooubleclick = (ImageView) findViewById(R.id.iv_dooubleclick);

        iv_contacts = (ImageView) findViewById(R.id.iv_contacts);

    }

    private void initData() {
        mConversationList = initConversationList();//获取融云会话列表的对象
    }

    private void initListener() {
        ib_main_icon1.setOnClickListener(this);
        ib_main_icon2.setOnClickListener(this);
        ib_main_icon3.setOnClickListener(this);
        ib_main_icon4.setOnClickListener(this);

        iv_contacts.setOnClickListener(this);

        iv_dooubleclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstClickTime > 0) {
                    secondClickTime = SystemClock.uptimeMillis();
                    if (secondClickTime - firstClickTime < 500) {
                        MsUtils.showToast("响应双击操作", MainActivity.this);
                    }
                    firstClickTime = 0;
                    return;
                }
                firstClickTime = SystemClock.uptimeMillis();

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        //
                        try {
                            Thread.sleep(500);
                            firstClickTime = 0;
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });

    }


    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mouzhequanFragment = new MouzhequanFragment();



       transaction.replace(R.id.fragment_content, mouzhequanFragment);

        //   transaction.add(R.id.fragment_content, mouzhequanFragment, "tag1").show(mouzhequanFragment);


        ib_main_icon1.setBackgroundResource(R.drawable.icon1_press);
        transaction.commit();

    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();

//        transaction.add(R.id.fragment_content, mouzhequanFragment, "tag1");
//        transaction.add(R.id.fragment_content, jianyueFragment, "tag2");
//        transaction.add(R.id.fragment_content, mConversationList, "tag3");
//        transaction.add(R.id.fragment_content, woFragment, "tag4");
        switch (v.getId()) {
            case R.id.ib_main_icon1:

                if (mouzhequanFragment == null) {
                    mouzhequanFragment = new MouzhequanFragment();
                }

                       transaction.replace(R.id.fragment_content, mouzhequanFragment);


             //   transaction.hide(jianyueFragment).hide(mConversationList).hide(woFragment).show(mouzhequanFragment);




                ib_main_icon1.setBackgroundResource(R.drawable.icon1_press);
                ib_main_icon2.setBackgroundResource(R.drawable.icon2);
                ib_main_icon3.setBackgroundResource(R.drawable.icon3);
                ib_main_icon4.setBackgroundResource(R.drawable.icon4);
                break;

            case R.id.ib_main_icon2:
                if (jianyueFragment == null) {
                    jianyueFragment = new JianyueFragment();
                }


               transaction.replace(R.id.fragment_content, jianyueFragment);


                //    transaction.hide(mouzhequanFragment).hide(mConversationList).hide(woFragment).show(jianyueFragment);


                ib_main_icon2.setBackgroundResource(R.drawable.icon2_press);
                ib_main_icon1.setBackgroundResource(R.drawable.icon1);
                ib_main_icon3.setBackgroundResource(R.drawable.icon3);
                ib_main_icon4.setBackgroundResource(R.drawable.icon4);
                break;
            case R.id.ib_main_icon3:
                if (xiaoxiFragment == null) {
                    xiaoxiFragment = new XiaoxiFragment();
                }
               transaction.replace(R.id.fragment_content, mConversationList);

                //         transaction.hide(mouzhequanFragment).hide(mouzhequanFragment).hide(woFragment).show(mConversationList);


                ib_main_icon3.setBackgroundResource(R.drawable.icon3_press);
                ib_main_icon2.setBackgroundResource(R.drawable.icon2);
                ib_main_icon1.setBackgroundResource(R.drawable.icon1);
                ib_main_icon4.setBackgroundResource(R.drawable.icon4);

                break;
            case R.id.ib_main_icon4:
                if (woFragment == null) {
                    woFragment = new WoFragment();
                }
           transaction.replace(R.id.fragment_content, woFragment);



                //         transaction.hide(mouzhequanFragment).hide(mouzhequanFragment).hide(mConversationList).show(woFragment);

                ib_main_icon4.setBackgroundResource(R.drawable.icon4_press);
                ib_main_icon2.setBackgroundResource(R.drawable.icon2);
                ib_main_icon3.setBackgroundResource(R.drawable.icon3);
                ib_main_icon1.setBackgroundResource(R.drawable.icon1);
                break;
            case R.id.iv_contacts:
                startActivity(new Intent(MainActivity.this, ContactsActivity.class));
                break;


            default:
                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 退出应用
     */
    private void exit() {
        if (!isExit) {
            isExit = true;
            MsUtils.showToast("再按一次退出程序", getApplicationContext());
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
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
