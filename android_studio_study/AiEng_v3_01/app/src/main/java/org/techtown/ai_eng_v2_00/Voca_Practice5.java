package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Voca_Practice5 extends AppCompatActivity {
TextView textView3;
    private CountDownTimer _timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.vocapractice_5);



        textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setText("여러가지의");
                _timer = new CountDownTimer(2 * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {


                    }
                };
                _timer.start();
            }
        });

    }
}
