package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.models.Brand;
import com.example.myapplication.models.Shoe;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    public static final String BRAND_DETAIL_KEY = "brand";
    private ViewPager2 viewPager2;
    private Handler slideHandler = new Handler();

    RecyclerView mPopular,mBrands;
    ArrayList<Shoe> shoeList;
    ArrayList<Brand> brandList;
    ArrayList<Shoe> topList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPopular = findViewById(R.id.popularItems);
        mBrands = findViewById(R.id.brands);
        shoeList = new ArrayList<Shoe>();
        brandList = new ArrayList<Brand>();

        viewPager2 = findViewById(R.id.viewPagerImageSlider);

        final List<SliderItem> sliderItem = new ArrayList<>();
        sliderItem.add(new SliderItem(R.drawable.m1));
        sliderItem.add(new SliderItem(R.drawable.m2));
        sliderItem.add(new SliderItem(R.drawable.m3));
        sliderItem.add(new SliderItem(R.drawable.m4));
        sliderItem.add(new SliderItem(R.drawable.m5));

        viewPager2.setAdapter(new AutoSliderAdapter(sliderItem, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable,3000);
            }
        });

        brandList.add(new Brand(1, "Jordan", R.drawable.jordan));
        brandList.add(new Brand(2, "Nike", R.drawable.nike));
        brandList.add(new Brand(3, "Adidas", R.drawable.adidas));
        brandList.add(new Brand(4, "Under Armour", R.drawable.ua));
        brandList.add(new Brand(5, "Big Baller Brand", R.drawable.bbb));
        brandList.add(new Brand(6, "New Balance", R.drawable.nb));

        shoeList = DataProvider.generateData();

        for (int i = 0; i < 10; i++){
            topList.add(shoeList.get(i));
        }

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mPopular.setLayoutManager(manager1);

        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        mBrands.setLayoutManager(manager2);

        listAdaptor adaptor1 = new listAdaptor(this,topList);
        mPopular.setAdapter(adaptor1);

        brandAdaptor adaptor2 = new brandAdaptor(this,brandList);
        mBrands.setAdapter(adaptor2);


        /*-----------------------------Bottom Navigation Bar------------------------------------*/
        // Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);



        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
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

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        };
    }


    /*
    @Override
    public void onNoteClick(int position) {
    }

     */
