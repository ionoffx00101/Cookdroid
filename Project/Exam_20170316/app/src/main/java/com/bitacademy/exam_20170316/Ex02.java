package com.bitacademy.exam_20170316;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Ex02 extends AppCompatActivity {

  //이미지뷰에 출력된 이미지 파일의 아이디가 저장된 배열
  Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

  // 리턴 받을 객체 미리 만들어 두기
  ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9;
  Button btnResult;

  // 쓸 배열들 미리 생성
  int voteCount[] = new int[9];
  ImageView[] imgArr = new ImageView[9];

  int[] imgIdArr = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};

  String[] imgNameArr = {"독서", "모자", "부채", "베르망", "잠", "테라스", "피아노", "피아노 소녀", "해변"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ex02);
    setTitle("EX02");

    // 리턴 받아서 넣기
    btnResult = (Button) findViewById(R.id.btnResult);

    for (int i = 0; i < imgIdArr.length; i++) {
      final int index;
      index = i;
      imgArr[index] = (ImageView) findViewById(imgIdArr[index]);

      imgArr[index].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Toast.makeText(getApplicationContext(),"크를릭",Toast.LENGTH_SHORT).show();
          voteCount[index]++;
        }
      });
    }

    btnResult.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // 데이터 보내기 전에 1등 고르기
        String firstImageName;//일등한 그림의 이름을 저장할 변수
        int firstImageId;//일등한 그림의 아이디를 저장할 변수

        firstImageName = imgNameArr[0];//기본값으로 첫번째 그림의 이미지를 대입
        firstImageId = imageFileId[0];//기본값으로 첫번째 이미지의 아이디 대입

        int firstCount;//일등한 그림의 투표수를 저장할 변수
        firstCount = voteCount[0];//기본으로 첫번째 그림의 투표수를 저장

        for (int i = 1; i < voteCount.length; i++) {
          if (firstCount < voteCount[i]) {//voteCount[i]의 투표수가 더 크면
            firstImageId = imageFileId[i];//이미지의 아이디를 i번째 그림의 이미지 아이디로 수정
            firstImageName = imgNameArr[i];//i번째 이미지 이름으로 설정
            firstCount = voteCount[i];//i번째 투표수로 firstCount 수정
          }
        }

        // 1등 데이터 넣어서 보내기
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

        intent.putExtra("voteCount", voteCount);
        intent.putExtra("imgNameArr", imgNameArr);
        intent.putExtra("firstImageId", firstImageId);
        intent.putExtra("firstImageName", firstImageName);

        startActivity(intent);
      }
    });
  }
}
