package com.coffee.exam_20170309;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {

      Point point = new Point();
      point.setX(Math.round(event.getX())); // 흠.. 형변환을 꼭 해줘야하나 어차피 좌표는 소수아닌가
      point.setY(Math.round(event.getY()));
      point.setIsDraw(false);

      pointList.add(point);

                     /*
            * 1.터치한  X좌표를 변수에 저장
            *   터치한 X좌표는 event.getX()
            *
            * 2.터치한  y좌표를 변수에 저장
            *   터치한 y좌표는 event.getY()
            *
            * 3.Point 객체 생성
            *
              4.3객체의 x속성에 1의 변수 저장

              5.3객체의 y속성에 2의 변수 저장

              6 3객체의 isDraw 속성에 false 저장.

              7.3객체를 pointList에 추가
              */
    } else if (event.getAction() == MotionEvent.ACTION_MOVE) {//화면에서 손을 이동할떄


      Point point = new Point();
      point.setX(Math.round(event.getX())); // 흠.. 형변환을 꼭 해줘야하나 어차피 좌표는 소수아닌가
      point.setY(Math.round(event.getY()));
      point.setIsDraw(true);

      pointList.add(point);

      // invalidate();

      /*
            * 1.터치한  X좌표를 변수에 저장
            *   터치한 X좌표는 event.getX()
            *
            * 2.터치한  y좌표를 변수에 저장
            *   터치한 y좌표는 event.getY()
            *
            * 3.Point 객체 생성
            *
              4.3객체의 x속성에 1의 변수 저장

              5.3객체의 y속성에 2의 변수 저장

               6. 3객체의 isDraw 속성에 true 저장

              6.3객체를 pointList에 추가

              7. invalidate() 메서드를 실행
                - invaidate() : 화면을 모두 지우고 아래의 onDraw() 메서드를 실행시키는 메서드

            * */
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


            /*
            * 1.pointList에서 i번째 객체를 꺼내서 변수 startPoint 에 저장
            *
            * 2. startPoint의 isDraw 속성이 true 이면
                * 2.1pointList에서 i+1번째 객체를 꺼내서 변수 endPoint에 저장
                * 2.3.startPoint의 x좌표를 변수 startX에 저장
                * 2.4.startPont의 y좌표를 변수 startY에 저장
                * 2.5.endPoint의 x좌표를 변수 endX에 저장
                * 2.6.endPont의 y좌표를 변수 endY에 저장
                *
                * 2. 7.startX,startY 부터 endX,endY까지 선을 그림
                * canvas.drawLine(startX,startY,endX,endY,paint);
            * */
    }


  }
}
