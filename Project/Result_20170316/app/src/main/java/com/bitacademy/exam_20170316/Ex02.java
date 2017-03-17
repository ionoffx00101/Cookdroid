package com.bitacademy.exam_20170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Ex02 extends AppCompatActivity {
    //이미지뷰에 출력된 이미지 파일의 아이디가 저장된 배열
    Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);
        setTitle("명화 선호도 투표");

        btnResult = (Button) findViewById(R.id.btnResult);

        /*
        * 1.명화 투표결과를 저장할 size9인 정수타입배열 voteCount를 상수로 생성*/
        final int voteCount[] = new int[9];

        /* 2.화면에있는 9개의 ImageView를 저장할 배열 image를 생성*/
        final ImageView image[] = new ImageView[9];

        /* 3.화면에 출력한 9개의 이미지뷰의 아이디를 저장하고있는 배열 imgeId를 생성
        * -imageId에 저장할 이미지의 아이디는 순서대로
        * R.id.iv1,R.id.iv2,R.id.iv3 ... R.id.iv9 임
        * -교재  10장 25페이지 참조*/
        final Integer[] imageId = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        /* 4.화면에 출력한 이미지 파일의 이름이 저장된 배열 imgName 을 생성
        * -교재 10장 25 페이지 참조
        * */
        final String[] imgName = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르앙", "잠자는 소녀", "테라스의 두 자매",
                "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};

        /*
        * 5. 화면에 출력한 이미지뷰의 아이디 개수 만큼 반복함
        * 화면에 출력한 이미지뷰의 아이디는 배열 imageId에 저장되있으므로 imageId.length만큼 반복
        */
        for (int i = 0; i < imageId.length; i++) {
            final int index; //
            index = i;
        /*   5.1 imageId배열에서 index 즉 i 번째 ImageView의 아이디를 리턴받아서 (imageId[index])
        *     ImageView객체를 배열 image에 저장*/
            image[index] = (ImageView) findViewById(imageId[index]);

            /*5.2 5.1의 image[index]즉 ImageView객체를 클릭했을때 (교재 10장 26페이지 5번째줄~12번째줄 참조)*/
            image[index].setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
               /*5.2.1
                   voteCount[index] (index번째 이미지의 투표결과를 저장하는 배열) 1증가(교재 10장 26페이지 7번째줄 참조)*/
                            voteCount[index]++;
               /*
               5.2.2
                   imageName[index] (index번째 이미지의 이름) +":총"+
                   voteCount[index] (index번째 이미지의 투표개수)
                   를 토스트로 출력
                  (교재 110장 26페이지 10~11라인 참조)
        */
                            Toast.makeText(getApplicationContext(), imgName[index] + ": 총 " + voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }
        /*
         6.투표 종료 버튼 클릭했을때*/
        btnResult.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
          /*6.1
             ResultActivity화면으로 이동하는 Intent 객체 생성  (교재 10장 27페이지 4~5라인 참조)*/
                        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
          /*6.2
             6.1의 Intent 객체에 각 그림의 투표 개수가 저장된 배열 voteCount 저장  (교재 10장 27페이지 6라인 참조)*/
                        intent.putExtra("VoteCount", voteCount);
          /*6.3
              6.1의 Intent 객체에 각 그림의 이름이 저장된 imageName 저장(교재 10장 27페이지 7라인 참조)*/
                        intent.putExtra("ImageName", imgName);

                        String firstImageName;//일등한 그림의 이름을 저장할 변수
                        int firstImageId;//일등한 그림의 아이디를 저장할 변수
                        firstImageName = imgName[0];//기본값으로 첫번째 그림의 이미지를 대입
                        firstImageId = imageFileId[0];//기본값으로 첫번째 이미지의 아이디 대입
                        int firstCount;//일등한 그림의 투표수를 저장할 변수
                        firstCount = voteCount[0];//기본으로 첫번째 그림의 투표수를 저장

                        for (int i = 1; i < voteCount.length; i++) {
                            if (firstCount < voteCount[i]) {//voteCount[i]의 투표수가 더 크면
                                firstImageId = imageFileId[i];//이미지의 아이디를 i번째 그림의 이미지 아이디로 수정
                                firstImageName = imgName[i];//i번째 이미지 이름으로 설정
                                firstCount = voteCount[i];//i번째 투표수로 firstCount 수정
                            }
                        }
       /*  6.5
        *   6.1의 Intent 객체에 일등한 그림의 아이디 firstImageId 저장*/
                        intent.putExtra("FirstImageId", firstImageId);
       /*  6.5
         *   6.1의 Intent 객체에 일등한 그림의 이름 firstImageName 저장*/
                        intent.putExtra("FirstImageName", firstImageName);
         /* 6.6
           *  ResultActivity로 화면 전환
        * */
                        startActivity(intent);
                    }
                }
        );
    }
}
