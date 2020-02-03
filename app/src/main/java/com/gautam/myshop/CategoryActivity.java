package com.gautam.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoryRecyclerView = findViewById(R.id.category_recycler_view);


        ////////////////








       List<slider_model>   sliderModelList =new ArrayList<slider_model>();





        sliderModelList.add(new slider_model(R.drawable.mango,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.pineapple,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.peas,"#077AE4"));







        sliderModelList.add(new slider_model(R.drawable.carrot,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.redchillies,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_order,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.potato,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.tomato,"#077AE4"));







        sliderModelList.add(new slider_model(R.drawable.brinjal,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.almond,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.watermelon,"#077AE4"));


        ////////////






        ///////////////////////////////*








        ///////////////////////////////*





















        //////////////////**





        List<horizontal_product_scroll_model> horizontalProductScrollModelList=new ArrayList<>();
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.mango,"mango ","Ratnagiri","Rs 100/kg"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.apple,"kasmiri ","fresh","Rs 200/kg"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.brinjal,"Brinjal ","fresh","Rs 35/kg"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.potato,"potato ","fresh","Rs 20/kg"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.tomato,"tomato ","fresh","Rs 30/kg"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.watermelon,"watermelon ","fresh","Rs 45/kg"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.redchillies,"chilli ","spicy","Rs 55/kg"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.pineapple,"pineapple","fresh","Rs 130/kg"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.peas,"Peas ","fresh & healthy","Rs 150/kg"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.almond,"Almond ","afgani","Rs 1000/kg"));







//////////////////***







        //////////////////***




        //////////////////**









        ///////////////test


        LinearLayoutManager testLayoutManager=new LinearLayoutManager(CategoryActivity.this);
        testLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       categoryRecyclerView.setLayoutManager(testLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();


        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ff0000"));
        //homePageModelList.add(new HomePageModel(1,R.drawable.app_icon,"#000000"));

        homePageModelList.add(new HomePageModel(2,"  DEALS OF THE DAY",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"DEALS OF THE DAY",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));

        // homePageModelList.add(new HomePageModel(0,sliderModelList));
        // homePageModelList.add(new HomePageModel(1,R.drawable.shopping,"#ffff00"));

        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);


        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
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
        else if (id==android.R.id.home)
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

