package com.example.nyle.jy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nyle.jy.R;

import java.util.List;

/**
 * Created by NYL on 2017/3/3 0003.
 * Email:1174212579@qq.com
 */

public class TextAdapter extends BaseAdapter{

    private List<ListData> listDatas;
    private Context mContext;
    private RelativeLayout layout;

    public TextAdapter(List<ListData> listDatas,Context mContext){
        this.listDatas=listDatas;
        this.mContext=mContext;
    }
    @Override
    public int getCount() {
        return listDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return listDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=LayoutInflater.from(mContext);
        if (listDatas.get(position).getFlag()== ListData.RECEIVER){
            layout= (RelativeLayout) inflater.inflate(R.layout.leftitem,null);

        }
        if (listDatas.get(position).getFlag()==ListData.SEND){
            layout= (RelativeLayout) inflater.inflate(R.layout.rightitem,null);
        }

        TextView textView= (TextView) layout.findViewById(R.id.tv);
        textView.setText(listDatas.get(position).getContent());


        return layout;
    }
}
