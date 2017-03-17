package com.example.bit.android_20170316;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ch11_Page7 extends AppCompatActivity {
    String [] mid={"히어로즈","24시","로스트","로스트룸","스몰빌"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch11__page7);

        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1,mid); // 받는 텍스트가 android.text1이면 생략할수 있다.

        ListView list=(ListView)findViewById(R.id.listView1);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
