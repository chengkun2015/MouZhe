package com.jzhihui.mmmouzhe.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.jzhihui.mmmouzhe.AppController;
import com.jzhihui.mmmouzhe.R;
import com.jzhihui.mmmouzhe.bean.LoginBean;
import com.jzhihui.mmmouzhe.utils.CacheUtils;
import com.jzhihui.mmmouzhe.utils.ConstantUtils;
import com.jzhihui.mmmouzhe.utils.MsUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录页面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = LoginActivity.class.getSimpleName();
    // Tag used to cancel the request
    String tag_string_req = "string_req";
    private EditText et_login_phone;
    private EditText et_login_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }


    private void initView() {
        et_login_phone = (EditText) findViewById(R.id.et_login_phone);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    private void initData() {
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                if (TextUtils.isEmpty(et_login_phone.getText().toString()) || TextUtils.isEmpty(et_login_password.getText().toString())) {
                    MsUtils.showToast("账号或密码为空", getApplicationContext());
                } else {
                    loginToServer();

                }
                break;
        }
    }

    /**
     * 登录
     */
    private void loginToServer() {
        String httpurl = ConstantUtils.LOGIN_URL;
        StringRequest strReq = new StringRequest(Request.Method.POST, httpurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i(TAG, "post请求成功" + s);
                processData(s);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i(TAG, "post请求失败" + volleyError.toString());

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("loginName", et_login_phone.getText().toString());
                map.put("password", et_login_password.getText().toString());
                return map;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);


    }

    /**
     * 解析
     *
     * @param s
     */
    private void processData(String s) {
        final LoginBean data = LoginBean.getData(s);
        if (data.error.equals("10000")) {
            CacheUtils.saveData(LoginActivity.this, "phoneNumber_Login", et_login_phone.getText().toString());
            CacheUtils.saveData(LoginActivity.this, "password_Login", et_login_password.getText().toString());
            CacheUtils.saveData(LoginActivity.this, "isLogined", true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else if (data.error.equals("20023")) {
            MsUtils.showToast("请输入正确的手机号或密码", getApplicationContext());
        }
    }
}
