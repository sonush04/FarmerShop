package com.gautam.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gautam.myshop.ui.product_details_adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.gautam.myshop.HomeActivity.showChart;

public class ProductDetailsActivity extends AppCompatActivity {
    private ViewPager productIMgesViewPager;
    private TabLayout viewPagerIndicator;

    private ViewPager productDetailsViewpager;
    private TabLayout productDetailsTablayout;
    private FloatingActionButton addToWishListButton;
    private static boolean ALLREADY_ADDED_TO_WISHLIST=false;

    //////rating layout
    private LinearLayout rateNowLayoutContainer;
    //////rating layout
    private Button buyNowBotton;

    // YE BUTTON HOTA HE YA BUTTTUNNN ????


    private void setRating(int starposition){
        for(int x = 0;x < rateNowLayoutContainer.getChildCount();x++){
            ImageView startBtn = (ImageView) rateNowLayoutContainer.getChildAt(x);
            startBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if(x <= starposition){
                startBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        buyNowBotton = findViewById(R.id.buy_now_btn);


        productIMgesViewPager=findViewById(R.id.product_images_viewpager);
        viewPagerIndicator=findViewById(R.id.viewpager_indicator);

        viewPagerIndicator.setupWithViewPager(productIMgesViewPager,true);
        productDetailsTablayout=findViewById(R.id.product_details);

        productDetailsViewpager=findViewById(R.id.product_details_viewpager);

        List<Integer> productImages= new ArrayList<>();
        productImages.add(R.drawable.shopping);

        productImages.add(R.drawable.banner);

        productImages.add(R.drawable.my_wishlist);

        productImages.add(R.drawable.carts);

        productImages.add(R.drawable.my_account);


        ProductImagesAdapter productImagesAdapter =new ProductImagesAdapter(productImages);

        productIMgesViewPager.setAdapter(productImagesAdapter);

        viewPagerIndicator.setupWithViewPager(productIMgesViewPager,true);


        addToWishListButton=findViewById(R.id.add_to_wishlist_button);

        addToWishListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ALLREADY_ADDED_TO_WISHLIST)
                {
                    ALLREADY_ADDED_TO_WISHLIST=false;

                    addToWishListButton.setSupportBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                }
                else {

                    ALLREADY_ADDED_TO_WISHLIST=true;

                    addToWishListButton.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorAccents));

                }
            }
        });

        productDetailsViewpager.setAdapter(new product_details_adapter(getSupportFragmentManager(),productDetailsTablayout.getTabCount()));

        productDetailsViewpager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));

        productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewpager.setCurrentItem((tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ////rating layout
        rateNowLayoutContainer = findViewById(R.id.rate_now_container);
        for(int x = 0;x < rateNowLayoutContainer.getChildCount();x++){
            final int starposition = x;
            rateNowLayoutContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starposition);
                }
            });
        }


        buyNowBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(ProductDetailsActivity.this, deliveryActivity.class);
            }
        });


    }


    // AGAR ISWAR PE SRADHHA RAKHTE TO TURANT LAPTOP SHUTDOWN KERKE SO JAO !!!

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==R.id.main_search_icon)
        {
            return true;
        }
        else if(id==android.R.id.home)
        {
            finish();
            return true;
        }

        else if(id==R.id.main_cart_icon)
        {
            Intent cartIntent = new Intent(ProductDetailsActivity.this, HomeActivity.class);
            showChart = true;
            startActivity(cartIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
