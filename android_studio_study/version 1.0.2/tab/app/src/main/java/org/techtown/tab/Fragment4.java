package org.techtown.tab;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment {
Button upbutton_1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment4, container, false);

        Button upbutton_1 = v.findViewById(R.id.upbutton_1);
        upbutton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),RandomCard.class);
                startActivity(intent);//액티비티 띄우기
            }
        });

        return v;
    }



}
