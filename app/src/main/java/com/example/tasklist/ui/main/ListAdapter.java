package com.example.tasklist.ui.main;

import android.sax.Element;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter
{
    private ArrayList<Task> mDataset;

    public ListAdapter()
    {
        this.mDataset = new ArrayList<Task>();
    }

    // Comment marche et que contient UN element de ma liste
    public static class ElementsHolder extends RecyclerView.ViewHolder
    {
        public TextView txt;
        public Button test;
        public ElementsHolder(TextView v, Button test)
        {
            super(v);
            txt = v;
            this.test = test;
        }

    }

    @NonNull
    @Override
    // Explique comment créer un élément de la liste
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        TextView v = new TextView(parent.getContext());
        Button test = new Button(parent.getContext());
        test.setText("fdf");
        return new ElementsHolder(v, test);
    }

    @Override
    // Mettre le contenu dans ce fameux éléments
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ((ElementsHolder)holder).txt.setText(mDataset.get(position).getText());
    }

    // Nombre d'elements dans ma liste
    @Override
    public int getItemCount() {
        return this.mDataset.size();
    }

    public void addItem(Task s) {
        mDataset.add(s);
        this.notifyDataSetChanged();
    }

    public ArrayList<Task> getmDataset() { return mDataset; }

}
