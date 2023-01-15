package com.example.myapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertAll(Student... students);

    @Query("SELECT * FROM Student")
    LiveData<List<Student>> getAllStudents();
}