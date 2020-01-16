package org.techtown.challenge07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button customerbutton = findViewById(R.id.loginbtn);
        customerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),custommanager.class);
                startActivity(intent);
            }
        });

        Button moneybutton = findViewById(R.id.moneybutton);
        moneybutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),moneymanager.class);
                startActivity(intent);
            }
        });

        Button productbutton = findViewById(R.id.productbutton);
        productbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),productmanager.class);
                startActivity(intent);
            }
        });

    }

}
