/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import pojos.Cliente;

public class ClienteModel {
    private static ClienteModel instance;
    private List<Cliente> clientes;

    private ClienteModel() {
        clientes = new ArrayList<>();
        clientes.add(new Cliente("11111111X", "Juan", "Pérez", "Calle 1", "600000001", "juan@mail.com"));
        clientes.add(new Cliente("22222222Y", "Maria", "Sanz", "Calle 2", "600000002", "maria@mail.com"));
    }

    public static ClienteModel getInstance() {
        if (instance == null) instance = new ClienteModel();
        return instance;
    }

    public void agregar(Cliente c) { clientes.add(c); }
    
    public Cliente buscarPorDni(String dni) {
        return clientes.stream().filter(c -> c.getDni().equals(dni)).findFirst().orElse(null);
    }

    public List<Cliente> getTodos() { return clientes; }
}