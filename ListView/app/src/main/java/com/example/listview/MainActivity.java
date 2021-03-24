package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //리스트 뷰를 가져온다
        list = findViewById(R.id.list);

        //리스트 뷰에 넣을 목록을 생성
        List<String> data = new ArrayList<>();

        //리스트 뷰와 리스트 를 연결해주는 어댑터
        //첫 인자로 해당 acitivity 두번째 인자로 ui, 세번째 인자로 들어갈 항목이다
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);

        //리스트 뷰에 adapter를 설정한다.
        list.setAdapter(adapter);

        data.add("갸아아앙");
        data.add("햐아아악");
        data.add("먀아아아악");

        //adapter에 설정을 저장한다.
        adapter.notifyDataSetChanged();
    }
}
