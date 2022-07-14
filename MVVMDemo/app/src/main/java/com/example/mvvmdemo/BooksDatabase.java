package com.example.mvvmdemo;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mvvmdemo.model.Book;
import com.example.mvvmdemo.model.Category;

@Database(entities = {Category.class, Book.class},version = 1)

public abstract class BooksDatabase extends RoomDatabase {
    public abstract CategoryDao categoryDao();
    public abstract BookDao bookDao();
    private static BooksDatabase instance;

    public static synchronized BooksDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    BooksDatabase.class,Constance.BOOKNAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    private static class InitialDataAsynTask extends AsyncTask<Void,Void,Void>{
        private CategoryDao categoryDao;
        private BookDao bookDao;

        public InitialDataAsynTask(BooksDatabase booksDatabase) {
            categoryDao = booksDatabase.categoryDao();
            bookDao = booksDatabase.bookDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
