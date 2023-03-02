package com.example.proyectoa_pmdm_t2_junzhou;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class FilterDialog extends DialogFragment {

    EditText etLat;
    EditText etLon;
    EditText etDist;

    OnDatosListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View v = getActivity().getLayoutInflater().inflate(R.layout.activity_filter_dialog, null);
        builder.setView(v);

        etLat = v.findViewById(R.id.etLat);
        etLon = v.findViewById(R.id.etLon);
        etDist = v.findViewById(R.id.etDist);



        builder.setTitle("Seleccionar filtro").setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String lat = etLat.getText().toString();
                String lon = etLon.getText().toString();
                String dist = etDist.getText().toString();

                if (lat.isEmpty() || lon.isEmpty() || dist.isEmpty()) {
                    dialog.cancel();
                    Toast.makeText(getActivity(), "No puede haber campos vacíos", Toast.LENGTH_SHORT).show();
                } else {
                    if(listener != null) {
                        listener.onDatosListener(Double.parseDouble(lat), Double.parseDouble(lon), Double.parseDouble(dist));
                    }
                }

            }
        } ).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnDatosListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnDatosListener");
        }
    }

    @Override
    public void onDetach() {
        if (listener != null) {
            listener = null;
        }
        super.onDetach();
    }
}
