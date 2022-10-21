package com.example.aplkmenumakanan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {

    ImageView Imgdetail;
    TextView Produk, Harga, Description, Nilai, Total;
    Button Increment, Decrement;
    int quantity = 1;
    double tot;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Imgdetail = findViewById(R.id.myImageView2);
        Produk = findViewById(R.id.produk);
        Harga = findViewById(R.id.harga);
        Description = findViewById(R.id.Desc);
        Nilai = findViewById(R.id.nilai);
        Total = findViewById(R.id.total);
        Increment = findViewById(R.id.increment);
        Decrement= findViewById(R.id.decrement);

        Imgdetail.setImageResource(getIntent().getIntExtra("Image",0));
        Produk.setText(getIntent().getStringExtra("Produk"));
        Harga.setText("Rp. " + getIntent().getStringExtra("Harga"));
        Description.setText(getIntent().getStringExtra("Description"));
        Total.setText("Rp. "+getIntent().getStringExtra("Harga"));

        String st = getIntent().getStringExtra("Harga");
        int num = Integer.parseInt(st);


        Increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity==100){
                    return;
                }
                quantity = quantity+1 ;
                tot = num * quantity;
                Nilai.setText(String.valueOf(quantity));
                Total.setText("Rp. "+tot);
            }
        });
        Decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity==1){
                    return;
                }
                quantity = quantity - 1;
                tot = tot - num;
                Nilai.setText(String.valueOf(quantity));
                Total.setText("Rp. "+tot);

            }
        });
    }
}