package org.techtown.ai_eng_v2_00;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

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

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        mAuth = FirebaseAuth.getInstance();

        button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),MasterCard.class);
                startActivity(intent);
            }
        });

    }
}
