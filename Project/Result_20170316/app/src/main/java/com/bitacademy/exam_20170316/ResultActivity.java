package com.bitacademy.exam_20170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tvResult;
    ImageView ivResult;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        tvResult=(TextView)findViewById(R.id.tvResult);
        ivResult=(ImageView)findViewById(R.id.ivResult);
        btnReturn=(Button)findViewById(R.id.btnReturn);

        /*
        * 1.Ex02에서 전달한 Intent를 리턴받음
        *  교재 10장 28페이지 7번째줄 참조*/
        Intent intent = getIntent();
        /* 2.Ex02에서 전달한 투표결과를 꺼내서 변수에 저장
        * *  *  교재 10장 28페이지 8번째줄 참조*/
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        /* 3.Ex02에서 전달한 이미지 파일명을 꺼내서 변수에 저장
        * -*  교재 10장 28페이지 9번째줄 참조*/
        String[] imageName = intent.getStringArrayExtra("ImageName");
        /* 4.Ex02에서 전달한 일등한 이미지 파일명을 꺼내서 변수에 저장 (파일명은 String 타입)*/
        /* 5.Ex02에서 전달한 일등한 이미지 아이디을 꺼내서 변수에 저장 (아이디는 int 타입)
        */
        String firstImageName = intent.getStringExtra("FirstImageName");
        int firstImageId = intent.getIntExtra("FirstImageId", 0);
        /* 6.
        * result.xml의 텍스트뷰 9개와 래이팅바 9개의 위젯 변수 배열을 선언
        텍스트뷰 id를 저장한 배열 변수, 래이팅바의 id를 저장한 배열 변수를 선언
        -*  교재 10장 29페이지 참조*/
        TextView[] tv = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer[] tvID = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer[] rbarID = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};
          /*7.XML 파일의 텍스트뷰 및 래이팅바를 위젯 변수에 대입
             -교재 10장 29페이지  9번째 줄부터 12번째 줄까지 참조*/
        for (int i = 0; i < voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }
          /*8.텍스트뷰 위젯 변수에 넘겨받은 그림 이름을 적용. 래이팅바에는 넘겨받은 투표 결과를  적용
            -교재 10장 29페이지 14번째 줄부터 17번째 줄까지 참조*/
        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }
          /*9. 4의 일등한 이미지 파일명을 텍스트뷰에 출력
          10. 5의 일등한 이미지를 이미지뷰에 출력*/
            tvResult.setText(firstImageName);
            ivResult.setImageResource(firstImageId);
          /*11.버튼 클릭시 액티비티 종료
           교재 10장 29페이지 19번째 줄부터 24번째 줄까지 참조
        * */
          btnReturn.setOnClickListener(
                  new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          finish();
                      }
                  }
          );

    }
}
