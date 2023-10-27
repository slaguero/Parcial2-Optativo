/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infraestructure.DbManagment;
import com.mycompany.Infraestructure.Conections.Connections;
import com.mycompany.Infraestructure.Models.PersonasModels;
import java.sql.SQLException;
/*
 *
 * @author solua
 */


public class Personas {
    private Connections connection;

    public Personas (String userBD, String passDB, String hostDB, String portDB, String dataBase){
        connection = new Connections(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonasModels personas){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("INSERT INTO persona (idpersona, nombre, apellido, tipodocumento, nrodocumento, direccion, email, celular, estado)" +
                    "values('" +
                    personas.IdCiudad + "', '" +
                    personas.Nombre + "', '" +
                    personas.Apellido + "', '" +
                    personas.TipoDocumento + "', '" +
                    personas.NroDocumento + "', '" +
                    personas.Direccion + "', '" +
                    personas.Email + "', '" +
                    personas.Celular + "', '" +
                    personas.Estado + "')");
            connection.connectionDB().close();
            return "La persona con nombre: " + personas.Nombre+", y apellido: "+personas.Apellido + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonasModels personas){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("UPDATE persona SET " +
                    "nombre = '" + personas.Nombre + "'," +
                    "apellido = '" + personas.Apellido + "'," +
                    "tipodocumento = '" + personas.TipoDocumento + "'," +
                    "nrodocumento= '" + personas.NroDocumento + "'," +
                    "direccion = '" + personas.Direccion + "'," +
                    "email = '" + personas.Email + "'," +
                    "celular = '" + personas.Celular + "'," +
                    "estado = '" + personas.Estado + "' " + " Where id = " + personas.Id);
            connection.connectionDB().close();
            return "Los datos de la persona " + personas.Nombre +" "+ personas.Apellido + " fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonasModels consultarPersona(int id){
        PersonasModels personas = new PersonasModels();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from persona where id = " + personas.Id));
            if(connection.getResultadoQuery().next()){
                personas.Nombre = connection.getResultadoQuery().getString("nombre");
                personas.Apellido = connection.getResultadoQuery().getString("apellido");


                return personas;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
     public PersonasModels consultarPersonaPorDocumento(int documento){
        PersonasModels personas = new PersonasModels();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from persona where nrodocumento = " + documento));
            if(connection.getResultadoQuery().next()){
                personas.Nombre = connection.getResultadoQuery().getString("nombre");
                personas.Apellido = connection.getResultadoQuery().getString("apellido");


                return personas;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

