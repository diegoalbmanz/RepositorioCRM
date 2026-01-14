/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author Alumno
 */


public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;
    private int stock;
    private String rutaImagen; // Guardamos la ruta (ej: "img/guitarra.png") para no cargar la memoria

    // Constructor vacío
    public Producto() {
    }

    // Constructor completo
    public Producto(int id, String nombre, String categoria, String descripcion, double precio, int stock, String rutaImagen) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.rutaImagen = rutaImagen;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getRutaImagen() { return rutaImagen; }
    public void setRutaImagen(String rutaImagen) { this.rutaImagen = rutaImagen; }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}