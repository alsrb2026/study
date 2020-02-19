package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.ai_eng_v2_00.classs.AttackStrategy;
import org.techtown.ai_eng_v2_00.classs.Card;
import org.techtown.ai_eng_v2_00.classs.Card_Attacker1;


public class Fragment1 extends Fragment  {
    Button practicebtn;
    Button gamebtn;
    Button fightbtn;
    Game game = new Game();
    Main_boardlist main_boardlist = new Main_boardlist();
    Button boardbtn;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment1, container, false);

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment1,
                container,
                false);


        practicebtn = view.findViewById(R.id.practice);
        practicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewAdapter.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                startActivity(intent);
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
