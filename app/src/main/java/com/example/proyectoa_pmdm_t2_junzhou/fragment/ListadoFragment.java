package com.example.proyectoa_pmdm_t2_junzhou.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectoa_pmdm_t2_junzhou.R;
import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.CentrosRes;
import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.Graph;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.APIRestService;
import com.example.proyectoa_pmdm_t2_junzhou.retrofitutils.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ListadoFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private RecyclerView recyclerView;
    private CentrosAdapter adapter;
    private ArrayList<Graph> centrosList;
    LinearLayoutManager llm;

    public ListadoFragment() {

    }


    public static ListadoFragment newInstance() {
        ListadoFragment fragment = new ListadoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the recycler view for this fragment
        return inflater.inflate(R.layout.fragment_listado, container, false);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado, container, false);

        recyclerView = view.findViewById(R.id.rcView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        centrosList = new ArrayList<>();
        adapter = new CentrosAdapter(centrosList);
        recyclerView.setAdapter(adapter);


        return view;
    }

    public void actualizarLista(APIRestService ars, Double lat, Double lon, int dist) {
        Call<CentrosRes> call;

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
                    centrosList.addAll(centrosRes.getGraph());
                    cargarRV(centrosList);
                    if (centrosList.size() > 0) {
                        Toast.makeText(getActivity(), "Datos obtenidos", Toast.LENGTH_SHORT).show();
                    } else {Toast.makeText(getActivity(), "No hay datos", Toast.LENGTH_SHORT).show();
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





    private void cargarRV(ArrayList<Graph> results) {
        llm = new LinearLayoutManager(getActivity());
        adapter = new CentrosAdapter((ArrayList<Graph>) results);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }


}