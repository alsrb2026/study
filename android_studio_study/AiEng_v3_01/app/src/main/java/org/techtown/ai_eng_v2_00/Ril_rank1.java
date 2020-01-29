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

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

import static org.techtown.ai_eng_v2_00.Drawing.player;
import static org.techtown.ai_eng_v2_00.Player.rankcounter;

public class Ril_rank1 extends Fragment {
    private TextView _text;
    private CountDownTimer _timer;
    TextView timertxt;
    Random rnd2;
    Button left;
    Button right;
    public static int ril_r1_cnt = 0;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.ril_rank1, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.ril_rank1,
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
            left.setText("그들은 정부로부터 독립적인 제도를 내가 그 과업을 그만둔 후에 가졌다. 나를위해 그 상황을 통제하는것은 너에 대하여 비교할만하다..");
            right.setText("그들은 정부로부터 독립된 시스템을 가졌는데 그건 내가 그 프로젝트를 그만두고나서이고, 내가 그 상황을 통제하는것은 니가 통제하는것과 비슷하다.");
            right = view.findViewById(R.id.right);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rankcounter++;
                    if(ril_r1_cnt == 3)
                    {
                        player.plusMP(70);
                        Toast.makeText(getContext(), "70MP 받음 + 강화기능 열림", Toast.LENGTH_LONG).show();
                    }
                    if(ril_r1_cnt == 5)
                    {
                        Snackbar.make(getActivity().findViewById(android.R.id.content), "초월기능 해제", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
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
            left.setText("그들은 정부로부터 독립된 시스템을 가졌는데 그건 내가 그 프로젝트를 그만두고나서이고, 내가 그 상황을 통제하는것은 니가 통제하는것과 비슷하다.");
            right.setText("그들은 정부로부터 독립적인 제도를 내가 그 과업을 그만둔 후에 가졌다. 나를위해 그 상황을 통제하는것은 너에 대하여 비교할만하다..");
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
                    if(ril_r1_cnt == 3)
                    {
                        player.plusMP(70);
                        Toast.makeText(getContext(), "70MP 받음 + 강화기능 열림", Toast.LENGTH_LONG).show();
                    }
                    if(ril_r1_cnt == 5)
                    {
                        Snackbar.make(getActivity().findViewById(android.R.id.content), "초월기능 해제", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
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