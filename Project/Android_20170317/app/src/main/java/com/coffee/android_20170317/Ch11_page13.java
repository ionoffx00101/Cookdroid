package com.coffee.android_20170317;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Ch11_page13 extends AppCompatActivity {

  GridView gv_item;
  // 밖에 있는 그리드 어댑터 찾아오기
  GridAdapter gridAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch11_page13);
    setTitle("Grid View Test");

    gv_item = (GridView) findViewById(R.id.gv_item);
    // this가 가르키는 건 getApplicationContext()
    gridAdapter = new GridAdapter(this);
    // 그리드 뷰에 만든 그리드어댑터 설정
    gv_item.setAdapter(gridAdapter);

    gv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // parent - GridView
        // view - 클릭한 한 개의 이미지 뷰
        // position - 해당 아이템의 순서
        // id - 해당 아이템의 id

        // 여기 id는 다 똑같다.
        // 아까 말한 id를 포지션값으로 바꿔줘야한다는 건 여기서 써야할 것 같다.
        // 밑에 오버라이드 해둔 getItem 이랑 getItemId을 고쳐야한다

        ImageView itemOneClick = (ImageView) view;

        // 아까 고친 메소드들을 써보자
        Object getItemInGridAdapter = gridAdapter.getItem(position);
        long getItemIdInGridAdapter = gridAdapter.getItemId(position);

        // 다이아 로그에 넣기 위해 getItemInGridAdapter를 Integer로 형변환
        Integer selectItem = (Integer)getItemInGridAdapter;


        // 다이아로그
        AlertDialog.Builder dialog = new AlertDialog.Builder(Ch11_page13.this);

        // 다이아로그 세부 설정
        dialog.setTitle("제목");
        dialog.setIcon(R.mipmap.ic_launcher); // 제목 옆 아이콘 / api 25는 아이콘 그림이 mipmap 폴더에 있다
        dialog.setNegativeButton("닫기",null);

        // 보여주려는 다이아로그 페이지가 xml 이다 객체로 만들어서 dialog.setView() 에 넣어줘야한다.
        //View dialogXmlToView = View.inflate(Ch11_page13.this,R.layout.dialog_ch11_page13,null);
        View dialogXmlToView = View.inflate(Ch11_page13.this,R.layout.dialog_ch11_page13,null);
        dialog.setView(dialogXmlToView);

        // 다이아로그에 있는 이미지 뷰를 찾아옴
        ImageView imageViewInDialog = (ImageView)dialogXmlToView.findViewById(R.id.iv_dialog_poster);
        // 찾아온 이미지 뷰에 이미지를 넣어줌
        imageViewInDialog.setImageResource(selectItem);

        // 다이아로그 보여주세요
        dialog.show();

      }
    });

  }

  // GridView 는 항목의 모양, 항목 내용을 설정하는 BaseAdapter 를 상속받은 객체를 구현해야한다.
  class GridAdapter extends BaseAdapter {

    Context context;

    // 그림 파일 위치 배열 만들어 두기
    private int[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09};

    // 페이징이 하고 싶었다..
    //    int pageNow=0;
    //    int pageAll=0;
    //    int pageCut=0;

    public GridAdapter(Context c) {
      context = c;
    }

    @Override
    public int getCount() {
      // getCount() 했을때 posterID의 길이를 return해 주면 된다.

      // 페이징이 하고 싶었다..
      //      pageNow=2;
      //      pageCut=5;
      //      (posterID.length+(pageNow*pageCut))-1;

      return posterID.length;
    }

    // 포지션을 통해 아이템과 아이템의 id를 얻을 수있는 메소드들
    @Override
    public Object getItem(int position) {

      return posterID[position];
    }

    @Override
    public long getItemId(int position) {
      return position;
    }

    // 이 작업은 그리드 개수만큼 호출된다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ImageView imageView = null;

      if (convertView == null) { //convertView가 널일때만 새 이미지를 불러옴
        // 새 이미지 뷰 만들기
        imageView = new ImageView(context);
        // 이미지 뷰 설정
        imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setPadding(5, 5, 5, 5);
        // 사진 넣기
        imageView.setImageResource(posterID[position]);
        // 만들어진 이미지뷰 보내기

      } else {
        imageView = (ImageView) convertView;
      }
      return imageView;
    }
  }
}
