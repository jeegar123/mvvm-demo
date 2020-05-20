package com.app.mvvmpractice.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mvvmpractice.R;

class RecordHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public RecordHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.txtRecord);
    }
}
