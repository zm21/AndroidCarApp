package com.example.shopauto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shopauto.dto.ProductDTO;
import com.example.shopauto.productview.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    private ProductAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.rcv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1,
                LinearLayoutManager.VERTICAL, false));

//        List<ProductDTO> list = new ArrayList<>();
//        list.add(new ProductDTO("Шарик",2000,"https://lemurrr.ru/medias/sys_master/images/h01/h48/8919446028318.png"));
//        list.add(new ProductDTO("Жигули",10,"https://auto.ironhorse.ru/wp-content/uploads/2007/01/2107-tmb1-550x300.jpg"));
//        list.add(new ProductDTO("Жигули",1000,"https://a.d-cd.net/QQAAAgOsveA-960.jpg"));
//
//        adapter = new ProductAdapter(list);
//        recyclerView.setAdapter(adapter);

        NetworkService.getInstance()
                .getJSONApi()
                .getList()
                .enqueue(new Callback<List<ProductDTO>>() {
                    @Override
                    public void onResponse(Call<List<ProductDTO>> call, Response<List<ProductDTO>> response) {
                        List<ProductDTO> list = response.body();
                        adapter = new ProductAdapter(list);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<ProductDTO>> call, Throwable t) {

                    }
                });
    }
}