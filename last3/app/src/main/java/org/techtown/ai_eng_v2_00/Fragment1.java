package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    TextView textView;
    Button practicebtn;
    Button gamebtn;
    Button fightbtn;
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
                Intent intent = new Intent(getActivity(),Voca_Practice.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        gamebtn = view.findViewById(R.id.game);
        gamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

            }
        });

        fightbtn = view.findViewById(R.id.fight);
        fightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

            }
        });




        return view;
    }
}
