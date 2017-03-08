package com.bitacademy.exam_20170308;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ex056 extends AppCompatActivity {

  // 에디트 2 버튼 5 텍스트뷰 1
  EditText editText01, editText02;
  Button btn01, btn02, btn03, btn04, btn05;
  TextView textView;

  // 리스너 객체
  CompoundButton.OnClickListener btnClickFn;


  Double resultDouble, inputNum1, inputNum2;
  String inputInteger1, inputInteger2;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ex03);

    //타이틀 멋지게 바꿔주기
    setTitle("어썸- 계산기");

    // 리턴받기
    editText01 = (EditText) findViewById(R.id.ex03_InputNumber01);
    editText02 = (EditText) findViewById(R.id.ex03_InputNumber02);

    btn01 = (Button) findViewById(R.id.ex03_Btn01);
    btn02 = (Button) findViewById(R.id.ex03_Btn02);
    btn03 = (Button) findViewById(R.id.ex03_Btn03);
    btn04 = (Button) findViewById(R.id.ex03_Btn04);
    btn05 = (Button) findViewById(R.id.ex03_Btn05);

    textView = (TextView) findViewById(R.id.ex03_OutputText);

    // 숫자 미리 받아두기


    // 버튼들한테 기능 넣기
    btn01.setOnClickListener(btnClickFn);
    btn02.setOnClickListener(btnClickFn);
    btn03.setOnClickListener(btnClickFn);
    btn04.setOnClickListener(btnClickFn);
    btn05.setOnClickListener(btnClickFn);

    // 텍스트 바꿔주기
    textView.setText(resultDouble + "");

// 버튼이 할 일 미리 만들어 두기기
    btnClickFn = new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        inputInteger1 = editText01.getText().toString();
        inputInteger2 = editText02.getText().toString();

        inputNum1 = Double.parseDouble(inputInteger1);
        inputNum2 = Double.parseDouble(inputInteger2);

        // 입력값.trim().length()==0
        if (inputNum1 == null && inputNum2 == null) {


          Toast.makeText(Ex056.this, inputNum1 + "ㅡㅡ" + inputNum2, Toast.LENGTH_SHORT).show();
          //Ex03.this.finish();
        } else {


          if (v.getId() == R.id.ex03_Btn01) {
            resultDouble = inputNum1 + inputNum2;
          } else if (v.getId() == R.id.ex03_Btn02) {

            resultDouble = inputNum1 - inputNum2;
          } else if (v.getId() == R.id.ex03_Btn03) {
            resultDouble = inputNum1 * inputNum2;
          } else if (v.getId() == R.id.ex03_Btn04) {
            if (inputNum2 != 0) {
              resultDouble = inputNum1 / inputNum2;
            } else {
              Toast.makeText(Ex056.this, "0 나누기 정의해오면 해드림", Toast.LENGTH_SHORT).show();
            }
          } else if (v.getId() == R.id.ex03_Btn05) {
            resultDouble = inputNum1 % inputNum2;
          }
        }
      }
    };
  }
}
