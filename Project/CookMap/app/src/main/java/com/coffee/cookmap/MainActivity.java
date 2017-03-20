package com.coffee.cookmap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  // 구글지도 객체
  GoogleMap googleMap;

  // 지도를 감쌀 투명 종이 만들기
  MapFragment mapFragment;

  GroundOverlayOptions videoMark;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
  }

  public void onMapReady(GoogleMap map){

    // 첫 화면 지도 타입과 위치 설정
    googleMap = map;
    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.494626, 127.027645),15));

    // 확대 축소 버튼
    googleMap.getUiSettings().setZoomControlsEnabled(true);

    // 맵을 터치했을 때의 위치를 얻을 수 있음
    googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
      @Override
      public void onMapClick(LatLng latLng) {
        // 터치한 곳에 안드로봇을 띄울것임
        videoMark =  new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)).position(latLng,100f,100f);
        googleMap.addGroundOverlay(videoMark);
      }
    });
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // 메뉴 설정
    super.onCreateOptionsMenu(menu);

    // menu.add(그룹 ID(같으면같은그룹),메뉴 ID,메뉴순서,"내용");
    menu.add(0, 1, 0, "위성지도");
    menu.add(0, 2, 0, "일반지도");
    menu.add(0, 3, 0, "월드컵지도");

    // 좋은 값으로 보내주기
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case 1:
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        break;
      case 2:
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        break;
      case 3:
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.668256,126.897240),15));
        break;
      default:googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
    return true;
  }

}
