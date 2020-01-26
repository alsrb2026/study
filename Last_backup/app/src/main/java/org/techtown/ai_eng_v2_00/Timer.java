package org.techtown.ai_eng_v2_00;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.widget.*;

import java.util.Random;

public class Timer extends Activity {
    private TextView _text;
    private CountDownTimer _timer;
    TextView timertxt;
    Random rnd2;
    Button left;
    Button right;
    static int correct2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        timertxt = (TextView)findViewById(R.id.timertxt);

        _timer = new CountDownTimer(5 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timertxt.setText("value = " + millisUntilFinished);
            }

            public void onFinish() {
                timertxt.setText("finshed");
            }
        };
        _timer.start();

        rnd2 = new Random();
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        int num = rnd2.nextInt(2);
        Log.d("abc", String.valueOf(num));
        if(num==0){
            left.setText("사과");
            right.setText("포도");
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(),Ant.class);
                    correct2++;
                    startActivity(intent);

                }
            });
        } else if(num==1){
            right.setText("사과");
            left.setText("자두");
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(),Ant.class);
                    correct2++;
                    startActivity(intent);

                }
            });
        }

    }
}