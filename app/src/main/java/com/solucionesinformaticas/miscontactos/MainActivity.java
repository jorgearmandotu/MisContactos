package com.solucionesinformaticas.miscontactos;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.solucionesinformaticas.miscontactos.adapter.ContactoAdaptador;
import com.solucionesinformaticas.miscontactos.adapter.PageAdapter;
import com.solucionesinformaticas.miscontactos.fragment.PerfilFragment;
import com.solucionesinformaticas.miscontactos.fragment.RecyclerViewFragment;
import com.solucionesinformaticas.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =  findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        /*
        android.support.v7.widget.Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        */

        /*

        */


/*
ArrayList<String> nombresContactos = new ArrayList<>();
        for (Contacto contacto:contactos
                ) {
            nombresContactos.add(contacto.getNombre());
        }



        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContactos));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {//i= position l=id
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });*/


    }

    private ArrayList<android.support.v4.app.Fragment> agregarFragments(){
        ArrayList<android.support.v4.app.Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager() {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }


}
