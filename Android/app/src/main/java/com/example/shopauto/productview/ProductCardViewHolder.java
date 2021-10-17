package com.example.shopauto.productview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shopauto.R;

public class ProductCardViewHolder extends RecyclerView.ViewHolder {

    private View view;
    //    public NetworkImageView prodImage;
    public ImageView prodImage;
    public TextView prodName;
    public TextView prodPrice;
    public TextView prodDescription;
    public ProductCardViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
        prodImage = itemView.findViewById(R.id.prodimg);
        prodName = itemView.findViewById(R.id.prodname);
        prodPrice = itemView.findViewById(R.id.prodprice);
        prodDescription = itemView.findViewById(R.id.proddescription);
    }
    public View getView() {
        return view;
    }
}
