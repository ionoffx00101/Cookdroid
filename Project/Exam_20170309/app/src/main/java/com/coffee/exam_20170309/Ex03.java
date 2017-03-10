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

    }
}
