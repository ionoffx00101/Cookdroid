package com.cookandroid.android_20170307_01;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

        /* 버튼 기능 추가 */
    // activity_main에 있는 버튼을 받아와서 리스너를 넣어줄 버튼 객체를 만든다
    Button buttonAddClick;

    // buttonAddClick 객체에 activity_main에 만들어둔 버튼을 리턴받아 넣는다
    buttonAddClick = (Button) findViewById(R.id.buttonInView); // findViewById(R.id.버튼아이디)

    // buttonAddClick에 클릭리스너를 세팅한다
    buttonAddClick.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) // 매개변수 v에는 버튼 정보가 담겨있다
      {
        String msg = ((Button) v).getText().toString(); //v.getText() 는 버튼에 담긴 메세지를 가져옴
        Toast.makeText(MainActivity.this, "버튼 누름" + msg, Toast.LENGTH_SHORT).show();
      }
    });

        /* 라디오 버튼 클릭시 메세지 출력 기능 추가 */
    RadioGroup radioGroupAddClick = (RadioGroup) findViewById(R.id.radioGroupInView);

    radioGroupAddClick.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) // group > Radio그룹객체, checkedId > 선택한 라디오버튼의 id 저장
      {
        String msg;

        // 1
        RadioButton clickRadioButton = (RadioButton) findViewById(checkedId);
        String checkIdgetText = clickRadioButton.getText().toString();

        // 2
        if (checkedId == R.id.female) {
          msg = "여자";
        } else {
          msg = "남자";
        }
        // 메세지로 제작해서 출력
        //1
        Toast.makeText(MainActivity.this, checkIdgetText, Toast.LENGTH_SHORT).show();
        //2
        //Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();

      }
    });
  }
}
