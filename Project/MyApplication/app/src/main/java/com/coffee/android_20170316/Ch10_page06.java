package com.coffee.android_20170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ch10_page06 extends AppCompatActivity {

  Button btnOpenSecondAty;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch10_page06);
    setTitle("Ch10_page06");

    btnOpenSecondAty = (Button) findViewById(R.id.btnOpenSecondAty);

    btnOpenSecondAty.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        startActivity(intent);
      }
    });
  }
}
