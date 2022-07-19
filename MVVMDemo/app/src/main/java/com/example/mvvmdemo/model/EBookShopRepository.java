package com.example.mvvmdemo.model;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.mvvmdemo.model.Book;
import com.example.mvvmdemo.model.BookDao;
import com.example.mvvmdemo.model.BooksDatabase;
import com.example.mvvmdemo.model.Category;
import com.example.mvvmdemo.model.CategoryDao;

import java.util.List;

public class EBookShopRepository {
    private CategoryDao categoryDao;
    private BookDao bookDao;
    private LiveData<Category>categories;
    private LiveData<Book>books;

    private static final String TAG = "EBookShopRepository";

    public EBookShopRepository(Application application) {
        Log.i("ActivityMainViewModel", "EBookShopRepository: ");
        BooksDatabase booksDatabase = BooksDatabase.getInstance(application);
        categoryDao = booksDatabase.categoryDao();
        bookDao = booksDatabase.bookDao();
        Log.d(TAG, "EBookShopRepository: "+"ham tao ");

    }

    public LiveData<List<Category>> getCategories() {
        Log.i(TAG, "getCategories: + nguyen anh ky  ");
        return categoryDao.getAllcategories();
    }

    public LiveData<List<Book>> getBooks(int categories) {
        return bookDao.getBooks(categories);
    }

    /*
    Category
     */
    public void insertCategory(Category category){
        new InsertCategoryAsyncTask(categoryDao).execute(category);
    }

    private static class InsertCategoryAsyncTask extends AsyncTask<Category,Void,Void>{

        private CategoryDao categoryDao;

        public InsertCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            Log.i(TAG, "doInBackground: ");
            categoryDao.insert(categories[0]);
            return null;
        }
    }

    public void deleteCategory(Category category){
        new DeleteCategoryAsyncTask(categoryDao).execute(category);
    }

    private static class DeleteCategoryAsyncTask extends AsyncTask<Category,Void,Void>{

        private CategoryDao categoryDao;

        public DeleteCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.delete(categories[0]);
            return null;
        }
    }

    public void updateCategory(Category category){
        new UpdateCategoryAsyncTask(categoryDao).execute(category);
    }

    private static class UpdateCategoryAsyncTask extends AsyncTask<Category,Void,Void>{

        private CategoryDao categoryDao;

        public UpdateCategoryAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.update(categories[0]);
            return null;
        }
    }


    /*
    Books
     */

    public void insertBook(Book book){
       new InsertBookAsyncTask(bookDao).execute(book);
    }

    private static class InsertBookAsyncTask extends AsyncTask<Book,Void,Void>{

        private BookDao bookDao;

        public InsertBookAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.insert(books[0]);
            return null;
        }
    }


    public void deleteBook(Book book){
        new DeleteBookAsyncTask(bookDao).execute(book);
    }

    private static class DeleteBookAsyncTask extends AsyncTask<Book,Void,Void>{

        private BookDao bookDao;

        public DeleteBookAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.delete(books[0]);
            return null;
        }
    }

    public void updateBook(Book book){
        new UpdateBookAsyncTask(bookDao).execute(book);
    }

    private static class UpdateBookAsyncTask extends AsyncTask<Book,Void,Void>{

        private BookDao bookDao;

        public UpdateBookAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.update(books[0]);
            return null;
        }
    }


}
