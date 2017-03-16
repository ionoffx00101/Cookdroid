package com.coffee.exam_20170315;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01 extends AppCompatActivity {

  // NoDapDiary에 추가된 내용이 있다.

  // 날짜, 일기쓰는곳,버튼, 두개 담긴 레이아웃
  DatePicker datePicker;
  LinearLayout writeLayout;
  TextView textView;
  EditText editText;
  Button button;

  String fileName;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ex01);

    // 리턴 받아두기
    datePicker = (DatePicker) findViewById(R.id.datePicker);
    writeLayout = (LinearLayout) findViewById(R.id.writeLayout);
    textView = (TextView) findViewById(R.id.textView);
    editText = (EditText) findViewById(R.id.editText);
    button = (Button) findViewById(R.id.button);

    // 오늘 날짜 용
//    Calendar c = Calendar.getInstance();
//    int year = c.get(Calendar.YEAR);
//    int month = c.get(Calendar.MONTH);
//    int day = c.get(Calendar.DAY_OF_MONTH);

    // datePick 기능 만들기
    //  datePicker.init(연도,달,일,)
    datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
      @Override
      public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // Toast.makeText(getApplicationContext(),dayOfMonth+"-"+monthOfYear+"-"+year,Toast.LENGTH_SHORT).show();
        writeLayout.setVisibility(View.VISIBLE);
        textView.setText(year + " - " + monthOfYear + " - " + dayOfMonth);

        // 이미 선택한 날짜에 일기가 있는지 없는지 체크해야할 시간이다
        checkedDay(year,monthOfYear,dayOfMonth);
      }
    });

    // 일기 저장
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //Toast.makeText(getApplicationContext(), "응 저장 ", Toast.LENGTH_SHORT).show();

        FileOutputStream fos = null;


        try {
          fos = openFileOutput(fileName, MODE_NO_LOCALIZED_COLLATORS); //MODE_WORLD_WRITEABLE
          String content = editText.getText().toString();

          // String.getBytes() = 스트링을 배열형으로 변환?
          fos.write(content.getBytes());
          //fos.flush();
          fos.close();

          // getApplicationContext() = 현재 클래스.this ?
          Toast.makeText(getApplicationContext(), "일기 저장됨", Toast.LENGTH_SHORT).show();

        } catch (Exception e) { // Exception - 에러 종류 제일 상위
          e.printStackTrace();
          Toast.makeText(getApplicationContext(), "오류오류", Toast.LENGTH_SHORT).show();
        }
      }
    });

  }

  private void checkedDay(int year, int monthOfYear, int dayOfMonth) {
    fileName = year+""+monthOfYear+""+dayOfMonth+".txt";

    // 읽어봐서 읽어지면 일기 가져오고
    // 없으면 catch 그냥 살아? 아주 위험한 생각같다..
    FileInputStream fis = null;
    try {
      fis = openFileInput(fileName);

      int sizeCut = fis.available();

      byte[] fileData = new byte[sizeCut];
      fis.read(fileData);
      fis.close();

      String str = new String(fileData,"EUC-KR");
      // 읽어서 토스트 메시지로 보여줌
      Toast.makeText(getApplicationContext(), "일기 써둔 날", Toast.LENGTH_SHORT).show();
      editText.setText(str);
      button.setText("수정하기");
    } catch (Exception e) {
      Toast.makeText(getApplicationContext(), "일기 없는 날", Toast.LENGTH_SHORT).show();
      editText.setText("");
      button.setText("새 일기 저장");
      e.printStackTrace();
    }

  }

}
