package org.techtown.randomtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//추가할 것 다이아 몇개 부족한지 표시
//코인 세부 추가

public class MainActivity extends AppCompatActivity implements Serializable {
    boolean isThread = false;
    Thread thread;
    Button button;
    FrameLayout page;
    Boolean mode = false;
    static int card = 0;
    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";
int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final TextView dia = findViewById(R.id.diamond);
        final TextView coin = findViewById(R.id.coin);
        final ImageView iv = (ImageView) findViewById(R.id.cardimage);
        final ImageView iv2 = (ImageView) findViewById(R.id.cardimage2);
        final TextView recruit = findViewById(R.id.recruit);
        final TextView bbobgi = findViewById(R.id.bbobgi);
        final TextView textView3 = findViewById(R.id.textView3);
        final Button b70 = findViewById(R.id.button70);
        final Button b700 = findViewById(R.id.button700);
        Player player = new Player(2400, 200);




        page = findViewById(R.id.recruitmenu);

        String dias = String.valueOf(player.dia);
        dia.setText("다이아 : " + dias);

        String coins = String.valueOf(player.coin);
        coin.setText("코인 : " + coins);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onoff(mode);
            }
        });

        Button button70 = findViewById(R.id.button70);
        button70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Player.dia >= 70) {
                    Player.dia = Player.dia - 70;
                    String str = String.valueOf(Player.dia);
                    dia.setText("다이아 : " + str);

                    recruit.setVisibility(View.INVISIBLE);
                    bbobgi.setVisibility(View.INVISIBLE);
                    b70.setVisibility(View.INVISIBLE);
                    b700.setVisibility(View.INVISIBLE);

                    String cardn;
                    Random rnd = new Random();
                    //1 불멸 2 전설 3 영웅 4 희귀108->90 5 일반
                    int num = rnd.nextInt(300); //정수로 바꿔야하나?
                    if (num > 0 && num <= 12) {
                        card = 1;
                    }
                    if (num > 12 && num <= 36) {
                        card = 2;
                    }
                    if (num > 36 && num <= 60) {
                        card = 3;
                    }
                    if (num > 60 && num <= 150) {
                        card = 4;
                    }
                    if (num > 150 && num <= 300) {
                        card = 5;
                    }


                    iv.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation70);
                    iv.startAnimation(anim);

                    iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            iv2.setVisibility(View.VISIBLE);
                            if (card == 1) {
                                textView3.setText("불멸");
                            }
                            if (card == 2) {
                                textView3.setText("전설");
                            }
                            if (card == 3) {
                                textView3.setText("영웅");
                            }
                            if (card == 4) {
                                textView3.setText("희귀");
                            }
                            if (card == 5) {
                                textView3.setText("일반");
                            }
                            textView3.setVisibility(View.VISIBLE);
                            Handler mHandler3 = new Handler();
                            mHandler3.postDelayed(new Runnable() {
                                public void run() {
                                    iv.setVisibility(View.INVISIBLE);
                                    iv2.setVisibility(View.INVISIBLE);
                                    recruit.setVisibility(View.VISIBLE);
                                    bbobgi.setVisibility(View.VISIBLE);
                                    b70.setVisibility(View.VISIBLE);
                                    b700.setVisibility(View.VISIBLE);
                                    textView3.setVisibility(View.INVISIBLE);
                                }
                            }, 3000); // 0.5초후*/


                        }
                    });

                } else {
                    Toast.makeText(getApplicationContext(), "다이아가 부족합니다", Toast.LENGTH_SHORT).show();
                }


            }
        });

        Button button700 = findViewById(R.id.button700);
        button700.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Player.dia >= 700) {
                    Player.dia = Player.dia - 700;
                    String str = String.valueOf(Player.dia);
                    dia.setText("다이아 : " + str);

                    recruit.setVisibility(View.INVISIBLE);
                    bbobgi.setVisibility(View.INVISIBLE);
                    b70.setVisibility(View.INVISIBLE);
                    b700.setVisibility(View.INVISIBLE);


                    isThread = true;
                    thread = new Thread() {
                        public void run() {
                            while (isThread) {
                                try {
                                    sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                ++n;
                                Random rnd = new Random();
                                //1 불멸 2 전설 3 영웅 4 희귀108->90 5 일반
                                int num = rnd.nextInt(300); //정수로 바꿔야하나?
                                Log.i("TedPark", "카드뽑기"); //
                                if (num > 0 && num <= 12) {
                                    card = 1;
                                }
                                if (num > 12 && num <= 36) {
                                    card = 2;
                                }
                                if (num > 36 && num <= 60) {
                                    card = 3;
                                }
                                if (num > 60 && num <= 150) {
                                    card = 4;
                                }
                                if (num > 150 && num <= 300) {
                                    card = 5;
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        iv.setVisibility(View.VISIBLE);
//애니메이션 밀려서 끝나고도 나옴                                        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation700);
//                                        iv.startAnimation(anim);
                                        iv2.setVisibility(View.VISIBLE);
                                        Log.i("TedPark", "카드2 표시"); //여기 5번 돌아감 왜?

                                        if (card == 1) {
                                            textView3.setText("불멸");
                                        }
                                        if (card == 2) {
                                            textView3.setText("전설");
                                        }
                                        if (card == 3) {
                                            textView3.setText("영웅");
                                        }
                                        if (card == 4) {
                                            textView3.setText("희귀");
                                        }
                                        if (card == 5) {
                                            textView3.setText("일반");
                                        }
                                        textView3.setVisibility(View.VISIBLE);

                                        if (n >= 12) {
                                            isThread = false;
                                            iv.setVisibility(View.INVISIBLE);
                                            iv2.setVisibility(View.INVISIBLE);
                                            recruit.setVisibility(View.VISIBLE);
                                            bbobgi.setVisibility(View.VISIBLE);
                                            b70.setVisibility(View.VISIBLE);
                                            b700.setVisibility(View.VISIBLE);
                                            textView3.setVisibility(View.INVISIBLE);
                                            Log.i("TedPark", "끝");
                                        }
                                        Log.i("TedPark", String.valueOf(n)); //여기 5번 돌아감 왜?


                                        /*if (isThread == false) {
                                            iv.setVisibility(View.INVISIBLE);
                                            iv2.setVisibility(View.INVISIBLE);
                                            recruit.setVisibility(View.VISIBLE);
                                            bbobgi.setVisibility(View.VISIBLE);
                                            b70.setVisibility(View.VISIBLE);
                                            b700.setVisibility(View.VISIBLE);
                                            textView3.setVisibility(View.INVISIBLE);
                                            Log.i("TedPark", "끝");
                                        }*/

                                    }
                                });


                            }
                        }
                    };
                    thread.start();


                    }else {
                    Toast.makeText(getApplicationContext(), "다이아가 부족합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button mycard = findViewById(R.id.mycard);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                String to = Integer.toString(card);
                SimpleData data = new SimpleData(100, to);
                intent.putExtra(KEY_SIMPLE_DATA, data);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

    }

    public void onoff(Boolean mode) {
        if (!mode) {
            page.setVisibility(View.VISIBLE);
            this.mode = true;
        } else if (mode) {
            page.setVisibility(View.INVISIBLE);
            this.mode = false;
        }
    }




    }



