package com.example.horairesdetrain;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText from, to;

    ArrayList<Trajet> listTrajet;
    private Object ArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        from = (EditText)findViewById(R.id.from);
        to = (EditText)findViewById(R.id.to);

        listTrajet = makeListTrajet();
    }

    public void myOnClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choisir");
        builder.setMessage("Voulez vous valider ?");
        builder.setPositiveButton("CONFIRMER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Submit" + "\n" +
                        "From :" + from.getText().toString() +"\n"+
                        "To :" + to.getText().toString(), Toast.LENGTH_LONG).show();
                String userCityFrom = from.getText().toString();
                String userCityTo = to.getText().toString();
                Intent intent = new Intent(MainActivity.this, ResultRoutes.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("RoutesList", listTrajet);
                intent.putExtras(bundle);
                intent.putExtra("userCityFrom", userCityFrom);
                intent.putExtra("userCityTo", userCityTo);
                startActivity(intent);
            }

        });

        builder.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public ArrayList<Trajet> makeListTrajet(){
        ArrayList<String> ville = new ArrayList<String>();
        ville.add("Montpellier");
        ville.add("Toulouse");
        ville.add("Marseille");
        ville.add("Perpignan");
        ville.add("Nice");

        ArrayList<Trajet> trajets = new ArrayList<Trajet>();
        int random = (int)(Math.random() * 80);
        for(int i = 0; i <= random; i++){
            int rand1 = (int)(Math.random() * 5);
            int rand2 = (int)(Math.random() * 5);
            while(rand2 == rand1){
                rand2 = (int)(Math.random() * 5);
            }
            int hour = (int)(Math.random() * 24);
            int minute = (int)(Math.random() * 60);
            trajets.add(new Trajet(ville.get(rand1), ville.get(rand2), "" + hour + "h" + minute));
        }
        return trajets;

    }

    public void seeRoutes(View view){
        Intent intent = new Intent(MainActivity.this, RoutesList.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("RoutesList", listTrajet);
        intent.putExtras(bundle);
        startActivity(intent);
        /*Intent intent = new Intent(MainActivity.this, RoutesList.class);
        intent.putExtra("RoutesList", ArrayList<Trajet> listTrajet);
        startActivity(intent);*/
    }
}