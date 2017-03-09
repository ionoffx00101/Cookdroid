package com.coffee.android_20170309_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

  // 저장 공간 할당해두기
  Switch switch1, switch2;
  ToggleButton toggleButton1, toggleButton2;
  CompoundButton.OnCheckedChangeListener checkChangeListen;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // 리턴받기
    // 받을 변수 = (형변환) 뷰에서 id로 찾는다(R.id.등록된id);
    switch1 = (Switch) findViewById(R.id.switch1);
    switch2 = (Switch) findViewById(R.id.switch2);
    toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
    toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);

    // 기능 미리 만들어두기
    checkChangeListen = new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String buttonText = buttonView.getText().toString();
        String isOnOff;

        if (isChecked) {
          isOnOff = "on";
        } else {
          isOnOff = "off";
        }

        Toast.makeText(MainActivity.this, buttonText + isOnOff, Toast.LENGTH_SHORT).show();
      }
    };

    // 기능 넣어주기
    switch1.setOnCheckedChangeListener(checkChangeListen);
    switch2.setOnCheckedChangeListener(checkChangeListen);
    toggleButton1.setOnCheckedChangeListener(checkChangeListen);
    toggleButton2.setOnCheckedChangeListener(checkChangeListen);


  }
}