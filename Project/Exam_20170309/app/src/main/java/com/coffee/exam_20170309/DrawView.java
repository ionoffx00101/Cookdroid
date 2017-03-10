package com.coffee.exam_20170309;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class DrawView extends View {
  /*화면에서 터치한 곳의 x좌표와 y좌표를 저장하는 리스트*/
  ArrayList<Point> pointList = new ArrayList<Point>();

  Paint paint;

  public DrawView(Context context, AttributeSet attrs) {
    super(context, attrs);
    //선의 모양을 설정하는 객체
    paint = new Paint();
    //선의 두께를 설정 -값이 커질수록 선이 두꺼위지니 보고 마음에 드는 두께로 수정
    paint.setStrokeWidth(3);
    //선의 색을 설정 -검정색
    paint.setColor(Color.BLACK);
    //선의 모양을 매끄럽게 설정
    paint.setAntiAlias(true);
  }

  // 1. Ex02로 paint객체롤 보내서 색을 바꿀 수 있게 해준다
//public Paint getPainting(){
// return paint;
//}

  // 2. 바꾸는 메소드
//  public void changePenColor(){
//    paint.setColor(Color.RED);
//  }
//public void clickBtnPenChange(View view){
//  int a = view.getId();
//  paint.setColor(Color.RED);
//}
  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {

      Point point = new Point();
      point.setX(Math.round(event.getX())); // 흠.. 형변환을 꼭 해줘야하나 어차피 좌표는 소수아닌가
      point.setY(Math.round(event.getY()));
      point.setIsDraw(false);

      pointList.add(point);

    } else if (event.getAction() == MotionEvent.ACTION_MOVE) {//화면에서 손을 이동할떄


      Point point = new Point();
      point.setX(Math.round(event.getX())); // 흠.. 형변환을 꼭 해줘야하나 어차피 좌표는 소수아닌가
      point.setY(Math.round(event.getY()));
      point.setIsDraw(true);

      pointList.add(point);

    }
    invalidate();

    return true;
  }

  @Override
  protected void onDraw(Canvas canvas) {
    //화면의 배경색을 설정
    canvas.drawColor(Color.WHITE);

    for (int i = 0; i < pointList.size() - 1; i++) {
      int startX, startY, endX, endY;

      Point startPoint = pointList.get(i);

      if (startPoint.getIsDraw()) {

        Point endPoint = pointList.get(i + 1);
        if (endPoint.getIsDraw()) {
          startX = startPoint.getX();
          startY = startPoint.getY();
          endX = endPoint.getX();
          endY = endPoint.getY();

          canvas.drawLine(startX, startY, endX, endY, paint);
        }
      }

    }


  }
}
