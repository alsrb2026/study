package org.techtown.ai_eng_v2_00;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MasterCard extends AppCompatActivity {
    Activity activity;
    Button shop;
    Button invenbtn;
    Button drawing;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    static RecyclerViewAdapter recyclerViewAdapter;
    static List<Person> person = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mastercard);
        activity = this;

        recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, gridLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(gridLayoutManager);

        // ArrayList에 person 객체(이름과 번호) 넣기


        // Adapter생성
        recyclerViewAdapter = new RecyclerViewAdapter(this, person);
        recyclerView.setAdapter(recyclerViewAdapter);

        shop = findViewById(R.id.shopbtn);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Shop.class);
                startActivity(intent);
            }
        });

        drawing = findViewById(R.id.drawing);
        drawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Drawing.class);
                startActivity(intent);
            }
        });







    }
}
