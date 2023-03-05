package com.example.proyectoa_pmdm_t2_junzhou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoa_pmdm_t2_junzhou.fragment.CentrosAdapter;
import com.example.proyectoa_pmdm_t2_junzhou.fragment.ListadoFragment;
import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.CentrosRes;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.APIRestService;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements OnDatosListener{

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

    private FragmentManager fragmentManager;

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

        fragmentManager = getSupportFragmentManager();

        btnConsultar.setOnClickListener(view -> {
            ListadoFragment lf = new ListadoFragment();
            cargarFragment(lf);
            lf.actualizarLista(initRetrofit());
        });
        btnFiltro.setOnClickListener(view -> {
            FilterDialog fd = new FilterDialog();
            fd.show(getSupportFragmentManager(), "Filtro");
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private void cargarFragment(Fragment fr) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frameLayout, fr);
        ft.addToBackStack(null);
        ft.commit();
    }


    // TODO Función de cada vista del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_listado:
                btnConsultar.setText(R.string.consultar_listado);
                ListadoFragment lf = new ListadoFragment();
                cargarFragment(lf);
                btnConsultar.setOnClickListener(view -> {
                    lf.actualizarLista(initRetrofit());
                });
                break;
            case R.id.menu_mapa:
                Toast.makeText(this, "Opción 2 pulsada", Toast.LENGTH_SHORT).show();
                break; // add break statement here
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


    public APIRestService initRetrofit() {
        // Inicializar la instacia de Retrofit
        Retrofit retrofit = RetrofitClient.getClient(APIRestService.BASE_URL);
        APIRestService ars = retrofit.create(APIRestService.class);

        return ars;
    }



    public void onDatosListener(Double lat, Double lon, int dist) {

        this.lat = lat;
        this.lon = lon;
        this.dist = dist;

        String latitud = getString(R.string.latitud);
        String longitud = getString(R.string.longitud);
        String distancia = getString(R.string.distancia);

        tvFiltro.setText(getString(R.string.filtro, latitud, String.valueOf(lat)));
        tvFiltro2.setText(getString(R.string.filtro, longitud, String.valueOf(lon)));
        tvFiltro3.setText(getString(R.string.filtro, distancia, String.valueOf(dist)));


    }


}