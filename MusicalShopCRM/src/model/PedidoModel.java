/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import pojos.Pedido;

public class PedidoModel {
    private static PedidoModel instance;
    private List<Pedido> pedidos;

    private PedidoModel() {
        pedidos = new ArrayList<>();
    }

    public static PedidoModel getInstance() {
        if (instance == null) instance = new PedidoModel();
        return instance;
    }

    public void registrarPedido(Pedido p) {
        pedidos.add(p);
        System.out.println("Pedido registrado ID: " + p.getId());
    }

    public List<Pedido> getTodos() { return pedidos; }
}