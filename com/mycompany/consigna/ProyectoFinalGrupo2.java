package com.mycompany.consigna;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProyectoFinalGrupo2 {

    public static void main(String[] args) {

        // Creamos administrador base
        // 1= Administrador, 2= Cliente, 3= Técnico Mantenimiento

        // Administrador Base

        Administrador administrador1 = new Administrador(114870018, "Esteban Rojas", "San Pedro", 61794458,
                "e.rojas@gmail.com", 1);

        // Creamos en el inventario dos tipos de plantas

        ArrayList<Plantas> ListaPlantas = new ArrayList<>();

        Plantas zacate = new Plantas(1, "zacate", "local", 2000.f, 50, "zacate de excelente calidad");
        Plantas rosa = new Plantas(2, "rosa", "europeas", 3500.f, 90, "la flor del amor");
        Plantas suculenta = new Plantas(3, "suculenta", "silvestre", 500.f, 300, "crecen donde sea");
        Plantas tulipan = new Plantas(4, "tulipan", "importadas", 5000.f, 20, "nadie puede pagarlas");

        ListaPlantas.add(zacate);
        ListaPlantas.add(rosa);
        ListaPlantas.add(suculenta);
        ListaPlantas.add(tulipan);

        // Creamos en el inventario dos tipos de servicios

        ArrayList<Servicios> ListaServicios = new ArrayList<>();

        Servicios recorteZacate1 = new Servicios(1, "recorte de zacate 1", "recorte de zacate premium", 10000.f, 4,
                "no disponible");
        Servicios plantacionrosas = new Servicios(2, "rosal nuevo", "plantacion de rosas jovenes", 50000.f, 5,
                "disponible");
        Servicios recorteZacate2 = new Servicios(3, "recorte de zacate 2", "recorte de zacate basico", 5000.f, 1,
                "disponible");

        ListaServicios.add(recorteZacate2);
        ListaServicios.add(recorteZacate1);
        ListaServicios.add(plantacionrosas);

        Usuarios usuario1 = new Usuarios();

        if (administrador1.getTipo() == 1) {
            usuario1.setCedula(402230527);
            usuario1.setNombre("Mónica Alvarado");
            usuario1.setDireccion("San Pedro");
            usuario1.setTelefono(78993210);
            usuario1.setCorreo_electronico("m.alvarado@gmail.com");
            usuario1.setTipo(2);
        } else {
            System.out.println("No puede crear el usuario");
        }

        int cedCliente;
        try {
            cedCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cédula del cliente:"));
            if (cedCliente == usuario1.getCedula()) {
                JOptionPane.showMessageDialog(null, "Bienvenid@ " + usuario1.getNombre());
                // Usuario genera una factura
                // Solicitar la descripción de la factura
                String desc = JOptionPane.showInputDialog(null, "Ingrese la descripción de la factura:");
                if (desc == null || desc.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ingresó ninguna descripción. Saliendo...");
                    return;
                }
                // Solicitar el tamaño del jardín
                double tamanioJardin;
                try {
                    tamanioJardin = Double.parseDouble(
                            JOptionPane.showInputDialog(null, "Ingrese el tamaño del jardín en metros cuadrados:"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El tamaño del jardín ingresado no es válido. Saliendo...");
                    return;
                }

                Factura factura = new Factura(usuario1.getCedula(), desc, tamanioJardin);

                String[] inventario = {
                        "Margaritas",
                        "Aloe",
                        "Hatchback",
                        "Helechos",
                        "Trepadoras",
                        "Bromelias",
                        "Drácena",
                        "Tronco de Brasil"
                };

                for (int i = 0; i <= 2; i++) {
                    String seleccion = (String) JOptionPane.showInputDialog(
                            null,
                            "Selecciona una planta:",
                            "Inventario de Plantas",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            inventario,
                            inventario[0] // opción predeterminada
                    );

                    int cantidad = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de plantas"));
                    if (seleccion == "Margaritas") {
                        factura.setConjunto_plantas_adicionales(
                                new ConjuntoPlantasAdicionales(cantidad, PlantasAdicionales.MARGARITAS));
                    } else if (seleccion == "Aloe") {
                        factura.setConjunto_plantas_adicionales(
                                new ConjuntoPlantasAdicionales(cantidad, PlantasAdicionales.ALOE));
                    } else if (seleccion == "Hatchback") {
                        factura.setConjunto_plantas_adicionales(
                                new ConjuntoPlantasAdicionales(cantidad, PlantasAdicionales.PALMERAS));
                    } else if (seleccion == "Helechos") {
                        factura.setConjunto_plantas_adicionales(
                                new ConjuntoPlantasAdicionales(cantidad, PlantasAdicionales.HELECHOS));
                    } else if (seleccion == "Trepadoras") {
                        factura.setConjunto_plantas_adicionales(
                                new ConjuntoPlantasAdicionales(cantidad, PlantasAdicionales.TREPADORAS));
                    } else if (seleccion == "Bromelias") {
                        factura.setConjunto_plantas_adicionales(
                                new ConjuntoPlantasAdicionales(cantidad, PlantasAdicionales.BROMELIAS));
                    } else if (seleccion == "Drácena") {
                        factura.setConjunto_plantas_adicionales(
                                new ConjuntoPlantasAdicionales(cantidad, PlantasAdicionales.DRACENA));
                    } else {
                        factura.setConjunto_plantas_adicionales(
                                new ConjuntoPlantasAdicionales(cantidad, PlantasAdicionales.TRONCOBRASIL));
                    }
                }
                // Generar el detalle de la factura
                String detalleFactura = factura.generar_detalle();

                // Mostrar la factura en un cuadro de diálogo
                JOptionPane.showMessageDialog(null, detalleFactura, "Factura", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "No tiene acceso. Saliendo...");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID ingresado no es válido. Saliendo...");
            return;
        }
    }
}
