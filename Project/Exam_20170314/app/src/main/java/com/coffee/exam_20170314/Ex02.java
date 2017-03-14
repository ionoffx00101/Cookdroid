package com.coffee.exam_20170314;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Ex02 extends TabActivity {

  TabHost tabHost;
  int currentTabIndex = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ex02);

    tabHost = getTabHost();

    // tabHost.newTabSpec("자바코드용 이름").setIndicator("보여지는 이름");
    TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("javaTap1").setIndicator("멍멈ㅇ");
    tabSpec1.setContent(R.id.tab1);

    TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("javaTap2").setIndicator("야옹");
    tabSpec2.setContent(R.id.tab2);

    TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("javaTap3").setIndicator("토낏");
    tabSpec3.setContent(R.id.tab3);

    TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("javaTap4").setIndicator("히잉");
    tabSpec4.setContent(R.id.tab4);

    // 탭순서 0,1,2..
    // 메뉴에 만든 탭들 집어넣기
    tabHost.addTab(tabSpec1);
    tabHost.addTab(tabSpec2);
    tabHost.addTab(tabSpec3);
    tabHost.addTab(tabSpec4);

    // 어떤 탭을 기본 화면으로 할지 설정 가능
    tabHost.setCurrentTab(currentTabIndex);
  }
}
