package com.coffee.android_20170309_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class Imageview_01 extends AppCompatActivity {

  ImageView imageView1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_imageview_01);

    // 리턴 받는다
    CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox);
    imageView1 =(ImageView) findViewById(R.id.imageView1);

    checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
          imageView1.setVisibility(View.VISIBLE);
        }else {
          imageView1.setVisibility(View.INVISIBLE);
          //imageView1.setVisibility(View.GONE);
        }

      }
    });
  }
}
