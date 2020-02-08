package org.techtown.ai_eng_v2_00;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class Voca_Practice3 extends Fragment {
TextView textView3;
    private CountDownTimer _timer;
    Voca_Practice4 voca_practice4 = new Voca_Practice4();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.vocapractice_3, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.vocapractice_3,
                container,
                false);



        textView3 = view.findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setText("한편");
                _timer = new CountDownTimer(2 * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, voca_practice4);

                        transaction.commit();
                    }
                };
                _timer.start();
            }
        });

        return view;
    }
}
