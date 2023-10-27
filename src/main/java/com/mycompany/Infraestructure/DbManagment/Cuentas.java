/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infraestructure.DbManagment;
import com.mycompany.Infraestructure.Conections.Connections;
import com.mycompany.Infraestructure.Models.CuentasModels;
import java.sql.SQLException;
/**
 *
 * @author solua
 */
public class Cuentas {

    private Connections connection;

    public Cuentas(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        connection = new Connections(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuenta(CuentasModels cuentas){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("INSERT INTO cuentas (idcliente, nrocuenta, fechaalta, tipocuenta, estado)" +
                    "values('" +
                    cuentas.IdCliente+ "', '" +
                    cuentas.NroCuenta + "', '" +
                    cuentas.FechaAlta + "', '" +
                    cuentas.TipoCuenta + "', '" +
                    cuentas.Estado + "')");
            connection.connectionDB().close();
            return "La cuenta Nro: " + cuentas.NroCuenta + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCuenta(CuentasModels cuentas){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("UPDATE cuentas SET " +
                    "idcliente = '" + cuentas.IdCliente + "'," +
                    "nrocuenta = '" + cuentas.NroCuenta + "'," +
                    "fechaalta = '" + cuentas.FechaAlta + "'," +
                    "tipocuenta = '" + cuentas.TipoCuenta + "'," +
                    "estado = '" + cuentas.Estado + "'" +
                    " Where id = " + cuentas.Id);
            connection.connectionDB().close();
            return "Los datos de la cuenta Nro.: " + cuentas.NroCuenta + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CuentasModels consultarCuenta(int id){
        CuentasModels cuentas = new CuentasModels();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from cuentas where id = " + id));
            if(connection.getResultadoQuery().next()){
                cuentas.setIdCliente(connection.getResultadoQuery().getInt("idcliente"));
                cuentas.setNroCuenta(connection.getResultadoQuery().getString("nrocuenta"));
                cuentas.setFechaAlta(connection.getResultadoQuery().getDate("fechaalta"));
                cuentas.setTipoCuenta(connection.getResultadoQuery().getString("tipocuenta"));
                cuentas.setEstadoCuenta(connection.getResultadoQuery().getString("estadocuenta"));
                cuentas.setSaldo(connection.getResultadoQuery().getFloat("saldo"));
                cuentas.setNroContrato(connection.getResultadoQuery().getString("nrocontrato"));
                cuentas.setContacto(connection.getResultadoQuery().getString("contacto"));
                cuentas.setPromedioAcreditacion(connection.getResultadoQuery().getString("promedioacreditacion"));
                cuentas.setCostoMantenimiento(connection.getResultadoQuery().getFloat("costomantenimiento"));
                cuentas.setMoneda(connection.getResultadoQuery().getString("moneda"));
                cuentas.setEstado(connection.getResultadoQuery().getString("estado"));


                return cuentas;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String eliminarCuenta(int id){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("DELETE FROM cuentas" +
                    " Where id = " + id);
            connection.connectionDB().close();
            return "Los datos de la cuenta fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}