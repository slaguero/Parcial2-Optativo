/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infraestructure.Models;
/**
 *
 * @author solua
 */
public class UsuariosModels {
    private int Id_Usuario;
    private PersonasModels persona;
    private String Usuario;
    private String Contraseña;
    private String Estado;
    
    public int getID_Usuario() {
        return Id_Usuario;
    }

    public void setIDUsuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public PersonasModels getPersonas() {
        return persona;
    }

    public void setPersonas(PersonasModels Personas) {
        this.persona = Personas;
    }


    public String getUsuario() {
        return Usuario;
    }


    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }


    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }


    public String getEstado() {
        return Estado;
    }


    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
    
    
   