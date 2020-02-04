package org.techtown.ai_eng_v2_00;


import android.content.Intent;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

import static org.techtown.ai_eng_v2_00.Drawing.player;
import static org.techtown.ai_eng_v2_00.Fragment3.wrong;
import static org.techtown.ai_eng_v2_00.Fragment3.wrongnum;
import static org.techtown.ai_eng_v2_00.Player.rankcounter;

public class Ril_rank4 extends Fragment {
    private TextView _text;
    private CountDownTimer _timer;
    TextView timertxt;
    Random rnd2;
    Button left;
    Button right;
    public static int ril_r4_cnt = 0;
    Ril_rank3 ril_rank3 = new Ril_rank3();
    private FragmentManager fragmentManager = getFragmentManager();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.ril_rank4, container, false);

        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.ril_rank4,
                container,
                false);



        timertxt = (TextView)view.findViewById(R.id.timertxt);

        count();

        rnd2 = new Random();
        left = view.findViewById(R.id.left);
        right = view.findViewById(R.id.right);
        int num = rnd2.nextInt(2);
        if(num==0){
            left.setText(R.string.r4w);
            right.setText(R.string.r4c);
            right = view.findViewById(R.id.right);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rankcounter++;
                    ril_r4_cnt++;

                    ifcnt3(ril_r4_cnt);
                    ifcnt5(ril_r4_cnt);

                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, ril_rank3);
                    transaction.commit();
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
            left.setText(R.string.r4c);
            right.setText(R.string.r4w);
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
                    ril_r4_cnt++;

                    ifcnt3(ril_r4_cnt);
                    ifcnt5(ril_r4_cnt);
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, ril_rank3);
                    transaction.commit();


                    correct();



                }
            });
        }




        return view;
    }


    public void count() {
        _timer = new CountDownTimer(20 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timertxt.setText("남은시간 = " + millisUntilFinished);
            }
            public void onFinish() {
                timertxt.setText("시간초과");
            }
        };
        _timer.start();
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
    public void ifcnt3(int ril_r4_cnt) { //3번이상 학습 시
        if (ril_r4_cnt == 3) {
            player.plusMP(70);
            Snackbar.make(getActivity().findViewById(android.R.id.content), "70MP 받음 + 강화기능 열림", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void ifcnt5(int ril_r4_cnt) { //5번이상 학습 시
        if (ril_r4_cnt == 5) {
            Snackbar.make(getActivity().findViewById(android.R.id.content), "초월기능 해제", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }
    public void sendmp() {
        if(rankcounter==3){
            player.plusMP(70);
        } else {

        }

    }


}