package com.coffee.exam_20170309;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Ex02 extends AppCompatActivity {

    // DrawView 리턴 받을 공간 생성
    // 형이 DrawView인가 View인가
    // 자체 클래스이니 DrawView 같다
    View drawview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);


    }

    public void penBtnClick(View view){

        Toast.makeText(Ex02.this,view.getId()+"",Toast.LENGTH_SHORT);
        // DrawView에서 정보가 담긴 paint객체를 리턴 받던지
        // DrawView에 새 메소드를 만들어서 그 메소드를 호출할 수 밖에 없는 것같다.
        // 아 어렵네
        // 아 Point 자체를 get할 수 도 있지 않을까
        // point 가 아니고 paint다 ㅇ..

        // 일단 여기로 paint객체를 받을 수 있게 해두었다
        // 여기서 코드가 늘어나는 게 좋은 건지 모르겠다
        // Paint paint = DrawView.getPaint();

        // 어차피 호출도 못하네 그 쪽으로 보내버려야겠다
        // DrawView.chagePenColor() 도 바로 안 되네양

        // 생성자 호출 이라고 하나 그거 해야하나
        // 아니 또 New 하면 안되잖앜ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
        // 아 돌겠녜
        //DrawView drawView = ;
        // 생성자 호출 ㄴㄴ해
        // DrawView 레이아웃에 id를 주고 R.java로 해당 레이아웃을 호출한 후 원하는 작업을 하면됨

        // 메소드 호출은 안되네
       // drawview.changePenColor();
       // drawview =(View) findViewById(R.id.drawView);
       // drawview;

        //paint.setColor(Color.RED);
    }
}
