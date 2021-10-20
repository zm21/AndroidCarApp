package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.example.myapplication.network.ImageRequester;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText txtData;
    //private ImageRequester imageRequester;
    //private NetworkImageView myImage;
    private ImageView myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtData=findViewById(R.id.txtData);
        String url = "https://ph0.qna.center/storage/photos/marina/1795532.jpg";
        //url="http://10.0.2.2:5000/upload/1.jpg";

        //imageRequester = ImageRequester.getInstance();
        //myImage = findViewById(R.id.myimg);
        //imageRequester.setImageFromUrl(myImage, url);

        myImage = findViewById(R.id.myimg);
        Glide.with(this)
                .load(url)
                .centerCrop()
                .into(myImage);

    }

    public void ClickBtnHello(View view) {
        //Toast.makeText(this,txtData.getText(),Toast.LENGTH_LONG).show();
        MainActivity intasnce = this;
        NetworkService.getInstance()
                .getJSONApi()
                .getWeather()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                        List<Post> post = response.body();
                        //Toast.makeText(intasnce,post.get(0).getTemperatureC(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                        t.printStackTrace();
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.headmenu, menu);
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
                intent = new Intent(this, RegiserActivity.class);
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