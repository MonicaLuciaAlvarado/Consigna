/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consigna;

/**
 *
 * @author ester
 */
public class Plantas {
    // Atributos .
    private int id_planta;
    private String nombre;
    private String especie;
    private double precio;
    private int cantidad_stock;
    private String descripcion;

    // Método constructor
    public Plantas() {
        this.id_planta = 0;
        this.nombre = "";
        this.especie = "";
        this.precio = 0.0;
        this.cantidad_stock = 0;
        this.descripcion = "";
    }

    // Método constructor sobrecargado
    public Plantas(int id_planta, String nombre, String especie, double precio, int cantidad_stock,
            String descripcion) {
        this.id_planta = id_planta;
        this.nombre = nombre;
        this.especie = especie;
        this.precio = precio;
        this.cantidad_stock = cantidad_stock;
        this.descripcion = descripcion;
    }

    // Métodos accesores y mutadores
    public int getId_planta() {
        return id_planta;
    }

    public void setId_planta(int id_planta) {
        this.id_planta = id_planta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad_stock() {
        return cantidad_stock;
    }

    public void setCantidad_stock(int cantidad_stock) {
        this.cantidad_stock = cantidad_stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
