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
public class SubstationStatusAccesor {

    private static final String SQL_SELECT_ALL = "select * from SUBSTATIONSTATUS";
    private static final String SQL_INSERT = "insert into SUBSTATIONSTATUS values(?,?,?,?)";
    private static final String SQL_DELETE = "delete from SUBSTATIONSTATUS where ID = ?";
    private static final String SQL_UPDATE = "update SUBSTATIONSTATUS set SUBSTATIONHB = ?, TIMEUPDATED = ?, STATIONID = ? where ID = ?";        
}
