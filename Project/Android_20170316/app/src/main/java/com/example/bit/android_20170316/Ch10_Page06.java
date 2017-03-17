package com.example.bit.android_20170316;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ch10_Page06 extends AppCompatActivity {
    Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch10__page06);
        btnNewActivity=(Button)findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(),
                               SecondActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
