package org.techtown.ai_eng_v2_00;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class RilPoint extends Fragment {
    Button point1;
    Bottom_Main Bottom_Main = new Bottom_Main();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.rilpoint, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.rilpoint,
                container,
                false);

        point1 = view.findViewById(R.id.point1);
        point1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Bottom_Main.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        return view;
    }
}