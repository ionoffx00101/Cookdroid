package com.coffee.exam_20170313;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Ex01 extends AppCompatActivity {

  Chronometer chronometer1;

  RadioGroup radioGroup1;
  RadioButton rdoDate, rdoTime;

  TimePicker timePicker;
  DatePicker datePicker;

  TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ex01);

    // 리턴 받아두기
    chronometer1 = (Chronometer) findViewById(R.id.chronometer1);

    radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
    rdoDate = (RadioButton) findViewById(R.id.rdoDate);
    rdoTime = (RadioButton) findViewById(R.id.rdoTime);

    timePicker = (TimePicker) findViewById(R.id.timePicker);
    datePicker = (DatePicker) findViewById(R.id.datePicker);

    tvYear = (TextView) findViewById(R.id.tvYear);
    tvMonth = (TextView) findViewById(R.id.tvMonth);
    tvDay = (TextView) findViewById(R.id.tvDay);
    tvHour = (TextView) findViewById(R.id.tvHour);
    tvMinute = (TextView) findViewById(R.id.tvMinute);

    // 초 시계 영역
    chronometer1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 1. 초 시계 시작
        chronometer1.start();
        // 2. 라디오 버튼 그룹 친구들 나타남
        radioGroup1.setVisibility(View.VISIBLE);

      }
    });
    chronometer1.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View v) {
        // 3. 초시계를 꾸욱 누르면 초시계가 멈추고 라디오 친구들이 사라짐
        // 꾸욱? 꾸욱을 어떻게 감지해?
        // setOnLongClick ㄱㄱ

        // 초시계 보이는 것만 멈추기
        chronometer1.stop();
        // 초시계 아예 멈추기
        chronometer1.setBase(SystemClock.elapsedRealtime());
        // 뷰 안 보이게 하고 선택값 초기화
        radioGroup1.setVisibility(View.INVISIBLE);
        radioGroup1.clearCheck();
        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);

        return true; // 다음 이벤트 계속 진행 false, 이벤트 완료 true
      }
    });


    // 라디오 버튼 친구들 영역
    radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (checkedId == R.id.rdoDate) {
          timePicker.setVisibility(View.INVISIBLE);
          datePicker.setVisibility(View.VISIBLE);
        } else if (checkedId == R.id.rdoTime) {
          datePicker.setVisibility(View.INVISIBLE);
          timePicker.setVisibility(View.VISIBLE);

        }
      }
    });

    // tvYear 꾸욱 클릭 영역
    tvYear.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View v) {
       // Toast.makeText(Ex01.this,"흠..",Toast.LENGTH_SHORT).show();
        // date와 time 에서 객체를 뽑아서
        // TextView들 값 바꿔주고
        // 위에 있는 위젯들 데이터 초기화 및 안 보임 설정

        // textView 바꾸기
        // 그냥하면 오류 나서 + " " 붙여줬더니 되긴 한다 흠..
//        tvYear.setText(datePicker.getYear()+" ");
//        tvMonth.setText(datePicker.getMonth()+" ");
//        tvDay.setText(datePicker.getDayOfMonth()+" ");
//        tvHour.setText(timePicker.getHour()+" ");
//        tvMinute.setText(timePicker.getMinute()+" ");

        // Integer.toString()
        // 오류는 안 나지만 안드로이드 스튜디오가 굉장히 싫어한다.. 흠..
        tvYear.setText(Integer.toString(datePicker.getYear()));
        tvMonth.setText(Integer.toString(datePicker.getMonth()));
        tvDay.setText(Integer.toString(datePicker.getDayOfMonth()));
        tvHour.setText(Integer.toString(timePicker.getHour()));
        tvMinute.setText(Integer.toString(timePicker.getMinute()));

        // 위젯들 초기화
        // 초시계 아예 멈추기
        chronometer1.stop();
        chronometer1.setBase(SystemClock.elapsedRealtime());
        // 뷰 안 보이게 하고 선택값 초기화
        radioGroup1.setVisibility(View.INVISIBLE);
        radioGroup1.clearCheck();
        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);

        return true;
      }
    });


  }

}
