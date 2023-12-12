package com.mycompany;

import com.mycompany.Services.CiudadesService;
import com.mycompany.Services.PersonasService;
import com.mycompany.Services.ClientesService;
import com.mycompany.Services.CuentasService;

import com.mycompany.Infraestructure.DbManagment.Ciudades;
import com.mycompany.Infraestructure.DbManagment.Personas;
import com.mycompany.Infraestructure.DbManagment.Clientes;
import com.mycompany.Infraestructure.DbManagment.Cuentas;

import com.mycompany.Infraestructure.Models.CiudadesModels;
import com.mycompany.Infraestructure.Models.PersonasModels;
import com.mycompany.Infraestructure.Models.ClientesModels;
import com.mycompany.Infraestructure.Models.CuentasModels;
import com.mycompany.presentation.ClientesPresentation;
import com.mycompany.presentation.Menu;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    //prueba
    public static void main(String[] args) {
       /* Personas personasconn = new Personas("postgres", "1234", "localhost", "5432", "OptativoII");
        Ciudades ciudadConn = new Ciudades("postgres", "1234", "localhost", "5432", "OptativoII");
        Clientes clientesConn = new Clientes("postgres", "1234", "localhost", "5432", "OptativoII");
        Cuentas cuentasConn = new Cuentas("postgres", "1234", "localhost", "5432", "OptativoII");

        System.out.println("CONECTADO");*/
       //puede partir de aca o directamente del formulario
        //Menu abrir = new Menu();
        //abrir.setVisible (true);
    }
}