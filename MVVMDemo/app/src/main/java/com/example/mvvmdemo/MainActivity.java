package com.example.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmdemo.databinding.ActivityMainBinding;
import com.example.mvvmdemo.model.Book;
import com.example.mvvmdemo.model.Category;
import com.example.mvvmdemo.viewmodel.ActivityMainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ActivityMainViewModel activityMainViewModel;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        activityMainViewModel = new ViewModelProvider(this).get(ActivityMainViewModel.class);

        activityMainViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                for(Category category : categories){
                    // chua lien quan gì den database
                    Log.i(TAG, "category: "+ category.getCategoryName());
                }
            }
        });


//        activityMainViewModel.getBooksASelectedCategory(1).observe(this, new Observer<List<Book>>() {
//            @Override
//            public void onChanged(List<Book> books) {
//                for(Book book: books){
//                    Log.i(TAG, "Book: "+ book.getBookName());
//                }
//            }
//        });


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "nguyen anh ky ", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class MainActivityClickHandlers{
        Context context;

        public MainActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onEnrollButtonclicked(View view){
            Toast.makeText(context, "Enroll clicked ", Toast.LENGTH_SHORT).show();
        }
        public void onCancellButtonclicked(View view){
            Toast.makeText(context, "Cancel clicked ", Toast.LENGTH_SHORT).show();
        }
    }
}