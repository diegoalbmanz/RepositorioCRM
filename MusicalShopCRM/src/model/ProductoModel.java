/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import pojos.Producto;

public class ProductoModel {
    private static ProductoModel instance;
    private List<Producto> productos;

    private ProductoModel() {
        productos = new ArrayList<>();
        productos.add(new Producto(1, "Guitarra Fender", "Cuerda", "Stratocaster", 1200.0, 5, ""));
        productos.add(new Producto(2, "Batería Pearl", "Percusión", "Export", 850.0, 3, ""));
    }

    public static ProductoModel getInstance() {
        if (instance == null) instance = new ProductoModel();
        return instance;
    }

    public void actualizarStock(int id, int cantidad) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                p.setStock(p.getStock() - cantidad);
                break;
            }
        }
    }

    public List<Producto> getTodos() { return productos; }
}