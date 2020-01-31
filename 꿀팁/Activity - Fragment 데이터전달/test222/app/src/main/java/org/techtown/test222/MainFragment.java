package org.techtown.test222;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment
{
    TextView tv_fragment;
    Button btn_fragment;
    public MainFragment()
    {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        tv_fragment = (TextView)view.findViewById(R.id.tv_fragment);
        btn_fragment = (Button)view.findViewById(R.id.btn_fragment);

        btn_fragment.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((MainActivity)getActivity()).changeText("하하하");
            }
        });
        return view;
    }

    public void changeFragmentTextView(String text)
    {
        tv_fragment.setText(text);
    }
}
