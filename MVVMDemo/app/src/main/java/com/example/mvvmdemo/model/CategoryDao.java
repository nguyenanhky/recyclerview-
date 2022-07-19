package com.example.mvvmdemo.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mvvmdemo.Constance;
import com.example.mvvmdemo.model.Category;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("SELECT * FROM "+ Constance.TABLENAMECATEGORY)
    LiveData<List<Category>>getAllcategories();
}
