/*
package org.techtown.ai_eng_v2_00;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.ai_eng_v2_00.R;

import static org.techtown.ai_eng_v2_00.Ril_rank1.point1_clear_num;

public class Point1_clear extends Fragment {
    RilPoint rilPoint = new RilPoint();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.ril_rank2, container, false);

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.ril_rank2,
                container,
                false);
        TextView textView2 = view.findViewById(R.id.textView2);
        textView2.setText(point1_clear_num);

        Button button11 = view.findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, rilPoint);
                transaction.commit();
            }
        });





        return view;
    }
}
*/
