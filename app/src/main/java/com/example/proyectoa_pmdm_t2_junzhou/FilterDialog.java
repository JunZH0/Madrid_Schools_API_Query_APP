package com.example.proyectoa_pmdm_t2_junzhou;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class FilterDialog extends DialogFragment {

    EditText etLat;
    EditText etLon;
    EditText etDist;


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
                // TODO: 10/12/2020  pasar los datos a la actividad principal

            }
        } ).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }
}
