package org.techtown.ai_eng_v2_00;


import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

import static org.techtown.ai_eng_v2_00.Player.rankcounter;

public class Ril_rank2 extends Fragment {
    private TextView _text;
    private CountDownTimer _timer;
    TextView timertxt;
    Random rnd2;
    Button left;
    Button right;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.ril_rank2, container, false);

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.ril_rank2,
                container,
                false);

        timertxt = (TextView)view.findViewById(R.id.timertxt);

        _timer = new CountDownTimer(5 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timertxt.setText("남은시간 = " + millisUntilFinished);
            }

            public void onFinish() {


            }
        };
        _timer.start();

        rnd2 = new Random();
        left = view.findViewById(R.id.left);
        right = view.findViewById(R.id.right);
        int num = rnd2.nextInt(2);
        if(num==0){
            left.setText("오답.");
            right.setText("정답.");
            right = view.findViewById(R.id.right);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rankcounter++;
                    correct();
                }
            });
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wrong();
                }
            });
        } else if(num==1){
            left.setText("정답.");
            right.setText("오답.");
            right = view.findViewById(R.id.right);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wrong();
                }
            });
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rankcounter++;
                    correct();
                }
            });
        }
        return view;
    }
    public void correct() {
        Toast toast = Toast.makeText(getActivity(), "정답!", Toast.LENGTH_SHORT);
        View viewToast = toast.getView();
        viewToast.setBackgroundColor(Color.rgb(0, 191, 254));
        TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
        tvToast.setTextColor(Color.rgb(190, 245, 225));
        tvToast.setWidth(500);
        tvToast.setGravity(Gravity.CENTER);
        toast.show();
    }

    public void wrong() {
        Toast toast = Toast.makeText(getActivity(),"땡!", Toast.LENGTH_SHORT);
        View viewToast = toast.getView();
        viewToast.setBackgroundColor(Color.rgb(225,61,43));
        TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
        tvToast.setTextColor(Color.rgb(231,171,171));
        tvToast.setWidth(500);
        tvToast.setGravity(Gravity.CENTER);
        toast.show();
    }
}