package com.coffee.exam_20170314;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Ex01 extends AppCompatActivity implements GestureDetector.OnGestureListener {

  // 터치 강도 만들어두기
  GestureDetector detector;

  // 쓸 위젯들 지역 변수로 선언
  ViewFlipper viewFlipper;
  Button btnStart, btnStop;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ex01);

    // 리턴 받을 거 미리 좀 받아두기
    viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
    btnStart = (Button) findViewById(R.id.btnStart);
    btnStop = (Button) findViewById(R.id.btnStop);

    // 터치 기능 뺏기
    detector = new GestureDetector(Ex01.this);
    viewFlipper.setFlipInterval(1000);

    // detector.onTouchEvent(dispatchTouchEvent());

    // 버튼 기능 넣어주기
    btnStart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        viewFlipper.startFlipping();

      }
    });
    btnStop.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        viewFlipper.stopFlipping();
      }
    });

  }

  // dispatchTouchEvent 재정의 시킴
  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    detector.onTouchEvent(ev);
    return super.dispatchTouchEvent(ev);
  }

  // 제스쳐때문에 구현하라고 만들어 준 메소드들
  @Override
  public boolean onDown(MotionEvent e) {
    return false;
  }

  @Override
  public void onShowPress(MotionEvent e) {

  }

  @Override
  public boolean onSingleTapUp(MotionEvent e) {
    return false;
  }

  @Override
  public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    return false;
  }

  @Override
  public void onLongPress(MotionEvent e) {

  }

  @Override
  public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

    float moveWhere = e1.getX() - e2.getX();

    if (moveWhere > 0) {
      viewFlipper.showNext();
    } else if (moveWhere < 0) {
      viewFlipper.showPrevious();
    } else {
      // 아무것도 안 하는게 좋을 거같다
    }

    return false;
  }
}
