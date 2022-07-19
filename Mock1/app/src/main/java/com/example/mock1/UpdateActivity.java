package com.example.mock1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mock1.Database.Mediadatabase;
import com.example.mock1.model.Media;

public class UpdateActivity extends AppCompatActivity {
    private EditText txt_medianame;
    private EditText txt_transportation;
    private EditText txt_price;

    private Button btn_update, btn_delete;

    private Media media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        txt_medianame = findViewById(R.id.txt_medianame);
        txt_transportation = findViewById(R.id.txt_transportation);
        txt_price = findViewById(R.id.txt_price);

        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        // receved data
        media = (Media) getIntent().getExtras().get("objmedia");
        if(media==null){
            return;
        }
        txt_medianame.setText(media.getMedianame());
        txt_transportation.setText(media.getTransportation());
        txt_price.setText(media.getPrice()+"");

        // update
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Updatemedia();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Deletemedia();
            }
        });
    }

    private void Deletemedia() {
        new AlertDialog.Builder(this)
                .setTitle("xóa phương tiện này ")
                .setMessage("bạn có chắc không  ?")
                .setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Mediadatabase.getInstance(UpdateActivity.this).mediaDao().deletemedia(media);
                        Toast.makeText(UpdateActivity.this, "xóa thành công ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        setResult(Activity.RESULT_OK,intent);
                        finish();
                    }
                })
                .setNegativeButton("không ",null)
                .show();
    }

    private void Updatemedia() {
        String medianame = txt_medianame.getText().toString().trim();
        String transportation = txt_transportation.getText().toString().trim();
        Double price = Double.parseDouble(txt_price.getText().toString().trim());

        media.setMedianame(medianame);
        media.setTransportation(transportation);
        media.setPrice(price);

        Mediadatabase.getInstance(this).mediaDao().updatemedia(media);
        Toast.makeText(this, "cập nhật thành công ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}