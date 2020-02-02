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

import static org.techtown.ai_eng_v2_00.Fragment3.correct;
import static org.techtown.ai_eng_v2_00.Fragment3.correctnum;
import static org.techtown.ai_eng_v2_00.Fragment3.wrong;
import static org.techtown.ai_eng_v2_00.Fragment3.wrongnum;

public class Voca1_5k extends Fragment {
    TextView apple;
    Button apple5;
    Button apple1;
    Button apple2;
    Button apple3;
    Button apple4;
    Voca1_correct voca1_correct = new Voca1_correct();
    Voca1_wrong voca1_wrong = new Voca1_wrong();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.voca1_5k, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.voca1_5k,
                container,
                false);

        apple = view.findViewById(R.id.apple);

        apple5 = view.findViewById(R.id.apple5);
        apple5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrong.add(apple.getText().toString());
                wrongnum++;
                if (correctnum / 5 >= 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_correct);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                } else if (correctnum / 5 < 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_wrong);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });


        apple1 = view.findViewById(R.id.apple1);
        apple1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrong.add(apple.getText().toString());
                wrongnum++;
                if (correctnum / 5 >= 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_correct);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                } else if (correctnum / 5 < 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_wrong);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });

        apple2 = view.findViewById(R.id.apple2);
        apple2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct.add(apple.getText().toString());
                correctnum++;
                if (correctnum / 5 >= 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_correct);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "정답!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(0, 191, 254));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(190, 245, 225));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                } else if (correctnum / 5 < 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_wrong);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "정답!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(0, 191, 254));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(190, 245, 225));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });

        apple3 = view.findViewById(R.id.apple3);
        apple3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrong.add(apple.getText().toString());
                wrongnum++;
                if (correctnum / 5 >= 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_correct);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                } else if (correctnum / 5 < 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_wrong);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });

        apple4 = view.findViewById(R.id.apple4);
        apple4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wapple = (String) apple.getText();
                wrong.add(wapple);
                wrongnum++;
                if (correctnum / 5 >= 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_correct);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                } else if (correctnum / 5 < 0.8) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, voca1_wrong);
                    transaction.commit();
                    Toast toast = Toast.makeText(getActivity(), "땡!", Toast.LENGTH_SHORT);
                    View viewToast = toast.getView();

                    viewToast.setBackgroundColor(Color.rgb(225,61,43));
                    TextView tvToast = (TextView) viewToast.findViewById(android.R.id.message);
                    tvToast.setTextColor(Color.rgb(231,171,171));
                    tvToast.setWidth(500);
                    tvToast.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });
        return view;
    }
}
