/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author StudentAdmin
 */
public class EnergySourceAccesor {

    private static final String SQL_SELECT_ALL = "select * from ENERGYSOURCE";
    private static final String SQL_INSERT = "insert into ENERGYSOURCE values(?,?,?)";
    private static final String SQL_DELETE = "delete from ENERGYSOURCE where ID = ?";
    private static final String SQL_UPDATE = "update ENERGYSOURCE set ENERGYSOURCE = ?, COSTPERWATT = ? where ID = ?";
}
