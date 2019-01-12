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
public class FuelPriceAccesor {

    private static final String SQL_SELECT_ALL = "select * from FUELPRICE";
    private static final String SQL_INSERT = "insert into FUELPRICE values(?,?,?,?)";
    private static final String SQL_DELETE = "delete from FUELPRICE where ID = ?";
    private static final String SQL_UPDATE = "update FUELPRICE set STARTDATE = ?, ENDDATE = ?, ENERGYSOURCE = ?  where ID = ?";    
}
