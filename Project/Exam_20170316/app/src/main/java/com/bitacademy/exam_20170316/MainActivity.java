package com.bitacademy.exam_20170316;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent=null;
        switch(position){
            case 0:
                intent=new Intent(this,Ex01.class);
                break;

            default:
                intent=new Intent(this,Ex02.class);
                break;
        }
        startActivity(intent);
    }
}
