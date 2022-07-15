package kynv1.fsoft.picassodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
//        Picasso.with(this)
//                .load("http://anhnendep.net/wp-content/uploads/2016/02/vit-boi-roi-Psyduck.jpg")
//                .into(imageView);


        Picasso
                .get()
                .load("http://anhnendep.net/wp-content/uploads/2016/02/vit-boi-roi-Psyduck.jpg")
                .into(imageView);

    }
}