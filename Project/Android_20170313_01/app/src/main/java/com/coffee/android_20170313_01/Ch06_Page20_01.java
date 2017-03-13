package com.coffee.android_20170313_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class Ch06_Page20_01 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page20_01);

    String[] items= {"aaa","bbb","ccc","ddd","eee"};

    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
    // 보여줄 모양 준비
    // new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, items);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item,items);
    // 뷰에 설정 입히기
    autoCompleteTextView.setAdapter(adapter);

    MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);

    // ,(콤마)를 누르면 제시어가 나와
//    MultiAutoCompleteTextView.CommaTokenizer commaTokenizer= new MultiAutoCompleteTextView.CommaTokenizer();
//    multiAutoCompleteTextView.setTokenizer(commaTokenizer);

    PeriodTokenizer periodTokenizer = new PeriodTokenizer();
    multiAutoCompleteTextView.setTokenizer(periodTokenizer);

    // 뷰에 디자인 입히기?
    multiAutoCompleteTextView.setAdapter(adapter);


  }
}
