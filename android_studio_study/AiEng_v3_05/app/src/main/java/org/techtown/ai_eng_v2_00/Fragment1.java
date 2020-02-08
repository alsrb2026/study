package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment  {
    TextView textView;
    Button practicebtn;
    Button gamebtn;
    Button fightbtn;
    Game game = new Game();
    Main_boardlist main_boardlist = new Main_boardlist();
    Voca_Practice voca_practice = new Voca_Practice();
    Button myword;
    Button boardbtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment1, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment1,
                container,
                false);




        myword = view.findViewById(R.id.myword);
        myword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        practicebtn = view.findViewById(R.id.practice);
        practicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, voca_practice);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        gamebtn = view.findViewById(R.id.game);
        gamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, game);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        fightbtn = view.findViewById(R.id.fight);
        fightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

            }
        });

        boardbtn =  view.findViewById(R.id.board);
        boardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, main_boardlist);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });




        return view;
    }


}
