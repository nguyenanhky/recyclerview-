package com.example.mvvmdemo.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.mvvmdemo.BR;
import com.example.mvvmdemo.Constance;

@Entity(tableName = Constance.TABLENAMECATEGORY)
public class Category extends BaseObservable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = Constance.CATEGORYNAME)
    private String categoryName;
    @ColumnInfo(name = Constance.CATEGORYDESTINATON)
    private String categoryDescription;

    public Category() {
    }

    public Category(int id, String categoryName, String categoryDescription) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        notifyPropertyChanged(BR.categoryName);
    }

    @Bindable
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
        notifyPropertyChanged(BR.categoryDescription);
    }
}
