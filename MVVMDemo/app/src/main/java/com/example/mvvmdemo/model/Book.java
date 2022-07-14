package com.example.mvvmdemo.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.mvvmdemo.BR;
import com.example.mvvmdemo.Constance;

@Entity(
        tableName =  Constance.TABLENAMEBOOKS,
        foreignKeys = @ForeignKey(entity = Category.class,parentColumns = "id", childColumns = Constance.CATEGORYID,onDelete = CASCADE)
)
public class Book extends BaseObservable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constance.BOOKID)
    private int bookId;

    @ColumnInfo(name = Constance.BOOKNAME)
    private String bookName;

    @ColumnInfo(name = Constance.UNNITPRICE)
    private String unitPrice;

    @ColumnInfo(name = Constance.CATEGORYID)
    private int categoryId ;

    public Book() {
    }

    public Book(int bookId, String bookName, String unitPrice, int categoryId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
    }

    @Bindable
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
        notifyPropertyChanged(BR.bookId);
    }

    @Bindable
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        notifyPropertyChanged(BR.bookName);
    }

    @Bindable
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        notifyPropertyChanged(BR.unitPrice);
    }

    @Bindable
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        notifyPropertyChanged(BR.categoryId);
    }
}
