package com.coffee.exam_20170309;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.japisoft.formula.Formula;
import com.japisoft.formula.FormulaFactory;
import com.japisoft.formula.Variant;
import com.japisoft.formula.node.EvaluateException;

public class Ex03 extends AppCompatActivity {
    FormulaFactory mFac;

 /*1.화면의 TextView를 저장할 변수*/
TextView resultView;

    /*클릭한 버튼의 계산식이 저장될 변수*/
    String input="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex03);

        resultView =(TextView) findViewById(R.id.resultView);

    }
    //3.버튼 클릭시 호출
    //매개변수:view -클릭당한 버튼객체
    public void clickButton(View view){

        Button clickButton=(Button)view;

        String clickText = clickButton.getText().toString();

       // Toast.makeText(Ex03.this,clickText,Toast.LENGTH_SHORT).show();


        if(clickText.equals("=") || clickText == "="){
           // input+=clickText;
            Toast.makeText(Ex03.this,input,Toast.LENGTH_SHORT).show();
            // 계산 하는 영역
            //Formula mFormula=mFac.getNewFormula(input);
            //Formula mFormula=mFac.getFormula(input);
            Formula mFormula = new Formula(input);
            Variant variant=null;
            try {
                variant = mFormula.evaluate();
            } catch (EvaluateException e) {
                e.printStackTrace();
            }

            resultView.setText(variant.toString());
            input="";
        }
        else if(clickText.equals("DEL") || clickText == "DEL"){

            if(input!=null && !input.equals(null) && input.length()>=1){

                if(input.length()>1){
                  input= input.substring(0,input.length()-1);
                }else {
                    input="";
                }

            }

            resultView.setText(input);

        }else {
            //input에 저장하는 영역
            input+=clickText;

            resultView.setText(input);
        }





        /*
        * 3.1 클릭당한 버튼객체 view를 Button타입 변수 clickButton 에 저장
        *  Button clickButton=(Button)view;
        * */
        /*3.2 .클릭당한 버튼의 텍스트를 변수에 저장
        * 클릭당한 버튼의 텍스트는 clickButton.getText()로 리턴받는다
        * */
        /*3.3  3.2의 값이 "=" 또는 "DEL" 이 아닐때
               3.3.1 클릭당한 버튼의 텍스트를 속성 input에 추가
               3.3.2  input을 1의 TextView에 출력
                      1객체.setText(input);


         3.4   3.2의 값이 "=" 일때
               3.4.1 input문자열에 저장된 수식을 계산해줄 Formula 객체 생성
                    Formula mFormula=mFac.getFormula(input);
               3.4.2
                     Variant variant=null;
               3.4.3
                    3.3.1의 객체를 이용해서 input 문자열의 수식을 계산하고 계산결과를
                     variant 객체에 저장 (try~catch 필요)
                     variant = mFormula.evaluate();

                     즉 문자열 변수 input에 저장된 값이 "30*2+3" 이라면
                     mFormula.evaluate() 를 실행하면
                     문자열에 저장된값 "30*2+3" 을 계산해서 63을 리턴

               3.4.4 variant를 문자열로 변환해서 1의 객체에 출력
                     1객체.setText(variant.toString());
               3.4.5 input에 "" 대입

          3.5 3.2의 값이 "DEL" 일때
              3.5.1 input이 null이 아니고 input.length()가 1이상일때
                    3.5.1.1
                      input의 글자수 즉 length()가 1이면
                      input="";
                    3.5.1.2
                      input의 글자수 즉 length()가 1초과면
                      input에서 첫글자부터 마지막 글자 앞까지 잘라서 input에 대입
                      첫글자부터 마지막 글자 앞까지 자를려면
                      input.substring(0,input.length()-1)


                  3.5.1.
                      input을 1의 TextView에 출력
                      1의 TextView객체.setText(출력할문자열)

        *
        * */
    }
}
