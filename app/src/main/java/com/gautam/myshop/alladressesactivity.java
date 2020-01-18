package com.gautam.myshop;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

public class alladressesactivity extends AppCompatActivity {
    private RecyclerView myaddressesRecyclerView;
    private static addresses_adapter addresses_adapter_obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alladressesactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("my adresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myaddressesRecyclerView =findViewById(R.id.addresses_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myaddressesRecyclerView.setLayoutManager(layoutManager);
        List<addresses_model> addresses_modelList =new ArrayList<>();

        addresses_modelList.add(new addresses_model("john","sdsdvhsk","242001",true));
        addresses_modelList.add(new addresses_model("john2","sdsdvhsk2","242011",false));
        addresses_modelList.add(new addresses_model("john3","sdsdvhsk3","242021",false));
        addresses_modelList.add(new addresses_model("john4","sdsdvhsk4","242031",false));
        addresses_modelList.add(new addresses_model("john5","sdsdvhsk5","242041",false));
        addresses_modelList.add(new addresses_model("john6","sdsdvhsk6","242051",false));

        int mode = getIntent().getIntExtra("MODE",-1);

        addresses_adapter addresses_adapter= new addresses_adapter(addresses_modelList,mode);
        myaddressesRecyclerView.setAdapter(addresses_adapter);

        ((SimpleItemAnimator)myaddressesRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        addresses_adapter.notifyDataSetChanged();


    }


    public  static void refreshItem(int deSelect,int select){
        addresses_adapter_obj.notifyItemChanged(deSelect);
        addresses_adapter_obj.notifyItemChanged(select);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
