package com.coffee.android_20170310_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.TextClock;
import android.widget.Toast;

import java.util.Calendar;

public class Ch06_Page05 extends AppCompatActivity {

  TextClock tClock;
  AnalogClock aClock;
  DigitalClock dClock;
  Button checkTimeBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page05);

    tClock = (TextClock) findViewById(R.id.tClock);
    aClock =(AnalogClock)findViewById(R.id.aClock);
    dClock = (DigitalClock)findViewById(R.id.dClock);
    checkTimeBtn = (Button) findViewById(R.id.checkTime);

    checkTimeBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String now = tClock.getText().toString();
        //Toast.makeText(Ch06_Page05.this,now,Toast.LENGTH_SHORT).show();

        // 아날로그 시계의 시간 보기
        Calendar nowTime = Calendar.getInstance();
        int hour = nowTime.get(Calendar.HOUR_OF_DAY);
        int minute = nowTime.get(Calendar.MINUTE);
        int second = nowTime.get(Calendar.SECOND);

        Toast.makeText(Ch06_Page05.this,hour+" : "+minute+" : "+second,Toast.LENGTH_SHORT).show();
      }
    });


  }
}
