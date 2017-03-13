package com.coffee.android_20170313_01;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class Ch06_Page09_02 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page09_02);

    CalendarView calendarView = (CalendarView)findViewById(R.id.calendarView);

    calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
      @Override
      public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        Toast.makeText(Ch06_Page09_02.this,dayOfMonth+"-"+month+"-"+year,Toast.LENGTH_SHORT).show();
      }
    });

  }
}
