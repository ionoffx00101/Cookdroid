package com.coffee.tab_cal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  // 계산중인걸 저장하는 공간을 만들어둔다.
  String saveTextInjava="";
  String resultTextInjava;

  Double resultDoubleSemi=0.0;
  Double resultDouble=0.0;
  // 리턴 받을 공간 만들어두기
  TextView saveTextView;
  TextView resultTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // 객체 리턴 받는다.
    saveTextView =(TextView)findViewById(R.id.save_text);
    resultTextView =(TextView)findViewById(R.id.result_text);


  }
  public void btnClick(View view){
    // v.getId() 버튼 id
    // v.getText() 버튼 text

    int clickId = view.getId();
    String clickText = ((Button)view).getText().toString();

    //Toast.makeText(MainActivity.this,clickText+"",Toast.LENGTH_SHORT).show();

    if(clickText.equals("+") || clickText == "+"){

    }else if(clickText.equals("-") || clickText == "-"){

    }else if(clickText.equals("*") || clickText == "*"){

    }else if(clickText.equals("/") || clickText == "/"){

    }else if(clickText.equals("C") || clickText == "C"){

    }else if(clickText.equals("ㅁ") || clickText == "ㅁ"){

    }
//    else {
//
//    }





    if(clickText.equals("=") || clickText == "="){
      Toast.makeText(MainActivity.this,clickText+"",Toast.LENGTH_SHORT).show();
      //계산 그냥 그때그때 받아서 처리하는게 ㅇㄷ인듯 ㅇㅇ ㄱ
//Fomula 공부하고 마저 하자..


      resultTextInjava = clickText + resultDouble;
      resultTextView.setText(resultTextInjava);
    }else {

//      if(!saveTextInjava.substring(saveTextInjava.length()).equals(".") && saveTextInjava.substring(saveTextInjava.length()) != ".") {
//        saveTextInjava += " ";
//      }

      if(!clickText.equals(".") && clickText != ".") {
        saveTextInjava += " ";
      }
      saveTextInjava += clickText;
      saveTextView.setText(saveTextInjava);
    }

  }
}
