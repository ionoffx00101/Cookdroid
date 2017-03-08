package com.coffee.android_20170308_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class Ch04_page38 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch04_page38);

    // 원하는 위젯 리턴 받기
    CheckBox androidCheck = (CheckBox) findViewById(R.id.android);
    CheckBox iphoneCheck = (CheckBox) findViewById(R.id.iphone);
    CheckBox windowCheck = (CheckBox) findViewById(R.id.window);
    // 기능 넣기
    androidCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // 체크 상태가 변했을 때 원하는 기능을 구현

        String phone = buttonView.getText().toString();

        // 체크가 활성화 되면 true를 리턴하고 , 비활성화 되면 false를 리턴한다.
        if (isChecked) {
          Toast.makeText(Ch04_page38.this, phone+" 정말 있어?", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(Ch04_page38.this, phone+" 정말 없어?", Toast.LENGTH_SHORT).show();
        }
      }
    });

    iphoneCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // 체크 상태가 변했을 때 원하는 기능을 구현

        String phone = buttonView.getText().toString();

        // 체크가 활성화 되면 true를 리턴하고 , 비활성화 되면 false를 리턴한다.
        if (isChecked) {
          Toast.makeText(Ch04_page38.this, phone+" 정말 있어?", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(Ch04_page38.this, phone+" 정말 없어?", Toast.LENGTH_SHORT).show();
        }
      }
    });

    windowCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // 체크 상태가 변했을 때 원하는 기능을 구현

        String phone = buttonView.getText().toString();

        // 체크가 활성화 되면 true를 리턴하고 , 비활성화 되면 false를 리턴한다.
        if (isChecked) {
          Toast.makeText(Ch04_page38.this, phone+" 정말 있어?", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(Ch04_page38.this, phone+" 정말 없어?", Toast.LENGTH_SHORT).show();
        }
      }
    });
  }
}
