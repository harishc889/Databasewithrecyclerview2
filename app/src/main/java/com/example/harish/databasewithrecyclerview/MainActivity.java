package com.example.harish.databasewithrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ArrayList<Student> studentArrayList = new ArrayList<>();
    Button btn,display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.addbutton);
        display= findViewById(R.id.displaybutton);

        btn.setOnClickListener(new View.
                OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        MainActivity.this,
                        SecondActivity.class);


                startActivity(intent);
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(
                        MainActivity.this,
                        MainActivity2.class);


                startActivity(intent);


            }
        });


}
}
