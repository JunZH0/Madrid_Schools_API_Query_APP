package com.example.proyectoa_pmdm_t2_junzhou.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoa_pmdm_t2_junzhou.DetalleActivity;
import com.example.proyectoa_pmdm_t2_junzhou.R;
import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.Graph;

import java.util.ArrayList;


public class CentrosAdapter extends RecyclerView.Adapter<CentrosAdapter.CentroViewHolder> {

    private ArrayList<Graph> centrosList;

    public CentrosAdapter(ArrayList<Graph> centrosList) {
        this.centrosList = centrosList;
    }

    public View.OnClickListener mListener;


    @NonNull
    @Override
    public CentrosAdapter.CentroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the row item layout file
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.centros_item, parent, false);
        return new CentroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CentrosAdapter.CentroViewHolder holder, int position) {
       Graph graph = centrosList.get(position);
       // cambia el valor de los textview al valor recogido por getTitle
       holder.getTvNombre().setText(graph.getTitle());
       holder.getTvNombre().setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               // recoge el id del centro y con el substring lo recorta para que solo quede el id despues del ultimo /
               String url = graph.getId();
               String id = url.substring(url.lastIndexOf('/') + 1);
               Intent intent = new Intent(view.getContext(), DetalleActivity.class);
               intent.putExtra("id", id);
               view.getContext().startActivity(intent);
           }
       });
    }


    @Override
    public int getItemCount() {
        return centrosList.size();
    }

    public static class CentroViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNombre;

        public CentroViewHolder(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvItem);
        }

        public TextView getTvNombre() {
            return tvNombre;
        }
    }

}
