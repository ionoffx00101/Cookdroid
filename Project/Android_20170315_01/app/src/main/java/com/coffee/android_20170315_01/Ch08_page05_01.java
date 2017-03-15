package com.coffee.android_20170315_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ch08_page05_01 extends AppCompatActivity {

  Button btnImport, btnExport;
  TextView textView ;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch08_page05_01);


    btnImport = (Button) findViewById(R.id.btnImport);
    btnExport = (Button) findViewById(R.id.btnExport);
    textView = (TextView) findViewById(R.id.textView);

    // 파일 내보내기 버튼을 눌렀을 때
    btnExport.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        FileOutputStream fos = null;

        try {
          // openFileOutput(파일 이름, Context.MODE_WORLD_WRITEABLE - 모든 클래스에서 사용가능 체크)

          // 오류나는 거 MODE_NO_LOCALIZED_COLLATORS 로 바꿨더니 되긴 하는데
          // 이게 기존에 넣어놨던 MODE_WORLD_WRITEABLE랑 같은 의미인지 모르겠네
          fos = openFileOutput("file.txt", MODE_NO_LOCALIZED_COLLATORS); //MODE_WORLD_WRITEABLE
          String fileName = "쿠킹";

          // String.getBytes() = 스트링을 배열형으로 변환?
          fos.write(fileName.getBytes());
          //fos.flush();
          fos.close();

          // getApplicationContext() = 현재 클래스.this ?
          Toast.makeText(getApplicationContext(), "생성", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) { // Exception - 에러 종류 제일 상위
          e.printStackTrace();
          Toast.makeText(getApplicationContext(), "오류오류", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
          // 원래 onClick에 throws가 안 되어 있어서 재정의도 안됨 ㅇㅇ
          // 그래서 트라이 캐치에 추가 시킴
          e.printStackTrace();
          Toast.makeText(getApplicationContext(), "오류오류", Toast.LENGTH_SHORT).show();

        }

      }
    });

    // 어디선가 파일을 데려오기
    btnImport.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String filePath = "file.txt";

        FileInputStream fis = null;
        try {
          fis = openFileInput(filePath);

          int sizeCut = fis.available();

          byte[] fileData = new byte[sizeCut];
          fis.read(fileData);
          fis.close();

          String str = new String(fileData);
          // 읽어서 토스트 메시지로 보여줌
          //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
          textView.setText(str);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

  }
}
