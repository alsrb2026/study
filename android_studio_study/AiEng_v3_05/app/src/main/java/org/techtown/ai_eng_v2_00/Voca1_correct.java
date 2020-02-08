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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static org.techtown.ai_eng_v2_00.Drawing.player;
import static org.techtown.ai_eng_v2_00.Fragment3.correctnum;


public class Voca1_correct extends Fragment {
    TextView textView2;
    Button button11;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.voca1_correct, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.voca1_correct,
                container,
                false);

        textView2 = view.findViewById(R.id.textView2);
        double Correct_rate = (correctnum/5)*100;
        int Correct_rates = (int)Correct_rate;
        String corretstring = String.valueOf(Correct_rates);
        textView2.setText("정답률 : " +corretstring+ "%");
        correctnum = 0;
        Correct_rate = 0;
        Correct_rates = 0;
        player.Episode++;

        button11 = view.findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.plusMP(120);
                button11.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "120다이아 획득", Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(Voca1_correct.this).commit();
                fragmentManager.popBackStack();



            }
        });


        return view;
    }
}
