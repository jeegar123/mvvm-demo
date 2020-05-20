package com.app.mvvmpractice.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.app.mvvmpractice.model.Record;

import java.util.List;

@Dao
public interface RecordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Record record);

    @Query("SELECT * FROM record_table")
    LiveData<List<Record>> getAllRecords();
}
