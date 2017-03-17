package com.example.bit.android_20170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ch10_Page31_1 extends AppCompatActivity {
    Button btnNewActivity;
    EditText edtNum1, edtNum2;
    Button btnNewActivity3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch10__page31_1);
        btnNewActivity=(Button)findViewById(R.id.btnNewActivity);
        btnNewActivity3=(Button)findViewById(R.id.btnNewActivity3);

        edtNum1=(EditText)findViewById(R.id.edtNum1);
        edtNum2=(EditText)findViewById(R.id.edtNum2);

        btnNewActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(),SecondActivity.class);

                        String strnum1=edtNum1.getText().toString();
                        String strnum2=edtNum2.getText().toString();
                        int num1=Integer.parseInt(strnum1);
                        int num2=Integer.parseInt(strnum2);

                        intent.putExtra("NUM1",num1);
                        intent.putExtra("NUM2",num2);

                        //startActivity(intent);
                        startActivityForResult(intent,0);
                    }
                }
        );
        btnNewActivity3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(),ThirdActivity.class);

                        String strnum1=edtNum1.getText().toString();
                        String strnum2=edtNum2.getText().toString();
                        int num1=Integer.parseInt(strnum1);
                        int num2=Integer.parseInt(strnum2);

                        intent.putExtra("NUM1",num1);
                        intent.putExtra("NUM2",num2);

                        //startActivity(intent);
                        startActivityForResult(intent,1);
                    }
                }
        );
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Toast.makeText(getApplicationContext(),
                "onActivityResult:resultCode="+resultCode+",data="+data,Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"requestCode="+requestCode,
                 Toast.LENGTH_SHORT).show();

        if(resultCode==RESULT_OK){
            if(requestCode==0) {
                int hap = data.getIntExtra("HAP", 0);
                Toast.makeText(getApplicationContext(), "hap=" + hap, Toast.LENGTH_SHORT).show();
            }else{
                int muti=data.getIntExtra("MULTI",0);
                Toast.makeText(getApplicationContext(),"multi="+muti,Toast.LENGTH_SHORT).show();
            }
        }

    }
}
