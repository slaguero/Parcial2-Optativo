/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infraestructure.DbManagment;

import com.mycompany.Infraestructure.Conections.Connections;
import com.mycompany.Infraestructure.Models.CiudadesModels;
import com.mycompany.Infraestructure.Models.PersonasModels;
import java.sql.SQLException;
/**
 *
 * @author solua
 */
public class Ciudades {
    private Connections connection;

    public Ciudades(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        connection = new Connections(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadesModels ciudades){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("INSERT INTO ciudad (ciudad,departamento,postal)" +
                    "values('" +
                    ciudades.nombreCiudad+ "', '" +
                    ciudades.Departamento + "', '" +
                    ciudades.Postal + "')");
            connection.connectionDB().close();
            return "La ciudad " + ciudades.nombreCiudad + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCiudad(CiudadesModels ciudades){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("UPDATE ciudad SET " +
                    "ciudad = '" + ciudades.nombreCiudad + "'," +
                    "departamento = '" + ciudades.Departamento + "'," +
                    "postal = '" + ciudades.Postal + "' " + " Where id = " + ciudades.Id);
            connection.connectionDB().close();
            return "Los datos de la ciudad " + ciudades.nombreCiudad + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CiudadesModels consultarCiudad(int id){
                CiudadesModels ciudades = new CiudadesModels();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from ciudad where id = " + ciudades.Id));
            if(connection.getResultadoQuery().next()){
                ciudades.setCiudad( connection.getResultadoQuery().getString("ciudad"));
                ciudades.setDepartamento(connection.getResultadoQuery().getString("departamento"));
                ciudades.setPostal(connection.getResultadoQuery().getString("postal"));
                
                return ciudades;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public String eliminarCiudad(int id){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("DELETE FROM ciudad" +
                    " Where id = " + id);
            connection.connectionDB().close();
            return "Los datos de la ciudad fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}