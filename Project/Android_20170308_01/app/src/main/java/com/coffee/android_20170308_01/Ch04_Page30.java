package com.coffee.android_20170308_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ch04_Page30 extends AppCompatActivity {

  // 객체가 저장될 공간 만들어 두기
  EditText edit1, edit2;
  Button btnAdd, btnMul, btnSub, btnDiv;
  TextView textResult;
  String num1, num2;
  Integer result;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch04__page30);

    // 객체들을 리턴 받는다
    edit1 = (EditText) findViewById(R.id.Edit1);
    edit2 = (EditText) findViewById(R.id.Edit2);

    btnAdd = (Button) findViewById(R.id.BtnAdd);
    btnSub = (Button) findViewById(R.id.BtnSub);
    btnMul = (Button) findViewById(R.id.BtnMul);
    btnDiv = (Button) findViewById(R.id.BtnDiv);

    textResult = (TextView) findViewById(R.id.TextResult);

    // 계산기 구현
    btnAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();
        result = Integer.parseInt(num1)+Integer.parseInt(num2);
        textResult.setText(result.toString());
      }
    });

    btnSub.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();
        result = Integer.parseInt(num1)-Integer.parseInt(num2);
        textResult.setText(result.toString());
      }
    });

    btnMul.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();
        result = Integer.parseInt(num1)*Integer.parseInt(num2);
        textResult.setText(result.toString());
      }
    });

    btnDiv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();
        result = Integer.parseInt(num1)/Integer.parseInt(num2);
        textResult.setText(result.toString());
      }
    });

//    btnAdd.setOnTouchListener(new View.OnTouchListener(){
//      @Override
//      public boolean onTouch(View v, MotionEvent event) {
//        // motionEvent가 btnAdd와 일치할때 실행하는 방법도 있지 않을까
//        String msg;
//        msg="{"+event.getX()+", "+event.getY()+"}\n";
//
//        Toast.makeText(Ch04_Page30.this,msg,Toast.LENGTH_SHORT).show();
//
//        num1 = edit1.getText().toString();
//        num2 = edit2.getText().toString();
//        result = Integer.parseInt(num1)+Integer.parseInt(num2);
//        textResult.setText(result.toString());
//        return false;
//      }
//    });

//    if(event.getAction()==MotionEvent.ACTION_DOWN){
//      msg="누르는 중";
//    }else if(event.getAction()==MotionEvent.ACTION_MOVE){
//      msg="누르고 움직여";
//    }else {
//      msg="뗌";
//    }




  }
}
