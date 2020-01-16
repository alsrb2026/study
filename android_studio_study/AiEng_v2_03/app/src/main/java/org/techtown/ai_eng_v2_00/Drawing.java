package org.techtown.ai_eng_v2_00;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

import static org.techtown.ai_eng_v2_00.Card.person;
import static org.techtown.ai_eng_v2_00.MainActivity.cardnumber;
import static org.techtown.ai_eng_v2_00.Player.CardImage;
import static org.techtown.ai_eng_v2_00.Player.Hp;
import static org.techtown.ai_eng_v2_00.Player.Power;

public class Drawing extends AppCompatActivity {

    Button drawingbtn70;
    Button drawingbtn700;
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


        drawingbtn70 = findViewById(R.id.drawingbtn70);
        drawingbtn700 = findViewById(R.id.drawingbtn700);
        mp = findViewById(R.id.mp);
        gold = findViewById(R.id.gold);

        mp.setText(String.valueOf(player.getMP() + "/9999 MP"));
        gold.setText(String.valueOf(player.getGOLD() + "/9999 GOLD"));
        cardimage = findViewById(R.id.cardimage);

        drawingbtn70.setOnClickListener(new View.OnClickListener() { //나갔닫가 다시 뽑기하면 MP 초긱화됨 해결
            @Override
            public void onClick(View v) {
                if (player.getMP() >= 70) {
                    player.minusMP(70);  //지역변수 player의 MP가 차감되는 것임 -> 전역으로 바꾸기 static으로. 해결 ->static으로 안 바꾸고 안전하게 get set처럼 못하나?
                    mp.setText(String.valueOf(player.getMP() + "/9999 MP"));
                    rnd(random()); //랜덤메소드로  카드등급 나온 후 그 등급에 의해 카드표시+카드목록에 추가
                } else {
                    int money = 70 - player.getMP();
                    Toast.makeText(getApplicationContext(), money + "MP가 부족합니다.", Toast.LENGTH_LONG).show();
                }
            }
        });

        drawingbtn700.setOnClickListener(new View.OnClickListener() { //나갔닫가 다시 뽑기하면 MP 초긱화됨 해결
            @Override
            public void onClick(View v) {
                if (player.getMP() >= 700) {
                    player.minusMP(700);  //지역변수 player의 MP가 차감되는 것임 -> 전역으로 바꾸기 static으로. 해결 ->static으로 안 바꾸고 안전하게 get set처럼 못하나?
                    mp.setText(String.valueOf(player.getMP() + "/9999 MP"));
                    drawing11();
                } else {
                    int money = 700 - player.getMP();
                    Toast.makeText(getApplicationContext(), money + "MP가 부족합니다.", Toast.LENGTH_LONG).show();
                    }
                }
            });
}


    public int random() {
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
        return card;
        }


    public void rnd(int card) {
        if (card == 1) {
            carddrawing1();
        }
        if (card == 2) {
            carddrawing2();
        }
        if (card == 3) {
            carddrawing3();
        }
        if (card == 4) {
            carddrawing4();
        }
        if (card == 5) {
            carddrawing5();
        }
        cardnumber++;
    }


    public void carddrawing1(){
        cardimage.setImageResource(R.drawable.card2_1);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.goldside));
        CardImage.add(cardnumber, R.drawable.card2_1);
        //Hp.add(cardnumber, 10);
        //Power.add(cardnumber, 5);
        person.add(new Person("체력 : 10 ", "공격력 : 5","불멸", getDrawable(R.drawable.card2_1)));
    }


    public void carddrawing2(){
        cardimage.setImageResource(R.drawable.card2_2);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.purple));
        CardImage.add(cardnumber, R.drawable.card2_2);
        //Hp.add(cardnumber, 8);
        //Power.add(cardnumber, 4);
        person.add(new Person("체력 : 8 ", "공격력 : 4", "전설", getDrawable(R.drawable.card2_2)));
    }

    public void carddrawing3(){
        cardimage.setImageResource(R.drawable.card2_3);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.red));
        CardImage.add(cardnumber, R.drawable.card2_3);
        person.add(new Person("체력 : 6 ", "공격력 : 3", "영웅", getDrawable(R.drawable.card2_3)));
    }


    public void carddrawing4(){
        cardimage.setImageResource(R.drawable.card2_4);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.blue));
        CardImage.add(cardnumber, R.drawable.card2_4);
        person.add(new Person("체력 : 4 ", "공격력 : 2", "희귀", getDrawable(R.drawable.card2_4)));
    }

    public void carddrawing5(){
        cardimage.setImageResource(R.drawable.card2_5);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.black));
        CardImage.add(cardnumber, R.drawable.card2_5);
        //마스터카드(인벤토리)에 사진 넣기 cardnumber에 따라서 순서대로 사진 넣기
        person.add(new Person("체력 : 2 ", "공격력 : 1", "일반", getDrawable(R.drawable.card2_5)));
    } //카드이미지 누르면 hp atk grade 출력 -> add가 순서대로 저장, 카드 개수 카운트하는 함수로?

    public void drawing11() {
        for (int i = 0; i <= 10; i++) {
            rnd(random());
        }
    }
}
