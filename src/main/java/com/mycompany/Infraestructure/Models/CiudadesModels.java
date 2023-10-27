/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infraestructure.Models;

/**
 *
 * @author solua
 */
public class CiudadesModels {
    public int Id;
    public String nombreCiudad;
    public String Departamento;
    public String Postal;
    
    public String getCiudad() {
        return nombreCiudad;
    }

    public void setCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
    public String getPostal() {
        return Postal;
    }

    public void setPostal(String Postal) {
        this.Postal = Postal;
    }


    
}