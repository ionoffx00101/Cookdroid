package com.bitacademy.exam_20170308;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Ex02 extends AppCompatActivity {
    /*
        * 1.화면의 EdiText
        * 화면의 2개의 버튼
        * 화면의 2개의 RadioButton
        * 화면의  ImaveView를
        * 저장할 변수를 각각 선언한다
         *
        **/
    EditText inputURL;
    Button btn01,btn02;
    RadioGroup rg;
    RadioButton rb01,rb02,rb03;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex02);

        // 타이틀 바꾸기
        setTitle("있어보이는 프로그램");

        // 리턴 받기
        inputURL = (EditText) findViewById(R.id.inputURL);
        btn01 =(Button) findViewById(R.id.ex02Btn01);
        btn02 =(Button) findViewById(R.id.ex02Btn02);
        rg = (RadioGroup) findViewById(R.id.ex02RadioBtnGroup);
        rb01 = (RadioButton)findViewById(R.id.ex02RadioBtn01);
        rb02 = (RadioButton)findViewById(R.id.ex02RadioBtn02);
        rb03 = (RadioButton)findViewById(R.id.ex02RadioBtn03);
        image = (ImageView) findViewById(R.id.imageView);

        // 버튼 두개에 기능 넣기
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ex02.this,inputURL.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(inputURL.getText().toString()));
                startActivity(intent);
            }
        });

        // 라디오 버튼 기능 넣기
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==R.id.ex02RadioBtn01){
                    image.setImageResource(R.drawable.jellybean);
                }else if(checkedId==R.id.ex02RadioBtn02){
                    image.setImageResource(R.drawable.kitkat);
                }else if(checkedId==R.id.ex02RadioBtn03){
                    image.setImageResource(R.drawable.lollipop);
                }else{
                    image.setImageResource(R.drawable.jellybean);
                }

            }
        });
                /*
        2.화면의 타이틀을 "좀 그럴듯한 응용프로그램" 으로 설정한다
        3. 화면의 EditText,
           화면의 버튼 2개
           화면의 2개의 RadioButton
           화면의 ImagetView를
           각각 1의 변수에 저장한다
         4. 화면의 글자 나타내기 버튼을 클릭했을때
            EditText의 입력한 글자를 Toast로 출력한다
            -버튼 클릭 처리
             교재 4장 27페이지 참조
            -EditText에 입력한 내용 리턴
            교재 4장 29페이지 참조
            Toast객체 이용
            -Android_20170308_1 프로젝트 Ch04_Page38.java 참조

         5.홈페이지 열기 버튼 을 클릭했을때
           EditText에 입력한 URL로 이동
           -EditText에 입력한 내용 리턴
            교재 4장 29페이지 참조
           - 특정 홈페이지 열기 홈페이지 url입력시 앞에 http://홈페이지url 형식으로 입력해야함

        Intent intent=new Intent(Intent.ACTION_VIEW,
                 Uri.parse("이동할홈페이지 URL"));
        Ex01.this.startActivity(intent);

        6.라디오 버튼 클릭 처리
		Android_20170307_1 프로젝트의 MainActivity 참조 
          -이미지를 바꿀려면
           이미지뷰객체.setImageResource(R.drawable.이미지파일명(확장자제외))

        * */
    }
}
