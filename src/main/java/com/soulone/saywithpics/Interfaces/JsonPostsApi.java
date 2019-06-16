package com.soulone.saywithpics.Interfaces;

import com.soulone.saywithpics.Models.Rutina;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPostsApi {

    @GET("/rutinas")
    Call<List<Rutina>> getRutina();

    @POST("/rutinas")
    Call<Rutina> createRutina(@Body Rutina rutina);


}
