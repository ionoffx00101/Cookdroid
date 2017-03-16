package com.coffee.android_20170316;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

  Button btnReturn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.second);
    setTitle("SecondActivity");

    btnReturn = (Button)findViewById(R.id.btnReturn);

    btnReturn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 종료 / 이전버튼 누른 효과
        finish();
      }
    });

  }
}
