package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class AddPromotionActivity extends AppCompatActivity {

    private TextInputEditText businessNameEdt, promotionTitleEdt, promotionContentEdt;
    private TextView promotionStartDateTV, promotionEndDateTV, photoCountTV;
    private ImageView photo1IV, photo2IV, photo3IV, photo4IV;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promotion);

        //init
        businessNameEdt = findViewById(R.id.idEdtBusinessName);
        promotionTitleEdt = findViewById(R.id.idEdtPromotionTitle);
        promotionContentEdt = findViewById(R.id.idEdtPromotionContent);
        promotionStartDateTV = findViewById(R.id.idTVPromotionStartDate);
        promotionEndDateTV = findViewById(R.id.idTVPromotionEndDate);
        photoCountTV = findViewById(R.id.idTVPhotoCount);
        photo1IV = findViewById(R.id.idIVPhoto1);
        photo2IV = findViewById(R.id.idIVPhoto2);
        photo3IV = findViewById(R.id.idIVPhoto3);
        photo4IV = findViewById(R.id.idIVPhoto4);
        submitBtn = findViewById(R.id.idBtnSubmit);
    }
}