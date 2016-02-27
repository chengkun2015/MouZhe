package com.jzhihui.mmmouzhe.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzhihui.mmmouzhe.R;
import com.jzhihui.mmmouzhe.bean.JianyueBean;

import java.util.List;

/**
 * Created by 程 on 2016/2/18.
 * 简阅页面的适配器
 */
public class JianyueAdapter extends BaseAdapter {

//    private List<JianyueBean> jianyueBeanList;
//    private Context context;
//    private LayoutInflater mInflater;
//
//
//    public JianyueAdapter(List<JianyueBean> jianyueBeanList, Context context) {
//        super();
//        this.jianyueBeanList = jianyueBeanList;
//        this.context = context;
//        ;
//        mInflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return jianyueBeanList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return jianyueBeanList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder = null;
//        if (convertView == null) {
//            holder = new ViewHolder();
//            convertView = mInflater.inflate(R.layout.item_jianyue, null);
//            holder.tv_jianyue_content = (TextView) convertView.findViewById(R.id.tv_jianyue_content);
//            holder.tv_jianyue_author = (TextView) convertView.findViewById(R.id.tv_jianyue_author);
//
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        holder.tv_jianyue_content.setText(jianyueBeanList.get(position).getContent());
//        holder.tv_jianyue_author.setText(jianyueBeanList.get(position).getAuthor());
//
//        return convertView;
//    }
//
//
//
//    public class ViewHolder {
//        private TextView tv_jianyue_content;
//        private TextView tv_jianyue_author;
//
//    }
private List<JianyueBean> jianyueBeanList;
    private Context context;
    private LayoutInflater mInflater;

    public JianyueAdapter(List<JianyueBean> jianyueBeanList, Context context) {
        super();
        this.jianyueBeanList = jianyueBeanList;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return jianyueBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        final JianyueBean jianyueBean = jianyueBeanList.get(position);
        return jianyueBean.getType();


    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return jianyueBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder = null;
        ViewHolder1 holder1 = null;
        if (convertView == null) {
            if (getItemViewType(position) == 0) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_jianyue, null);
                holder.tv_jianyue_content = (TextView) convertView.findViewById(R.id.tv_jianyue_content);
                holder.tv_jianyue_author = (TextView) convertView.findViewById(R.id.tv_jianyue_author);
                convertView.setTag(holder);
            } else {
                holder1 = new ViewHolder1();
                convertView = mInflater.inflate(R.layout.item_jianyue2, null);
                holder1.tv_jianyue_content = (TextView) convertView.findViewById(R.id.tv_jianyue_content_pic);
                holder1.iv_jianyue_item1 = (ImageView) convertView.findViewById(R.id.iv_jianyue_item1);
                holder1.iv_jianyue_item2 = (ImageView) convertView.findViewById(R.id.iv_jianyue_item2);
                holder1.iv_jianyue_item3 = (ImageView) convertView.findViewById(R.id.iv_jianyue_item3);
                convertView.setTag(holder1);
            }


        } else if (getItemViewType(position) == 0) {
            holder = (ViewHolder) convertView.getTag();

        } else {
            holder1 = (ViewHolder1) convertView.getTag();
        }


        if (getItemViewType(position) == 0) {
            holder.tv_jianyue_content.setText(jianyueBeanList.get(position).getContent());
            holder.tv_jianyue_author.setText(jianyueBeanList.get(position).getAuthor());
        } else {
            holder1.tv_jianyue_content.setText(jianyueBeanList.get(position).getContent());

            holder1.iv_jianyue_item2.setBackgroundResource(R.drawable.jianyue_item2);
//            holder1.iv_jianyue_item3.setBackgroundResource(R.drawable.jianyue_item3);

            holder1.iv_jianyue_item1.setImageBitmap(jianyueBeanList.get(position).getIcon());
        }


        return convertView;
    }


    public class ViewHolder {
        private TextView tv_jianyue_content;
        private TextView tv_jianyue_author;

    }

    public class ViewHolder1 {
        private TextView tv_jianyue_content;
        private ImageView iv_jianyue_item1;
        private ImageView iv_jianyue_item2;
        private ImageView iv_jianyue_item3;
    }

}
