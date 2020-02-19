package org.techtown.ai_eng_v2_00;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import static org.techtown.ai_eng_v2_00.MainActivity.cardnumber;
import static org.techtown.ai_eng_v2_00.Fragment3.person;
import static org.techtown.ai_eng_v2_00.Fragment3.recyclerViewAdapter;
import static org.techtown.ai_eng_v2_00.Player.CardImage;

public class Drawing extends AppCompatActivity {

    Button drawingbtn70;
    Button drawingbtn700;
    static int card = 0;
    static Player player = new Player(700, 1);
    TextView mp;
    TextView Mileage;
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
        Mileage = findViewById(R.id.Mileage);

        mp.setText(String.valueOf(player.getMP() + "/9999 MP"));
        Mileage.setText(String.valueOf(player.getMileage() + "/9999 Mileage"));
        cardimage = findViewById(R.id.cardimage);

        drawingbtn70.setOnClickListener(new View.OnClickListener() { //나갔닫가 다시 뽑기하면 MP 초긱화됨 해결
            @Override
            public void onClick(View v) {
                if (player.getMP() >= 70) {
                    player.minusMP(70);  //지역변수 player의 MP가 차감되는 것임 -> 전역으로 바꾸기 static으로. 해결 ->static으로 안 바꾸고 안전하게 get set처럼 못하나?
                    mp.setText(String.valueOf(player.getMP() + "/9999 MP"));
                    rnd(random()); //랜덤메소드로  카드등급 나온 후 그 등급에 의해 카드표시+카드목록에 추가
                    recyclerViewAdapter.notifyDataSetChanged();

                    /*Intent intent = new Intent(getApplication(),MasterCard.class);
                    startActivity(intent);*/ //액티브 시작이 아닌 데이터 보낸 후 갱신해야함 how? ->
                    //데이터 추가는 되고있음 -> 추가 후 갱신을 해야함
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
                    for (int i = 0; i <= 10; i++) {
                        rnd(random());
                        recyclerViewAdapter.notifyDataSetChanged();
                        ; //메소드 안에 rnd(random()) 있음
                    }
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
        cardimage.setImageResource(R.drawable.hearth1);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.goldside));
        CardImage.add(cardnumber, R.drawable.hearth1);
        person.add(new Person("체력 : 10 ", "공격력 : 5","5", getDrawable(R.drawable.hearth1)));
    }


    public void carddrawing2(){
        cardimage.setImageResource(R.drawable.hearth2);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.purple));
        CardImage.add(cardnumber, R.drawable.hearth2);
        person.add(new Person("체력 : 8 ", "공격력 : 4", "4", getDrawable(R.drawable.hearth2)));
    }

    public void carddrawing3(){
        cardimage.setImageResource(R.drawable.hearth3);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.red));
        CardImage.add(cardnumber, R.drawable.hearth3);
        person.add(new Person("체력 : 6 ", "공격력 : 3", "3", getDrawable(R.drawable.hearth3)));
    }

    public void carddrawing4(){
        cardimage.setImageResource(R.drawable.hearth4);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.blue));
        CardImage.add(cardnumber, R.drawable.hearth4);
        person.add(new Person("체력 : 4 ", "공격력 : 2", "2", getDrawable(R.drawable.hearth4)));
    }

    public void carddrawing5(){
        cardimage.setImageResource(R.drawable.hearth5);//card1을 card2 로 변경
        cardimage.setBackground(getDrawable(R.drawable.black));
        CardImage.add(cardnumber, R.drawable.hearth5);
        //마스터카드(인벤토리)에 사진 넣기 cardnumber에 따라서 순서대로 사진 넣기
        person.add(new Person("체력 : 2 ", "공격력 : 1", "1", getDrawable(R.drawable.hearth5)));
    } //카드이미지 누르면 hp atk grade 출력 -> add가 순서대로 저장, 카드 개수 카운트하는 함수로?


}
