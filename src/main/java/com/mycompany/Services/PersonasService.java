package com.mycompany.Services;

import com.mycompany.Infraestructure.DbManagment.Personas;
import com.mycompany.Infraestructure.Models.PersonasModels;
/**
 *
 * @author solua
 */
public class PersonasService {

    Personas personasDB;
    public PersonasService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personasDB = new Personas(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonasModels persona){
        if(validarDatos(persona)){
           return personasDB.registrarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarPersona(PersonasModels persona){
        if(validarDatos(persona)){
            return personasDB.modificarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public PersonasModels consultarPersonaPorId(int id){
        return  personasDB.consultarPersona(id);
    }
    
    public PersonasModels consultarPersonaPorDocumento(int documento){
        return  personasDB.consultarPersonaPorDocumento(documento);
    }

    private boolean validarDatos(PersonasModels persona) {
        try {
        if(persona.getNombre().trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (persona.getNombre().trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }

}