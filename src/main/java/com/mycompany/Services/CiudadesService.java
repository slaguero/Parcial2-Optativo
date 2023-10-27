/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Services;
import com.mycompany.Infraestructure.DbManagment.Ciudades;
import com.mycompany.Infraestructure.Models.CiudadesModels;

/**
 *
 * @author solua
 */
public class CiudadesService {
    
    Ciudades ciudadDB;
    public CiudadesService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        ciudadDB = new Ciudades(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadesModels Ciudades){
        if(validarDatos(Ciudades)){
           return ciudadDB.registrarCiudad(Ciudades);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCiudad(CiudadesModels Ciudades){
        if(validarDatos(Ciudades)){
            return ciudadDB.modificarCiudad(Ciudades);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public CiudadesModels consultarCiudad(int id){
        return ciudadDB.consultarCiudad(id);
    }

    private boolean validarDatos(CiudadesModels Ciudades) {
        try {
        if(Ciudades.nombreCiudad.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (Ciudades.nombreCiudad.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}