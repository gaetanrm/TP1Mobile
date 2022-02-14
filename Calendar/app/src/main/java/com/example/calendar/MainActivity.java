package com.example.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CalendarView calendar;
    TextView dateView;
    LinearLayout ll;

    static ArrayList<Evenement> listEvenements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = findViewById(R.id.calender);
        dateView = findViewById(R.id.dateView);
        ll = (LinearLayout)findViewById(R.id.linearlayout);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                dateView.setText(Date);
                ll.removeAllViews();
                for (Evenement e : listEvenements){
                    if ((dayOfMonth == e.getDay()) && (month+1 == e.getMonth()) && (year == e.getYear())) {
                        TextView txtEvent = new TextView(MainActivity.this);
                        txtEvent.setText("Date: " + e.getDay() + "/" + e.getMonth() + "/" + e.getYear() +
                                " Time: " + e.getHour() + "h \nTitle: " + e.getTitle() +
                                " Description: " + e.getDescr());
                        ll.addView(txtEvent);
                    }
                }
            }
        });

        Intent intent2 = getIntent();
        Bundle bundle = intent2.getExtras();
        if (bundle != null) {
            String date = bundle.getString("date");
            String time = bundle.getString("time");
            String title = bundle.getString("title");
            String descr = bundle.getString("description");

            String spliter = "/";
            String dateContainer[] = date.split(spliter);
            int day, month, year, hour;
            day = Integer.parseInt(dateContainer[0]);
            month = Integer.parseInt(dateContainer[1]);
            year = Integer.parseInt(dateContainer[2]);
            hour = Integer.parseInt(time);
            Evenement event = new Evenement(day, month, year, hour, title, descr);
            listEvenements.add(event);
        }
    }

    public void addEvent(View view){
        Intent intent = new Intent(MainActivity.this, AddEvent.class);
        startActivity(intent);
    }
}