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

        clientes.add(new Cliente("11111111X", "Juan", "Pérez",
                "Calle 1", "600000001", "juan@mail.com"));

        clientes.add(new Cliente("22222222Y", "María", "Sanz",
                "Calle 2", "600000002", "maria@mail.com"));

        clientes.add(new Cliente("33333333Z", "Luis", "Gómez",
                "Calle 3", "600000003", "luis@mail.com"));

        clientes.add(new Cliente("44444444A", "Ana", "Martínez",
                "Avenida Central 45", "600000004", "ana@mail.com"));

        clientes.add(new Cliente("55555555B", "Carlos", "Ruíz",
                "Plaza Mayor 10", "600000005", "carlos@mail.com"));
    }


    public static ClienteModel getInstance() {
        if (instance == null) instance = new ClienteModel();
        return instance;
    }

    public void agregar(Cliente c) { clientes.add(c); }
    
    public Cliente buscarPorDni(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null;
    }

    public boolean existeDni(String dni) {
        return buscarPorDni(dni) != null;
    }
    
    public boolean addCliente(Cliente cliente) {
        if (cliente == null || existeDni(cliente.getDni())) {
            return false;
        }
        clientes.add(cliente);
        return true;
    }

    public boolean updateCliente(Cliente cliente) {
        Cliente existente = buscarPorDni(cliente.getDni());
        if (existente != null) {
            existente.setNombre(cliente.getNombre());
            existente.setApellidos(cliente.getApellidos());
            existente.setDireccion(cliente.getDireccion());
            existente.setTelefono(cliente.getTelefono());
            existente.setCorreo(cliente.getCorreo());
            return true;
        }
        return false;
    }
    
    public List<Cliente> getTodos() { return clientes; }
}