package com.example.myapplication.network;

import com.example.myapplication.dto.RegisterDTO;
import com.example.myapplication.dto.RegisterResultDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountApi {
    @POST("/api/account/register")
    public Call<RegisterResultDTO> Registration(@Body RegisterDTO registerDTO);
}
