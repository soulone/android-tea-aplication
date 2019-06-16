package com.soulone.saywithpics.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.soulone.saywithpics.R;

public class CreateRutinasDialog extends AppCompatDialogFragment {

    private EditText etNombreRutina;
    private CreatRutinasDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.modal_nombre_rutina,null);
        builder.setView(view)
                .setTitle("Crear nueva rutina")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nombre = etNombreRutina.getText().toString();
                        listener.applyNombre(nombre);
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        etNombreRutina =  view.findViewById(R.id.titNombreRutinaModal);
        return builder.create();

        }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (CreatRutinasDialogListener) context;
        } catch (ClassCastException e){
          throw new ClassCastException(context.toString()+"Implement Crear Rtuinas Dialog Listener");
        }


    }

    public interface CreatRutinasDialogListener{
        void applyNombre(String nombre);
    }
}
