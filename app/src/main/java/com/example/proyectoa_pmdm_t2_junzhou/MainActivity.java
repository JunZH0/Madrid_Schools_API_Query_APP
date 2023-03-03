package com.example.proyectoa_pmdm_t2_junzhou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.APIRestService;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnDatosListener{

    TextView tvTitulo;
    TextView tvFiltro;
    TextView tvFiltro2;
    TextView tvFiltro3;
    Button btnConsultar;
    Button btnFiltro;

    Double lat;
    Double lon;
    int dist;
    OnDatosListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvFiltro = findViewById(R.id.tvFiltro);
        tvFiltro2 = findViewById(R.id.tvFiltro2);
        tvFiltro3 = findViewById(R.id.tvFiltro3);
        btnConsultar = findViewById(R.id.btn_consulta);
        btnFiltro = findViewById(R.id.btn_filtro);

        btnConsultar.setOnClickListener((View.OnClickListener) this);
        btnFiltro.setOnClickListener((View.OnClickListener) this);

        initRetrofit();

    }

    private void initRetrofit() {
        Retrofit retrofit = RetrofitClient.getClient(APIRestService.BASE_URL);
        APIRestService ars = retrofit.create(APIRestService.class);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_consulta) {
            consultarDatos();
            // TODO Mostrar los datos en el fragment


        } else if (v.getId() == R.id.btn_filtro) {
            FilterDialog fd = new FilterDialog();
            fd.show(getSupportFragmentManager(), "Filtro");

        }
    }

    private void consultarDatos() {
        Retrofit retrofit = RetrofitClient.getClient(APIRestService.BASE_URL);
        APIRestService ars = retrofit.create(APIRestService.class);
        // TODO Obtener los datos con el resto de parámetros
          /*Call<DatosCentro> call = ars.getData();
      call.enqueue(new retrofit2.Callback<DatosCentro>() {
            @Override
            public void onResponse(Call<DatosCentro> call, retrofit2.Response<DatosCentro> response) {
                if (response.isSuccessful()) {
                    String datosCentro = response.body().toString();
                    Toast.makeText(MainActivity.this, "Datos obtenidos correctamente", Toast.LENGTH_SHORT).show();
                    System.out.println(datosCentro);
                } else {
                    Toast.makeText(MainActivity.this, "Error al obtener los datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DatosCentro> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        }); */


    }

    public void onDatosListener(Double lat, Double lon, int dist) {

        this.lat = lat;
        this.lon = lon;
        this.dist = dist;
        // Texto Harcodeado
        tvFiltro.setText("Latitud: " + lat);
        tvFiltro2.setText("Longitud: " + lon);
        tvFiltro3.setText("Distancia: " + dist);
    }


}