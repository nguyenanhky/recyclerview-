package com.example.mvvmdemo.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmdemo.model.Book;
import com.example.mvvmdemo.model.Category;
import com.example.mvvmdemo.model.EBookShopRepository;

import java.util.List;

public class ActivityMainViewModel extends AndroidViewModel {
    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>>allCategories;
    private LiveData<List<Book>>booksASelectedCategory;

    private static final String TAG = "ActivityMainViewModel";

    public ActivityMainViewModel(@NonNull Application application) {
        super(application);
        Log.i(TAG, "ActivityMainViewModel: ");
        eBookShopRepository = new EBookShopRepository(application);

    }

    public LiveData<List<Category>> getAllCategories() {
        Log.i(TAG, "getAllCategories: ");
        allCategories = eBookShopRepository.getCategories();
        return allCategories;
    }


    public LiveData<List<Book>> getBooksASelectedCategory(int categoryId) {
        Log.i(TAG, "getBooksASelectedCategory: ");
        booksASelectedCategory = eBookShopRepository.getBooks(categoryId);
        return booksASelectedCategory;
    }

    public void addNewBook(Book book){
        eBookShopRepository.insertBook(book);
    }
    public void updateBook(Book book){
        eBookShopRepository.updateBook(book);
    }
    public void deleteBook(Book book){
        eBookShopRepository.deleteBook(book);
    }
}
