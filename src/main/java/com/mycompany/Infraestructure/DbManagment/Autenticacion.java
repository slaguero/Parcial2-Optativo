/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infraestructure.DbManagment;

import com.mycompany.Infraestructure.Conections.Connections;
import com.mycompany.Infraestructure.Models.UsuariosModels;
import java.sql.SQLException;

/**
 *
 * @author solua
 */
public class Autenticacion {
    private  Connections conexion;
    private Personas persona;

    public Autenticacion(String userBD, String passDB, String hostDB, String portDB, String dataBase) {
        this.conexion = new Connections(userBD, passDB, hostDB, portDB, dataBase);
        this.persona = new Personas(userBD, passDB, hostDB, portDB, dataBase);
    }
    public UsuariosModels Autenticar(String usuario){
        
        try {
            UsuariosModels usuariomodelo = new UsuariosModels();
            conexion.setQuerySQL(conexion.connectionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from usuarios  where usuario = '" + usuario +"'" ));
            if(conexion.getResultadoQuery().next()){
                usuariomodelo.setIDUsuario  (conexion.getResultadoQuery().getInt("IDUsuario"));
                usuariomodelo.setContraseña  (conexion.getResultadoQuery().getString("contraseña"));
                usuariomodelo.setPersonas (persona.consultarPersona(conexion.getResultadoQuery().getInt("idpersona")));
                usuariomodelo.setEstado (conexion.getResultadoQuery().getString("estado"));
                
                return usuariomodelo;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
        
    }
    
    public String registrarUsuario(UsuariosModels usuario){

        try {
            conexion.setQuerySQL(conexion.connectionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO usuarios("+
                    
                    "idpersona, " +
                    "usuario, " +
                    "contrasena, " +
                    "estado)"  +
                    "values(" + usuario.getPersonas().getId() +",'" + usuario.getUsuario() + "',' " + usuario.getContraseña() + "','ACTIVO')");
            conexion.connectionDB().close();
            return "La persona " + usuario.getUsuario() + " fue registrada exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     public UsuariosModels editarCiudad(int id){
        UsuariosModels  usuario = new UsuariosModels();
        try {
            conexion.setQuerySQL(conexion.connectionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from ciudades where id_ciudad = " + id));
            if(conexion.getResultadoQuery().next()){
                usuario.setUsuario(conexion.getResultadoQuery().getString("usuario"));
                usuario.setContraseña(conexion.getResultadoQuery().getString("contrasena"));    
                usuario.setIDUsuario(conexion.getResultadoQuery().getInt("idusuario"));
                usuario.setEstado(conexion.getResultadoQuery().getString("estado"));
                return usuario;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
      public String modificarPersona(UsuariosModels ciudad){
        try {
            conexion.setQuerySQL(conexion.connectionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudades "
                    + "SET " + 
                     " estado = '" + ciudad.getEstado()+ "'," +
                    " usuario = '" + ciudad.getUsuario()+ "'," +
                    "contrasena = '" + ciudad.getContraseña()+ "'" +
                    " Where ciudades.id_ciudad = " + ciudad.getID_Usuario());
            conexion.connectionDB().close();
            return "Los datos de la ciudad " + ciudad.getID_Usuario()+ " fue modificado exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}
}
