package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static org.techtown.ai_eng_v2_00.Drawing.player;
import static org.techtown.ai_eng_v2_00.MasterCard.correct;
import static org.techtown.ai_eng_v2_00.MasterCard.correctnum;
import static org.techtown.ai_eng_v2_00.MasterCard.wrong;
import static org.techtown.ai_eng_v2_00.MasterCard.wrongnum;

public class Voca1_correct extends AppCompatActivity {
    TextView textView2;
    Button button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.voca1_correct);

        textView2 = findViewById(R.id.textView2);
        double Correct_rate = (correctnum/5)*100;
        int Correct_rates = (int)Correct_rate;
        String corretstring = String.valueOf(Correct_rates);
        textView2.setText("정답률 : " +corretstring+ "%");
        correctnum = 0;
        Correct_rate = 0;
        Correct_rates = 0;
        player.Episode++;

        button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.plusMP(120);
                button11.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "120다이아 획득", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}
