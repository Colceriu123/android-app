package com.example.myapplication.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.myapplication.Student;
import com.example.myapplication.dao.StudentDao;
import com.example.myapplication.database.StudentDatabase;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

import javax.xml.transform.Result;

public class StudentRepository {
    StudentDao studentDao;

    public StudentRepository(Application application){
        StudentDatabase db = StudentDatabase.getDatabase(application);
        studentDao = db.studentDao();
    }

    public LiveData<List<Student>> getStudent(){
        return  studentDao.getAllStudents();
    }

    public void insert(Student student){
        new insertAsyncTask(studentDao).execute(student);
    }

    private static class insertAsyncTask extends AsyncTask<Student, Void, Void>{
        private StudentDao taskDao;

        insertAsyncTask(StudentDao studentDao){
            taskDao = studentDao;
        }


        @Override
        protected Void doInBackground(Student... people) {
            taskDao.insertAll(people[0]);
            return null;
        }
    }
}
