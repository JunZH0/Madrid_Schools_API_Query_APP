package com.example.proyectoa_pmdm_t2_junzhou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.APIRestService;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView tvTitulo;
    TextView tvFiltro;
    TextView tvFiltro2;
    TextView tvFiltro3;
    Button btnConsultar;
    Button btnFiltro;


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
}