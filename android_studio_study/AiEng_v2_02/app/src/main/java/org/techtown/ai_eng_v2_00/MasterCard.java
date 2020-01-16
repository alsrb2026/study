package org.techtown.ai_eng_v2_00;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MasterCard extends AppCompatActivity {
    Activity activity;
    Button shop;
    Button invenbtn;
    Button drawing;
    Button c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mastercard);
        activity = this;


        invenbtn = findViewById(R.id.invenbtn);
        invenbtn.setOnClickListener(    new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Card.class);
                startActivity(intent);
            }
        });

        shop = findViewById(R.id.shopbtn);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Shop.class);
                startActivity(intent);
            }
        });

        drawing = findViewById(R.id.drawing);
        drawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Drawing.class);
                startActivity(intent);
            }
        });







    }
}
