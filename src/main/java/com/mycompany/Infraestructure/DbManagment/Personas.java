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
            boolean execute = connection.getQuerySQL().execute("INSERT INTO persona (id, nombre, apellido, tipodocumento, nrodocumento, direccion, email, celular, estado)" +
                    "values('" +
                    personas.getId() + "', '" +
                    personas.getNombre() + "', '" +
                    personas.getApellido() + "', '" +
                    personas.getTipoDocumento() + "', '" +
                    personas.getNroDocumento() + "', '" +
                    personas.getDireccion() + "', '" +
                    personas.getEmail() + "', '" +
                    personas.getCelular() + "', '" +
                    personas.getEstado() + "')");
            connection.connectionDB().close();
            return "La persona con nombre: " + personas.getNombre()+", y apellido: "+personas.getApellido() + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonasModels personas){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            String execute = connection.getQuerySQL().execute("UPDATE persona SET " +
                    "nombre = '" + personas.getNombre()) + "'," +
                    "apellido = '" + personas.getApellido() + "'," +
                    "tipodocumento = '" + personas.getTipoDocumento() + "'," +
                    "nrodocumento= '" + personas.getNroDocumento() + "'," +
                    "direccion = '" + personas.getDireccion() + "'," +
                    "email = '" + personas.getEmail() + "'," +
                    "celular = '" + personas.getCelular() + "'," +
                    "estado = '" + personas.getEstado() + "' " + " Where id = " + personas.getId();
            connection.connectionDB().close();
            return "Los datos de la persona " + personas.getNombre() +" "+ personas.getApellido() + " fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonasModels consultarPersona(int id){
        PersonasModels personas = new PersonasModels();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from persona where id = " + id));
            if(connection.getResultadoQuery().next()){
                personas.setNombre(connection.getResultadoQuery().getString("nombre"));
                personas.setApellido(connection.getResultadoQuery().getString("apellido"));
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
                personas.setNombre(connection.getResultadoQuery().getString("nombre"));
                personas.setApellido(connection.getResultadoQuery().getString("apellido"));

                return personas;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

