package org.techtown.ai_eng_v2_00;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;

public class Splash extends Activity {
    Random rnd;
    TextView textview8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 2000); // 1초 후에 hd handler 실행  3000ms = 3초

        textview8 = findViewById(R.id.textView8);

        rnd = new Random();
        int num = rnd.nextInt(2);
        if(num==0) {
            textview8.setText("포기해야겠다는 생각이 들 때야 말로 성공에 가까워진 때이다.\n" +
                    "– 밥 파슨스");
        } else if(num==1) {
            textview8.setText("내일은 우리가 어제로부터 무엇인가 배웠기를 바란다.\n" +
                    "– 존 웨인");

        }


    }

    private class splashhandler implements Runnable {
        public void run() {
            Intent intent = new Intent(getApplication(),Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            Splash.this.finish(); // 로딩페이지 Activity stack에서 제거
        }
    }

    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함 무반응
    }
}
