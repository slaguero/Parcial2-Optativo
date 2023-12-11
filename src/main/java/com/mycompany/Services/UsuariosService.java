/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Services;

import com.mycompany.Infraestructure.DbManagment.Autenticacion;
import com.mycompany.Infraestructure.Models.UsuariosModels;

/**
 *
 * @author Toby
 */
public class UsuariosService {
        
    private Autenticacion  usuariosDB;
    public UsuariosService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        usuariosDB = new Autenticacion(userBD, passDB, hostDB, portDB, dataBase);
    }
    
    public UsuariosModels autenticar(String usuario){
        return usuariosDB.Autenticar(usuario);
    }

    public void registrarUsuario(UsuariosModels usuario){
        usuariosDB.registrarUsuario(usuario);
    }
    public void actualizarUsuario(UsuariosModels usuario){
        
        usuariosDB.modificarPersona(usuario);
    }
}
    

