package com.bitacademy.exam_20170316;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex01 extends AppCompatActivity {
    /*
           1.이전그림버튼
             다음그림 버튼
              현재 그림 인덱스를 보여주는 텍스트 뷰
            /전체 그림수를 보여주는 텍스트 뷰
             MyPictureView 객체를
             저장할 변수를 선언한다
             -교재 8장 33페이지 참고

             현재 그림 인덱스를 보여주는 텍스트 뷰
            /전체 그림수를 보여주는 텍스트 뷰 가 없으므로
              추가 할것
       * */
    Button btnPrev, btnNext;
    TextView cIndex, tCount;
    MyPictureView myPictureView1;


    int curNum;
    File[] imageFiles;
    String imageFname;
    //raw 폴더에 저장된 이미지 파일명들이 저장된 배열
    String[] rawFolderImageName = {
            "renoir01.png",
            "renoir02.png",
            "renoir03.png",
            "renoir04.png",
            "renoir05.png"
    };
    //raw 폴더에 저장된 이미지 파일들의 아이디가 저장된 배열
    int[] rawFolderImageId = {
            R.raw.renoir01,
            R.raw.renoir02,
            R.raw.renoir03,
            R.raw.renoir04,
            R.raw.renoir05
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);
        verifyStoragePermissions(this);

        /*2. 1의 변수에 이전그림버튼
          다음그림 버튼

          현재 그림 인덱스를 보여주는 텍스트 뷰
         /전체 그림수를 보여주는 텍스트 뷰
          MyPictureView 객체를 대입한다 */
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        cIndex = (TextView) findViewById(R.id.cIndex);
        tCount = (TextView) findViewById(R.id.tCount);
        myPictureView1 = (MyPictureView) findViewById(R.id.myPictureView1);

        /*4  이미지는 SD 카드의 picture라는 경로에 저장하려고 한다
             SD 카드의 picture라는 폴더가 없으면 생성한다
             4.1 SD 카드의 경로를 리턴받는다
             -교재 8장 24페이지 예제의 8번째줄 9번째 줄 참조
             */
        String absoluteSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        /*
             4.2 4.1의 경로+"/picture 라는 폴더를 관리할 File 객체 생성해서 변수에 저장
             -교재 8장 24페이지 10번째줄 참조
        */
        File file = new File(absoluteSDPath + "/picture");
        /*
             4.3 4.2 객체에 picture 폴더가 존재하지 않는다면
                  - 4.2객체.exist()==false
             4.3.1  폴더를 생성한다
                   교재 8장 24페이지 14번째줄 참조
          * */
        if (file.exists() == false) {
            file.mkdir();
        }


        /*
        보여줄 이미지 파일은 res/raw 폴더에 저장되있다
        *   SD 카드의 pictue 폴더에 이 이미지가 존재하지 않는다면
         *   이 이미지를 SD 카드에 복사하려고 한다
        *   raw 폴더에 저장된 이미지 파일들의 이름은 속성
        *   rawFolderImageName 에 배열로 저장되 있다
        */
        for (int i = 0; i < rawFolderImageName.length; i++) {
         /*
            *  5.1 4.1의 SD카드경로+"/picture/"+rawFolderImageName[i] 를 String 변수에 저장
         */
            String picturePath = absoluteSDPath + "/picture/" + rawFolderImageName[i];
            /*
            *  5.2 5.1의 파일을 관리하는 File 객체를 생성해서 변수에 저장
            *   - new File(5.1변수)*/
            File pictureFile = new File(picturePath);







              /*
            *  5.3  5.2 의 경로의 파일이 존재하지 않는다면
             *    5.2객체.exist()==false
             */
            if (pictureFile.exists() == false) {
                try {
                     /*   5.3.1
              *      5.2 객체를 raw폴더에서 읽어오는 InputStream 객체 생성해서 변수에 저장
              *       getResources().openRawResource(rawFolderImageId[i])
              *       교재 8장 18페이지 참조
              */
                    InputStream inputStream = getResources().openRawResource(rawFolderImageId[i]);
                    /*   5.3.2
               *      5.3.1 이 읽어올 이미지 파일의 사이즈 만큼 byte 배열을 생성
               *      byte[] img=new byte[5.3.1객체.avaliable()];
               */
                    byte[] image = new byte[inputStream.available()];
                    /*  5.3.3
                   *  raw 폴더의 i번째 이미지를 읽어서 img 배열에 저장
                   *  5.3.1 객체.read(img);
                   */
                    inputStream.read(image);

                 /*5.3.4
                    img 폴더에 저장된 이미지파일의 내용을 SD 카드의 picture 폴더에 저장할
                    FileOutputStream 객체 생성

                    FileOutputStream toSDcardPicturFolder=
                       new FileOutputStream(5.2객체);
                */
                    FileOutputStream toSDCardPictureFolder = new FileOutputStream(pictureFile);
                     /*5.3.5
                       img 폴더에 저장된 내용을 SD카드의 pictue 폴더로 출력
                       toSDCardPictureFolder.write(img);
                       toSDCardPictureFolder.flush();
                   */
                    toSDCardPictureFolder.write(image);
                    toSDCardPictureFolder.flush();
                    /*5.3.6
                       5.3.1 객체.close();
                  */
                    inputStream.close();
                    /*5.3.7
                      toSDCardPictureFolder.close();
            * */
                    toSDCardPictureFolder.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
         /*
        * 6. SD 카드의 picture 폴더에 저장된 파일 리스트를 리턴해서 속성 imgFiles에 저장
        *   - 교재 8장 34페이지 참조
        */
        imageFiles = new File(absoluteSDPath + "/picture").listFiles();
          /*
          7. imageFiles배열의 length를
            1에서 전체 파일의 수를 출력하는 텍스트 뷰에 "/"+imageFiles배열의 length
            출력
        * 7.imgFiles배열의 0번째 파일을 속성 imgFname에 대입*/
        tCount.setText("/" + imageFiles.length);
        imageFname = imageFiles[0].toString();
          /*
          8. 1의 MyPictureView 변수의 imgePath 속성에 7의 변수 대입*/
        myPictureView1.imagePath = imageFname;


        /*
          9. 이전그림버튼을 클릭했을때*/
        btnPrev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
          /*
             9.0 curNum 1감소*/
                        curNum--;
          /*
            9.1  curNum이 0이하면
              - curNum에 imageFiles.length-1 대입*/
                        if (curNum < 0) {
                            curNum = imageFiles.length - 1;
                        }
          /*
            9.2
               imageFname 속성에 imageFiles[curNum] 번째 이미지 파일 이름 대입
             */


                        imageFname = imageFiles[curNum].toString();
                        //  1의 MyPictureView 변수의 imgePath 속성에 imageFname 대입
                        myPictureView1.imagePath = imageFname;
                         /*  1의 MyPictureView 변수의 onDraw()메서드를 호출하고 화면을 갱신할
               1의 MyPictureView 변수의 invalidate() 메서드 호출
               -교재 8장 35페이지 참조*/
                        myPictureView1.invalidate();
          /*
            9.3 curNum+1 을 문자로 변환해서 1에서 현재 이미지파일의 인덱스를 출력하는
               TextView에 출력
               -curNum+1을 문자로 변환
               new Integer(curNum+1).toString()*/
                        cIndex.setText(new Integer(curNum + 1).toString());
                    }
                }
        );
          /*
           10. 다음 그림버튼을 클릭했을때*/
        btnNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
          /*
             10.0    curNum 1 증가*/
                        curNum++;
          /*
            10.1  curNum이 imageFiles.length-1 이상이면
              - curNum에 0대입*/
                        if (curNum > imageFiles.length - 1) {
                            curNum = 0;
                        }
          /*
            10.2
               imageFname 속성에 imageFiles[curNum] 번째 이미지 파일 이름 대입
               */



                        imageFname = imageFiles[curNum].toString();
                        //1의 MyPictureView 변수의 imgePath 속성에 imageFname 대입
                        myPictureView1.imagePath = imageFname;
                        //1의 MyPictureView 변수의 onDraw()메서드를 호출하고 화면을 갱신할
                        /*1의 MyPictureView 변수의 invalidate() 메서드 호출
               -교재 8장 35페이지 참조*/
                        myPictureView1.invalidate();
          /*
            10.3
               curNum+1 을 문자로 변환해서 1에서 현재 이미지파일의 인덱스를 출력하는
               TextView에 출력
               -curNum+1을 문자로 변환
             new   Integer(curNum_1).toString()
        * */
                        cIndex.setText(new Integer(curNum + 1).toString());
                    }
                }
        );

    }

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(
                activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
