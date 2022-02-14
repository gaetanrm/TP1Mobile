package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddEvent extends AppCompatActivity {

    EditText date, time, title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        date = (EditText)findViewById(R.id.editTextDate);
        time = (EditText)findViewById(R.id.editTextTime);
        title = (EditText)findViewById(R.id.editText2);
        description = (EditText)findViewById(R.id.editText);


    }

    public void submitEvent(View view){
        Intent intent = new Intent(AddEvent.this, MainActivity.class);
        intent.putExtra("date", date.getText().toString());
        intent.putExtra("time", time.getText().toString());
        intent.putExtra("title", title.getText().toString());
        intent.putExtra("description", description.getText().toString());
        startActivity(intent);
    }
}