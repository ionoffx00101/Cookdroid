package com.coffee.android_20170317;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Ch12_page20 extends AppCompatActivity {

  // 뷰에 있는 위젯 들
  EditText edtInputName,edtInputNumber,edtOutputName,edtOutputNumber;
  Button btnInit,btnInsert,btnSearch;

  // DB 관련
  coffeeDBHelper coffeeDBHelper;
  SQLiteDatabase sqlDB;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch12_page20);

    edtInputName =(EditText)findViewById(R.id.edt_input_name);
    edtInputNumber = (EditText)findViewById(R.id.edt_input_number);
    edtOutputName = (EditText)findViewById(R.id.edt_output_name);
    edtOutputNumber = (EditText)findViewById(R.id.edt_output_number);
    btnInit = (Button)findViewById(R.id.btn_init);
    btnInsert = (Button)findViewById(R.id.btn_insert);
    btnSearch = (Button)findViewById(R.id.btn_search);


  }
}
