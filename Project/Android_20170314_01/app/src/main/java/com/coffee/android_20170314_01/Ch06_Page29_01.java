package com.coffee.android_20170314_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Ch06_Page29_01 extends AppCompatActivity {

  Button btnPrv, btnNext;
  ViewFlipper viewFlipper;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page29_01);

    btnPrv = (Button) findViewById(R.id.btnPrv);
    btnNext = (Button) findViewById(R.id.btnNext);

    viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

    btnPrv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        viewFlipper.showPrevious();
      }
    });
    btnNext.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        viewFlipper.showNext();
      }
    });
  }
}
