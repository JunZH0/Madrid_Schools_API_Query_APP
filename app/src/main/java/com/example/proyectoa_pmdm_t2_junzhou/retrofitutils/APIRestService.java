package com.example.proyectoa_pmdm_t2_junzhou.retrofitutils;

import com.example.proyectoa_pmdm_t2_junzhou.retrofidata.DatosCentro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIRestService {
    public static final String BASE_URL = "https://datos.madrid.es/egob/catalogo/";


    // Utilizar BASE_URL + parte variable para obtener los datos de la API
    @GET("203166-0-universidades-educacion.json")
    Call<DatosCentro> getData(@Query("latitud") double lat,
                                  @Query("longitud") double lon,
                                  @Query("distancia") int dist);

    @GET("203166-0-universidades-educacion.json")
    Call<DatosCentro> getData();

    @GET("tipo/entidadesyorganismos/{id_url}")
    Call<DatosCentro> getData(@Path("id_url") String url);


}



