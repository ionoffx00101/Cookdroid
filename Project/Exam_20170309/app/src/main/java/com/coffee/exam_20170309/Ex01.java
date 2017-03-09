package com.coffee.exam_20170309;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Ex01 extends AppCompatActivity {
    /*1.화면의 스위치
       *   라디오그룹
       *   텍스트뷰
       *   버튼2개를
       *   각각 저장할 변수들을 선언
       *
       * */

  TextView textView03;
  Switch switch01;
  RadioGroup radioGroup01;
  RadioButton radioButton01,radioButton02,radioButton03;
  Button button01, button02;
  ImageView imageView01;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ex01);

    switch01 = (Switch)findViewById(R.id.ex01_switch_01);
    textView03 = (TextView)findViewById(R.id.ex01_textView_03);

    radioGroup01 = (RadioGroup)findViewById(R.id.ex01_radioGroup_01);

    radioButton01 = (RadioButton)findViewById(R.id.ex01_radioButton_01);
   radioButton02 = (RadioButton)findViewById(R.id.ex01_radioButton_02);
    radioButton03 = (RadioButton)findViewById(R.id.ex01_radioButton_03);

    button01 = (Button) findViewById(R.id.ex01_button_01);
    button02 = (Button) findViewById(R.id.ex01_button_02);

    imageView01 = (ImageView) findViewById(R.id.ex01_imageView_01);

    switch01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
          textView03.setVisibility(View.VISIBLE);
          radioGroup01.setVisibility(View.VISIBLE);
        }else {
          textView03.setVisibility(View.INVISIBLE);
          radioGroup01.setVisibility(View.INVISIBLE);
          imageView01.setVisibility(View.INVISIBLE);
        }
      }
    });

    radioGroup01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        imageView01.setVisibility(View.VISIBLE);
        if(checkedId==R.id.ex01_radioButton_01){
          imageView01.setImageResource(R.drawable.jellybean);
        }else if(checkedId==R.id.ex01_radioButton_02){
          imageView01.setImageResource(R.drawable.kitkat);
        }else if(checkedId==R.id.ex01_radioButton_03){
          imageView01.setImageResource(R.drawable.lollipop);
        }
      }
    });

    button01.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Ex01.this.finish();
      }
    });

    button02.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        radioGroup01.clearCheck();
        imageView01.setImageResource(0);
        //setChecked(false);
      }
    });

        /*
        * 2. 화면의 스위치
        * 텍스트뷰
    *   라디오버튼 3개
    *   버튼2개를 1의 변수에 저장
     *   교재 4장 9페이지 참조
        * */

        /*3.
        * 스위치를 선택했을때 실행될 메서드를 구현
        *
         * 교재 4장 38페이지 참조
         *


         * 스위치 객체가 on 상태일때
         * 화면의 텍스트뷰 버튼2개 라디오버튼3개 이미지뷰를 보이도록 설정

           객체.setVisibility(View.VISIBLE);

         * 스위치 객체가 off 상태일때
         * 화면의 텍스트뷰 버튼2개 라디오버튼3개 이미지뷰를 안보이도록 설정
           객체.setVisibility(View.INVISIBLE);

           -교재 4장 49페이지 참조
          */
        /*
        * 4.라디오 버튼 선택했을때 실행될 메서드를 구현
        * -setOnCheckedChangeListener
         * -교재  155페이지 3번 참조
         *
         * 라디오 버튼을 선택했을때 이미지뷰에 선택한 라디오 버튼에 해당하는 이미지 출력
         * 이미지뷰객체.setImageResource(R.drawable.이미지파일명 (확장자제외))
        *
        * */
        /*5.처음으로 버튼 클릭시
        *  모든 라디오버튼의 선택 취소
        *  라디오버튼객체.setChecked(false);
        *
        *
        * */

        /*6.종료버튼 클릭시
        *
        액티비티 종료
        Exam_20170308의 Ex01 참조
        * */
  }
}
