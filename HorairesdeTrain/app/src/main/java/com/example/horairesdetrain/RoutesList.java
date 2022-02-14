package com.example.horairesdetrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RoutesList extends AppCompatActivity {

    ArrayList<Trajet> listTrajets;

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_list);

        ll = ((LinearLayout)findViewById(R.id.linearlayout2));

        listTrajets = this.getIntent().getExtras().getParcelableArrayList("RoutesList");

        for(Trajet tra : listTrajets){
            TextView route = new TextView(this);
            route.setText(tra.getCityFrom().toString() + "->" + tra.getCityTo().toString() + " at " + tra.getTime());
            ll.addView(route);
        }
    }
}