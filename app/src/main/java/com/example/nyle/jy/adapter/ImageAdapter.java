package com.example.nyle.jy.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.nyle.jy.httpdata.MeiNv;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Mr.Jude on 2016/6/7.
 */
public class ImageAdapter extends RecyclerArrayAdapter<MeiNv> {
    public ImageAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(parent);
    }
}
