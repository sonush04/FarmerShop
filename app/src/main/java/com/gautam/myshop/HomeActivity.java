package com.gautam.myshop;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import io.paperdb.Paper;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Dialog dialog;
    public Button dialogyes,dialogno;

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout frameLayout;
    private static final int HOME_FRAGMENT=0;
    private static final int CART_FRAGMENT=3;
    private static final int WISHLIST_FRAGMENT=3;
    private static final int ORDERS_FRAGMENT=1;
    private static final int REWARD_FRAGMENT = 2;
    private static final int ACCOUNT_FRAGMENT=5;
    private  NavigationView navigationView;
    private ImageView actionBarLogo;

    public static boolean showChart = false;

    private int currentFragment;



    private ProgressDialog loadingBar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        actionBarLogo=findViewById(R.id.actionbar_logo);
        frameLayout=findViewById(R.id.main_framelayout);
        setFragment(new HomeFragment(),HOME_FRAGMENT);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

       // createDialog();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(HomeActivity.this);
        //navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.getMenu().getItem(3).setChecked(false);
        if(showChart){
            drawer.setDrawerLockMode(1);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            gotoFragment("My Cart", new MyCartFragment(),-2);
        }else{
            ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(HomeActivity.this,drawer,toolbar,0,0);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            setFragment(new HomeFragment(), HOME_FRAGMENT);
        }

        // AdView adView=new AdView(this);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //  mAppBarConfiguration = new AppBarConfiguration.Builder(
        //    R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
        //  R.id.nav_tools, R.id.nav_share, R.id.nav_send)
        //    .setDrawerLayout(drawer)
        //  .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        // NavigationUI.setupWithNavController(navigationView, navController);
    }

  /*  private void createDialog() {
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
       dialog.setContentView(R.layout.dialog_exit);

        dialog.setCancelable(true);

        dialogyes=(Button)findViewById(R.id.yes);
        dialogno=(Button)findViewById(R.id.no);

        dialogyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_MAIN);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                finish();
                System.exit(0);



            }
        });

        dialogno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (currentFragment == HOME_FRAGMENT) {
                super.onBackPressed();
            } else {
                if(showChart){
                    showChart = false;
                    finish();
                }else {
                    //getSupportActionBar().setDisplayShowTitleEnabled(false);
                    actionBarLogo.setVisibility(View.VISIBLE);
                    invalidateOptionsMenu();
                    setFragment(new HomeFragment(), HOME_FRAGMENT);
                    navigationView.getMenu().getItem(0).setChecked(true);
                    //navigationView.getMenu().getItem(0).setChecked(true);
                    //navigationView.getMenu().getItem(3).setChecked(false);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(currentFragment==HOME_FRAGMENT) {
            getMenuInflater().inflate(R.menu.home, menu);


        }
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
        else if(id==R.id.main_notification_icon)
        {
            return true;
        }

        else if(id==R.id.main_cart_icon)
        {
            myCart();
            return true;
        }
        else if(id == android.R.id.home){
            if(showChart){
                showChart = false;
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void myCart() {
        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("MY CART");
        invalidateOptionsMenu();
        setFragment(new MyCartFragment(),CART_FRAGMENT);
        navigationView.getMenu().getItem(3).setChecked(true);
        navigationView.getMenu().getItem(0).setChecked(false);
    }





    private void myOrder() {
        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("MY ORDER");
        invalidateOptionsMenu();
        setFragment(new myOrderFragment(),ORDERS_FRAGMENT);
        navigationView.getMenu().getItem(1).setChecked(true);
        navigationView.getMenu().getItem(0).setChecked(false);
    }




    public boolean onNavigationItemSelected(MenuItem item)
    {

        int id=item.getItemId();



        if(id==R.id.my_mall)

        {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomeFragment(),HOME_FRAGMENT);
            navigationView.getMenu().getItem(0).setChecked(true);
            navigationView.getMenu().getItem(3).setChecked(false);
        }

        else if(id==R.id.my_order)
        {
                myOrder();
            }

        else if(id==R.id.my_rewards)
        {
            gotoFragment("My Rewards",new MyRewardsFragment(),REWARD_FRAGMENT);
        }
        else if(id==R.id.my_cart)
        {
            myCart();
        }

        else if(id==R.id.my_whishlist)
        {
             gotoFragment("My Wishlist",new MyWishlistFragment(),WISHLIST_FRAGMENT);
        }
        else if(id==R.id.my_account)
        {
            gotoFragment("My Account ",new MyAccountFragment(),ACCOUNT_FRAGMENT);

        }
        else if(id==R.id.my_signout)
        {
            Intent intent = new Intent(HomeActivity.this, Main2Activity.class);
            startActivity(intent);

            Paper.book().destroy();

//chnages
        }
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
    private void setFragment(Fragment fragment, int fragmentNo)


    {

        currentFragment = fragmentNo;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();

    }
    private void gotoFragment(String title ,Fragment fragment,int fragmentNO)
    {
        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment,fragmentNO);
        if(fragmentNO==CART_FRAGMENT)
        {
            navigationView.getMenu().getItem(3).setChecked(true);
        }
    }










}
