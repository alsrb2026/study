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

import static org.techtown.ai_eng_v2_00.MasterCard.correct;
import static org.techtown.ai_eng_v2_00.MasterCard.correctnum;
import static org.techtown.ai_eng_v2_00.MasterCard.wrong;
import static org.techtown.ai_eng_v2_00.MasterCard.wrongnum;

public class Voca1_5 extends AppCompatActivity {
    TextView apple;
    Button apple5;
    Button apple1;
    Button apple2;
    Button apple3;
    Button apple4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.voca1_5);

        apple = findViewById(R.id.apple);

        apple5 = findViewById(R.id.apple5);
        apple5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrong.add(apple.getText().toString());
                wrongnum++;
                Intent intent = new Intent(getApplication(), Voca1_correct.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplication(), "땡!", Toast.LENGTH_SHORT);
                View viewToast = toast.getView();

                viewToast.setBackgroundColor(Color.rgb(225,61,43));
                TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                tvToast.setTextColor(Color.rgb(231,171,171));
                tvToast.setWidth(500);
                tvToast.setGravity(Gravity.CENTER);
                toast.show();
            }
        });


        apple1 = findViewById(R.id.apple1);
        apple1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrong.add(apple.getText().toString());
                wrongnum++;
                if (correctnum / 5 >= 0.8) {
                    Intent intent = new Intent(getApplication(), Voca1_correct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplication(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                } else if (correctnum / 5 < 0.8) {
                    Intent intent = new Intent(getApplication(), Voca1_wrong.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplication(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });

        apple2 = findViewById(R.id.apple2);
        apple2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct.add(apple.getText().toString());
                correctnum++;
                if (correctnum / 5 >= 0.8) {
                    Intent intent = new Intent(getApplication(), Voca1_correct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplication(), "정답!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(0, 191, 254));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(190, 245, 225));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                } else if (correctnum / 5 < 0.8) {
                    Intent intent = new Intent(getApplication(), Voca1_wrong.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplication(), "정답!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(0, 191, 254));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(190, 245, 225));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });

        apple3 = findViewById(R.id.apple3);
        apple3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrong.add(apple.getText().toString());
                wrongnum++;
                if (correctnum / 5 >= 0.8) {
                    Intent intent = new Intent(getApplication(), Voca1_correct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplication(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                } else if (correctnum / 5 < 0.8) {
                    Intent intent = new Intent(getApplication(), Voca1_wrong.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplication(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });
        apple4 = findViewById(R.id.apple4);
        apple4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wapple = (String) apple.getText();
                wrong.add(wapple);
                wrongnum++;
                if (correctnum / 5 >= 0.8) {
                    Intent intent = new Intent(getApplication(), Voca1_correct.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplication(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                } else if (correctnum / 5 < 0.8) {
                    Intent intent = new Intent(getApplication(), Voca1_wrong.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplication(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });
    }
}
