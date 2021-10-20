package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.dto.ProductDTO;
import com.example.myapplication.productview.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

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

        List<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO("Сало",200,"http://10.0.2.2:5000/images/2.jpg"));
        list.add(new ProductDTO("Морква",10,"http://10.0.2.2:5000/images/1.jpg"));
        list.add(new ProductDTO("Самогон",70,"http://10.0.2.2:5000/images/3.jpg"));
        list.add(new ProductDTO("Цибуля",5,"http://10.0.2.2:5000/images/4.jpg"));
        list.add(new ProductDTO("Зелені ощипки",20,"http://10.0.2.2:5000/images/5.jpg"));

        adapter = new ProductAdapter(list);
        recyclerView.setAdapter(adapter);

    }
}