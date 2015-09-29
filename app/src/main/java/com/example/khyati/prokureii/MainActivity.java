package com.example.khyati.prokureii;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.support.v7.widget.SearchView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khyati.prokureii.FragmentsForCarousel.*;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private CharSequence mTitle;
    private DrawerLayout drawerLayout;
    SearchView search;
    ViewPager viewPager;
    LinePageIndicator lIndicator;
    List<Product> list = new ArrayList<>();
    int productCount = 6;
    SearchManager searchManager;
    TextView textView;
    String[] pNames = {"Batteries","Chargers"};
    int[] img = {R.drawable.batteries,R.drawable.charger};
    ScrollView scroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addProductToList();

        // navigation drawer and toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mTitle = getTitle();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, drawerLayout, toolbar);


        //search view
        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search = (SearchView)findViewById(R.id.seach_view);
        search.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchableActivity.class)));
        search.setIconifiedByDefault(false);


        //view pager
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new ViewPagerAdpater(fragmentManager));
        viewPager.setCurrentItem(1);

        lIndicator = (LinePageIndicator) findViewById(R.id.indicator);
        lIndicator.setViewPager(viewPager);

        ((LinearLayout)findViewById(R.id.product10)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count = Integer.parseInt(textView.getText().toString()) + 1;
                PrefUtils.setCartCount(MainActivity.this, count);
                textView.setText("" + Integer.toString(count));
                Toast.makeText(getApplicationContext(), "Item Added to cart", Toast.LENGTH_SHORT).show();

            }
        });
                ((LinearLayout) findViewById(R.id.product20)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(textView.getText().toString()) + 1;
                PrefUtils.setCartCount(MainActivity.this, count);
                textView.setText("" + Integer.toString(count));

                Toast.makeText(getApplicationContext(), "Item Added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        ((LinearLayout)findViewById(R.id.product11)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(textView.getText().toString()) + 1;
                PrefUtils.setCartCount(MainActivity.this,count);
                textView.setText("" + Integer.toString(count));

                Toast.makeText(getApplicationContext(), "Item Added to cart", Toast.LENGTH_SHORT).show();
            }
        }); ((LinearLayout)findViewById(R.id.product21)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(textView.getText().toString()) + 1;
                PrefUtils.setCartCount(MainActivity.this,count);
                textView.setText("" + Integer.toString(count));

                Toast.makeText(getApplicationContext(), "Item Added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        ((LinearLayout)findViewById(R.id.product12)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(textView.getText().toString()) + 1;
                PrefUtils.setCartCount(MainActivity.this,count);
                textView.setText("" + Integer.toString(count));

                Toast.makeText(getApplicationContext(), "Item Added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        ((LinearLayout)findViewById(R.id.product22)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(textView.getText().toString()) + 1;
                PrefUtils.setCartCount(MainActivity.this,count);
                textView.setText("" + Integer.toString(count));

                Toast.makeText(getApplicationContext(), "Item Added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void addProductToList() {
        for(int i = 0; i < productCount; i++){
            Product p = new Product(img[i%2],pNames[i%2]);
            list.add(p);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        RelativeLayout frameLayout = (RelativeLayout) menu.findItem(R.id.badge).getActionView();
        textView = (TextView) frameLayout.findViewById(R.id.menu_badge);
        int count = PrefUtils.getCartCount(this);
        if(count != -1)
            textView.setText(""+count);
        else
            textView.setText(""+0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}


class ViewPagerAdpater extends FragmentPagerAdapter {
    public ViewPagerAdpater(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch(i){
            case 0:
                fragment = new FragmentA();
                break;
            case 1:
                fragment = new FragmentB();
                break;
            case 2:
                fragment = new FragmentC();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}





