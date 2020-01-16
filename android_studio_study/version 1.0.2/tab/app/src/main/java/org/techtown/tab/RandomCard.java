package org.techtown.tab;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RandomCard extends AppCompatActivity {
    ImageView cardimage;
    TextView gradecard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomcard);

        final ImageView iv =findViewById(R.id.cardimage);
        final ImageView iv2 =findViewById(R.id.cardimage2);
        gradecard = findViewById(R.id.gradecard);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                //1 불멸 2 전설 3 영웅 4 희귀108->90 5 일반
                int num = rnd.nextInt(300); //정수로 바꿔야하나?
                if (num > 0 && num <= 12) {
                    MainActivity.card = 1;
                }
                if (num > 12 && num <= 36) {
                    MainActivity.card = 2;
                }
                if (num > 36 && num <= 60) {
                    MainActivity.card = 3;
                }
                if (num > 60 && num <= 150) {
                    MainActivity.card = 4;
                }
                if (num > 150 && num <= 300) {
                    MainActivity.card = 5;
                }
                if (MainActivity.card == 1) {
                    gradecard.setText("불멸");
                }
                if (MainActivity.card == 2) {
                    gradecard.setText("전설");
                }
                if (MainActivity.card == 3) {
                    gradecard.setText("영웅");
                }
                if (MainActivity.card == 4) {
                    gradecard.setText("희귀");
                }
                if (MainActivity.card == 5) {
                    gradecard.setText("일반");
                }
                iv2.setVisibility(View.VISIBLE);

            }
        });




    }
}
