package com.jzhihui.mmmouzhe.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jzhihui.mmmouzhe.R;
import com.jzhihui.mmmouzhe.utils.MsUtils;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String token1 = "Q/Z0HgIQtdffLlEC/EpTWVb+uge+NMyXIc6tfFV5db9m9/D4fAY+Nu7vle2DwHO0y2Gwvo/+dfOK9GHZGdPP3mPA96rh3TTD";
    private static final String token2 = "d6tSB1N0NYahYMysMcQQSVb+uge+NMyXIc6tfFV5db9m9/D4fAY+NtgbwMPR8IODqJa9KrurG4YRTCHMQCqKdQ==";

    private Button mUser1, mUser2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        mUser1 = (Button) findViewById(R.id.mUser1);
        mUser2 = (Button) findViewById(R.id.mUser2);

        mUser1.setOnClickListener(this);
        mUser2.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.mUser1) {
            connectRongServer(token1);
        } else if (v.getId() == R.id.mUser2) {
            connectRongServer(token2);
        }
    }

    private void connectRongServer(String token) {
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {

            }

            @Override
            public void onSuccess(String s) {


                if (s.equals("10010")) {
                    MsUtils.showToast("连接服务器成功", getApplicationContext());
                    startActivity(new Intent(ContactsActivity.this, HomeActivity.class));
                    Log.e("onSuccess", "onSuccess userid :" + s);
                } else {
                    startActivity(new Intent(ContactsActivity.this, HomeActivity.class));
                    MsUtils.showToast("连接服务器成功", getApplicationContext());
                    Log.e("onSuccess", "onSuccess userid :" + s);
                }
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("onError", "onError userid :" + errorCode.getValue());
            }
        });
    }



}
