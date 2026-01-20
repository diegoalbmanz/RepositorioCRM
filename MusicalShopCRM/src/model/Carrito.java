/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import pojos.Producto;

public class Carrito {
    private static Carrito instance;
    private List<Producto> productos;
    
    private Carrito() {
        this.productos = new ArrayList<>();
    }
    
    public static Carrito getInstance() {
        if (instance == null) {
            instance = new Carrito();
        }
        return instance;
    }
    
    public void agregarProducto(Producto p) {
        productos.add(p);
    }
    
    public void vaciar() {
        productos.clear();
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
    
    public double getTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }
    
    public int getCantidadItems() {
        return productos.size();
    }
}