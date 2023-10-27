/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Services;
import com.mycompany.Infraestructure.DbManagment.Clientes;
import com.mycompany.Infraestructure.Models.ClientesModels;
/**
 *
 * @author solua
 */
public class ClientesService {
    
    Clientes clienteDB;
    public ClientesService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new Clientes(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClientesModels Clientes){
        if(validarDatos(Clientes)){
           return clienteDB.registrarCliente(Clientes);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarPersona(ClientesModels Clientes){
        if(validarDatos(Clientes)){
            return clienteDB.modificarCliente(Clientes);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public ClientesModels consultarCliente(int id){
        return clienteDB.consultarCliente(id);
    }

    private boolean validarDatos(ClientesModels Clientes) {
        try {
        if(Clientes.Calificacion.isEmpty()){
            if (Clientes.Calificacion.length() < 3) {
                throw new Exception("El nombre no tiene la longitud necesaria");
            }
        }
        else {
            throw new Exception("El nombre no debe estar vacío");
            }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}