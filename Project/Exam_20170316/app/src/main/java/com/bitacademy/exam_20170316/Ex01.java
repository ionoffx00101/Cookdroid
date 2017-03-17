package com.bitacademy.exam_20170316;

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

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Ex01 extends AppCompatActivity {

  // 뷰에 있는 위젯들
  Button btnPrv, btnNext;
  TextView txtNaviNow, txtNaviAll;


  // sd카드 진짜 폴더 경로
  String sdCardAbsPath;
  // 사진 폴더 관리하는 File 객체
  File folderPicture;

  // MyPictureView
  MyPictureView myPictureView;

  // 파일 저장용 객체들
  int curNum;
  File[] imageFiles;
  String imageName;
  //raw 폴더에 저장된 이미지 파일명들이 저장된 배열
  String[] rawFolderImageName = {
      "renoir01.png",
      "renoir02.png",
      "renoir03.png",
      "renoir04.png",
      "renoir05.png"
  };
  //raw 폴더에 저장된 이미지 파일들의 아이디가 저장된 배열
  int[] rawFolderImageId = {
      R.raw.renoir01,
      R.raw.renoir02,
      R.raw.renoir03,
      R.raw.renoir04,
      R.raw.renoir05
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ex01);
    setTitle("EX01");
    // sd카드 권한 설정
    verifyStoragePermissions(this);

    // sd카드 진짜 경로 가져오기
    sdCardAbsPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    folderPicture = new File(sdCardAbsPath + "/picture");

    // 위젯들 리턴 받아서 준비
    btnPrv = (Button) findViewById(R.id.btnPrv);
    btnNext = (Button) findViewById(R.id.btnNext);
    txtNaviNow = (TextView) findViewById(R.id.txtNaviNow);
    txtNaviAll = (TextView) findViewById(R.id.txtNaviAll);


    // MyPictureView 준비
    //myPictureView = new MyPictureView(getApplicationContext(),null); // 일단 null로함
    myPictureView = (MyPictureView) findViewById(R.id.myPictureViewInlayout);

    // 사진 폴더 있는 지 검사
    if (folderPicture.exists() == false) {
      // 없으면 폴더 생성
      folderPicture.mkdir();
    }

    // 사진 있나 확인 / 없으면 복붙
    for (int i = 0; i < rawFolderImageName.length; i++) {
      // 파일이름 포함한 경로 만들어주기
      String artPath = sdCardAbsPath + "/picture/" + rawFolderImageName[i];
      // 파일 경로를 이용해서 파일 관리 객체 만들어 주기
      File artFile = new File(artPath);

      // 파일 존재하는 지 확인
      if (artFile.exists() == false) {
        // 없으니까 만들어 줘야지 ㅇㅇ
        // 읽고 가져오자마자 저장 시키면 그게 복붙인가..

        try {
          // 가져오기
          InputStream inputStream = getResources().openRawResource(rawFolderImageId[i]);

          // 배열의 크기는 파일의 크기
          byte[] txt = new byte[inputStream.available()];

          inputStream.read(txt);

          // String으로 변환
          // String str = new String(txt);

          // sd카드에 쓰기
          FileOutputStream fout = new FileOutputStream(artPath);
          fout.write(txt);
          fout.flush();

          // 끄기
          fout.close();
          inputStream.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    imageFiles = folderPicture.listFiles();

    // 첫 화면 설정
    txtNaviNow.setText(1 + "");
    txtNaviAll.setText(imageFiles.length + "");

    imageName = imageFiles[0].toString();
    myPictureView.setImagePath(imageName);

    // 버튼 누른 것들 설정
    btnPrv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 이전 버튼 눌렀을 때
        curNum--;
        if (curNum < 0) {
          curNum = imageFiles.length - 1;
        }

        imageName = imageFiles[curNum].toString();
        myPictureView.setImagePath(imageName);
        //myPictureView.onDraw();
        myPictureView.invalidate();
        txtNaviNow.setText((curNum + 1) + "");
        // (new Integer(curNum+1).toString());
      }
    });

    btnNext.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 다음 버튼 눌렀을 때

        curNum++;
        if (curNum > imageFiles.length - 1) {
          curNum = 0;
        }
        imageName = imageFiles[curNum].toString();
        myPictureView.setImagePath(imageName);
        //myPictureView.onDraw();
        myPictureView.invalidate();
        txtNaviNow.setText((curNum + 1) + "");

      }
    });

  }

  // sd 카드 권한 설정
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
}
