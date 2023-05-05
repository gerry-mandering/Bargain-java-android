package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class AddPromotionActivity extends AppCompatActivity {

    private TextInputEditText businessNameEdt, promotionTitleEdt, promotionContentEdt;
    private TextView promotionStartDateTV, promotionEndDateTV, photoCountTV;
    private ImageView photo1IV, photo2IV, photo3IV, photo4IV;
    private Button submitBtn;
    private ProgressBar loadingPB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private static long promotionCount = 0;

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
        loadingPB = findViewById(R.id.idPBLoading);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Promotions");

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog startDatePickerDialog = new DatePickerDialog(AddPromotionActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectedDate = year + " / " + (month + 1) + " / " + dayOfMonth;
                promotionStartDateTV.setText(selectedDate);
            }
        }, year, month, dayOfMonth);

        promotionStartDateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDatePickerDialog.show();
            }
        });

        DatePickerDialog endDatePickerDialog = new DatePickerDialog(AddPromotionActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectedDate = year + " / " + (month + 1) + " / " + dayOfMonth;
                promotionEndDateTV.setText(selectedDate);
            }
        }, year, month, dayOfMonth);

        promotionEndDateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endDatePickerDialog.show();
            }
        });

        // Declare a final variable to store the entered text
        final String[] photoUrlInput = new String[4];

        photo1IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the dialog
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(AddPromotionActivity.this);
                builder.setTitle("URL을 입력하시오:");

                // Create the input field
                final TextInputEditText input = new TextInputEditText(AddPromotionActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input.setHint("URL");

                // Add the input field to the dialog
                builder.setView(input);

                // Set the positive button
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Get the entered text
                        photoUrlInput[0] = input.getText().toString();
                        Picasso.get().load(photoUrlInput[0]).into(photo1IV);
                        photo1IV.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        photo2IV.setVisibility(View.VISIBLE);
                        photoCountTV.setText("1 / 4");
                        // Do something with the entered text
                        Toast.makeText(AddPromotionActivity.this, "사진이 등록되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                // Set the negative button
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                    }
                });

                // Show the dialog
                builder.show();
            }
        });

        photo2IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the dialog
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(AddPromotionActivity.this);
                builder.setTitle("URL을 입력하시오:");

                // Create the input field
                final TextInputEditText input = new TextInputEditText(AddPromotionActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input.setHint("URL");

                // Add the input field to the dialog
                builder.setView(input);

                // Set the positive button
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Get the entered text
                        photoUrlInput[1] = input.getText().toString();
                        Picasso.get().load(photoUrlInput[1]).into(photo2IV);
                        photo2IV.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        photo3IV.setVisibility(View.VISIBLE);
                        photoCountTV.setText("2 / 4");
                        // Do something with the entered text
                        Toast.makeText(AddPromotionActivity.this, "사진이 등록되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                // Set the negative button
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                    }
                });

                // Show the dialog
                builder.show();
            }
        });

        photo3IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the dialog
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(AddPromotionActivity.this);
                builder.setTitle("URL을 입력하시오:");

                // Create the input field
                final TextInputEditText input = new TextInputEditText(AddPromotionActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input.setHint("URL");

                // Add the input field to the dialog
                builder.setView(input);

                // Set the positive button
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Get the entered text
                        photoUrlInput[2] = input.getText().toString();
                        Picasso.get().load(photoUrlInput[2]).into(photo3IV);
                        photo3IV.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        photo4IV.setVisibility(View.VISIBLE);
                        photoCountTV.setText("3 / 4");
                        // Do something with the entered text
                        Toast.makeText(AddPromotionActivity.this, "사진이 등록되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                // Set the negative button
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                    }
                });

                // Show the dialog
                builder.show();
            }
        });

        photo4IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the dialog
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(AddPromotionActivity.this);
                builder.setTitle("URL을 입력하시오:");

                // Create the input field
                final TextInputEditText input = new TextInputEditText(AddPromotionActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input.setHint("URL");

                // Add the input field to the dialog
                builder.setView(input);

                // Set the positive button
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Get the entered text
                        photoUrlInput[3] = input.getText().toString();
                        Picasso.get().load(photoUrlInput[3]).into(photo4IV);
                        photo4IV.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        photoCountTV.setText("4 / 4");
                        // Do something with the entered text
                        Toast.makeText(AddPromotionActivity.this, "사진이 등록되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                // Set the negative button
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                    }
                });

                // Show the dialog
                builder.show();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String businessName = businessNameEdt.getText().toString();
                String promotionTitle = promotionTitleEdt.getText().toString();
                String promotionContent = promotionContentEdt.getText().toString();
                String promotionStartDate = promotionStartDateTV.getText().toString();
                String promotionEndDate = promotionEndDateTV.getText().toString();
                String photoCount = photoCountTV.getText().toString();
                String photoUrl1 = photoUrlInput[0];
                String photoUrl2 = photoUrlInput[1];
                String photoUrl3 = photoUrlInput[2];
                String photoUrl4 = photoUrlInput[3];
                String promotionID = Long.toString(promotionCount++);

                PromotionParcel promotionParcel = new PromotionParcel(businessName, promotionTitle, promotionContent, promotionStartDate, promotionEndDate, photoCount, photoUrl1, photoUrl2, photoUrl3, photoUrl4, promotionID);

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(promotionID).setValue(promotionParcel);
                        Toast.makeText(AddPromotionActivity.this, "행사가 등록되었습니다", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddPromotionActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(AddPromotionActivity.this, "오류가 발생했습니다" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}