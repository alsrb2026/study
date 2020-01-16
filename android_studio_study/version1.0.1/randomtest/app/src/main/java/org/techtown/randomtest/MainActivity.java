package org.techtown.randomtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
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


public class MainActivity extends AppCompatActivity implements Serializable {
    boolean isThread = false;
    Thread thread;
    Button mycard;
    FrameLayout page;
    Boolean mode = false;
    static int card = 0;
    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";
    int n = 0;
    ConstraintLayout container;
    ArrayList<String> list = new ArrayList<>();

    boolean isRecyclerViewVisible = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player player = new Player(2400, 200);
        final TextView dia = findViewById(R.id.diamond);
        final TextView coin = findViewById(R.id.coin);
        final ImageView iv = (ImageView) findViewById(R.id.cardimage);
        final ImageView iv2 = (ImageView) findViewById(R.id.cardimage2);
        final TextView recruit = findViewById(R.id.recruit);
        final TextView bbobgi = findViewById(R.id.bbobgi);
        final TextView textView3 = findViewById(R.id.textView3);
        final Button b70 = findViewById(R.id.button70);
        final Button b700 = findViewById(R.id.button700);




        page = findViewById(R.id.recruitmenu);

        String dias = String.valueOf(player.dia);
        dia.setText("다이아 : " + dias);

        String coins = String.valueOf(player.coin);
        coin.setText("코인 : " + coins);

        Button adv_menu = findViewById(R.id.adv_menu);
        adv_menu.setOnClickListener(new View.OnClickListener() {
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


                } else {
                    Toast.makeText(getApplicationContext(), "다이아가 부족합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button payment = findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Payment.class);
                startActivity(intent);
            }
        });



        for (int i=0; i<100; i++) {
            list.add(String.format("TEXT %d", i));
        }




        /*RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler1) ;
        SimpleTextAdapter adapter = new SimpleTextAdapter(list) ;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this)) ;
*/
       // recyclerView.setVisibility(View.GONE);





        mycard = findViewById(R.id.mycard);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                } //화면전환 성공했고 이제 리사이클러뷰만 추가하면 되는데 추가를 어디서 하나? invoke 에러는 참조를 안해줘서 밑에서 참조를 못했다는건데 어떻게 미리 참조를하나
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



