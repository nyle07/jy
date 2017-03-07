package com.example.nyle.jy.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.nyle.jy.httpdata.CharsetJsonRequest;
import com.example.nyle.jy.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by NYL on 2017/3/2 0002.
 * Email:1174212579@qq.com
 */

public class TranslateFragment extends BaseFragment {

    private EditText editText;
    private Button button;
    private TextView textView;
    private final String urlAddress = "http://fanyi.youdao.com/openapi" +
            ".do?keyfrom=translatetion&key=660729186&type=data&doctype=json&version=1.1&q=";
    private RequestQueue mQueue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.translate_fragment_layout, container, false);

        editText = (EditText) view.findViewById(R.id.editText);
        button = (Button) view.findViewById(R.id.button);
        textView = (TextView) view.findViewById(R.id.textView2);

        mQueue= Volley.newRequestQueue(getActivity());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word=editText.getText().toString();
                try {
                    word= URLEncoder.encode(word,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String query=urlAddress+word;
                Log.d("demo",query);
                readResult(query);
            }
        });

        return view;
    }

    private void readResult(String url) {
        JsonObjectRequest jsonObjectRequest = new CharsetJsonRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                String result = "";
                try {
                    result = URLEncoder.encode(result, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                try {
                    String errcode = response.getString("errorCode");
                    if (Integer.parseInt(errcode) != 0) {
                        Toast.makeText(getActivity(), "error, please try again",
                                Toast.LENGTH_LONG).show();
                    } else {
                        String direct_translation = response.getString("translation");
                        direct_translation = direct_translation.replace("\"", "");
                        direct_translation = direct_translation.replace("[", "");
                        direct_translation = direct_translation.replace("]", "");
                        textView.setText(direct_translation);
                        System.out.println(direct_translation);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError arg0) {
            }
        });
        mQueue.add(jsonObjectRequest);
    }


}
