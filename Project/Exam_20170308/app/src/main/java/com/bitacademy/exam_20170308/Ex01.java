package com.bitacademy.exam_20170308;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Ex01 extends AppCompatActivity {
  /*1.화면의 4개의 버튼객체를 저장할 변수 선언*/
  Button btn01, btn02, btn03, btn04;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ex01);

    //화면 타이틀 설정
    setTitle("버튼 4개");

    // 버튼 객체들 리턴 받기
    btn01 = (Button) findViewById(R.id.btn01);
    btn02 = (Button) findViewById(R.id.btn02);
    btn03 = (Button) findViewById(R.id.btn03);
    btn04 = (Button) findViewById(R.id.btn04);

    // 버튼들이 할 일 미리 만들어 두기
    View.OnClickListener btnClickListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(v.getId()==R.id.btn01) {
          Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
          Ex01.this.startActivity(intent);
        }
        else if(v.getId()==R.id.btn02){
          Intent intent=new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel://01022542354"));
         Ex01.this.startActivity(intent);
        }
        else if(v.getId()==R.id.btn03){
          Intent intent = new Intent(Intent.ACTION_PICK);
          intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
          intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
          startActivity(intent);
        }
        else if(v.getId()==R.id.btn04){
          Ex01.this.finish();
        }
        else {
          //Ex01.this.finish();
        }
      }
    };
    // 버튼들한테 기능 넣어주기
    btn01.setOnClickListener(btnClickListener);
    btn02.setOnClickListener(btnClickListener);
    btn03.setOnClickListener(btnClickListener);
    btn04.setOnClickListener(btnClickListener);
         /*
        화면의 타이틀은 setTitle("화면의 타이틀");
        로 설정한다

        2.화면에서 4개의 버튼 객체를 각각 리턴받아서
        * 1의 변수에 저장
        * -교재 4장 27페이지 참조
        * 3.2의 버튼을 클릭했을때 할일을 구현
        * -교재 4장 27 페이지 참조
        *
        * 네이트 홈페이지 여는 방법
        * Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.nate.com"));
        * Ex01.this.startActivity(intent);
        *
        * 119에 전화걸기
        * Intent intent=new Intent(Intent.ACTION_DIAL,
        *          Uri.parse("tel://119"));
        * Ex01.this.startActivity(intent);
        *
        * 겔러리 열기
        * - 실행하기 전에 Genymotion 겔러리에 사진들을 추가한다
        *
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
        intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivity(intent);
        *
        * 끝내기
        * Ex01.this.finish();
        * */
  }
}
