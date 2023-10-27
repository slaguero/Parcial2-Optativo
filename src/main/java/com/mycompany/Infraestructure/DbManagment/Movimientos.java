/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infraestructure.DbManagment;

import com.mycompany.Infraestructure.Conections.Connections;
import com.mycompany.Infraestructure.Models.MovimientosModels;
import java.sql.SQLException;
/**
 *
 * @author solua
 */
public class Movimientos {
    

    private Connections connection;

    public Movimientos (String userBD, String passDB, String hostDB, String portDB, String dataBase){
        connection = new Connections(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimiento(MovimientosModels movimientos){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("INSERT INTO movimientos (idcuenta, fechamovimiento, tipomovimiento, saldoanterior, saldoactual, montomovimiento, cuentaorigen, cuentadestino, canal)" +
                    "values('" +
                    movimientos.IdCuenta+ "', '" +
                    movimientos.FechaMovimiento + "', '" +
                    movimientos.TipoMovimiento + "', '" +
                    movimientos.SaldoAnterior + "', '" +
                    movimientos.SaldoActual+ "', '" +
                    movimientos.MontoMovimiento + "', '" +
                    movimientos.CuentaOrigen+ "', '" +
                    movimientos.CuentaDestino + "', '" +
                    movimientos.Canal + "')");
            connection.connectionDB().close();
            return "El registro de movimiento fue insertado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarMovimiento(MovimientosModels movimientos, int id){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("UPDATE movimientos SET " +
                    "idcuenta= '" + movimientos.IdCuenta + "'," +
                    "fechamovimiento = '" + movimientos.FechaMovimiento + "'," +
                    "tipomovimiento= '" + movimientos.TipoMovimiento + "'," +
                    "saldoanterior= '" + movimientos.SaldoAnterior + "'," +
                    "saldoactual = '" + movimientos.SaldoActual + "'," +
                    "montomovimiento = '" + movimientos.MontoMovimiento + "'," +
                    "cuentaorigen = '" + movimientos.CuentaOrigen + "'," +
                    "cuentadestino= '" + movimientos.CuentaDestino + "'," +
                    "canal = '" + movimientos.Canal + "' " + " Where id = " + id);
            connection.connectionDB().close();
            return "Los datos del movimiento fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MovimientosModels consultarMovimiento(int id){
        MovimientosModels movimientos = new MovimientosModels();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from movimiento where id = " + id));
            if(connection.getResultadoQuery().next()){
                movimientos.IdCuenta = connection.getResultadoQuery().getInt("idcuenta");
                movimientos.MontoMovimiento = connection.getResultadoQuery().getInt("montomovimiento");


                return movimientos;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}