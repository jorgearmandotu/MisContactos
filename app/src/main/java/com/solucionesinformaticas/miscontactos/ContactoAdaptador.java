package com.solucionesinformaticas.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by home on 18/02/2018.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {

        this.contactos = contactos;
        this.activity = activity;
    }


//inflar el layout y pasar el viewholder para obtener los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent , false);

        return new ContactoViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoviewholder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoviewholder.imgFoto.setImageResource(contacto.getFoto());
        contactoviewholder.tvNombreCV.setText(contacto.getNombre());
        contactoviewholder.tvTelefonoCV.setText(contacto.getTelefono());


        contactoviewholder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                intent.putExtra("foto", contacto.getFoto());
                activity.startActivity(intent);
            }
        });

        contactoviewholder.btnLIke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "like a "+contacto.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLIke;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombre);
            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefono);
            btnLIke = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}
