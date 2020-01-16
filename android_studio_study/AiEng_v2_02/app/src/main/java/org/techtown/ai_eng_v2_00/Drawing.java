package org.techtown.ai_eng_v2_00;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import static org.techtown.ai_eng_v2_00.MainActivity.cardnumber;
import static org.techtown.ai_eng_v2_00.Player.CardImage;
import static org.techtown.ai_eng_v2_00.Player.Hp;
import static org.techtown.ai_eng_v2_00.Player.Power;

public class Drawing extends AppCompatActivity {

    Button drawingbtn;
    static int card = 0;
    static Player player = new Player(700, 500);
    TextView mp;
    TextView gold;
    ImageView cardimage;
    static Random rnd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.drawing);


        drawingbtn = findViewById(R.id.drawingbtn);
        mp = findViewById(R.id.mp);
        gold = findViewById(R.id.gold);

        mp.setText(String.valueOf(player.getMP() + "/9999 MP"));
        gold.setText(String.valueOf(player.getGOLD() + "/9999 GOLD"));
        cardimage = findViewById(R.id.cardimage);

        drawingbtn.setOnClickListener(new View.OnClickListener() { //나갔닫가 다시 뽑기하면 MP 초긱화됨 해결
            @Override
            public void onClick(View v) {
                if (player.getMP() >= 70) {
                    player.minusMP(70);  //지역변수 player의 MP가 차감되는 것임 -> 전역으로 바꾸기 static으로. 해결 ->static으로 안 바꾸고 안전하게 get set처럼 못하나?
                    mp.setText(String.valueOf(player.getMP() + "/9999 MP"));
                    rnd();
                } else {
                    int money = 70 - player.getMP();
                    Toast.makeText(getApplicationContext(), money + "MP가 부족합니다.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void rnd() {
        rnd = new Random();
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




        if (card == 1) {
            cardimage.setImageResource(R.drawable.card2_1);//card1을 card2 로 변경
            cardimage.setBackground(getDrawable(R.drawable.goldside));
            CardImage.add(cardnumber, R.drawable.card2_1);
            Hp.add(cardnumber, 10);
            Power.add(cardnumber, 5);
        }
        if (card == 2) {
            cardimage.setImageResource(R.drawable.card2_2);//card1을 card2 로 변경
            cardimage.setBackground(getDrawable(R.drawable.purple));
            CardImage.add(cardnumber, R.drawable.card2_2);
            Hp.add(cardnumber, 8);
            Power.add(cardnumber, 4);
        }
        if (card == 3) {
            cardimage.setImageResource(R.drawable.card2_3);//card1을 card2 로 변경
            cardimage.setBackground(getDrawable(R.drawable.red));
            CardImage.add(cardnumber, R.drawable.card2_3);
            Hp.add(cardnumber, 6);
            Power.add(cardnumber, 3);
        }
        if (card == 4) {
            cardimage.setImageResource(R.drawable.card2_4);//card1을 card2 로 변경
            cardimage.setBackground(getDrawable(R.drawable.blue));
            CardImage.add(cardnumber, R.drawable.card2_4);
            Hp.add(cardnumber, 4);
            Power.add(cardnumber, 2);
        }
        if (card == 5) {
            cardimage.setImageResource(R.drawable.card2_5);//card1을 card2 로 변경
            cardimage.setBackground(getDrawable(R.drawable.black));
            CardImage.add(cardnumber, R.drawable.card2_5);
            //마스터카드(인벤토리)에 사진 넣기 cardnumber에 따라서 순서대로 사진 넣기
            Hp.add(cardnumber, 2);
            Power.add(cardnumber, 1);
        }

        cardnumber++;
        //여기에 mastercard에 사진 추가하는 기능 넣기
    }
}
