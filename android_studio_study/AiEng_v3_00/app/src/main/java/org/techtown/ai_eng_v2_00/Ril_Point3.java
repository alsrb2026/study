package org.techtown.ai_eng_v2_00;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Ril_Point3 extends Activity {
    private TextView _text;
    private CountDownTimer _timer;
    TextView timertxt;
    Random rnd2;
    Button left;
    Button right;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ril_point3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        timertxt = (TextView)findViewById(R.id.timertxt);

        _timer = new CountDownTimer(5 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timertxt.setText("남은시간 = " + millisUntilFinished);
            }

            public void onFinish() {
                Intent intent = new Intent(getApplication(),Ril_Point4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

            }
        };
        _timer.start();

        rnd2 = new Random();
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        int num = rnd2.nextInt(2);
        if(num==0){
            left.setText("개미");
            right.setText("나방");
        } else if(num==1){
            right.setText("개미");
            left.setText("벌레");

        }

    }
}