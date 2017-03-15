package com.coffee.android_20170315_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

public class Ch08_page17_01 extends AppCompatActivity {

  Button btnRawImport;
  TextView readRawView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch08_page17_01);

    btnRawImport = (Button) findViewById(R.id.btnRawImport);
    readRawView = (TextView) findViewById(R.id.readRawView);

    btnRawImport.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // raw 폴더안에 들은 파일들 이름은 영어 소문자조합으로만 가능하다.
        // raw 폴더에 들은 파일 읽기 형변환을 시켜줘야하나..
        //FileInputStream inputStream = (FileInputStream) getResources().openRawResource(R.raw.raw_text);
        // InputStream > FileInputStream
        InputStream inputStream = getResources().openRawResource(R.raw.raw_text);
        try {
          // 배열의 크기는 파일의 크기
          byte[] txt = new byte[inputStream.available()];

          inputStream.read(txt);

          // String으로 변환해서 텍스트 뷰에 넣기
          readRawView.setText(new String(txt));

          inputStream.close();

        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    });

  }
}
