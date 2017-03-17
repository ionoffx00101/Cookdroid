package com.coffee.android_20170317;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BIT on 2017-03-17.
 */

public class coffeeDBHelper extends SQLiteOpenHelper{


  public coffeeDBHelper(Context context) {
    //super(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    super(context,"groupDB",null,1);
  }


  @Override
  public void onCreate(SQLiteDatabase db) {
    // 테이블 생성
    // 이 SQLite와 연결된 앱을 처음 설치 시 실행된다.

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // 테이블 업데이트


  }
}
