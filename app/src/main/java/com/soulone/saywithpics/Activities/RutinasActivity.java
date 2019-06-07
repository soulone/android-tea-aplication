package com.soulone.saywithpics.Activities;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.soulone.saywithpics.Adapters.RutinasAdapter;
import com.soulone.saywithpics.Fragments.AllRutinas;
import com.soulone.saywithpics.Fragments.ArchivadoRutinas;
import com.soulone.saywithpics.R;

public class RutinasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout mtablayout;
    private int[] tabIcons = {R.drawable.ic_twotone_access_time_24px, R.drawable.ic_twotone_archive_24px};
    private String[] tabText = {"Rutinas", "Archivados"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ViewPager viewPager = findViewById(R.id.viewpager);
        loadViewPager(viewPager);
        mtablayout = findViewById(R.id.tabLayout);
        mtablayout.setupWithViewPager(viewPager);
        tabSet();


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mis rutinas");


        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void tabSet() {
        for (int i = 0; i < 2; i++) {
            mtablayout.getTabAt(i).setIcon(tabIcons[i]);
            mtablayout.getTabAt(i).setText(tabText[i]);
        }
    }

    private void loadViewPager(ViewPager viewPager) {
        RutinasAdapter rutinasAdapter = new RutinasAdapter(getSupportFragmentManager());
        rutinasAdapter.addFragment(newIntanceRutinas("Todas"));
        rutinasAdapter.addFragment(newIntanceArchivados("Archivados"));
        viewPager.setAdapter(rutinasAdapter);
    }

    private AllRutinas newIntanceRutinas(String title) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        AllRutinas fragment = new AllRutinas();
        fragment.setArguments(bundle);
        return fragment;
    }

    private ArchivadoRutinas newIntanceArchivados(String title) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        ArchivadoRutinas fragment = new ArchivadoRutinas();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rutinas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tutorial) {

        } else if (id == R.id.nav_share_app) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
