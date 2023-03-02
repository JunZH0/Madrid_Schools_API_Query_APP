package com.example.proyectoa_pmdm_t2_junzhou.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoa_pmdm_t2_junzhou.R;
import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.DatosCentro;

import java.util.List;

public class CentrosAdapter extends RecyclerView.Adapter<CentrosAdapter.CentroViewHolder>{

    private List<DatosCentro> centrosList;

    public CentrosAdapter(List<DatosCentro> centrosList) {
        this.centrosList = centrosList;
    }


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
        DatosCentro centro = centrosList.get(position);
        holder.tvNombre.setText(centro.getTitle());
    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CentroViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNombre;

        public CentroViewHolder(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvItem);
        }
    }
}
