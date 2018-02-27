package com.solucionesinformaticas.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        GridLayoutManager glm = new GridLayoutManager(this, 2);


        listaContactos.setLayoutManager(glm);
        inicializarListaContactos();
        inicializarAdaptador();


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



    public void inicializarListaContactos () {
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("emma", "3104558752", "bodoca@gmail.com",R.drawable.hipopotamo));
        contactos.add(new Contacto("valentina", "3204558752", "valentina@gmail.com",R.drawable.jirafa));
        contactos.add(new Contacto("daniela", "3167067631", "daniela@gmail.com",R.drawable.rana));
        contactos.add(new Contacto("armando", "3148516572", "armand@gmail.com",R.drawable.tigre));
        contactos.add(new Contacto("carmen", "3149916572", "carmensita@gmail.com",R.drawable.zebra));
        contactos.add(new Contacto("jorge", "3147816572", "jorge@gmail.com",R.drawable.mono));
        contactos.add(new Contacto("jorge", "3147816572", "jorge@gmail.com",R.drawable.mono));
        contactos.add(new Contacto("jorge", "3147816572", "jorge@gmail.com",R.drawable.mono));
        contactos.add(new Contacto("jorge", "3147816572", "jorge@gmail.com",R.drawable.mono));
        contactos.add(new Contacto("jorge", "3147816572", "jorge@gmail.com",R.drawable.mono));

    }
    public ContactoAdaptador adaptador;
    public void inicializarAdaptador() {
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }
}
