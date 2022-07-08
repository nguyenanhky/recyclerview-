package com.example.viewtypedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.viewtypedemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ActorAdapter actorAdapter;
    private List<Actor> actorList;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayout;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private int mCurrentTypeDisplay = Actor.TYPE_GRID;
    private Menu menu;
    private static final String TAG = "logger";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gridLayoutManager = new GridLayoutManager(this, 2);
        linearLayout = new LinearLayoutManager(this);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        addEvent();


    }

    private void addEvent() {
        binding.rcvActor.setLayoutManager(gridLayoutManager);
        actorList = new ArrayList<>();
        actorList.add(new Actor(R.drawable.messi));
        actorList.add(new Actor(R.drawable.conan));
        actorList.add(new Actor(R.drawable.inista));
        actorList.add(new Actor(R.drawable.tom));
        actorList.add(new Actor(R.drawable.jerry));
        actorList.add(new Actor(R.drawable.ran));
        actorList.add(new Actor(R.drawable.sontung));
        actorList.add(new Actor(R.drawable.xavi));
        actorList.add(new Actor(R.drawable.phanmanhquynh));
        actorList.add(new Actor(R.drawable.midu));

        actorList.add(new Actor(R.drawable.messi));
        actorList.add(new Actor(R.drawable.conan));
        actorList.add(new Actor(R.drawable.inista));
        actorList.add(new Actor(R.drawable.tom));
        actorList.add(new Actor(R.drawable.jerry));
        actorList.add(new Actor(R.drawable.ran));
        actorList.add(new Actor(R.drawable.sontung));
        actorList.add(new Actor(R.drawable.xavi));
        actorList.add(new Actor(R.drawable.phanmanhquynh));
        actorList.add(new Actor(R.drawable.midu));


        setTypeDisplayRCV(Actor.TYPE_GRID);
        actorAdapter = new ActorAdapter(actorList);
        binding.rcvActor.setAdapter(actorAdapter);

    }

    private void setTypeDisplayRCV(int typeDisplay) {
        if(actorList==null){
            return;
        }
        mCurrentTypeDisplay = typeDisplay;
        for(Actor actor:actorList){
            actor.setTypeDisplay(typeDisplay);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_menu){
            Log.d(TAG, "onOptionsItemSelected: "+"nguyen anh ky");
            onClickChangeTypeDisplay();
        }
        return true;
    }

    private void onClickChangeTypeDisplay() {
        if(mCurrentTypeDisplay==Actor.TYPE_GRID){
            setTypeDisplayRCV(Actor.TYPE_LISt);
            binding.rcvActor.setLayoutManager(linearLayout);
        }else if(mCurrentTypeDisplay==Actor.TYPE_LISt){
            setTypeDisplayRCV(Actor.TYPE_GRID);
            binding.rcvActor.setLayoutManager(staggeredGridLayoutManager);
        }
        else if(mCurrentTypeDisplay==Actor.TYPE_STAGGERED){
            setTypeDisplayRCV(Actor.TYPE_STAGGERED);
            binding.rcvActor.setLayoutManager(gridLayoutManager);
        }
        actorAdapter.notifyDataSetChanged();
       // setIconMenu();
    }

    private void setIconMenu() {
        switch (mCurrentTypeDisplay){
            case Actor.TYPE_GRID:
                menu.getItem(0).setIcon(R.drawable.ic_grid);
                break;
            case Actor.TYPE_LISt:
                menu.getItem(0).setIcon(R.drawable.ic__list);

                break;
            case Actor.TYPE_STAGGERED:
                menu.getItem(0).setIcon(R.drawable.ic_list_alt_);
                break;
        }
    }
}