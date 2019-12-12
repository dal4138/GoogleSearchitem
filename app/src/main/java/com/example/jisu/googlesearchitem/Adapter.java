package com.example.jisu.googlesearchitem;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CutromHolder> {
    private int layout;
    private ArrayList<String> list;

    public Adapter(int layout, ArrayList<String> list) {
        this.layout = layout;
        this.list = list;
    }

    @NonNull
    @Override
    public CutromHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        CutromHolder viewHolder=new CutromHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CutromHolder cutromHolder, int i) {
        final String str=list.get(i);
        cutromHolder.textview.setText(str);
        cutromHolder.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() { return (list!=null)?list.size():0; }

    public class CutromHolder extends RecyclerView.ViewHolder {
        private TextView textview;
        private Button btnSearch;
        public CutromHolder(@NonNull View itemView) {
            super(itemView);
            textview= itemView.findViewById(R.id.textview);
            btnSearch= itemView.findViewById(R.id.btnSearch);
        }
    }
}
