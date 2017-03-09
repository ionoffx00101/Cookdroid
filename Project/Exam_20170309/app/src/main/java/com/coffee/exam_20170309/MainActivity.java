package com.coffee.exam_20170309;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

  ArrayList<String> menuList=new ArrayList<String>();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    menuList.add("Ex01");
    menuList.add("Ex02");
    menuList.add("Ex03");


    ArrayAdapter<String>arrayAdapter=
        new ArrayAdapter<String>(
            MainActivity.this,
            android.R.layout.simple_list_item_1,
            menuList
        );

    setListAdapter(arrayAdapter);
  }


  protected void onListItemClick(ListView l, View v, int position, long id) {
    Intent intent=null;



    switch (position){
      case 0:
        intent= new Intent(this,Ex01.class);
        break;
      case 1:
        intent= new Intent(this,Ex02.class);
        break;
      default:
        intent=new Intent(this,Ex03.class);
    }
    startActivity(intent);

  }
}
