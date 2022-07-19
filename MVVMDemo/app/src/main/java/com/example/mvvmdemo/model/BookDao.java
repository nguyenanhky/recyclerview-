package com.example.mvvmdemo.model;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mvvmdemo.Constance;
import com.example.mvvmdemo.model.Book;
import com.example.mvvmdemo.model.Category;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("SELECT * FROM "+ Constance.TABLENAMEBOOKS)
    LiveData<List<Book>> getAllBooks();


    @Query("SELECT * FROM book_table WHERE catefory_id==:categoryId")
    LiveData<List<Book>>getBooks(int categoryId);

}
