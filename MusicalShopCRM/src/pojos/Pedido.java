/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.EstadoPedido;

/**
 *
 * @author Alumno
 */

public class Pedido {
    private int id;
    private List<Producto> productos; // Mejor que Array []
    private Cliente cliente;
    private EstadoPedido estado;
    private LocalDateTime fecha;
    private double precioTotal;

    public Pedido() {
        this.productos = new ArrayList<>();
        this.fecha = LocalDateTime.now(); // Fecha actual por defecto
        this.estado = EstadoPedido.PENDIENTE;
    }

    public Pedido(int id, Cliente cliente) {
        this(); // Llama al constructor vacío para inicializar lista y fecha
        this.id = id;
        this.cliente = cliente;
    }
    
    //Constructor completo
    public Pedido(int id, List<Producto> productos, Cliente cliente, EstadoPedido estado, LocalDateTime fecha,double precioTotal) {
        this.id = id;
        this.productos = productos;
        this.cliente = cliente;
        this.estado = estado;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
    }


    // Método para agregar producto y recalcular total automáticamente
    public void agregarProducto(Producto p) {
        this.productos.add(p);
        this.precioTotal += p.getPrecio();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido estado) { this.estado = estado; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }
}