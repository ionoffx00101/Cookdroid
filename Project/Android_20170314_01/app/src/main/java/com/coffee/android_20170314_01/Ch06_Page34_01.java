package com.coffee.android_20170314_01;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

public class Ch06_Page34_01 extends TabActivity implements GestureDetector.OnGestureListener { // Actionbar 쪽으로 바뀜

  GestureDetector detector;
  TabHost tabHost;
  int currentTabIndex =2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page34_01);

    tabHost = getTabHost();

    // tabHost.newTabSpec("자바코드용 이름").setIndicator("보여지는 이름");
    TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("SONG").setIndicator("노래");
    tabSpec1.setContent(R.id.tabSong1);

    TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("ARTIS").setIndicator("아티");
    tabSpec2.setContent(R.id.tabSong2);

    TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("ALBUM").setIndicator("앨범");
    tabSpec3.setContent(R.id.tabSong3);


    // 탭순서 0,1,2..
    // 메뉴에 만든 탭들 집어넣기
    tabHost.addTab(tabSpec1);
    tabHost.addTab(tabSpec2);
    tabHost.addTab(tabSpec3);

    // 어떤 탭을 기본 화면으로 할지 설정 가능
    tabHost.setCurrentTab(currentTabIndex);

    // 이런 식으로 호출하도록 설정하는 것 같은데
    // 음 이런 식으로 호출하는걸 그만 하라고 알려주네
    detector = new GestureDetector(Ch06_Page34_01.this);

  }

  public boolean onTouch(View v, MotionEvent event) {

    return true;
  }

  public boolean dispatchTouchEvent(MotionEvent event) {
    // 재정의 하는 영역
    detector.onTouchEvent(event);
    return true;
  }

  @Override
  public boolean onDown(MotionEvent e) {
    //Toast.makeText(Ch06_Page34_01.this, "onDown", Toast.LENGTH_SHORT).show();
    return false; // 이벤트를 계속 보내려면 false, 여기까지만 하려면 true
  }

  @Override
  public void onShowPress(MotionEvent e) {
    //Toast.makeText(Ch06_Page34_01.this, "onShowPress", Toast.LENGTH_SHORT).show();
  }

  @Override
  public boolean onSingleTapUp(MotionEvent e) {
    //Toast.makeText(Ch06_Page34_01.this, "onSingleTapUp", Toast.LENGTH_SHORT).show();
    return false;
  }

  @Override
  public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    //Toast.makeText(Ch06_Page34_01.this, "onScroll", Toast.LENGTH_SHORT).show();
    return false;
  }

  @Override
  public void onLongPress(MotionEvent e) {
    //Toast.makeText(Ch06_Page34_01.this, "onLongPress", Toast.LENGTH_SHORT).show();

  }

  // 처음 손을 붙인 장소 e1 e1.getX,e1.getY
  // 뗀 장소 e2 e2.getX,e2.getY
  @Override
  public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    //Toast.makeText(Ch06_Page34_01.this, "onFling", Toast.LENGTH_SHORT).show();

    float moveX = e1.getX() - e2.getX();
    float moveY = e1.getY() - e2.getY();

    if (moveX > 0) {
      //Toast.makeText(Ch06_Page34_01.this, "{" + Float.toString(moveX) + " , " + Float.toString(moveY) + "}", Toast.LENGTH_SHORT).show();
      currentTabIndex++;
      if(currentTabIndex>2){
        currentTabIndex=0;
      }
      tabHost.setCurrentTab(currentTabIndex);
    } else if (moveX < 0) {
      //Toast.makeText(Ch06_Page34_01.this, "{" + Float.toString(moveX) + " , " + Float.toString(moveY) + "}", Toast.LENGTH_SHORT).show();

      currentTabIndex--;
      if(currentTabIndex<0){
        currentTabIndex=2;
      }
      tabHost.setCurrentTab(currentTabIndex);
    } else {
      //Toast.makeText(Ch06_Page34_01.this, "흠..", Toast.LENGTH_SHORT).show();
    }
    return false;
  }
}
