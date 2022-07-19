package com.example.mock1.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mock1.model.Media;

import java.util.List;

@Dao
public interface MediaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert_media(Media media);

    @Query("SELECT *FROM media  where id=:id")
    List<Media>checklmedia(int id);


    @Query("SELECT * FROM MEDIA")
    List<Media>getAll();


    @Update
    void updatemedia(Media media);

    @Delete
    void deletemedia(Media media);

    @Query("SELECT * FROM MEDIA where ID=:id")
    List<Media>Search_id(int id);

    @Query("SELECT * FROM MEDIA ORDER BY medianame")
    List<Media>get_sort_name();

    @Query("SELECT * FROM MEDIA ORDER BY price")
    List<Media>get_sort_price();

    @Query("SELECT * FROM MEDIA WHERE MEDIANAME LIKE '%' || :name || '%'")
    List<Media>Searchmedia(String name);

    @Query("SELECT * FROM MEDIA WHERE price >=:money")
    List<Media>get_money(Double money);

}
