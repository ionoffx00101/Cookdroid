package com.coffee.android_20170317;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ch11_page10 extends AppCompatActivity {

  // 항목들이 들어가 있을 ArrayList 객체 자리 준비해주기
  ArrayList<String> itemList = new ArrayList<>();
  ArrayAdapter<String> adapter;

  // 위젯 리턴 받을 자리
  Button btn_item_add;
  EditText et_item_input;
  ListView lv_item_list;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch11_page10);
    setTitle("Item List");

    // 어댑터 설정하기
    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);

    // 위젯 리턴 받기
    btn_item_add = (Button) findViewById(R.id.btn_item_add);
    et_item_input = (EditText) findViewById(R.id.et_item_input);
    lv_item_list = (ListView) findViewById(R.id.lv_item_list);

    // list에 어댑터 설정 / 어댑터에 있는 내용을 list에 출력하겠다.
    lv_item_list.setAdapter(adapter);

    // 추가 버튼을 누르면 아이템이 추가 된다.
    btn_item_add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // 아이템 리스트에 추가
        itemList.add(et_item_input.getText().toString());

        // 화면 갱신
        adapter.notifyDataSetChanged();

        // editText 안에 있는 텍스트 초기화 시켜주기
        et_item_input.setText("");

      }
    });

    // 아이템 리스트에서 원하는 아이템을 살짝 누르면 뭔 아이템인지 메시지를 띄워준다.
    lv_item_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // v를 TextView 로 형변환 시켜서 받아준다.
        TextView itemOnClick = (TextView)view;

        // 메시지 출력
        Toast.makeText(getApplicationContext(),"ClickItem : "+itemOnClick.getText().toString()+"\n"+"index : "+position+"\n"+"id : "+id,Toast.LENGTH_SHORT).show();
      }
    });

    // 아이템 리스트에서 삭제를 원하는 아이템을 꾸욱 누르면 해당 아이템이 삭제 된다.
    lv_item_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // parent(adapterView)  LongClick 한 ListView 객체가 있다
        // view LongClick 한 줄(textView)
        // position LongClick 한 줄의 index
        // id LongClick 한 줄의 id

        // 보려면 형변환 시켜줘야한다.
        TextView itemOnClick = (TextView)view;

        // 받은 index(position) 를 사용해서 리스트에서 해당 항목 삭제
        itemList.remove(position);

        // 화면 갱신
        adapter.notifyDataSetChanged();

        // 이벤트 버블이 일어날 수 있다. 다음 이벤트를 호출 하려면 false , 여기서 그만 두려면 true 로 설정해야한다.
        return true;

        // Toast.makeText(getApplicationContext(),"parent : "+parent+"\n"+"ClickItem : "+itemOnClick.getText()+"\n"+"index : "+position+"\n"+"id : "+id,Toast.LENGTH_SHORT).show();
        // id랑 position이랑 같은데 ..?
        // id 다 다른데
        // 같으면 어댑터 레이아웃 들어가서 고쳐줘야한다.
      }
    });

  }
}
