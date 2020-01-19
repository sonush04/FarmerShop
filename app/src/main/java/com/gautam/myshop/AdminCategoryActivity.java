package com.gautam.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminCategoryActivity extends AppCompatActivity {
    private Button addNewCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);
        addNewCategory=findViewById(R.id.addNewCategory);
        addNewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AdminCategoryActivity.this,farmerCategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
