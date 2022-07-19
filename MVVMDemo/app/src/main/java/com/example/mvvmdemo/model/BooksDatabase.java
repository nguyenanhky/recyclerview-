package com.example.mvvmdemo.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mvvmdemo.Constance;

@Database(entities = {Category.class, Book.class}, version = 1)

public abstract class BooksDatabase extends RoomDatabase {
    public abstract CategoryDao categoryDao();
    public abstract BookDao bookDao();
    private static BooksDatabase instance;

    private static final String TAG = "BooksDatabase";
    
    public static synchronized BooksDatabase getInstance(Context context) {
        Log.i(TAG, "getInstance: ");
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            BooksDatabase.class, Constance.BOOKNAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.d(TAG, "onCreate:RoomDatabase.Callback ");
            new InitialDataAsynTask(instance).execute();
        }
    };

    private static class InitialDataAsynTask extends AsyncTask<Void, Void, Void> {
        private CategoryDao categoryDao;
        private BookDao bookDao;

        public InitialDataAsynTask(BooksDatabase booksDatabase) {
            categoryDao = booksDatabase.categoryDao();
            bookDao = booksDatabase.bookDao();
            Log.i(TAG, "InitialDataAsynTask: ");}

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "doInBackground: ");
            Category category1 = new Category();
            category1.setCategoryName("text Book");
            category1.setCategoryDescription("Text Book Description");

            Category category = new Category();
            category.setCategoryName("Novels");
            category.setCategoryDescription("Novels Dscription");

            Category category2 = new Category();
            category2.setCategoryName("Other Book");
            category2.setCategoryDescription("Text Book Description");


            categoryDao.insert(category);
            categoryDao.insert(category1);
            categoryDao.insert(category2);


            Book book = new Book();
            book.setBookName("High school java");
            book.setUnitPrice("$150");
            book.setCategoryId(1);

            Book book1 = new Book();
            book1.setBookName("Mathematics for beginners");
            book1.setUnitPrice("150$");
            book1.setCategoryId(1);

            Book book2 = new Book();
            book2.setBookName("Object Oriented Adnorid App Design");
            book2.setUnitPrice("$150");
            book2.setCategoryId(1);

            Book book3 = new Book();
            book3.setBookName("Astrolgogy for beginners");
            book3.setUnitPrice("$150");
            book3.setCategoryId(1);

            Book book4 = new Book();
            book4.setBookName("High school java");
            book4.setUnitPrice("$150");
            book4.setCategoryId(1);

            Book book5 = new Book();
            book5.setBookName("Chemistry for secondary school students");
            book5.setUnitPrice("$250");
            book5.setCategoryId(1);


            bookDao.insert(book1);
            bookDao.insert(book2);
            bookDao.insert(book3);
            bookDao.insert(book4);
            bookDao.insert(book);
            bookDao.insert(book5);


            return null;
        }
    }
}
