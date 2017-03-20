package com.coffee.android_20170317;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ch12_page20 extends AppCompatActivity {

  // 뷰에 있는 위젯 들
  EditText edtInputName, edtInputNumber, edtOutputName, edtOutputNumber;
  Button btnInit, btnInsert, btnSearch;

  // DB 관련
  coffeeDBHelper cDBHelper;
  SQLiteDatabase sqlDB;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch12_page20);

    edtInputName = (EditText) findViewById(R.id.edt_input_name);
    edtInputNumber = (EditText) findViewById(R.id.edt_input_number);
    edtOutputName = (EditText) findViewById(R.id.edt_output_name);
    edtOutputNumber = (EditText) findViewById(R.id.edt_output_number);
    btnInit = (Button) findViewById(R.id.btn_init);
    btnInsert = (Button) findViewById(R.id.btn_insert);
    btnSearch = (Button) findViewById(R.id.btn_search);

    // db helper 객체 생성하기
    cDBHelper = new coffeeDBHelper(this);

    // 입력 버튼 기능 넣기
    btnInsert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // sqlDB에 쓰기 넣기
        sqlDB = cDBHelper.getWritableDatabase();

        // sqlDB.execSQL("실행할 쿼리");
        sqlDB.execSQL("INSERT INTO groupTBL VALUES ('"
            + edtInputName.getText().toString() + "',"
            + edtInputNumber.getText().toString() + ");");

        // db 연결 종료
        sqlDB.close();

        // 내가 알수있게 메세지 한개
        Toast.makeText(Ch12_page20.this, "입력됨", Toast.LENGTH_SHORT).show();
      }
    });

    // 조회 버튼 기능 넣기
    btnSearch.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // sqlDB에 읽기 넣기
        sqlDB = cDBHelper.getReadableDatabase();

        // 조회 결과를 넣을 Cursor 객체를 한개 만들어 둠
        Cursor cursor;

        // rawQuery 한줄씩 받음
        // cursor = sqlDB.rawQuery("실행할 쿼리"); / 받은 결과는 cursor 에 넣음
        cursor = sqlDB.rawQuery("select * from groupTBL;", null);

        String strName = " 그룹이름 \r\n----------------\r\n";
        String strNumber = " 인원 \r\n------------------\r\n";

        // cursor.moveToNext() / 조회 결과 한줄 가져오기 / 있으면 true 없으면 false를 반환함
        while (cursor.moveToNext()) {
          // cursor.getString(0) / 이제 한칸씩 가져오기
          strName += cursor.getString(0) + "\r\n";
          strNumber += cursor.getString(1) + "\r\n";
        }

        // 다 넣었으면 edt에 출력
        edtOutputName.setText(strName);
        edtOutputNumber.setText(strNumber);

        // 커서객체랑 DB연결 닫아주기
        cursor.close();
        sqlDB.close();

      }
    });

    // 초기화 버튼 기능 넣기
    btnInit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 테이블을 아예 삭제시킬거임 ㅇ
        sqlDB = cDBHelper.getWritableDatabase();
        // 테이블 삭제
        sqlDB.execSQL("delete from groupTBL;");
        // 닫기
        sqlDB.close();
      }
    });
  }
}
