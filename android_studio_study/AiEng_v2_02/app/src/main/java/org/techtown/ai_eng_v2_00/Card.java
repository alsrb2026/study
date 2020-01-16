package org.techtown.ai_eng_v2_00;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Card extends AppCompatActivity {

    private RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //layoutManager = new GridLayoutManager(this, 1);
        layoutManager = new LinearLayoutManager(this);


        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewA();
        recyclerView.setAdapter(adapter);
    }
}