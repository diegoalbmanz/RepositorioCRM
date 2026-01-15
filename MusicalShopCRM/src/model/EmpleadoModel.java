/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import pojos.Empleado;

/**
 * Clase que gestiona los empleados del sistema.
 * Actúa como "capa de datos" para el CRM.
 */
public class EmpleadoModel {

    // Lista de empleados (simula una base de datos)
    private final ArrayList<Empleado> empleados;

    // Constructor: inicializa la lista con datos de ejemplo
    public EmpleadoModel() {
        empleados = new ArrayList<>();

        empleados.add(new Empleado(1, "juan", "1234", "Juan Pérez", 1500.0));
        empleados.add(new Empleado(2, "ana", "1234", "Ana López", 2300.0));
        empleados.add(new Empleado(3, "mario", "1234", "Mario Ruiz", 900.0));
        empleados.add(new Empleado(4, "laura", "1234", "Laura Gómez", 1800.0));
        empleados.add(new Empleado(5, "carlos", "1234", "Carlos Sánchez", 2100.0));
        empleados.add(new Empleado(6, "sofia", "1234", "Sofía Martín", 1200.0));
        empleados.add(new Empleado(7, "diego", "1234", "Diego Torres", 3000.0));
        empleados.add(new Empleado(8, "lucia", "1234", "Lucía Fernández", 2700.0));
    }

    /**
     * Busca un empleado por usuario y contraseña.
     */
    public Empleado buscarEmpleado(String usuario, String password) {
        for (Empleado e : empleados) {
            if (e.getUsuario().equalsIgnoreCase(usuario) &&
                e.getPassword().equals(password)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Devuelve todos los empleados.
     */
    public ArrayList<Empleado> getTodos() {
        return empleados;
    }
}

