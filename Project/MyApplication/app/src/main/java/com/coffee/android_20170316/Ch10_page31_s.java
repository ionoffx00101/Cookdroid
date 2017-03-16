package com.coffee.android_20170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ch10_page31_s extends AppCompatActivity {

  Button btnReturn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch10_page31_s);
    setTitle("Ch10_page31_s");

    btnReturn = (Button) findViewById(R.id.btnReturn);

    // Ch10_page31_f에서 intent로 보낸 값 찾아야함
    // getIntent() /  여기로 넘어온 Intent 객체를 찾아옴
    Intent intent = getIntent();

    // intent.getIntExtra(아까 받으라고 준 이름,그 이름의 데이터가 없을때 리턴할 값);
    int num1 = intent.getIntExtra("num1",0);
    int num2 = intent.getIntExtra("num2",0);
    int num3 = intent.getIntExtra("num3",0); // 데이터가 없을 때 리턴하는 값 보려고 일부러 없는 이름을 찾아봄

    Toast.makeText(getApplicationContext(),num1+", "+num2+", "+num3,Toast.LENGTH_SHORT).show();

    // 돌아가기 버튼을 눌렀을때
    btnReturn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // finish() / 이전 버튼 누르는 효과
        finish();
      }
    });
  }
}
