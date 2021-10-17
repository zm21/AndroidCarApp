package com.example.shopauto;

import com.example.shopauto.dto.ProductDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
//    @GET("/p24api/pubinfo?json&exchange&coursid=5")
//    public Call<List<Currency>> getPostWithID();
    @GET("/api/autos/list")
    public Call<List<ProductDTO>> getList();
}
