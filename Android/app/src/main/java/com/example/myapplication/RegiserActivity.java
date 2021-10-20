package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.myapplication.application.HomeApplication;
import com.example.myapplication.dto.RegisterDTO;
import com.example.myapplication.dto.RegisterResultDTO;
import com.example.myapplication.security.JwtSecurityService;
import com.example.myapplication.services.AccountService;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.oginotihiro.cropview.CropView;

import java.io.ByteArrayOutputStream;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegiserActivity extends AppCompatActivity {// implements AdapterView.OnItemSelectedListener{

//    private Spinner spinner;
//    private static final String[] paths = {"item 1", "item 2", "item 3"};

    private static int RESULT_LOAD_IMAGE = 1;
    RegiserActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiser);
        activity=this;

//        spinner = (Spinner)findViewById(R.id.spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item,paths);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);


    }

    public void onClickRegister(View view) {
        TextInputLayout emailLayout = findViewById(R.id.emailLayout);
        TextInputEditText textEmail =  findViewById(R.id.inputEmail);

        String text = textEmail.getText().toString();
        if(text.isEmpty())
        {
            emailLayout.setError("Поле є пустим");
        }
        else
            emailLayout.setError("");

        CropView cropView = (CropView) findViewById(R.id.cropView);
        Bitmap croppedBitmap = cropView.getOutput();
        Matrix matrix = new Matrix();

        matrix.postRotate(cropView.getRotation());
        Bitmap rotatedBitmap = Bitmap.createBitmap(croppedBitmap, 0, 0, croppedBitmap.getWidth(), croppedBitmap.getHeight(), matrix, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        rotatedBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);

        TextInputEditText inputFirstName =  findViewById(R.id.inputFirstName);
        TextInputEditText inputSecondName =  findViewById(R.id.inputSecondName);
        TextInputEditText inputPhone =  findViewById(R.id.inputPhone);
        TextInputEditText inputPassword =  findViewById(R.id.inputPassword);
        TextInputEditText inputСonfirmPassword =  findViewById(R.id.inputСonfirmPassword);

        RegisterDTO registerDTO = new RegisterDTO(textEmail.getText().toString(),
                inputFirstName.getText().toString(),inputSecondName.getText().toString(),
                inputPhone.getText().toString(), encoded, inputPassword.getText().toString(),
                inputСonfirmPassword.getText().toString());

        //registerDTO.setPassword(password.getText().toString());
        RegiserActivity myActivity = this;

        AccountService.getInstance()
                .getJSONApi()
                .Registration(registerDTO)
                .enqueue(new Callback<RegisterResultDTO>() {
                    @SneakyThrows
                    @Override
                    public void onResponse(Call<RegisterResultDTO> call, Response<RegisterResultDTO> response) {
                        if(!response.isSuccessful()) {
                            String message = response.errorBody().string();
                            String res = "sdfsdf";
                        }
                        RegisterResultDTO myDto = response.body();
                        String token = myDto.getToken();
                        JwtSecurityService jwtService = (JwtSecurityService) HomeApplication.getInstance();
                        jwtService.saveJwtToken(token);
                        Intent intent = new Intent(myActivity, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<RegisterResultDTO> call, Throwable t) {
                    }
                });



    }

    public void onClickSelectImage(View view) {
        Intent i = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //Intent intent = new Intent(this, SomeActivity.class);
        someActivityResultLauncher.launch(i);
    }

    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();

                        //CommonUtils.showLoading(this);
                        Uri selectedImage = data.getData();
                        CropView cropView = (CropView) findViewById(R.id.cropView);
                        cropView.of(selectedImage)
                                //.withAspect(x, y)
                                .withOutputSize(100, 100)
                                .initialize(activity);
                        //CommonUtils.hideLoading();
                    }

                }
            });


//    @Override
//    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
//
//        switch (position) {
//            case 0:
//                int a=23;
//                // Whatever you want to happen when the first item gets selected
//                break;
//            case 1:
//                int c=23;
//                // Whatever you want to happen when the second item gets selected
//                break;
//            case 2:
//                int b=23;
//                // Whatever you want to happen when the thrid item gets selected
//                break;
//
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        // TODO Auto-generated method stub
//    }

}