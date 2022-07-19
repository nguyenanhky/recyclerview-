package com.example.mock1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mock1.Database.Mediadatabase;
import com.example.mock1.model.Media;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;
    private EditText txt_mediacode;
    private EditText txt_medianame;
    private EditText txt_transportation;
    private EditText txt_price;

    private Button btn_add, btn_search_id,btn_sort_name, btn_sort_price,btn_search_name, btn_show_money;

    private List<Media> list_media;
    private MediaAdapter mediaAdapter;
    private RecyclerView rcv_media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // anh xa
        txt_mediacode = findViewById(R.id.txt_mediacode);
        txt_medianame = findViewById(R.id.txt_medianame);
        txt_transportation = findViewById(R.id.txt_transportation);
        txt_price = findViewById(R.id.txt_price);

        btn_add = findViewById(R.id.btn_add);
        btn_search_id = findViewById(R.id.btn_search_id);
        btn_sort_name = findViewById(R.id.btn_sort_name);
        btn_sort_price = findViewById(R.id.btn_sort_price);
        btn_search_name = findViewById(R.id.btn_search_name);
        btn_show_money = findViewById(R.id.btn_show_money);

        list_media = new ArrayList<>();
        mediaAdapter = new MediaAdapter(new MediaAdapter.Clickitemmedia() {
            @Override
            public void UpdateandDelete_media(Media media) {
                click_update_and_delete(media);
            }
        });
        rcv_media = findViewById(R.id.rcv_media);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_media.setLayoutManager(linearLayoutManager);
        rcv_media.setAdapter(mediaAdapter);

        // event
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_media();
            }
        });

        btn_search_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Search_id_media();
            }
        });
        btn_sort_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sort_name();
            }
        });
        btn_sort_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sort_price();
            }
        });
        btn_search_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Search_name();
            }
        });
        btn_show_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Show_money();
            }
        });
        loadData();
    }

    private void Show_money() {
        Double money = Double.parseDouble(txt_price.getText().toString());
        List<Media>mlistmoney = new ArrayList<>();
        mlistmoney = Mediadatabase.getInstance(this).mediaDao().get_money(money);
        mediaAdapter.setData(mlistmoney);
    }

    private void Search_name() {
        String txt_search =txt_medianame.getText().toString().trim();
        List<Media>mediaList = new ArrayList<>();
        mediaList = Mediadatabase.getInstance(this).mediaDao().Searchmedia(txt_search);
        if(mediaList.size()==0){
            Toast.makeText(this,"không có trong hệ thống", Toast.LENGTH_SHORT).show();
            return;
        }
        mediaAdapter.setData(mediaList);
    }

    private void Sort_price() {
        list_media = Mediadatabase.getInstance(this).mediaDao().get_sort_price();
        mediaAdapter.setData(list_media);
    }

    private void Sort_name() {
        list_media  = Mediadatabase.getInstance(this).mediaDao().get_sort_name();
        mediaAdapter.setData(list_media);
    }

    private void Search_id_media() {
        int id = Integer.parseInt(txt_mediacode.getText().toString().trim());
        List<Media>mlist = new ArrayList<>();
        mlist = Mediadatabase.getInstance(this).mediaDao().Search_id(id);
        if(mlist.size()==0){
            Toast.makeText(this, "không tồn tại phương tiện  id = "+id, Toast.LENGTH_SHORT).show();
            return;
        }
        mediaAdapter.setData(mlist);
    }

    private void click_update_and_delete(Media media) {
        Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("objmedia", media);
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_CODE);
    }

    private void loadData() {
        list_media = Mediadatabase.getInstance(this).mediaDao().getAll();
        mediaAdapter.setData(list_media);
    }

    private void add_media() {
        int id = Integer.parseInt(txt_mediacode.getText().toString());
        String medianame = txt_medianame.getText().toString().trim();
        String transportation = txt_transportation.getText().toString();
        Double price = Double.parseDouble(txt_price.getText().toString());

        Media media = new Media(id, medianame, transportation, price);
        if (check_id(media)) {
            Toast.makeText(this, "đã có trong hệ thống", Toast.LENGTH_SHORT).show();
            txt_mediacode.setText("");
            txt_medianame.setText("");
            txt_transportation.setText("");
            txt_price.setText("");
            return;
        }
        Mediadatabase.getInstance(this).mediaDao().insert_media(media);
        Toast.makeText(this, "thêm thành công ", Toast.LENGTH_SHORT).show();
        txt_mediacode.setText("");
        txt_medianame.setText("");
        txt_transportation.setText("");
        txt_price.setText("");
        loadData();

    }

    private boolean check_id(Media media) {
        List<Media> list = Mediadatabase.getInstance(this).mediaDao().checklmedia(media.getId());
        return list != null && !list.isEmpty();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            loadData();
        }
    }
}