package com.soulone.saywithpics.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soulone.saywithpics.Models.Actividad;
import com.soulone.saywithpics.R;


import java.util.ArrayList;

public class ActividadAdapter extends RecyclerView.Adapter<ActividadAdapter.ActividadViewHolder> {
    @NonNull

    private ArrayList<Actividad> actividades;
    private int resource;
    private Activity activity;

    public ActividadAdapter(ArrayList<Actividad> actividad, int resource, Activity activity) {
        this.actividades = actividad;
        this.resource = resource;
        this.activity = activity;
    }



    //Va a iniciarlizar nuestra clase  RutinaViewHolder
    @Override
    public ActividadViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource,viewGroup,false);
        //Le devolvemos el recursos ya inflado
        return new ActividadViewHolder(view);
    }


    //Le mandamos el array de datos
    //Recorre la lista
    @Override
    public void onBindViewHolder(@NonNull ActividadViewHolder actividadViewHolder, int i) {
        Actividad actividad = actividades.get(i);
        //Recorre la lista de datos y asigna a tarjetas
        actividadViewHolder.nombreActividad.setText(actividad.getNombreActividad());
        //Tiene acceso a los views
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public class ActividadViewHolder extends RecyclerView.ViewHolder  {

        private TextView nombreActividad;


        //View Holder permite reutilizar los items
        public ActividadViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreActividad = (TextView)itemView.findViewById(R.id.nombreAcitividad);
        }
    }
}
