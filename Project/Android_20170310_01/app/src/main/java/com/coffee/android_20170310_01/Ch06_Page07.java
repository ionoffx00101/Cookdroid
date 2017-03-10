package com.coffee.android_20170310_01;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Ch06_Page07 extends AppCompatActivity {

  Chronometer timer01;
  Button startBtn, endBtn, resetBtn, catchTimeBtn;
  TextView saveText;
  TimePicker timePicker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page07);

    timer01 = (Chronometer) findViewById(R.id.chronometer2);
    startBtn = (Button) findViewById(R.id.startBtn);
    endBtn = (Button) findViewById(R.id.endBtn);
    resetBtn = (Button) findViewById(R.id.resetBtn);
    saveText = (TextView) findViewById(R.id.saveText);
    timePicker = (TimePicker) findViewById(R.id.timePicker);
    catchTimeBtn = (Button) findViewById(R.id.catchTimeBtn);


    // android:timePickerMode="spinner"
    timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
      @Override
      public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(Ch06_Page07.this, hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();

      }
    });

    // android:timePickerMode="clock"
    timePicker.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
          int hour = timePicker.getHour();
          int minute = timePicker.getMinute();

          Toast.makeText(Ch06_Page07.this, hour + " : " + minute, Toast.LENGTH_SHORT).show();
        }

        return true;
      }
    });


  }

  public void chronoClick(View view) {

    int vId = view.getId();
//  String vText = (Button)view.ge;
    if (vId == R.id.startBtn) {
      timer01.start();
    } else if (vId == R.id.endBtn) {
      timer01.stop();
    } else if (vId == R.id.resetBtn) {
      timer01.stop();
      saveText.setText(SystemClock.elapsedRealtime() + "");
      timer01.setBase(SystemClock.elapsedRealtime());


    }

  }

}
