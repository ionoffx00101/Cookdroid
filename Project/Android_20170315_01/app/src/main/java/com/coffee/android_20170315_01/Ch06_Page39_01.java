package com.coffee.android_20170315_01;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Ch06_Page39_01 extends AppCompatActivity implements ActionBar.TabListener {
  MyTabFragment myFrags[] = new MyTabFragment[3];

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page39_01);

    ActionBar bar = getSupportActionBar();
    bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    ActionBar.Tab tabSong = bar.newTab();
    tabSong.setText("음악별");
    tabSong.setTabListener(this);

    bar.addTab(tabSong);

    ActionBar.Tab tabArtist = bar.newTab();
    tabArtist.setText("가수별");
    tabArtist.setTabListener(this);

    bar.addTab(tabArtist);

    ActionBar.Tab tabAlbum = bar.newTab();
    tabAlbum.setText("앨범별");
    tabAlbum.setTabListener(this);

    bar.addTab(tabAlbum);

  }

  @Override
  public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
    MyTabFragment myTabFrag = null;

    if (myFrags[tab.getPosition()] == null) {
      myTabFrag = new MyTabFragment();

      Bundle data = new Bundle();
      data.putString("tabName", tab.getText().toString());

      myTabFrag.setArguments(data);
      myFrags[tab.getPosition()] = myTabFrag;
    } else {
      myTabFrag = myFrags[tab.getPosition()];
    }
    ft.replace(android.R.id.content, myTabFrag);
  }

  @Override
  public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

  }

  @Override
  public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

  }

  public static class MyTabFragment extends Fragment {
    String tabName;//메뉴 이름

    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Bundle data = getArguments();
      tabName = data.getString("tabName");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      LinearLayout baseLayout =
          (LinearLayout) inflater.inflate(R.layout.fragment01, null);

      TextView title = (TextView) baseLayout.findViewById(R.id.title);
      title.setText(tabName);
      if ("음악별".equals(tabName)) {
        baseLayout.setBackgroundColor(Color.BLUE);
      } else if ("가수별".equals(tabName)) {
        baseLayout.setBackgroundColor(Color.RED);
      } else {
        baseLayout.setBackgroundColor(Color.GREEN);
      }
      return baseLayout;
    }
  }
}
