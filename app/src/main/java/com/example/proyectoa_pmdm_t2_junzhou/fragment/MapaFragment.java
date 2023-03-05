package com.example.proyectoa_pmdm_t2_junzhou.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectoa_pmdm_t2_junzhou.R;
import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.CentrosRes;
import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.Graph;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.APIRestService;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.RetrofitClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapaFragment extends Fragment {

    protected SupportMapFragment mapa;
    private ArrayList<Graph> centrosList;

    public void onMapReady(SupportMapFragment mapa) {
        this.mapa = mapa;

    }


    public MapaFragment() {

    }

    public static MapaFragment newInstance(String param1, String param2) {
        MapaFragment fragment = new MapaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.mapa);
            mapFragment.getMapAsync((OnMapReadyCallback) getActivity());

        }

    }

    public void actualizarMapa(APIRestService ars, Double lat, Double lon, int dist) {
        Call<CentrosRes> call;
        centrosList = new ArrayList<>();
        mapa = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapa);

        if (lat != null && lon != null && dist > 0) {
            call = ars.getDataFilter(lat, lon, dist);
        } else {
            call = ars.getData();
        }
        call.enqueue(new Callback<CentrosRes>() {
            @Override
            public void onResponse(Call<CentrosRes> call, Response<CentrosRes> response) {
                if (response.isSuccessful()) {
                    CentrosRes centrosRes = response.body();
                    if (centrosRes != null) {
                        centrosList = (ArrayList<Graph>) response.body().getGraph();
                    }
                    if (centrosList != null && centrosList.size() > 0) {
                        Toast.makeText(getActivity(), "Datos obtenidos", Toast.LENGTH_SHORT).show();

                        aplicarMarcador();

                    } else {
                        Toast.makeText(getActivity(), "No hay datos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Error al obtener los datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CentrosRes> call, Throwable t) {
                Toast.makeText(getActivity(), "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aplicarMarcador() {
        mapa.getMapAsync(googleMap -> {
            googleMap.clear();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            LatLng latLn = null;
            if (centrosList != null) {
                // Itera sobre la lista de centros y los añade al mapa
                for (int i = 0; i < centrosList.size(); i++) {
                    latLn = new LatLng(centrosList.get(i).getLocation().getLatitude(), centrosList.get(i).getLocation().getLongitude());
                    googleMap.addMarker(new MarkerOptions().position(latLn).title(centrosList.get(i).getTitle()));
                    builder.include(latLn);
                }
            }
            if (latLn != null) {
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLn, 10));
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mapa, container, false);

    }


}