package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.models.Shoe;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    int[] shoePhotos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final RatingBar ratingBar = (RatingBar)findViewById(R.id.rating_bar);
        Button submitButton = (Button)findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "Thank you for your submit,\n You rated this shoe : " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });

        getIncomingIntent();
        ViewPager viewPager = findViewById(R.id.ivImageSlider);
        SliderAdaptor adapter = new SliderAdaptor(this, shoePhotos);
        viewPager.setAdapter(adapter);

        /*-----------------------------Bottom Navigation Bar------------------------------------*/
        // Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.browse);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity (new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.browse:
                        startActivity (new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.cart:
                        startActivity (new Intent(getApplicationContext(),Cart.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        /*-----------------------------Bottom Navigation Bar End------------------------------------*/
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("name") && getIntent().hasExtra("image") && getIntent().hasExtra("price")
        && getIntent().hasExtra("photos") && getIntent().hasExtra("brand") && getIntent().hasExtra("description")){
            String shoeName = getIntent().getStringExtra("name");
            int shoeImage = getIntent().getIntExtra("image",0);
            double shoePrice = getIntent().getDoubleExtra("price",0);
            shoePhotos = getIntent().getIntArrayExtra("photos");
            String shoeBrand = getIntent().getStringExtra("brand");
            String shoeDescription = getIntent().getStringExtra("description");
            setImage(shoeName,shoeImage,shoePrice,shoeBrand,shoeDescription);
        }
    }

    private void setImage(String shoeName, int shoeImage, double shoePrice, String shoeBrand, String shoeDescription){
        TextView name = findViewById(R.id.tvTitle);
        ImageView image = findViewById(R.id.ivAvatar);
        TextView price = findViewById(R.id.tvPrice);
        TextView brand = findViewById(R.id.tvBrand);
        TextView description = findViewById(R.id.tvDescription);

        brand.setText(shoeBrand);
        name.setText(shoeName);
        image.setImageResource(shoeImage);
        price.setText("$" + String.valueOf(shoePrice));
        description.setText(shoeDescription);
    }   
}