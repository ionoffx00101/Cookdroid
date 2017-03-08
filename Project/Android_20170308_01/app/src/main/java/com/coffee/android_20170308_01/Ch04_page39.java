package com.coffee.android_20170308_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class Ch04_page39 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch04_page38);

    // 체크 박스가 많을 경우 하는 방법

    // 원하는 위젯 리턴 받기
    CompoundButton.OnCheckedChangeListener checkedChangedListener = new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String phone = buttonView.getText().toString();

        if(buttonView.getId()==R.id.android){
          // 안드로이드 랑 같은 거인지 확인 가능
        }

        // 체크가 활성화 되면 true를 리턴하고 , 비활성화 되면 false를 리턴한다.
        if (isChecked) {
          Toast.makeText(Ch04_page39.this, phone + " 정말 있어?", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(Ch04_page39.this, phone + " 정말 없어?", Toast.LENGTH_SHORT).show();
        }
      }
    };

    CheckBox androidCheck = (CheckBox) findViewById(R.id.android);
    CheckBox iphoneCheck = (CheckBox) findViewById(R.id.iphone);
    CheckBox windowCheck = (CheckBox) findViewById(R.id.window);

    // 기능 넣기
    androidCheck.setOnCheckedChangeListener(checkedChangedListener);
    iphoneCheck.setOnCheckedChangeListener(checkedChangedListener);
    windowCheck.setOnCheckedChangeListener(checkedChangedListener);

  }
}
