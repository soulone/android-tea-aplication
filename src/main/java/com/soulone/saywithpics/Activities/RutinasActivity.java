package com.soulone.saywithpics.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.soulone.saywithpics.Adapters.RutinasAdapter;
import com.soulone.saywithpics.Fragments.CreateRutinasDialog;
import com.soulone.saywithpics.Interfaces.ConfiguracionRetrofit;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.soulone.saywithpics.Adapters.RutinasPagerAdapter;
import com.soulone.saywithpics.Fragments.AllRutinas;
import com.soulone.saywithpics.Fragments.ArchivadoRutinas;
import com.soulone.saywithpics.Models.Rutina;
import com.soulone.saywithpics.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RutinasActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener ,CreateRutinasDialog.CreatRutinasDialogListener
{

    //TAG
    private static final String TAG ="Rutinas Activity" ;

    //RecyclerView
    private RecyclerView recyclerView;
    //TabLayout
    private TabLayout mtablayout;
    private int[] tabIcons = {R.drawable.ic_twotone_access_time_24px, R.drawable.ic_twotone_archive_24px};
    private String[] tabText = {"Rutinas", "Archivados"};
    //Firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    //[Funciones y metodos]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas);
        TextView textViewRutinaName     = findViewById(R.id.textViewRutinaName);
        recyclerView                    = findViewById(R.id.my_recycler_view);
        Toolbar toolbar                 = findViewById(R.id.toolbar);
        ViewPager viewPager             = findViewById(R.id.viewpager);
        FloatingActionButton fab        = findViewById(R.id.fabCrearRutina);
        mtablayout                      = findViewById(R.id.tabLayout);
        DrawerLayout drawer             = findViewById(R.id.drawer_layout);
        NavigationView navigationView   = findViewById(R.id.nav_view);

        //Inicializando Inicialize
        inicialize();

        //Comfiguracion de Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mis rutina");

        //Configuracion de los Tabslayout
        loadViewPager(viewPager);
        mtablayout.setupWithViewPager(viewPager);
        tabSet();

        //Configuracion de FAB en rutinas
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearNuevaRutina();
            }
        });

        //Configuracion de Drawer del Actionbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void crearNuevaRutina() {
        CreateRutinasDialog createRutinasDialog =  new CreateRutinasDialog();
        createRutinasDialog.show(getSupportFragmentManager(),"Dialog Rutinas");
    }
    @Override
    public void applyNombre(String nombre) {
        //No funciona
    }
    //[Conguraciones de los TABS en Rutinas]

    //Setting de los Tabs layouts tabs 'ICONOS Y TITULOS'
    private void tabSet() {
        for (int i = 0; i < 2; i++) {
            mtablayout.getTabAt(i).setIcon(tabIcons[i]);
            mtablayout.getTabAt(i).setText(tabText[i]);
        }
    }
    //Load los Pager "Setting the titles"
    private void loadViewPager(ViewPager viewPager) {
        RutinasPagerAdapter rutinasPagerAdapter = new RutinasPagerAdapter(getSupportFragmentManager());
        rutinasPagerAdapter.addFragment(newIntanceRutinas("Todas"));
        rutinasPagerAdapter.addFragment(newIntanceArchivados("Archivados"));
        viewPager.setAdapter(rutinasPagerAdapter);
    }
    //Cargando las instancias de Rutinas
    private AllRutinas newIntanceRutinas(String title) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        AllRutinas fragment = new AllRutinas();
        fragment.setArguments(bundle);
        return fragment;
    }
    //Cargando las instancias de Archivados(Rutinas)
    private ArchivadoRutinas newIntanceArchivados(String title) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        ArchivadoRutinas fragment = new ArchivadoRutinas();
        fragment.setArguments(bundle);
        return fragment;
    }

    //Configuraciones del hamburguer menu
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
    //Setting de la accion al presionar los botones del menu item de la vista rutinas
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tutorial) {
            Intent intent = new Intent(RutinasActivity.this,TutorialActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share_app) {

        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "Cerrar sesion", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //[Configuraciones del firebase]
    //Inicializardor

    private void inicialize() {
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseAuth != null) {
                    TextView tvEmail = findViewById(R.id.tvUserEmail);
                    tvEmail.setText(firebaseUser.getEmail());
                } else {
                    Log.w(TAG, "onAuthStateChanged - singned_out");
                }
            }
        };
    }


}


