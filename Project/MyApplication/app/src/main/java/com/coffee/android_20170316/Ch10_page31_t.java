package com.coffee.android_20170316;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ch10_page31_t extends AppCompatActivity {

  Button btnReturn;

  int multiValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch10_page31_s);
    setTitle("Ch10_page31_t");

    btnReturn = (Button) findViewById(R.id.btnReturn);

    // Ch10_page31_f에서 intent로 보낸 값 찾아야함
    // getIntent() /  여기로 넘어온 Intent 객체를 찾아옴
    Intent intent = getIntent();

    // intent.getIntExtra(아까 받으라고 준 이름,그 이름의 데이터가 없을때 리턴할 값);
    int num1 = intent.getIntExtra("num1",0);
    int num2 = intent.getIntExtra("num2",0);

    multiValue = num1*num2;
    Toast.makeText(getApplicationContext(),num1+", "+num2,Toast.LENGTH_SHORT).show();

    // 돌아가기 버튼을 눌렀을때
    btnReturn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // 내가 만든 데이터를 보낼 Intent를 만든다
        Intent outIntent = new Intent(getApplicationContext(),Ch10_page31_f.class);

        // 데이터를 넣는다
        outIntent.putExtra("multiResult",multiValue);

        // 보낸 값인지 인증하기? 약간 그런 의미던데
        setResult(RESULT_OK,outIntent);

        // finish() / 이전 버튼 누르는 효과
        finish();
      }
    });
  }
}
