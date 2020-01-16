package org.techtown.doitmission09;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

        private Button birth;
        private DatePickerDialog.OnDateSetListener callbackMethod;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            this.InitializeView();
            this.InitializeListener();

         /*   Date currentTime = Calendar.getInstance().getTime();
            SimpleDateFormat weekdayFormat = new SimpleDateFormat("EE", Locale.getDefault());
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
            SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

            String weekDay = weekdayFormat.format(currentTime);
            String year = yearFormat.format(currentTime);
            String month = monthFormat.format(currentTime);
            String day = dayFormat.format(currentTime);*/

        }

        public void InitializeView()
        {
            birth = (Button)findViewById(R.id.birth);
        }

        public void InitializeListener()
        {
            callbackMethod = new DatePickerDialog.OnDateSetListener()
            {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                {
                    monthOfYear=monthOfYear+1;
                    birth.setText(year + "년" + monthOfYear + "월" + dayOfMonth + "일");
                }
            };
        }

        public void OnClickHandler(View view)
        {
            DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod, 2019, 5, 24);
            dialog.show();
        }
    }