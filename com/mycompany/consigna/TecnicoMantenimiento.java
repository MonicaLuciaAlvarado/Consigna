package com.mycompany.consigna;

public class TecnicoMantenimiento extends Usuarios{

    private String especializacion;
    private boolean estado;

    public TecnicoMantenimiento(){
        super();
        this.especializacion="";
        this.estado=false;
    }

    public TecnicoMantenimiento(int cedula, String nombre, String direccion, int telefono, String correo_electronico, int tipo,String especializacion, boolean estado){
        super(cedula,nombre,direccion,telefono,correo_electronico,tipo);
        this.especializacion = especializacion;
        this.estado = estado;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
                ", especializacion=" + especializacion +
                ", estado=" + estado +
                '}';
    }
    

}
