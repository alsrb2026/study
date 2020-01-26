package org.techtown.ai_eng_v2_00;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import static org.techtown.ai_eng_v2_00.Drawing.player;

public class Fragment2 extends Fragment {
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.fragment2, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment2,
                container,
                false);




        textView = (TextView)view.findViewById(R.id.textView);
        textView = (TextView)view.findViewById(R.id.textView);
        Button btn1100 = (Button) view.findViewById(R.id.btn1100);
        btn1100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1100();
                Log.d("abc","클릭함");
            }
        });

        Button btn11000 = (Button) view.findViewById(R.id.btn11000);
        btn11000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button11000();
            }
        });

        Button btn33000 = (Button) view.findViewById(R.id.btn33000);
        btn33000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button33000();
            }
        });

        Button btn55000 = (Button) view.findViewById(R.id.btn55000);
        btn55000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button55000();
            }
        });
        return rootView;
    }

    public void button1100() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("결제");
        builder.setMessage("1100원 결제하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                player.plusMP(70);
                Snackbar.make(textView, "결제완료", Snackbar.LENGTH_LONG).show();
            }
        });


        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void button11000() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("결제");
        builder.setMessage("11000원 결제하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                player.plusMP(700);
                Snackbar.make(textView, "결제완료", Snackbar.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void button33000() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("결제");
        builder.setMessage("33000원 결제하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                player.plusMP(2100);
                Snackbar.make(textView, "결제완료", Snackbar.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void button55000() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("결제");
        builder.setMessage("55000원 결제하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                player.plusMP(3500);
                Snackbar.make(textView, "결제완료", Snackbar.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
