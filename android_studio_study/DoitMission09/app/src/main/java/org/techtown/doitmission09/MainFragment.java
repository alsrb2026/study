package org.techtown.doitmission09;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.fragment.app.Fragment;


public class MainFragment extends Fragment {
    EditText editText;
    EditText ageText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main,container,false);



        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
//                int age = Integer.parseInt(ageText.getText().toString());
                Toast.makeText(getActivity(), "이름은 = "+name, Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;
    }
}
