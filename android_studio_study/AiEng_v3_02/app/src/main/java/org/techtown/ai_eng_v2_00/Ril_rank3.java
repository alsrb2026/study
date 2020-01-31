package org.techtown.ai_eng_v2_00;
//

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

public class Ril_rank3 extends Fragment {
    private TextView _text;
    private CountDownTimer _timer;
    TextView timertxt;
    Random rnd2;
    Button left;
    Button right;
    Ril_rank4 rank4 = new Ril_rank4();
    public static int ril_r3_cnt = 0;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.ril_rank3, container, false);

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.ril_rank3,
                container,
                false);

        timertxt = (TextView)view.findViewById(R.id.timertxt);
        left = view.findViewById(R.id.left);
        right = view.findViewById(R.id.right);

        _timer = new CountDownTimer(10 * 1000, 1000) {
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
            left.setText("두대의 차는 외형 안에서 비교할만하다.");
            right.setText("저 두 대의 차는 겉모습이 비슷하다.");
            right = view.findViewById(R.id.right);
            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rankcounter++;
                    ril_r3_cnt++;
                    if(ril_r3_cnt == 3)
                    {
                        player.plusMP(70);
                        Snackbar.make(v,"70MP받음 + 강화기능 열림",Snackbar.LENGTH_SHORT).show();
                    }
                    if(ril_r3_cnt == 5)
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
            left.setText("저 두 대의 차는 겉모습이 비슷하다.");
            right.setText("두대의 차는 외형 안에서 비교할만하다.");
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
                    ril_r3_cnt++;
                    if(ril_r3_cnt == 3)
                    {
                        player.plusMP(70);
                        Toast.makeText(getContext(), "70MP 받음 + 강화기능 열림", Toast.LENGTH_LONG).show();
                    }
                    if(ril_r3_cnt == 5)
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
