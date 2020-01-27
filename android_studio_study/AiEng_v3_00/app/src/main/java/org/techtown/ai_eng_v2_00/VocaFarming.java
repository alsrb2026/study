package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static org.techtown.ai_eng_v2_00.Drawing.player;

public class VocaFarming extends AppCompatActivity {

    Button voca1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.vocafarming);
        //여기에 카운트세면서 2면 다른 voca페이지로(한글보고 영어 고르는거)
        /*voca1 = findViewById(R.id.voca1);
        voca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.Episode < 3) {
                    Intent intent = new Intent(getApplication(), Voca1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else if(player.Episode>=3){
                    Intent intent = new Intent(getApplication(), Voca1k.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });


*/




    }
}
