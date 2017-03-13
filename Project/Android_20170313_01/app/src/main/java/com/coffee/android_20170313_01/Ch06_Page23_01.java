package com.coffee.android_20170313_01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class Ch06_Page23_01 extends AppCompatActivity {

  Button button;
  ProgressBar progressBar;
  SeekBar seekBar;

  EditText editText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page23_01);

    button = (Button) findViewById(R.id.button);
    progressBar = (ProgressBar) findViewById(R.id.progressBar);
    seekBar = (SeekBar) findViewById(R.id.seekBar);

    editText = (EditText) findViewById(R.id.editText);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Toast.makeText(Ch06_Page23_01.this, progressBar.getProgress() + " || " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
        // Async 돌리기
        changeTask chTask = new changeTask();
        chTask.execute();

      }
    });

    // 반복문 돌려줄 쓰레드 1이 더 필요하다
    // increaseThread inThread = new increaseThread();
    // inThread.start();



  }

  public class increaseThread extends Thread {
    public void run() {
      for (; progressBar.getProgress() < 100; ) {
        progressBar.setProgress(progressBar.getProgress() + 10);

        try {
          Thread.sleep(500);
        } catch (Exception e) {
          e.printStackTrace();
        }
        if (progressBar.getProgress() >= 100) {
          progressBar.setProgress(0);
        }
      }
    }

  }

  // 파라미터 형 먼저 쓰고 리턴타입 차례로 쓰고
  // ㄴㄴ
  // AsyncTask<Params, Progress, Result>
  // doInBackground params
  // progress params
  // doInBackground return type
  class changeTask extends AsyncTask<Void, Integer, Void> {

    public Void doInBackground(Void... params) {

      for (int i = 0; i < 100; ) {
        this.publishProgress(i);
        try {
          Thread.sleep(500);
        } catch (Exception e) {
          e.printStackTrace();
        }
        if (i >= 100) {
          i = 0;
        }
        i = i+10;
      }

      return null;

//      for (; progressBar.getProgress() < 100; ) {
//        progressBar.setProgress(progressBar.getProgress() + 10);
//
//        try {
//          Thread.sleep(500);
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//        if (progressBar.getProgress() >= 100) {
//          progressBar.setProgress(0);
//        }
//      }
    }

    // 위젯을 건드릴 수 있는건 이 메서드뿐이다.
    public void onProgressUpdate(Integer ... param) {
      progressBar.setProgress(param[0]);
      editText.append(progressBar.getProgress() + " \n");
    }

  }
}
