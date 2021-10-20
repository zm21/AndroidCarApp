package com.example.myapplication.productview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.application.HomeApplication;
import com.example.myapplication.dto.ProductDTO;

import java.util.Date;
import java.util.List;

import com.example.myapplication.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductCardViewHolder>  {
    private List<ProductDTO> modelList;
    public ProductAdapter(List<ProductDTO> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.product_card,
                        parent, false);
        return new ProductCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
        if (modelList != null && position < modelList.size()) {
            ProductDTO model = modelList.get(position);
            holder.prodName.setText(model.getName());
            holder.prodPrice.setText(String.valueOf(model.getPrice()));
            int i = (int) (new Date().getTime()/1000);
            String url = model.getImage()+"?data="+i;
            Glide.with(HomeApplication.getAppContext())
                    .load(url)
                    //.circleCrop()
                    .apply(new RequestOptions().override(300, 300))
                    .into(holder.prodImage);
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
