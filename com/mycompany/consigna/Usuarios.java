/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consigna;

/**
 *
 * @author ester
 */
public class Usuarios {

    protected int cedula;
    protected String nombre;
    protected String direccion;
    protected int telefono;
    protected String correo_electronico;
    protected int tipo;

    // Constructor

    public Usuarios(){
        this.cedula = 0;
        this.nombre = "";
        this.direccion = "";
        this.telefono = 0;
        this.correo_electronico = "";
        this.tipo = 0;
    }

    //CONstructor sobrecargado
    public Usuarios(int cedula, String nombre, String direccion, int telefono, String correo_electronico, int tipo) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.tipo = tipo;

    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
