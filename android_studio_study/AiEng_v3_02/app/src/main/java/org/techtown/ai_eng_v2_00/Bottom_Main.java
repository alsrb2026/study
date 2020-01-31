package org.techtown.ai_eng_v2_00;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottom_Main extends AppCompatActivity {

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // 4개의 메뉴에 들어갈 Fragment들
    private Ril_rank4 menu4Fragment = new Ril_rank4();
    private Ril_rank3 menu3Fragment = new Ril_rank3();
    private Ril_rank2 menu2Fragment = new Ril_rank2();
    private Ril_rank1 menu1Fragment = new Ril_rank1();

    private Lock lock = new Lock();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.bottom_menu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        // 첫 화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, menu4Fragment).commitAllowingStateLoss();

        // bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {

                    case R.id.navigation_menu1: {
                        transaction.replace(R.id.frame_layout, menu4Fragment).commitAllowingStateLoss();
                        break;
                    }

                    case R.id.navigation_menu2: {
                        if (Player.rankcounter >= 1 ) {
                            transaction.replace(R.id.frame_layout, menu3Fragment).commitAllowingStateLoss();
                            break;
                        }
                        else if(Player.rankcounter < 1 ) {
                            transaction.replace(R.id.frame_layout, lock).commitAllowingStateLoss();
                            break;
                        }
                    }

                    case R.id.navigation_menu3: {
                        if (Player.rankcounter >= 2) {
                            transaction.replace(R.id.frame_layout, menu2Fragment).commitAllowingStateLoss();
                            break;
                        }
                        else if(Player.rankcounter < 2 ) {
                            transaction.replace(R.id.frame_layout, lock).commitAllowingStateLoss();
                            break;
                            }
                        }

                    case R.id.navigation_menu4: {
                        if (Player.rankcounter >= 3) {
                            transaction.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();
                            break;
                        }
                        else if(Player.rankcounter < 3 ) {
                            transaction.replace(R.id.frame_layout, lock).commitAllowingStateLoss();
                            break;
                        }
                    }
                    }
                return true;
            }
        });
    }
}