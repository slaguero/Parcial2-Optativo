/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infraestructure.DbManagment;
import com.mycompany.Infraestructure.Conections.Connections;
import com.mycompany.Infraestructure.Models.ClientesModels;
import java.sql.SQLException;
/**
 *
 * @author solua
 */
public class Clientes {
    private Connections connection;

    public Clientes(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        connection = new Connections(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClientesModels clientes){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("INSERT INTO cliente (idpersona, fechaingreso, calificacion, estado)" +
                    "values('" +
                    clientes.IdPersona+ "', '" +
                    clientes.FechaIngreso + "', '" +
                    clientes.Calificacion + "', '" +
                    clientes.Estado + "')");
            connection.connectionDB().close();
            return "El cliente fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCliente(ClientesModels clientes){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("UPDATE cliente SET " +
                    "idpersona = '" + clientes.IdPersona + "'," +
                    "fechaingreso= '" + clientes.FechaIngreso + "'," +
                    "calificacion = '" + clientes.Calificacion + "'," +
                    "estado= '" + clientes.Estado + "' " + " Where id = " + clientes.IdCliente);
            connection.connectionDB().close();
            return "Los datos del cliente fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClientesModels consultarCliente(int id){
        ClientesModels clientes = new ClientesModels();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from cliente where id = " + id));
            if(connection.getResultadoQuery().next()){
                clientes.setIdPersona(connection.getResultadoQuery().getInt("idpersona"));
                clientes.setFechaIngreso(connection.getResultadoQuery().getDate("fechaingreso"));  
                clientes.setCalificacion(connection.getResultadoQuery().getString("calificacion"));
                clientes.setEstado(connection.getResultadoQuery().getString("estado"));


                return clientes;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public String eliminarCliente(int id){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("DELETE FROM cliente" +
                    " Where id = " + id);
            connection.connectionDB().close();
            return "Los datos del cliente fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}