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
    // 파라미터로 들어온 쿼리문을 이용해서 쿼리문을 실행해야한다
    // db.execSQL("쿼리문";);
    db.execSQL("create table groupTBL (gName char(20) primary key, gNumber integer);");

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // 테이블 업데이트
    // 기존에 있었던 테이블 지우기
    db.execSQL("drop table if exists groupTBL");

    // onCreate 호출해서 테이블 다시 만들기
    onCreate(db);
  }
}
