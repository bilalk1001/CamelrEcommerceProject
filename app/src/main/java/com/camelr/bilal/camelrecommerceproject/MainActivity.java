package com.camelr.bilal.camelrecommerceproject;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.camelr.bilal.camelrecommerceproject.Data.AtmRecyclerViewAdapter;
import com.camelr.bilal.camelrecommerceproject.Fragments.SearchItems;
import com.camelr.bilal.camelrecommerceproject.Fragments.ShowATMs;
import com.camelr.bilal.camelrecommerceproject.Fragments.ShowItems;
import com.camelr.bilal.camelrecommerceproject.Models.ATM;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nView;

    private ActionBarDrawerToggle toggle;

    private RequestQueue queue;

    private List<ATM> atmList;

    private RecyclerView atmView;

    private AtmRecyclerViewAdapter atmRecyclerViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find drawer layout
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Find drawer view
        nView = (NavigationView) findViewById(R.id.nav_view);
        // Set up drawer view
        setupDrawerContent(nView);

        // Not sure what this does
        nView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        // Tie DrawerLayout events to the ActionBarDrawerToggle
        mDrawer.addDrawerListener(toggle);


//        queue = Volley.newRequestQueue(this);

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hey there how ya doin", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        // Pass any configuration change to the drawer toggles
        toggle.onConfigurationChanged(newConfig);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // The action bar home/up action should open or close the drawer.

        switch (item.getItemId()) {

            case android.R.id.home:

                mDrawer.openDrawer(GravityCompat.START);

                return true;

        }

        if (toggle.onOptionsItemSelected(item)) {

            return true;

        }

/*        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_items_catalog) {
            // Handle the items catalog action
        } else if (id == R.id.nav_items_search) {

        } else if (id == R.id.nav_atms) {

/*
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Constants.atmURL,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            try {

                                for (int i = 0; i < response.length(); i++) {

                                    JSONObject atmObj = response.getJSONObject(i);

                                    ATM atm = new ATM();

                                    atm.setAtmId(atmObj.getString("atmid"));
                                    atm.setTitle(atmObj.getString("title"));
                                    atm.setAddress(atmObj.getString("address"));
                                    atm.setType(atmObj.getString("type"));
                                    atm.setLat(atmObj.getDouble("lat"));
                                    atm.setLon(atmObj.getDouble("lon"));
                                    atm.setOnlineStatus(atmObj.getString("onlineStatus"));

                                    atmList.add(atm);

                                    // Log.d("ATM Statuses", atmList.get(i).getOnlineStatus());

                                }

//                                atmView = findViewById(R.id.atmRecyclerView);
//                                atmView.setHasFixedSize(true);
//                                atmView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                atmRecyclerViewAdapter = new AtmRecyclerViewAdapter
                                        (MainActivity.this, atmList);
                                atmView.setAdapter(atmRecyclerViewAdapter);
                                atmRecyclerViewAdapter.notifyDataSetChanged();

                            } catch (JSONException e) {

                                e.printStackTrace();

                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    error.printStackTrace();

                }
            });

            queue.add(jsonArrayRequest);
*/

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectDrawerItem(menuItem);
                return true;
            }
        });

    }

    public void selectDrawerItem(MenuItem menuItem) {

        // Create a new fragment and specify the fragment to show based on nav item clicked

        Fragment fragment = null;

        Class fragmentClass;

        switch(menuItem.getItemId()) {

            case R.id.nav_items_catalog:

                fragmentClass = ShowItems.class;

                // TODO: Find out how to show the fragments in these calls

//                fragment.listItems(???);

                break;

            case R.id.nav_items_search:

                fragmentClass = SearchItems.class;

                break;

            case R.id.nav_atms:

                fragmentClass = ShowATMs.class;

/*
                atmView = findViewById(R.id.atmRecyclerView);
                atmView.setHasFixedSize(true);
                atmView.setLayoutManager(new LinearLayoutManager(this));
*/

                break;

            default:

                fragmentClass = ShowItems.class;

        }

        try {

            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {

            e.printStackTrace();

        }

        // Insert the fragment by replacing any existing fragment

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView

        menuItem.setChecked(true);

        // Set action bar title

        setTitle(menuItem.getTitle());

        // Close the navigation drawer

        mDrawer.closeDrawers();

    }

}
