package com.coffee.android_20170308_01;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextViewPractice extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_text_view_practice);

    // 툴바가 추가된 베이직 액티비티
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });

    // 텍스트 뷰 속성을 자바 코드에서 변경시키기
    // 리턴 받아 저장할 공간 미리 만들어두기
    TextView textView1,textView2,textView3;
    // id를 이용해서 원하는 객체를 리턴받는다
    textView1 = (TextView) findViewById(R.id.textView1);
    textView2 = (TextView) findViewById(R.id.textView2);
    textView3 = (TextView) findViewById(R.id.textView3);

    // 속성 변경하기
    textView1.setText("setText로 변경한다");
    textView1.setTextColor(Color.RED);
    textView2.setTextSize(30);
    textView2.setTypeface(Typeface.MONOSPACE);
    textView3.setText("setSingleLine setSingleLine setSingleLine setSingleLine setSingleLine");
    textView3.setSingleLine();

    // 버튼에 페이지 이동 기능 넣기
    Button goMainActivity = (Button) findViewById(R.id.goMainActivity);

    goMainActivity.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 페이지 이동 하는 메소드
        //Intent(내가 지금 있는 현재 Activity주소,가려고 하는 Activity주소)
        //Intent intent = new Intent(본인.this,가는 곳.class);
        Intent intent = new Intent(TextViewPractice.this,MainActivity.class);
        // 실제 페이지 전환(주소값주기)
        startActivity(intent);
      }
    });
  }

}
