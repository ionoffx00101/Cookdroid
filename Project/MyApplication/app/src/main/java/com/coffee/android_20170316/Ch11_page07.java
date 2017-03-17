package com.coffee.android_20170316;

import static android.R.layout.simple_list_item_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ch11_page07 extends AppCompatActivity {

  ListView listView1;

  // 배열 준비
  String[] coffee = {"coo","aww","qwe","zxvf","fgsd"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch11_page07);
    setTitle("Ch11_page07");


    // 어댑터 설정
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.fixed_simple_list_item,R.id.text1);

    // 뷰에 있는 거 리턴 받아오기
    listView1 = (ListView)findViewById(R.id.listView1);

    // 설정된 어댑터를 리스트 뷰에 껴넣기
    listView1.setAdapter(adapter);

  }
}
