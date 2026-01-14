/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author Alumno
 */


public class Empleado {
    private int id; // Agregué ID por si hay empleados con mismo nombre
    private String usuario;
    private String password; // Renombrado de 'cont' para claridad
    private String nombre;
    private double montoVentas;

    public Empleado() {
    }

    public Empleado(int id, String usuario, String password, String nombre, double montoVentas) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.montoVentas = montoVentas;
    }

    // Método para actualizar ventas fácilmente
    public void sumarVenta(double monto) {
        this.montoVentas += monto;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getMontoVentas() { return montoVentas; }
    public void setMontoVentas(double montoVentas) { this.montoVentas = montoVentas; }
}