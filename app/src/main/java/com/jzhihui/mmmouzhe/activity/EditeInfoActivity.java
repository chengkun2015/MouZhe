package com.jzhihui.mmmouzhe.activity;

import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.jzhihui.mmmouzhe.R;
import com.jzhihui.mmmouzhe.fragment.EducationFragment;
import com.jzhihui.mmmouzhe.fragment.HobbyFragment;
import com.jzhihui.mmmouzhe.fragment.PersonInfoFragment;
import com.jzhihui.mmmouzhe.fragment.WorkFragment;

public class EditeInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_info_back;


    private ImageView iv_tabInfo;
    private ImageView iv_tabWork;
    private ImageView iv_tabExp;
    private ImageView iv_tabHobby;


    private PersonInfoFragment personInfoFragment;
    private EducationFragment educationFragment;
    private WorkFragment workFragment;
    private HobbyFragment hobbyFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_info);
        initView();
        initListener();
        // 设置默认的Fragment
        setDefaultFragment();

    }

    private void setDefaultFragment() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        personInfoFragment = new PersonInfoFragment();
        transaction.replace(R.id.fragment, personInfoFragment);
        iv_tabInfo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.personinfo_press));
        transaction.commit();
    }


    private void initView() {
        iv_info_back = (ImageView) findViewById(R.id.iv_info_back);
        iv_tabInfo = (ImageView) findViewById(R.id.iv_tabInfo);
        iv_tabWork = (ImageView) findViewById(R.id.iv_tabWork);
        iv_tabExp = (ImageView) findViewById(R.id.iv_tabExp);
        iv_tabHobby = (ImageView) findViewById(R.id.iv_tabHobby);


    }

    private void initListener() {
        iv_info_back.setOnClickListener(this);
        iv_tabInfo.setOnClickListener(this);
        iv_tabWork.setOnClickListener(this);
        iv_tabExp.setOnClickListener(this);
        iv_tabHobby.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (v.getId()) {

            case R.id.iv_info_back:
                finish();
                break;
            case R.id.iv_tabInfo:


                if (personInfoFragment == null) {
                    personInfoFragment = new PersonInfoFragment();
                }


                transaction.replace(R.id.fragment, personInfoFragment);
                iv_tabInfo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.personinfo_press));
                iv_tabWork.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.job));
                iv_tabExp.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.experence));
                iv_tabHobby.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hobby));
                break;
            case R.id.iv_tabWork:
                if (educationFragment == null) {
                    educationFragment = new EducationFragment();
                }
                transaction.replace(R.id.fragment, educationFragment);


                iv_tabInfo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.personinfo));
                iv_tabWork.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.job_press));
                iv_tabExp.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.experence));
                iv_tabHobby.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hobby));

                break;

            case R.id.iv_tabExp:

                if (workFragment == null) {
                    workFragment = new WorkFragment();
                }
                transaction.replace(R.id.fragment, workFragment);

                iv_tabInfo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.personinfo));
                iv_tabWork.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.job));
                iv_tabExp.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.experence_press));
                iv_tabHobby.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hobby));
                break;


            case R.id.iv_tabHobby:

                if (hobbyFragment == null) {
                    hobbyFragment = new HobbyFragment();
                }
                transaction.replace(R.id.fragment, hobbyFragment);


                iv_tabInfo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.personinfo));
                iv_tabWork.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.job));
                iv_tabExp.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.experence));
                iv_tabHobby.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hobby_press));


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
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
