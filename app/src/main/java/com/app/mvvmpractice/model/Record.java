package com.app.mvvmpractice.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "record_table")
public class Record {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "record")
    private String record;

    @NonNull
    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
