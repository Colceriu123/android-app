package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.repository.StudentRepository;

import java.util.List;

public class StudentsViewmodel extends AndroidViewModel {

    StudentRepository repository;
    LiveData<List<Student>> studentList;

    public StudentsViewmodel(Application application){
        super(application);
        repository = new StudentRepository(application);
        studentList = repository.getStudent();
    }

    LiveData<List<Student>> getAllStudents(){
        return studentList;
    }

    public void insertStudent(Student student){
        repository.insert(student);
    }
}
