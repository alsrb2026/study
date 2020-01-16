package org.techtown.testsdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean isThread = false;
    Thread thread;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isThread = true;
                thread = new Thread() {
                    public void run() {
                        while (isThread) {
                            try {
                                sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.i("aa", "dsa"); //여기 5번 돌아감 왜?
                        }
                    }
                };
                thread.start();
            }
        });
    }
}
