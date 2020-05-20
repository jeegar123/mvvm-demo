package com.app.mvvmpractice;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mvvmpractice.adapter.RecordAdapter;
import com.app.mvvmpractice.model.Record;
import com.app.mvvmpractice.viewmodel.RecordViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecordViewModel recordViewModel;

    private LiveData<List<Record>> liveData;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recycleViewRecords);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        activateViewModeWithLiveData();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Record record1 = new Record();
                record1.setRecord(random());
                recordViewModel.insert(record1);
            }
        });
    }

    public void activateViewModeWithLiveData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        final RecordAdapter recordAdapter = new RecordAdapter();
        recyclerView.setAdapter(recordAdapter);

        recordViewModel = ViewModelProviders.
                of(this)
                .get(RecordViewModel.class);

        recordViewModel.getRecords().observe(this, new Observer<List<Record>>() {
            @Override
            public void onChanged(List<Record> records) {
                recordAdapter.setRecord(records);
            }
        });
    }

    //    random string generator
    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(10);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        if (randomStringBuilder.toString().trim().isEmpty())
            random();
        return randomStringBuilder.toString().trim();
    }
}
