package com.coffee.android_20170315_01;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStream;

public class Ch08_page22 extends AppCompatActivity {

  Button btnRawImport;
  TextView readRawView;
  String filePath =null;

  private static String[] PERMISSIONS_STORAGE = {
      Manifest.permission.READ_EXTERNAL_STORAGE,
      Manifest.permission.WRITE_EXTERNAL_STORAGE
  };
  private static final int REQUEST_EXTERNAL_STORAGE = 1;

  public static void verifyStoragePermissions(Activity activity) {
    // Check if we have write permission
    int permission = ActivityCompat.checkSelfPermission(
        activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

    if (permission != PackageManager.PERMISSION_GRANTED) {
      // We don't have permission so prompt the user
      ActivityCompat.requestPermissions(
          activity,
          PERMISSIONS_STORAGE,
          REQUEST_EXTERNAL_STORAGE
      );
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch08_page17_01);
    verifyStoragePermissions(Ch08_page22.this);

    btnRawImport = (Button) findViewById(R.id.btnRawImport);
    readRawView = (TextView) findViewById(R.id.readRawView);

    // sd 카드의 디렉토리 경로를 알아야한다. 읽으려면 manifests에 권한설정하고java에도 해줘야한다 ㅎㅎ
    String sdCardAbsPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    filePath = sdCardAbsPath+"/sd_text.txt"; ///mnt/sdcard/

    btnRawImport.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // sd카드에 있는 파일 읽어오기

        InputStream inputStream=null;
        try {

          inputStream = new FileInputStream(filePath);
          // 배열의 크기는 파일의 크기
          byte[] txt = new byte[inputStream.available()];

          inputStream.read(txt);

          // String으로 변환해서 텍스트 뷰에 넣기
          readRawView.setText(new String(txt,"EUC-KR"));

          inputStream.close();

        } catch (Exception e) {
          readRawView.setText(filePath);
         // Toast.makeText(getApplicationContext(),"오류",Toast.LENGTH_SHORT).show();
          e.printStackTrace();
        }

      }
    });

  }
}
