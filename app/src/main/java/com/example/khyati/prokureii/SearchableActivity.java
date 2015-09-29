package com.example.khyati.prokureii;

import android.animation.ObjectAnimator;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class SearchableActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView textView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        searchView= (SearchView)toolbar.getChildAt(0);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        searchView =
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this,SearchableActivity.class)));
        searchView.setIconifiedByDefault(false);
        textView = (TextView) findViewById(R.id.text);
        setupWindowAnimations();
    }
    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);

        Slide slide = new Slide();
        fade.setDuration(1000);
        getWindow().setReturnTransition(slide);

    }

    void handleSearch(Intent intent) {
        if (Intent.ACTION_SEARCH.equalsIgnoreCase(intent.getAction())){
            String q = intent.getStringExtra(SearchManager.QUERY);
            Log.d("query",""+q);
            textView.setText("You searched for " + q);
        }
    }

    @Override
    protected void onStart() {
        handleSearch(getIntent());
        super.onStart();
    }

    @Override
    protected void onNewIntent(Intent intent) {

        setIntent(intent);
        Log.d("Intent", " new intent is sent");
        handleSearch(intent);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

//        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setIconified(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_searchable, menu);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//        if(searchView != null) {
//            searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchableActivity.class)));
//            searchView.setIconifiedByDefault(true);
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.search){
            return true;
        }
        if( id == R.id.home){
            Log.d("Home "," clicked");
            startActivity(new Intent(this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
