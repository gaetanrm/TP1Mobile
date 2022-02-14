package com.example.horairesdetrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultRoutes extends AppCompatActivity {

    ArrayList<Trajet> listTrajets;
    String userCityFrom, userCityTo;

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_routes);

        ll = ((LinearLayout)findViewById(R.id.linearlayout3));

        Intent intent2 = getIntent();
        listTrajets = intent2.getExtras().getParcelableArrayList("RoutesList");
        Bundle bundle = intent2.getExtras();
        userCityFrom = bundle.getString("userCityFrom");
        userCityTo = bundle.getString("userCityTo");

        for(Trajet tr : listTrajets){
            String routeCityFrom = tr.getCityFrom().toString();
            String routeCityTo = tr.getCityTo().toString();
            if (routeCityFrom.equals(userCityFrom)) {
                if (routeCityTo.equals(userCityTo)) {
                    TextView newRoute = new TextView(ResultRoutes.this);
                    newRoute.setText(routeCityFrom + "->" + routeCityTo + " at " + tr.getTime());
                    ll.addView(newRoute);
                }
                else if (userCityTo.equals("")){
                    TextView newRoute = new TextView(ResultRoutes.this);
                    newRoute.setText(routeCityFrom + "->" + routeCityTo + " at " + tr.getTime());
                    ll.addView(newRoute);
                }
            }
            else if (userCityFrom.equals("")){
                if (routeCityTo.equals(userCityTo)){
                    TextView newRoute = new TextView(ResultRoutes.this);
                    newRoute.setText(routeCityFrom + "->" + routeCityTo + " at " + tr.getTime());
                    ll.addView(newRoute);
                }
                else if (userCityTo.equals("")){
                    TextView newRoute = new TextView(ResultRoutes.this);
                    newRoute.setText(routeCityFrom + "->" + routeCityTo + " at " + tr.getTime());
                    ll.addView(newRoute);
                }
            }
        }
    }
}