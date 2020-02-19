package org.techtown.ai_eng_v2_00;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class ViewAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.viewmain);

        ViewPager pager = findViewById(R.id.pager);
        //캐싱을 해놓을 프래그먼트 개수
        pager.setOffscreenPageLimit(5);

        //getSupportFragmentManager로 프래그먼트 참조가능
        MoviePagerAdapter adapter = new MoviePagerAdapter(getSupportFragmentManager());

        ViewFragment viewFragment= new ViewFragment();
        adapter.addItem(viewFragment);

        ViewFragment2 viewFragment2= new ViewFragment2();
        adapter.addItem(viewFragment2);

        ViewFragment3 viewFragment3= new ViewFragment3();
        adapter.addItem(viewFragment3);

        ViewFragment4 viewFragment4= new ViewFragment4();
        adapter.addItem(viewFragment4);

        ViewFragment5 viewFragment5= new ViewFragment5();
        adapter.addItem(viewFragment5);

        pager.setAdapter(adapter);
    }

    //어댑터 안에서 각각의 아이템을 데이터로서 관리한다
    class MoviePagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MoviePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }


}