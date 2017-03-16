package com.coffee.android_20170316;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ch10_page31_f extends AppCompatActivity {

  EditText edtNum1, edtNum2;
  Button btnAdd;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch10_page31_f);
    setTitle("Ch10_page31_f");

    edtNum1 = (EditText) findViewById(R.id.edtNum1);
    edtNum2 = (EditText) findViewById(R.id.edtNum2);
    btnAdd = (Button) findViewById(R.id.btnAdd);

    btnAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // intent 객체를 새로 만들면서 현재 주소, 갈 주소 넣기
        Intent intent = new Intent(getApplicationContext(),Ch10_page31_s.class);

        // 사용자가 입력한 값 뽑아서 형 변환 시키기
        String stringInputNum1 = edtNum1.getText().toString();
        String stringInputNum2 = edtNum2.getText().toString();
        int intInputNum1 = Integer.parseInt(stringInputNum1);
        int intInputNum2 = Integer.parseInt(stringInputNum2);

        // intent 객체에 데이터 집어 넣기
        // intent.putExtra(K,V);
        // intent.putExtra(꺼낼때 사용할 이름, 보낼데이터값);
        intent.putExtra("num1",intInputNum1);
        intent.putExtra("num2",intInputNum2);

        // 페이지 전환
        startActivity(intent);
      }
    });

  }
}
