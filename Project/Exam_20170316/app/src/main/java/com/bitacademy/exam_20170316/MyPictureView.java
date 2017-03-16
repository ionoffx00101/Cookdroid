package com.bitacademy.exam_20170316;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;


public class MyPictureView extends View {
  String imagePath;//보여줄 이미지 경로가 저장될 배열

  public MyPictureView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (imagePath != null) {
      //1.imagePath의 이미지를 화면 중앙에 출력
      // -이미지를 출력하는건 교재 8장 30페이지 참조
      //- 이지지 파일을 중앙에 출력하는것은 교재 9장 18 페이지 14번째줄 ~ 16번째 줄 참조
      Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
      int picX = (this.getWidth() - bitmap.getWidth()) / 2;
      int picY = (this.getHeight() - bitmap.getHeight()) / 2;

      canvas.drawBitmap(bitmap, picX,picY, null);
      bitmap.recycle();
    }
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }
}
