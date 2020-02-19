package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class CardInfo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.cardinfo);
        ImageView cardimgview = findViewById(R.id.cardimgview);


        Intent intent = getIntent();
        String imgselect = intent.getExtras().getString("select");
        // ;
        if(imgselect.equals("1")) { //카드마다 번호가있는데 그 번호대로 사진 교체
            //Drawable drawable = getResources().getDrawable(R.drawable.noodle, null);
            cardimgview.setImageResource(R.drawable.noodle);
        }

        if(imgselect.equals("2")) { //카드마다 번호가있는데 그 번호대로 사진 교체
            //Drawable drawable = getResources().getDrawable(R.drawable.noodle, null);
            cardimgview.setImageResource(R.drawable.minidia);
        }










    }



}
