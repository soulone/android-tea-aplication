package com.soulone.saywithpics.Models;

public class Actividad {
    int idActividad;
    String nombreActividad;
    String pictureActividad;

    public Actividad() {
    }

    public Actividad(int idActividad, String nombreActividad, String pictureActividad) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.pictureActividad = pictureActividad;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getPictureActividad() {
        return pictureActividad;
    }

    public void setPictureActividad(String pictureActividad) {
        this.pictureActividad = pictureActividad;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "idActividad=" + idActividad +
                ", nombreActividad='" + nombreActividad + '\'' +
                ", pictureActividad='" + pictureActividad + '\'' +
                '}';
    }


}
