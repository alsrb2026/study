package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
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

import static org.techtown.ai_eng_v2_00.Drawing.player;


public class Voca_Practice5 extends Fragment {
TextView textView3;
    private CountDownTimer _timer;
    Game game = new Game();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.vocapractice_5, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.vocapractice_5,
                container,
                false);

        final Button button2 = view.findViewById(R.id.button2);
        button2.setVisibility(View.INVISIBLE);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, game);
                transaction.commit();
                player.plusMP(50);
                Toast toast = Toast.makeText(getActivity(),"50MP 획득!", Toast.LENGTH_SHORT);
                View viewToast = toast.getView();

                viewToast.setBackgroundColor(Color.rgb(0,191,254));
                TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                tvToast.setTextColor(Color.rgb(255,240,150));
                tvToast.setWidth(500);
                tvToast.setGravity(Gravity.CENTER);
                toast.show();
            }
        });

        textView3 = view.findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setText("여러가지의");
                _timer = new CountDownTimer(2 * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        button2.setVisibility(View.VISIBLE);


                    }
                };
                _timer.start();
            }
        });
        return view;
    }
}
