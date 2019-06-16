package com.soulone.saywithpics.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soulone.saywithpics.Activities.RoutineDetailActivity;
import com.soulone.saywithpics.Models.Rutina;
import com.soulone.saywithpics.R;

import java.util.ArrayList;

public class RutinaAdapter extends RecyclerView.Adapter<RutinaAdapter.RutinaViewHolder> {
    @NonNull

    private ArrayList<Rutina> rutinas;
    private int resource;
    private Activity activity;

    public RutinaAdapter(ArrayList<Rutina> rutina, int resource, Activity activity) {
        this.rutinas = rutina;
        this.resource = resource;
        this.activity = activity;
    }


    //Va a iniciarlizar nuestra clase  ActividadViewHolder
    @Override
    public RutinaAdapter.RutinaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource,viewGroup,false);
        //Le devolvemos el recursos ya inflado
        return new RutinaAdapter.RutinaViewHolder(view);
    }


    //Le mandamos el array de datos
    //Recorre la lista
    @Override
    public void onBindViewHolder(@NonNull RutinaViewHolder rutinaViewHolder, int i) {
        Rutina rutina = rutinas.get(i);
        //Recorre la lista de datos y asigna a tarjetas
        rutinaViewHolder.nombreRutina.setText(rutina.getNombre());
                //Tiene acceso a los views

        rutinaViewHolder.crdItemRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RoutineDetailActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rutinas.size();
    }

    public class RutinaViewHolder extends RecyclerView.ViewHolder  {

        private TextView nombreRutina;
        private CardView crdItemRoutine;


        //View Holder permite reutilizar los items
        public RutinaViewHolder(@NonNull View itemView) {
            super(itemView);
                nombreRutina = (TextView)itemView.findViewById(R.id.tvItemNombre);
                crdItemRoutine = (CardView)itemView.findViewById(R.id.crdItemRoutine);
        }
    }
}
