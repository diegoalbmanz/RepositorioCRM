/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import pojos.Empleado;

public class EmpleadoModel {
    private static EmpleadoModel instance;
    private List<Empleado> empleados;

    public EmpleadoModel() {
        empleados = new ArrayList<>();
        // Datos iniciales
        empleados.add(new Empleado(1, "ana",   "1234", "Ana López",        1200));
        empleados.add(new Empleado(2, "juan",  "1234", "Juan Pérez",      1800));
        empleados.add(new Empleado(3, "maria", "1234", "María García",    700));
        empleados.add(new Empleado(4, "carlos","1234", "Carlos Sánchez",  2200));
        empleados.add(new Empleado(5, "laura", "1234", "Laura Martín",    1700));
        empleados.add(new Empleado(6, "pedro", "1234", "Pedro Gómez",     800));
        empleados.add(new Empleado(7, "lucia", "1234", "Lucía Fernández", 1300));
        empleados.add(new Empleado(8, "david", "1234", "David Ruiz",      3000));

    }

    public static EmpleadoModel getInstance() {
        if (instance == null) instance = new EmpleadoModel();
        return instance;
    }

    public Empleado autenticar(String user, String pass) {
        for (Empleado e : empleados) {
            if (e.getUsuario().equals(user) && e.getPassword().equals(pass)) {
                return e; // Retorna el empleado que inició sesión
            }
        }
        return null;
    }

    public List<Empleado> getTodos() { return empleados; }
}
