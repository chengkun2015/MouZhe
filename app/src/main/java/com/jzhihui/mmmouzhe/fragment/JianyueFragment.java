package com.jzhihui.mmmouzhe.fragment;


import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.jzhihui.mmmouzhe.R;
import com.jzhihui.mmmouzhe.adapter.JianyueAdapter;
import com.jzhihui.mmmouzhe.bean.JianyueBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 程 on 2016/1/26.
 * 简阅页面
 */
public class JianyueFragment extends Fragment implements SearchView.OnQueryTextListener {
    View view;//根视图


    String[] str = {"朋友的类型：指路型，默契型，互助型，倾听型。不同阶段需要不同类型的朋友。",
            "几乎所有项目最终未按计划执行，其最根本原因就是在项目开始阶段，没有对需求、技术、产品有足够的了解，也就没有后续开发中的可控力度。",
            "小步快跑，不断迭代。小步快跑，快速迭代，是已经被验证的最好方式。只有在足够小的粒度上设置里程碑，才不会造成整体的项目受到大的影响而被无限期延后，这是管理者需要非常清楚的。另一方面，快速迭代，也有助于发现问题，然后快速解决，另一方面，快速迭代，也有助于发现问题，然后快速解决。",
            "现在创业成本越来越低, 但因为全球化以及资讯透明度越来越高，创业环境也变得越来越竞争，当app store里有上千万个app， 单纯的growth hacking已经不够了，就算是连续创业家也需要更多专家及更多资源的帮忙。"};
    private SwipeRefreshLayout swipeRefreshLayout_jianyue;
    private ListView listview_jianyue;
    private List<JianyueBean> jianyueBeanList;
    private JianyueAdapter adapter;
    private EditText etSearch;
    private ImageView ivDeleteText;

    private List<JianyueBean> newBeanList = new ArrayList<>();


    Object[] names;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_jianyue, container, false);

        initView();
        initData();
        names = str;

        return view;

    }


    private void initView() {
        swipeRefreshLayout_jianyue = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout_jianyue);
        listview_jianyue = (ListView) view.findViewById(R.id.listview_jianyue);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        ivDeleteText = (ImageView) view.findViewById(R.id.ivDeleteText);


    }

    private void initData() {
        adapter = new JianyueAdapter(getJianyueData(), getActivity());

        listview_jianyue.setAdapter(adapter);


        SwipeRefresh();

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                newBeanList.clear();

                String input_info = etSearch.getText().toString();
                final List<JianyueBean> newData = getNewData(input_info);
                adapter = new JianyueAdapter(newData, getActivity());
                listview_jianyue.setAdapter(adapter);

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    ivDeleteText.setVisibility(View.GONE);//当文本框为空时，则叉叉消失

                } else {
                    ivDeleteText.setVisibility(View.VISIBLE);//当文本框不为空时，出现叉叉

                }
            }
        });


        ivDeleteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearch.setText("");

            }
        });
    }


    //当editetext变化时调用的方法，来判断所输入是否包含在所属数据中
    private List<JianyueBean> getNewData(String input_info) {
        //遍历list
        for (int i = 0; i < jianyueBeanList.size(); i++) {
            final JianyueBean jianyueBean1 = jianyueBeanList.get(i);
            final String content = jianyueBean1.getContent();
            //   MsUtils.showToast(content,getActivity().getApplicationContext());
            //如果遍历到的名字包含所输入字符串
            if (jianyueBean1.getContent().contains(input_info)) {
                //将遍历到的元素重新组成一个list
                final JianyueBean jianyueBean2 = new JianyueBean();

                jianyueBean2.setContent(jianyueBean1.getContent());
                jianyueBean2.setAuthor("黄先生");
                newBeanList.add(jianyueBean2);
            }
        }
        return newBeanList;
    }


    /**
     * 获取简阅列表数据
     */
    private List<JianyueBean> getJianyueData() {

        jianyueBeanList = new ArrayList<JianyueBean>();

        for (int i = 0; i < 4; i++) {
            JianyueBean jianyueBean = new JianyueBean();
            jianyueBean.setType(0);
            jianyueBean.setContent(str[i]);
            jianyueBean.setAuthor("黄先生");

            jianyueBeanList.add(jianyueBean);

        }

        JianyueBean newjianyueBean = new JianyueBean();
        newjianyueBean.setType(1);
        newjianyueBean.setContent("朋友的类型：指路型，默契型，互助型，倾听型。不同阶段需要不同类型的朋友。");
        newjianyueBean.setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.jianyue_item1));
        jianyueBeanList.add(newjianyueBean);

        return jianyueBeanList;

    }

    /**
     * 下拉刷新
     */
    private void SwipeRefresh() {
        //设置卷内的颜色
        swipeRefreshLayout_jianyue.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        //设置下拉刷新监听
        swipeRefreshLayout_jianyue.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                // TODO Auto-generated method stub
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        adapter.notifyDataSetChanged();
                        //停止刷新动画
                        swipeRefreshLayout_jianyue.setRefreshing(false);

                    }
                }, 2000);
            }
        });
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            // Clear the text filter.
            listview_jianyue.clearTextFilter();
        } else {
            // Sets the initial value for the text filter.
            listview_jianyue.setFilterText(newText.toString());
        }
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }
}
