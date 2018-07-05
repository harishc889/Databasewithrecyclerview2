package com.example.harish.databasewithrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/*
 * @author Gurjas Singh,
 * Brillica Services, Dehradun
 * 7/May/2018*/

public class SecondActivity extends AppCompatActivity  {

    static final String TAG = MainActivity.class.getName();
    /*
     * Creating global object of different views that we
     * are going to use in our application.
     * */
    EditText studentNameTF, studentPhoneTF, studentFeesTF,collegeNameTF;
    Button addStudentBtn;


    /*
     * Creating a global collegeName String object.*/


    /*
     * ArrayList of Student class will be used
     * to store the data of individual student.*/
    ArrayList<Student> studentArrayList = new ArrayList<>();

    /*
     * Creating a spinner object*/


    /*
     * Creating a string of array of colleges*/


    /*
     * Database Helper*/
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_details);

        /*
         * casting objects with the respective view ids.*/
        studentNameTF = findViewById(R.id.editText5);
        studentPhoneTF = findViewById(R.id.editText3);
        studentFeesTF = findViewById(R.id.editText4);
        collegeNameTF= findViewById(R.id.editText6);
        addStudentBtn = findViewById(R.id.buttonadd);






        databaseHelper = new DatabaseHelper(this);

        /*
         * Using setOnItemSelectedListener on spinner object
         * and giving it the context - this, meaning current activity*/


        /*
         * Creating an arrayAdapter object and passing 3 different arguments
         * i.e. context, layout, array*/


        /*
         * using the spinner's setAdapter method to update it's adapter*/


        /*
         * setPrompt is select on spinner to just give the refernce that the
         * first object of array is only a label.*/


        /*
         * Adding a click listener on addStudentBtn*/
        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                 * On the click of the button, getting values from
                 * the user input.*/
                String name = studentNameTF.getText().toString();
                int phone = Integer.parseInt(studentPhoneTF.getText().toString());
                int fees = Integer.parseInt(studentFeesTF.getText().toString());
                String college=collegeNameTF.getText().toString();

                /*
                 * Storing the new values into the arrayList using the
                 * Student class object.*/
                databaseHelper.addNewStudent(new Student( name,
                        college, fees, phone));

                /*
                 * Showing a success message once the data has been saved into arrayList*/
                Toast.makeText(getApplicationContext(), "Student data saved successfully", Toast.LENGTH_LONG).show();
            }
        });

        /*
         * Display button used to display the data of students*/


    }


}