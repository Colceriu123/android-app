package com.example.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.Student;
import com.example.myapplication.dao.StudentDao;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDao studentDao();

    public static StudentDatabase INSTANCE;

    public static StudentDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StudentDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), StudentDatabase.class, "student_database").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}
