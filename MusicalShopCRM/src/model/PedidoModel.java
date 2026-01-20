/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import pojos.Pedido;

public class PedidoModel {
    private static PedidoModel instance;
    private List<Pedido> pedidos;
    
    private PedidoModel() {
        pedidos = new ArrayList<>();

        ClienteModel cm = ClienteModel.getInstance();
        ProductoModel pm = ProductoModel.getInstance();

        // ============================
        // PEDIDO 1 — Juan (1 producto)
        // ============================
        pedidos.add(
            new Pedido(
                1,
                List.of(pm.getPorId(1)),                 // Yamaha C2X PE
                cm.buscarPorDni("11111111X"),                // Juan
                EstadoPedido.PENDIENTE,
                LocalDateTime.of(2025, 11, 15, 0, 0),
                pm.getPorId(1).getPrecio()
            )
        );

            // ============================
            // PEDIDO 2 — María (2 productos)
            // ============================
            pedidos.add(
                new Pedido(
                    2,
                    List.of(
                        pm.getPorId(11),                     // Fender Strat HSS
                        pm.getPorId(7)                       // Yamaha YAS‑280S
                    ),
                    cm.buscarPorDni("22222222Y"),                // María
                    EstadoPedido.ENVIADO,
                    LocalDateTime.of(2025, 10, 20, 0, 0),
                    pm.getPorId(11).getPrecio() +
                    pm.getPorId(7).getPrecio()
                )
            );

            // ============================
            // PEDIDO 3 — Carlos (3 productos)
            // ============================
            pedidos.add(
                new Pedido(
                    3,
                    List.of(
                        pm.getPorId(4),                      // Mapex Comet
                        pm.getPorId(9),                      // Sonor AQX
                        pm.getPorId(16)                      // DW DWe E33
                    ),
                    cm.buscarPorDni("55555555B"),                // Carlos
                    EstadoPedido.ENTREGADO,
                    LocalDateTime.of(2025, 9, 5, 0, 0),
                    pm.getPorId(4).getPrecio() +
                    pm.getPorId(9).getPrecio() +
                    pm.getPorId(16).getPrecio()
                )
            );

            // ============================
            // PEDIDO 4 — Ana (2 productos)
            // ============================
            pedidos.add(
                new Pedido(
                    4,
                    List.of(
                        pm.getPorId(3),                      // Buffet Crampon E11
                        pm.getPorId(18)                      // Yamaha V5 SA44
                    ),
                    cm.buscarPorDni("44444444A"),                // Ana
                    EstadoPedido.CANCELADO,
                    LocalDateTime.of(2025, 12, 1, 0, 0),
                    pm.getPorId(3).getPrecio() +
                    pm.getPorId(18).getPrecio()
                )
            );
    }

    public static PedidoModel getInstance() {
        if (instance == null) instance = new PedidoModel();
        return instance;
    }

    public void registrarPedido(Pedido p) {
        pedidos.add(p);
        System.out.println("Pedido registrado ID: " + p.getId());
    }
    
    public List<Pedido> getPedidosPorCliente(String dni) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getCliente() != null &&
                p.getCliente().getDni().equalsIgnoreCase(dni)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<Pedido> getTodos() { return pedidos; }
}