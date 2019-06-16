package com.soulone.saywithpics.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soulone.saywithpics.Fragments.AllRutinas;
import com.soulone.saywithpics.Models.Rutina;
import com.soulone.saywithpics.R;
import com.soulone.saywithpics.Adapters.RutinasAdapter;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class RutinasAdapter  extends RecyclerView.Adapter<RutinasAdapter.ViewHolder>{
    @NonNull


    private List<Rutina> RutinaList;
    private Activity activity;

    public RutinasAdapter(FragmentManager supportFragmentManager) {
        this.RutinaList = new ArrayList<>();
    }




    public void setPostsList(List<Rutina> rutinaList) {
        this.RutinaList = rutinaList;
    }

    @Override
    public RutinasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rutina, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RutinasAdapter.ViewHolder viewHolder, int i) {
        Rutina rutina=this.RutinaList.get(i);
        viewHolder.nombre.setText(rutina.getNombre());
    }

    @Override
    public int getItemCount() {
        return RutinaList.size();
    }

    public void addFragment(AllRutinas todas) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.tvItemNombre);
        }
    }
}

