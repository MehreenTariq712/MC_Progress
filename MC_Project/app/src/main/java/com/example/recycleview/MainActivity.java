package com.example.recycleview;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import static com.example.recycleview.RegesterActivity.setSignUpFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static final int ORDERS_FRAGMENT = 2;
    private static final int WISHLIST_FRAGMENT = 3;
    private static final int REWARDS_FRAGMENT=4;
    private static final int ACCOUNT_FRAGMENT=5;
    public static Boolean showCart = false;

    private FrameLayout frameLayout;
    private ImageView actionBarLogo;
    private int currentFragment = -1;
    private NavigationView navigationView;

    private Window window;
    private Toolbar toolbar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        actionBarLogo = findViewById(R.id.actionbar_logo);
        toolbar.setSubtitle("");
        toolbar.inflateMenu(R.menu.main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                int id = item.getItemId();
//                if (id == R.id.main_search_icon) {
//
//                    //todo:search
//                    return true;
//                } else if (id == R.id.main_notification_icon) {
//
//                    //todo:notification
//                    return true;
//                } else if (id == R.id.main_cart_icon1) {
//                    final Dialog signInDialog = new Dialog(MainActivity.this);
//                    signInDialog.setContentView(R.layout.sign_in_dialog);
//                    signInDialog.setCancelable(true);
//
//                    signInDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//                    Button dialogSigInBtn = signInDialog.findViewById(R.id.sign_in_btn);
//                    Button dialogSigUpBtn = signInDialog.findViewById(R.id.sign_up_btn);
//
//                    dialogSigInBtn.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            signInDialog.dismiss();
//                            setSignUpFragment = false;
//                            Intent registerIntent = new Intent(MainActivity.this,RegesterActivity.class);
//                            startActivity(registerIntent);
//                        }
//                    });
//
//                    dialogSigUpBtn.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            signInDialog.dismiss();
//                            setSignUpFragment = true;
//                            Intent registerIntent = new Intent(MainActivity.this,RegesterActivity.class);
//                            startActivity(registerIntent);
//                        }
//                    });
//
//                    signInDialog.show();
//
//                    //gotoFragment("My Animal Cart", new MyCartFragment(), CART_FRAGMENT);
//                    return true;
//                } else if(id == android.R.id.home){
//                    if (showCart){
//                        showCart = false;
//                        finish();
//                        return true;
//                    }
//                }
//                return false;
//            }
//        });

        window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration); // djfds
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);


        frameLayout = findViewById(R.id.main_framelayout);

        if (showCart ){
            drawer.setDrawerLockMode(1);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            gotoFragment("My Cart", new MyCartFragment(),-2);
        }else {
            setFragment(new HomeFragment(), HOME_FRAGMENT);
        }

    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (currentFragment == HOME_FRAGMENT) {
                currentFragment = -1;
                super.onBackPressed();
            } else {
                if (showCart){
                    showCart = false;
                    finish();
                }else {
                    actionBarLogo.setVisibility(View.VISIBLE);
                    invalidateOptionsMenu();
                    setFragment(new HomeFragment(), HOME_FRAGMENT);
                    navigationView.getMenu().getItem(0).setChecked(true);
                }
            }
        }
    }


    // remove this
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentFragment == HOME_FRAGMENT) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        getMenuInflater().inflate(R.menu.main, menu);

        for (int i = 0; i < menu.size(); i++) {
            final MenuItem item = menu.getItem(i);
            View actionView = MenuItemCompat.getActionView(item);
            if (actionView != null) {
                actionView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        onOptionsItemSelected(item);
                    }
                });
            }
        }

        return true;
    }
    public boolean onOptionItemSelected(MenuItem item) {
        int id = item.getGroupId();
        if (id == R.id.main_search_icon) {

            //todo:search
            return true;
        } else if (id == R.id.main_notification_icon) {

            //todo:notification
            return true;
        } else if (id == R.id.main_cart_icon1) {
            final Dialog signInDialog = new Dialog(MainActivity.this);
            signInDialog.setContentView(R.layout.sign_in_dialog);
            signInDialog.setCancelable(true);

            signInDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            Button dialogSigInBtn = signInDialog.findViewById(R.id.sign_in_btn);
            Button dialogSigUpBtn = signInDialog.findViewById(R.id.sign_up_btn);
            final Intent registerIntent = new Intent(MainActivity.this,RegesterActivity.class);

            dialogSigInBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signInDialog.dismiss();
                    setSignUpFragment = false;
                    startActivity(registerIntent);
                }
            });

            dialogSigInBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signInDialog.dismiss();
                    setSignUpFragment = true;
                    startActivity(registerIntent);
                }
            });

            signInDialog.show();

            //gotoFragment("My Animal Cart", new MyCartFragment(), CART_FRAGMENT);
            return true;
        } else if(id == android.R.id.home){
            if (showCart){
                showCart = false;
                finish();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    //remove end

    private void gotoFragment(String title, Fragment fragment, int fragmentNo) {
        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment, fragmentNo);
        if (fragmentNo == CART_FRAGMENT) {
            navigationView.getMenu().getItem(3).setChecked(true);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_my_animal) {
            actionBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomeFragment(), HOME_FRAGMENT);
        } else if (id == R.id.nav_my_order) {
            gotoFragment("My Animal Orders", new MyOrderFragment(), ORDERS_FRAGMENT);
        } else if (id == R.id.nav_my_rewar) {
            gotoFragment("My Rewards", new MyRewardsFragment(),REWARDS_FRAGMENT);
        } else if (id == R.id.nav_my_cart) {
            gotoFragment("My Animal Cart", new MyCartFragment(), CART_FRAGMENT);
        } else if (id == R.id.nav_my_wishlist) {
            gotoFragment("My Animal Wishlist", new MyWishlistFragment(), 3);
        } else if (id == R.id.nav_my_account) {
            gotoFragment("My Account",new MyAccountFragment(),ACCOUNT_FRAGMENT);
        } else if (id == R.id.nav_signout) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setFragment(Fragment fragment, int fragmentNo) {
        if (fragmentNo != currentFragment) {
            if (fragmentNo == REWARDS_FRAGMENT){
                window.setStatusBarColor(Color.parseColor("#5B04B1"));
                toolbar.setBackgroundColor(Color.parseColor("#5B04B1"));
            }else {
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            currentFragment = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }
}
