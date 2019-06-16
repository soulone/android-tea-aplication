package com.soulone.saywithpics.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soulone.saywithpics.Adapters.ActividadAdapter;
import com.soulone.saywithpics.Models.Actividad;
import com.soulone.saywithpics.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivitesofRoutine extends Fragment {


    public ActivitesofRoutine() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable  LayoutInflater inflater,@Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activitesof_routine, container, false);
        RecyclerView ActividadesRecyclerView = (RecyclerView) view.findViewById(R.id.rv_actividades);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

         ActividadesRecyclerView.setLayoutManager(linearLayoutManager);

         ActividadAdapter actividadAdapter =
                 new ActividadAdapter(buildActividad(), R.layout.item_actividad, getActivity());
                ActividadesRecyclerView.setAdapter(actividadAdapter);
        return view;
    }

    public ArrayList<Actividad> buildActividad() {
        ArrayList<Actividad> actividad = new ArrayList<>();
        actividad.add(new Actividad(1, "Lavarse los dientes", "https://cdn5.dibujos.net/dibujos/pintados/201818/cepillarse-los-dientes-la-casa-el-bano-11358152.jpg"));
        return actividad;

    }
}
