package com.app.mvvmpractice.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.app.mvvmpractice.dao.RecordDao;
import com.app.mvvmpractice.database.RecordRoomDatabase;
import com.app.mvvmpractice.model.Record;

import java.lang.ref.PhantomReference;
import java.util.List;

public class RecordRepository {

    private RecordDao recordDao;

    private LiveData<List<Record>> data;

    public RecordRepository(Application application) {
        RecordRoomDatabase recordRoomDatabase = RecordRoomDatabase.getINSTANCE(application);
        recordDao = recordRoomDatabase.recordDao();
        data=recordDao.getAllRecords();
    }

    public void insert(Record record) {
        new InsertAsyncTask(recordDao).execute(record);
    }


    private static class InsertAsyncTask extends AsyncTask<Record, Void, Void> {

        RecordDao recordDao;

        InsertAsyncTask(RecordDao recordDao) {
            this.recordDao = recordDao;
        }

        @Override
        protected Void doInBackground(Record... records) {
            recordDao.insert(records[0]);
            return null;
        }
    }

    public LiveData<List<Record>> getData() {
        return data;
    }
}
