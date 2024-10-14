package com.mycompany.consigna;

public class Cliente extends Usuarios {

    private double tamano_jardin;

// Constructor por defecto
    public Cliente() {
        super();
        this.tamano_jardin = 0.0;
    }

// Parametros Construct
    public Cliente(int cedula, String nombre, String direccion, int telefono, String correo_electronico, int tipo,double tamano_jardin) {
        super(cedula,nombre,direccion,telefono,correo_electronico,tipo);
        this.tamano_jardin = tamano_jardin;
    }

    public double getTamano_jardin() {
        return tamano_jardin;
    }

    public void setTamano_jardin(double tamano_jardin) {
        this.tamano_jardin = tamano_jardin;
    }

    public void generarFactura(Factura factura){
        //LLamar factura
    }

    public void agendarCita(Cita cita){
        //Llamar cita
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
                ", tamano_jardin=" + tamano_jardin +
                '}';
    }
}

