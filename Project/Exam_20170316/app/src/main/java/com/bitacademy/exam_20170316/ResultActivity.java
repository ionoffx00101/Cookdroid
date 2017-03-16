package com.bitacademy.exam_20170316;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

  Button btnReturn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.result);

    btnReturn = (Button) findViewById(R.id.btnReturn);

    Intent intentData = getIntent();

    // Intent에 넣어져서 온 객체 받기
    int[] voteCount = intentData.getIntArrayExtra("voteCount");
    String[] imgNameArr = intentData.getStringArrayExtra("imgNameArr");
    int firstImageId = intentData.getIntExtra("firstImageId", 0);
    String firstImageName = intentData.getStringExtra("firstImageName");

    Toast.makeText(getApplicationContext(),imgNameArr[0]+"  "+firstImageName,Toast.LENGTH_SHORT).show();

    btnReturn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

        /*
        * 1.Ex02에서 전달한 Intent를 리턴받음
        *  교재 10장 28페이지 7번째줄 참조
        * 2.Ex02에서 전달한 투표결과를 꺼내서 변수에 저장
        * *  *  교재 10장 28페이지 8번째줄 참조
        * 3.Ex02에서 전달한 이미지 파일명을 꺼내서 변수에 저장
        * -*  교재 10장 28페이지 9번째줄 참조
        * 4.Ex02에서 전달한 일등한 이미지 파일명을 꺼내서 변수에 저장 (파일명은 String 타입)
        * 5.Ex02에서 전달한 일등한 이미지 아이디을 꺼내서 변수에 저장 (아이디는 int 타입)
        *
        * 6.
        * result.xml의 텍스트뷰 9개와 래이팅바 9개의 위젯 변수 배열을 선언
        텍스트뷰 id를 저장한 배열 변수, 래이팅바의 id를 저장한 배열 변수를 선언
        -*  교재 10장 29페이지 참조

          7.XML 파일의 텍스트뷰 및 래이팅바를 위젯 변수에 대입
             -교재 10장 29페이지  9번째 줄부터 12번째 줄까지 참조

          8.텍스트뷰 위젯 변수에 넘겨받은 그림 이름을 적용. 래이팅바에는 넘겨받은 투표 결과를  적용
            -교재 10장 29페이지 14번째 줄부터 17번째 줄까지 참조

          9. 4의 일등한 이미지 파일명을 텍스트뷰에 출력
          10. 5의 일등한 이미지를 이미지뷰에 출력

          11.버튼 클릭시 액티비티 종료
           교재 10장 29페이지 19번째 줄부터 24번째 줄까지 참조


        * */
  }
}
