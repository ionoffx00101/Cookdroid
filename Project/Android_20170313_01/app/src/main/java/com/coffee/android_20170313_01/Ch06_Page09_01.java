package com.coffee.android_20170313_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Ch06_Page09_01 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page09_01);

    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);

    DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
    datePicker.updateDate(year, month, day);

    //  datePicker.init(연도,달,일,)
    datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
      @Override
      public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(Ch06_Page09_01.this,dayOfMonth+"-"+monthOfYear+"-"+year,Toast.LENGTH_SHORT).show();
      }
    });

//    datePicker.init(year,month, day, new DatePicker.OnDateChangedListener() {
//      @Override
//      public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//        Toast.makeText(Ch06_Page09_01.this,dayOfMonth+"-"+monthOfYear+"-"+year,Toast.LENGTH_SHORT).show();
//      }
//    });

  }
}
