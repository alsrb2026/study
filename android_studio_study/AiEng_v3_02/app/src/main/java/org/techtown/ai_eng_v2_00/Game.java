package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static org.techtown.ai_eng_v2_00.Player.Episode;

public class Game extends Fragment {
    Button rilbtn;
    Button word_game;
    Voca1 voca1 = new Voca1();
    Voca1k voca1k = new Voca1k();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.game, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.game,
                container,
                false);

        rilbtn = view.findViewById(R.id.rilbtn);
        rilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RilPoint.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        word_game = view.findViewById(R.id.word_game);
        word_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Episode<3){
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(Episode>=3) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1k);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        return view;
    }
}
