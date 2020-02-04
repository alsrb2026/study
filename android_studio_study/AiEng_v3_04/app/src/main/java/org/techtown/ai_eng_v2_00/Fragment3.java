package org.techtown.ai_eng_v2_00;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment {

    Activity activity;

    Button drawing2;
    RecyclerView recyclerView;

    static RecyclerViewAdapter recyclerViewAdapter;
    static List<Person> person = new ArrayList<>();
    static List<String> correct = new ArrayList<>();
    static List<String> wrong = new ArrayList<>();
    static double correctnum = 0;
    static double wrongnum = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment3, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment3,
                container,
                false);
        getActivity().getWindow().setNavigationBarColor(Color.rgb(209,237,255));

        recyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(getActivity(), gridLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(gridLayoutManager);

        // ArrayList에 person 객체(이름과 번호) 넣기


        // Adapter생성
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), person);
        recyclerView.setAdapter(recyclerViewAdapter);


        drawing2 = view.findViewById(R.id.drawing2);
        drawing2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Drawing.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
