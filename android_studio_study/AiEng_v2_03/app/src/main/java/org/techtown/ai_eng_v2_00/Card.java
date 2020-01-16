package org.techtown.ai_eng_v2_00;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Card extends AppCompatActivity {

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    static List<Person> person = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.card);

        recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, gridLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(gridLayoutManager);

        // ArrayList에 person 객체(이름과 번호) 넣기


        // Adapter생성
        recyclerViewAdapter = new RecyclerViewAdapter(this, person);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}