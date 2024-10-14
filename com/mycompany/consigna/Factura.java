
package com.mycompany.consigna;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    // Atributos
    private int folio;
    private int id_cliente;
    private Date fecha_emision;
    private String servicios_prestados;
    private double tamano_jardin;
    private ConjuntoPlantasAdicionales[] conjunto_plantas_adicionales;
    private double costo_base;
    private double costo_total;
    private boolean cancelada;
    public static final int MAX_ITEMS = 12;
    private int indice_plantas_adicionales;

    private static int ultimoFolio;

    // Constructores

    public Factura() {
        this.folio = ++ultimoFolio;
        this.id_cliente = 0;
        this.fecha_emision = new Date();
        this.servicios_prestados = "";
        this.tamano_jardin = 0.0;
        this.conjunto_plantas_adicionales = new ConjuntoPlantasAdicionales[MAX_ITEMS];
        this.costo_base = 0.0f;
        this.costo_total = 0.0f;
        this.cancelada = false;
    }

    public Factura(int id_cliente, String servicios_prestados, double tamano_jardin) {
        this();
        this.id_cliente = id_cliente;
        this.servicios_prestados = servicios_prestados;
        this.tamano_jardin = tamano_jardin;
    }

    /**
     * @return the id_cliente
     */
    public int getFolio() {
        return folio;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the fecha_emision
     */
    public Date getFecha_emision() {
        return fecha_emision;
    }

    /**
     * @param fecha_emision the fecha_emision to set
     */
    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    /**
     * @return the servicios_prestados
     */
    public String getServicios_prestados() {
        return servicios_prestados;
    }

    /**
     * @param servicios_prestados the servicios_prestados to set
     */
    public void setServicios_prestados(String servicios_prestados) {
        this.servicios_prestados = servicios_prestados;
    }

    /**
     * @return the tamano_jardin
     */
    public double getTamano_jardin() {
        return tamano_jardin;
    }

    /**
     * @param tamano_jardin the tamano_jardin to set
     */
    public void setTamano_jardin(double tamano_jardin) {
        this.tamano_jardin = tamano_jardin;
    }

    /**
     * @return the costo_base
     */
    public double getCosto_base() {
        return costo_base;
    }

    /**
     * @param costo_base the costo_base to set
     */
    public void setCosto_base(double costo_base) {
        this.costo_base = costo_base;
    }

    /**
     * @return the costo_total
     */
    public double getCosto_total() {
        return costo_total;
    }

    /**
     * @param costo_total the costo_total to set
     */
    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }

    /**
     * @return the cancelada
     */
    public boolean isCancelada() {
        return cancelada;
    }

    /**
     * @param cancelada the cancelada to set
     */
    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    /**
     * @return the conjunto_plantas_adicionales
     */
    public ConjuntoPlantasAdicionales[] getConjunto_plantas_adicionales() {
        return conjunto_plantas_adicionales;
    }

    public void setConjunto_plantas_adicionales(ConjuntoPlantasAdicionales item) {
        if (indice_plantas_adicionales < MAX_ITEMS) {
            this.conjunto_plantas_adicionales[indice_plantas_adicionales++] = item;
        }
    }

    public double calcular_precio_base() {
        double precio_base = 0.0f;
        if (this.tamano_jardin <= 20) {
            precio_base = 20000;
        } else if (this.tamano_jardin <= 30) {
            precio_base = 30000;
        } else {
            precio_base = 47000;
        }
        return precio_base;
    }

    public double calcular_costo_total() {
        double total = 0.0f;
        if (this.tamano_jardin <= 20) {
            total = 20000;
        } else if (this.tamano_jardin <= 30) {
            total = 30000;
        } else {
            total = 47000;
        }
        for (ConjuntoPlantasAdicionales item : this.conjunto_plantas_adicionales) {
            if (item == null) {
                continue;
            }
            total += item.calcular_precio_rubro();
        }

        return total;
    }

    public String generar_detalle() {
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(id_cliente)
                .append("\t Descripción: ")
                .append(servicios_prestados)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM,yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha_emision))
                .append("\n")
                .append("\n#\tÍtem\tcantidad\t$\tTotal\n");

        sb.append("1\tCosto base para un jardín de ")
                .append(tamano_jardin)
                .append("m2\t1\t")
                .append(calcular_precio_base())
                .append("\t")
                .append(calcular_precio_base())
                .append("\n");
        int contador = 2;
        for (ConjuntoPlantasAdicionales item : conjunto_plantas_adicionales) {
            if (item == null) {
                continue;
            }
            sb.append(contador)
                    .append("\t")
                    .append(item.getPlantas_adicionales().getNombre())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.getPlantas_adicionales().getCosto())
                    .append("\t")
                    .append(item.calcular_precio_rubro())
                    .append("\n");
            contador++;
        }
        sb.append("\nGran Total: ")
                .append(calcular_costo_total());

        return sb.toString();
    }

}
