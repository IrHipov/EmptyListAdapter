package com.example.emptylistadapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {
    private static final int VIEW_TYPE_DATE = 1;
    private static final int VIEW_TYPE_EMPTY = 0;

    List<String> items;

    public AdapterList(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        ViewHolder vh;
        if (viewType == VIEW_TYPE_DATE) {
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.list_item, parent, false);
            vh = new ViewHolderItem(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.list_empty_item, parent, false);
            vh = new ViewHolderEmptyItem(v);
        }

        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        if (items.size() == 0) {
            return VIEW_TYPE_EMPTY;
        } else {
            return VIEW_TYPE_DATE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return items.size() == 0 ? 1 : items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class ViewHolderEmptyItem extends ViewHolder {
        public ViewHolderEmptyItem(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class ViewHolderItem extends ViewHolder {
        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
        }
    }
}
