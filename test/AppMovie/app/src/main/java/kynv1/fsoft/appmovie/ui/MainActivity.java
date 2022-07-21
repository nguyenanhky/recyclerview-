package kynv1.fsoft.appmovie.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kynv1.fsoft.appmovie.R;
import kynv1.fsoft.appmovie.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}