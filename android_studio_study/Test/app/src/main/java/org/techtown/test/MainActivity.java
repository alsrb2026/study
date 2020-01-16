package org.techtown.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity{

    private TextView textView_Date;
    private TimePickerDialog.OnTimeSetListener callbackMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InitializeView();
        this.InitializeListener();

        t
    }

    public void InitializeView()
    {
        textView_Date = (TextView)findViewById(R.id.textView_date);
    }

    public void InitializeListener()
    {
        callbackMethod = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute)
            {
                textView_Date.setText(hourOfDay + "시" + minute + "분");
            }
        };
    }
    public void OnClickHandler(View view)
    {
        TimePickerDialog dialog = new TimePickerDialog(this, callbackMethod, 8, 10, true);

        dialog.show();
    }
}