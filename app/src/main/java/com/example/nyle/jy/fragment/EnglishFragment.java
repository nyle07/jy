package com.example.nyle.jy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.nyle.jy.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NYL on 2017/3/5 0005.
 * Email:1174212579@qq.com
 */

public class EnglishFragment extends BaseFragment {

    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private ImageButton imageBtn;
    private RequestQueue requestQueue;
    //    private String url="https://route.showapi
    // .com/1211-1?count=1&showapi_appid=33094&showapi_sign=744fd030f69f4abcbbd0e5683f2ee090";
    private final String url = "http://open.iciba.com/dsapi/";
    private final String url2="http://api.hitokoto.us/rand?cat=a&charset=utf-8";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.english_layout, container, false);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        textView4 = (TextView) view.findViewById(R.id.textView4);
        textView5 = (TextView) view.findViewById(R.id.textView5);
        textView6 = (TextView) view.findViewById(R.id.textView6);
        imageBtn = (ImageButton) view.findViewById(R.id.imageBtn);
        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readYiyan();
            }
        });


        requestQueue = Volley.newRequestQueue(getActivity());
        readYiyan();
        readResult();
        return view;
    }

    private void readYiyan() {

        JsonObjectRequest yiyan=new JsonObjectRequest(Request.Method.GET, url2, new Response.Listener<JSONObject>() {



            @Override
            public void onResponse(JSONObject response) {

                try {
                    String hitokoto=response.getString("hitokoto");
                    textView6.setText(hitokoto);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(yiyan);
    }

    private void readResult() {

        JsonObjectRequest js=new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {



            @Override
            public void onResponse(JSONObject response) {
                try {
                    String english =response.getString("content");
                    String chinese =response.getString("note");
                    String trans =response.getString("translation");
                    textView3.setText(english);
                    textView4.setText(chinese);
                    textView5.setText(trans);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(getActivity().findViewById(R.id.drawer_layout),"服务器开小差了",Snackbar.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(js);
    }
}
