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

import org.w3c.dom.Text;

import static org.techtown.ai_eng_v2_00.Drawing.player;
import static org.techtown.ai_eng_v2_00.Fragment3.correctnum;


public class Voca1_wrong extends Fragment {
    TextView textView2;
    Button button11;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.voca1_wrong, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.voca1_wrong,
                container,
                false);

        textView2 = view.findViewById(R.id.textView2);
        double Correct_rate = (correctnum/5)*100;
        int Correct_rates = (int)Correct_rate;
        String corretstring = String.valueOf(Correct_rates);
        textView2.setText("정답률 : " +corretstring+ "%");
        Correct_rate = 0;
        Correct_rates = 0;
        correctnum = 0;

        button11 = view.findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(Voca1_wrong.this).commit();
                fragmentManager.popBackStack();
            }
        });

        return view;
    }
}
