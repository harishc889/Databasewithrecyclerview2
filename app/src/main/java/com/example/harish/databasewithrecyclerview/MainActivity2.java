package com.example.harish.databasewithrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity
        implements RecyclerAdapter.ListItemClickListener{

    ArrayList<Student> studentModelArrayList = new ArrayList<>();


    RecyclerView recyclerView;

    DatabaseHelper databaseHelper;
    RecyclerAdapter recyclerAdapter;




    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        setContentView(R.layout.recyclerview);

        recyclerView = findViewById(R.id.recycler_view_samples);
        studentModelArrayList = (ArrayList<Student>) databaseHelper.allStudentsDetail();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new
                RecyclerAdapter(studentModelArrayList,
                this);

        recyclerView.setAdapter(recyclerAdapter);
    }


    @Override
    public void onListItemClickListener(int clickedItemIndex) {
        Toast.makeText(getApplicationContext(), studentModelArrayList.get(clickedItemIndex).name, Toast.LENGTH_SHORT).show();
    }
}
