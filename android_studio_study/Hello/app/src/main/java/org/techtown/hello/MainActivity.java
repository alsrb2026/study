package org.techtown.hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.net.Uri.parse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //이게 main 함수 역할
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onbutton1Clicked(View v) {
        Toast.makeText(this, "확인1 버튼이 눌렸어요", Toast.LENGTH_LONG).show();
    }


    public void onButton2Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, parse("http://m.naver.com"));
        startActivity(myIntent);
    }


public void onButtonClicked3(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, parse("tel:010-1000-1000"));
        startActivity(myIntent);
        }
}
