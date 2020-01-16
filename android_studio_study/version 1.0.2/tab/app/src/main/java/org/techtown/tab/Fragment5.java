package org.techtown.tab;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class Fragment5 extends Fragment {
    Button button10;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment5, container, false);
        View main = inflater.inflate(R.layout.activity_main, container, false);

        button10 = main.findViewById(R.id.button10);


        Button button2 = v.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage1100();
            }
        });

        Button button3 = v.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage11000();
            }
        });

        Button button4 = v.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage33000();
            }
        });

        Button button5 = v.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage55000();
            }
        });
        return v;
    }


    private void showMessage1100() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("결제");
        builder.setMessage("1100원 결제하시겠습니까?");
        builder.setIcon((R.drawable.casah));
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                Toast.makeText(getContext(), "70다이아 구매 완료", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();
    }

    private void showMessage11000() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("결제");
        builder.setMessage("11000원 결제하시겠습니까?");
        builder.setIcon((R.drawable.casah));
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                Toast.makeText(getActivity(), "700다이아 구매 완료", Toast.LENGTH_LONG).show();


            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();
    }

    private void showMessage33000() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("결제");
        builder.setMessage("33000원 결제하시겠습니까?");
        builder.setIcon((R.drawable.casah));
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                //Toast.makeText(getContext(), "2100다이아 구매 완료", Toast.LENGTH_LONG).show();
                Player.dia = Player.dia + 2100;




                button10.setText(String.valueOf(Player.dia));
            }

        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();
    }

    private void showMessage55000() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("결제");
        builder.setMessage("55000원 결제하시겠습니까?");
        builder.setIcon((R.drawable.casah));
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                Toast.makeText(getContext(), "3500다이아 구매 완료", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();


    }
}




