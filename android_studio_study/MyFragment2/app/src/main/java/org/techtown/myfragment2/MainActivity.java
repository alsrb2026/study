package org.techtown.myfragment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
        ListFragment fragment1;
        ViewerFragment fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new ListFragment();
        fragment2 = new ViewerFragment();

    }

    public void onImageChange(int inde) {

    }
}
