package com.app.mvvmpractice.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.app.mvvmpractice.model.Record;
import com.app.mvvmpractice.repo.RecordRepository;

import java.util.List;

public class RecordViewModel extends AndroidViewModel {

    private RecordRepository recordRepository;

    private LiveData<List<Record>> records;

    public RecordViewModel(@NonNull Application application) {
        super(application);
        recordRepository = new RecordRepository(application);
        records = recordRepository.getData();
    }

    public void insert(Record record) {
        recordRepository.insert(record);
    }

    public LiveData<List<Record>> getRecords() {
        return records;
    }
}
