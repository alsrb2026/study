package org.techtown.apple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static org.techtown.apple.PlayerB.bhp;

public class MainActivity extends AppCompatActivity {

    TextView bhptext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final PlayerA playera = new PlayerA(10,3,1,0,0);
        final PlayerB playerb = new PlayerB(7,2,1,0,0);
        bhptext = findViewById(R.id.bhptext);



        Button abutton = findViewById(R.id.abutton);
        abutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playera.attack(playera.atk);
                String inbhp = String.valueOf(bhp);
                bhptext.setText(inbhp); //안에가 string이 아니네? 그럼 int -> string으로 바꾸자
            }
        });


    }
}
