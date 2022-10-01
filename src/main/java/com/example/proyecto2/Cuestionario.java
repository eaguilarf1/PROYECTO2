package com.example.proyecto2;

public class Cuestionario {

    public static int numero=1;
    private int correlativo;
    private int pin=0;
    private String nombre;
    private String descripcion;

    public Cuestionario(String nombre, String descripcion) {
        this.correlativo=numero;
        this.nombre = nombre;
        this.descripcion = descripcion;

        numero++;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
