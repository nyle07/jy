package com.example.nyle.jy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.nyle.jy.adapter.ListData;
import com.example.nyle.jy.adapter.TextAdapter;
import com.example.nyle.jy.httpdata.HttpData;
import com.example.nyle.jy.httpdata.HttpGetDataListener;
import com.example.nyle.jy.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NYL on 2017/3/3 0003.
 * Email:1174212579@qq.com
 */

public class ChatFragment extends BaseFragment implements HttpGetDataListener,View.OnClickListener{


    private HttpData mHttpData;
    private List<ListData> listDatas;
    private ListView lv;
    private EditText sendtext;
    private Button send_btn;
    private String content_str;
    private TextAdapter adapter;
    private String[] welcome_array;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.chat_main,container,false);
        lv = (ListView) view.findViewById(R.id.lv);
        sendtext = (EditText) view.findViewById(R.id.sendText);
        send_btn = (Button) view.findViewById(R.id.sendBtn);
        listDatas = new ArrayList<ListData>();
        send_btn.setOnClickListener(this);
        adapter=new TextAdapter(listDatas,getActivity());
        lv.setAdapter(adapter);
        ListData listData;
        listData= new ListData(getRandomWelcomeTips(),ListData.RECEIVER);
        listDatas.add(listData);


        return view;
    }

    private String getRandomWelcomeTips() {
        String welcome_tip=null;
        welcome_array=this.getResources().getStringArray(R.array.welcome_tips);
        int index= (int) (Math.random()*(welcome_array.length-1));
        welcome_tip=welcome_array[index];
        return welcome_tip;

    }

    @Override
    public void onClick(View view) {
        content_str=sendtext.getText().toString();
        ListData listData;
        listData=new ListData(content_str,ListData.SEND);
        listDatas.add(listData);
        adapter.notifyDataSetChanged();
        mHttpData = (HttpData) new HttpData(
                "http://api.qingyunke.com/api.php?key=free&appid=0&msg="+content_str,
                this).execute();
        sendtext.setText("");

    }

    @Override
    public void getDataUrl(String data) {
        parseText(data);
    }

    private void parseText(String string) {
        try {
            JSONObject jb = new JSONObject(string);
            //System.out.println(jb.getString("code"));
            //System.out.println(jb.getString("text"));
            ListData listData;
            listData = new ListData(jb.getString("content"),ListData.RECEIVER);
            listDatas.add(listData);//封装数据
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
