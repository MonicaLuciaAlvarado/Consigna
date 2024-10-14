/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consigna;

/**
 *
 * @author ester
 */
public class Administrador extends Usuarios {

    // Constructor de subclase

    public Administrador(int cedula, String nombre, String direccion, int telefono, String correo_electronico, int tipo){
        super(cedula,nombre,direccion,telefono,correo_electronico,tipo);
    }

    @Override
    public String toString(){
        return "Cliente{" +
                "cedula=" + getCedula() +
                ", nombre='" + getNombre() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", telefono=" + getTelefono() +
                ", correo_electronico='" + getCorreo_electronico() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                '}';
    }
}
