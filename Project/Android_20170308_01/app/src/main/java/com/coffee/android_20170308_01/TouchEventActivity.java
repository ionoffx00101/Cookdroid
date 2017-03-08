package com.coffee.android_20170308_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TouchEventActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_touch_event);

    // 기능 넣기
    LinearLayout BigLayout = (LinearLayout) findViewById(R.id.BigTouchEventLayout);
    LinearLayout SmallLayout = (LinearLayout) findViewById(R.id.SmallTouchEventLayout);
    ImageView Androbot = (ImageView) findViewById(R.id.imageView);

    // 터치 기능 구현
    // 하위 뷰 터치시 상위까지 터치되는걸 이벤트 버블이라고 한다
    // return false 하면 상위 터치 리스너한테 값을 넘긴다.
    // 그래서 이벤트 버블이 생기는 것이다.
    // return true 하면 이벤트 버블을 막을 수 있다.
    BigLayout.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        Toast.makeText(TouchEventActivity.this,"큰거 누름",Toast.LENGTH_SHORT).show();
        //return false;
        return true;
      }
    });

    SmallLayout.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        Toast.makeText(TouchEventActivity.this,"작은거 누름",Toast.LENGTH_SHORT).show();
        //return false;
        return true;
      }
    });

    Androbot.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        Toast.makeText(TouchEventActivity.this,"이미지 누름",Toast.LENGTH_SHORT).show();
        //return false;
        return true;
      }
    });
  }
}
