package com.example.bit.android_20170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Button btnReturn;
    int hapValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent intent=getIntent();
        int num1=intent.getIntExtra("NUM1",0);
        int num2=intent.getIntExtra("NUM2",0);
        int num3=intent.getIntExtra("NUM3",0);

        hapValue=num1+num2;

        Toast.makeText(SecondActivity.this,"SecondActivity:num1="+num1+",num2="+num2
           +",num3="+num3,Toast.LENGTH_SHORT).show();


        btnReturn=(Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent outIntent=new Intent();
                        outIntent.putExtra("HAP",hapValue);

                        setResult(RESULT_OK,outIntent);

                        finish();
                    }
                }
        );
    }
}
