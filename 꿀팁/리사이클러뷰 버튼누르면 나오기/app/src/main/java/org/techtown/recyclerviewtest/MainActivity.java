package org.techtown.recyclerviewtest;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
Button button;
ConstraintLayout container;
    ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflate
        button = findViewById(R.id.button3);
        container = findViewById(R.id.container);

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.activity_main, container, true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 리사이클러뷰에 표시할 데이터 리스트 생성.
                for (int i=0; i<100; i++) {
                    list.add(String.format("TEXT %d", i)) ;


                    // 리사이클러뷰에 LinearLayoutManager 객체 지정.
                    RecyclerView recyclerView = findViewById(R.id.recycler1) ;
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this)) ;

                    // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
                    SimpleTextAdapter adapter = new SimpleTextAdapter(list) ;
                    recyclerView.setAdapter(adapter) ;
                }
            }
        });



    }
}
