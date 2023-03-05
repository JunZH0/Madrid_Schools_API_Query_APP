package com.example.proyectoa_pmdm_t2_junzhou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.CentrosRes;
import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.Graph;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.APIRestService;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleActivity extends AppCompatActivity {

    TextView tvNombre;
    TextView tvDireccion;
    TextView tvCp;
    TextView tvLocalidad;
    TextView tvDesc;
    private static final String BASE_URL = "https://datos.madrid.es/egob/catalogo/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tvNombre = findViewById(R.id.tvNombre);
        tvDireccion = findViewById(R.id.tvDir);
        tvCp = findViewById(R.id.tvCp);
        tvLocalidad = findViewById(R.id.tvLocalidad);
        tvDesc = findViewById(R.id.tvDescr);

        ApiCall();

    }

    private void ApiCall() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIRestService ars = retrofit.create(APIRestService.class);
        Call<CentrosRes> call = ars.getDataCenter(id);

        call.enqueue(new retrofit2.Callback<CentrosRes>() {
            @Override
            public void onResponse(Call<CentrosRes> call, retrofit2.Response<CentrosRes> response) {
                String desc;
                if (response.isSuccessful()) {
                    // Llamadas anidadas para obtener los datos
                    List<Graph> graphs = response.body().getGraph();
                    if (graphs != null && !graphs.isEmpty()) {
                        Graph graph = graphs.get(0);
                        tvNombre.setText(graph.getTitle());
                        tvDireccion.setText(graph.getAddress().getStreetAddress());
                        tvCp.setText(graph.getAddress().getPostalCode());
                        tvLocalidad.setText(graph.getAddress().getLocality());
                        tvDesc.setText(graph.getOrganization().getOrganizationDesc());

                    }
                } else {
                    Toast.makeText(DetalleActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CentrosRes> call, Throwable t) {
                Toast.makeText(DetalleActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}