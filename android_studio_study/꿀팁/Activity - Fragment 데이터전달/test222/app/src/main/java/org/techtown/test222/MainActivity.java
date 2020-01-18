package org.techtown.test222;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    LinearLayout ll_fragment;
    TextView tv_activity;
    Button btn_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_fragment = findViewById(R.id.ll_fragment);
        tv_activity = findViewById(R.id.tv_activity);
        btn_activity = findViewById(R.id.btn_activity);


        btn_activity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.ll_fragment);
                mainFragment.changeFragmentTextView("호호호");
            }
        });
        replaceFragment();
    }

    public void replaceFragment()
    {
        MainFragment mainFragment = new MainFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.ll_fragment, mainFragment).commit();
    }

    public void changeText(String text)
    {
        tv_activity.setText(text);
    }
}

