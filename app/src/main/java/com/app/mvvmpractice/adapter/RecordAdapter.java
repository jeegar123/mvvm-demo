package com.app.mvvmpractice.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mvvmpractice.R;
import com.app.mvvmpractice.model.Record;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordHolder> {

    private List<Record> records;

    @NonNull
    @Override
    public RecordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecordHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecordHolder holder, int position) {
        holder.textView.setText(records.get(position).getRecord());
    }

    @Override
    public int getItemCount() {
        if (records != null)
            return records.size();
        return 0;
    }

    public void setRecord(List<Record> record) {
        records = record;
        notifyDataSetChanged();
    }
}
