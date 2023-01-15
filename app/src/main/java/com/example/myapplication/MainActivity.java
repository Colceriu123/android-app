package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentsViewmodel viewmodel = ViewModelProviders.of(this).get(StudentsViewmodel.class);

        Student bob = new Student("Bob","Vance");
        Student phyllis = new Student("Phyllis", "Smith");

        //db.studentDao().insertAll(bob,phyllis);

        //List<Student> studentList = db.studentDao().getAllStudents();

        viewmodel.getAllStudents().observe(this, studentList -> {

            for (Student list: studentList){
                Log.d("students",list.firstName + " " + list.lastName);
            }
        });

    }
}