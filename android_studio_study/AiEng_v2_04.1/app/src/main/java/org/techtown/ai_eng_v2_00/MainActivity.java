package org.techtown.ai_eng_v2_00;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
Button button;
Button invenbtn;
static int cardnumber = 0 ;
Button logout;
public Login login;
RecyclerView recycler;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    Button btnRevoke, btnLogout;
    private FirebaseAuth mAuth ;
    final CharSequence[] grade = { "중/1학년", "중/2학년", "중/3학년", "고/1학년", "고/2학년", "고/3학년" };
    TextView textView41;
    TextView rilbtn;
    TextView vicbtn;
    TextView gisbtn;
    TextView practice;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);
        textView41 = findViewById(R.id.textView41);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("학년을 선택하세요");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setItems(grade,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 프로그램을 종료한다
                        dialog.dismiss();
                        textView41.setText(grade[id]);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        mAuth = FirebaseAuth.getInstance();

        button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),MasterCard.class);
                startActivity(intent);
            }
        });


        rilbtn = findViewById(R.id.rilbtn);
        rilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),RilPoint.class);
                startActivity(intent);
            }
        });

        vicbtn = findViewById(R.id.vicbtn);
        vicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),VicPoint.class);
                startActivity(intent);
            }
        });

        gisbtn = findViewById(R.id.gisbtn);
        gisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),GisPoint.class);
                startActivity(intent);
            }
        });

        practice = findViewById(R.id.practice);
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Timer.class);
                startActivity(intent);
            }
        });





    }
}
