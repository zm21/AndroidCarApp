package com.example.shopauto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shopauto.network.ImageRequester;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText txtInfo;
    private ImageRequester imageRequester;
    private NetworkImageView myImage;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInfo = findViewById(R.id.txtInfo);
        String urlImg = "https://dengi.ua/i/18/22/60/0/1822600/faec057a34d4a6d8d0890b8164f5ebc1-quality_75Xresize_crop_1Xallow_enlarge_0Xw_740Xh_400.jpg";
        imageRequester = ImageRequester.getInstance();
        myImage = findViewById(R.id.myimg);
        imageRequester.setImageFromUrl(myImage, urlImg);

        imageView = findViewById(R.id.imageView);

        RequestOptions requestOptions=new RequestOptions();
        //requestOptions.placeholder(R.drawable.bg_grey);
        //requestOptions.error(R.drawable.bg_grey);

        Glide.with(this)
                .load(urlImg)

                //.apply(requestOptions)
                .centerCrop()
                .into(imageView);
//        try {
//            URL url = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
//            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            imageView.setImageBitmap(bmp);
//        }


    }
    public void onClickInfo(View view) {
        //Toast.makeText(this,txtInfo.getText(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
//        MainActivity intasnce = this;
//        NetworkService.getInstance()
//                .getJSONApi()
//                .getPostWithID()
//                .enqueue(new Callback<List<Currency>>() {
//                    @Override
//                    public void onResponse(@NonNull Call<List<Currency>> call, @NonNull Response<List<Currency>> response) {
//                        List<Currency> post = response.body();
//                        //Toast.makeText(intasnce,post.getBuy(), Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onFailure(@NonNull Call<List<Currency>> call, @NonNull Throwable t) {
//                        t.printStackTrace();
//                    }
//                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.mhome:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mregister:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                return true;
            case R.id.mproduct:
                intent = new Intent(this, ProductActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}