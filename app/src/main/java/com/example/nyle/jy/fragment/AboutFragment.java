package com.example.nyle.jy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nyle.jy.R;

/**
 * Created by NYL on 2017/3/6 0006.
 * Email:1174212579@qq.com
 */

public class AboutFragment extends BaseFragment{

    private ImageView imageView5;
    private ImageView imageView2;
    private TextView textView;
    private TextView textView11;
    private ImageView imageView4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.about_main,container,false);

        imageView5 = (ImageView) view.findViewById(R.id.imageView5);
        imageView2 = (ImageView) view.findViewById(R.id.imageView2);
        textView = (TextView) view.findViewById(R.id.textView);
        textView11 = (TextView) view.findViewById(R.id.textView11);
        imageView4 = (ImageView) view.findViewById(R.id.imageView4);

        return view;
    }
}
