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

import org.w3c.dom.Text;

import static org.techtown.ai_eng_v2_00.Drawing.player;
import static org.techtown.ai_eng_v2_00.MasterCard.correct;
import static org.techtown.ai_eng_v2_00.MasterCard.correctnum;
import static org.techtown.ai_eng_v2_00.MasterCard.wrong;
import static org.techtown.ai_eng_v2_00.MasterCard.wrongnum;

public class Voca1_wrong extends AppCompatActivity {
    TextView textView2;
    Button button11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.voca1_wrong);

        textView2 = findViewById(R.id.textView2);
        double Correct_rate = (correctnum/5)*100;
        int Correct_rates = (int)Correct_rate;
        String corretstring = String.valueOf(Correct_rates);
        textView2.setText("정답률 : " +corretstring+ "%");
        Correct_rate = 0;
        Correct_rates = 0;
        correctnum = 0;
        player.Episode++;

        button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
