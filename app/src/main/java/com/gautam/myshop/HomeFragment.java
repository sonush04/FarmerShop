package com.gautam.myshop;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

   private RecyclerView testing;
   private  List<Category_model> category_modelList;
   private FirebaseFirestore firebaseFirestore;


    public HomeFragment() {
        // Required empty public constructor
    }
private RecyclerView categoryRecyclerView;
    private Category_adapter category_adapter;









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home2, container, false);
        categoryRecyclerView=view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);

        category_modelList=new ArrayList<Category_model>();

        category_adapter=new Category_adapter(category_modelList);
        categoryRecyclerView.setAdapter(category_adapter);

    //    category_adapter.notifyDataSetChanged();


        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){

                                category_modelList.add( new Category_model(documentSnapshot.get("icon").toString() , documentSnapshot.get("CategoryName").toString()) );

                            }

                            category_adapter.notifyDataSetChanged();
                        }
                        else{
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });




        ////////////////








     List<slider_model>   sliderModelList =new ArrayList<slider_model>();






        sliderModelList.add(new slider_model(R.drawable.search,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.app_icon,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.banner,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.profile,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_order,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_wishlist,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_rewards,"#077AE4"));



        ////////////






        ///////////////////////////////*








        ///////////////////////////////*





















        //////////////////**





List<horizontal_product_scroll_model> horizontalProductScrollModelList=new ArrayList<>();
horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.profile,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_rewards,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.app_icon,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_wishlist,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_wishlist,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));







//////////////////***







        //////////////////***




        //////////////////**









        ///////////////test

        testing=view.findViewById(R.id.home_page_recycler_view);
        LinearLayoutManager testLayoutManager=new LinearLayoutManager(getContext());
        testLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();


        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ff0000"));
        //homePageModelList.add(new HomePageModel(1,R.drawable.app_icon,"#000000"));

        homePageModelList.add(new HomePageModel(2,"  DEALS OF THE DAY",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"DEALS OF THE DAY",horizontalProductScrollModelList));

       // homePageModelList.add(new HomePageModel(0,sliderModelList));
       // homePageModelList.add(new HomePageModel(1,R.drawable.shopping,"#ffff00"));

        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);


testing.setAdapter(adapter);
adapter.notifyDataSetChanged();


        ////////////test

        return view;
    }




    ///////////////






    /////////

}
