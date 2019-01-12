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
public class FeederStatusAccesor {
    
    private static final String SQL_SELECT_ALL = "select * from FEEDERSTATUS";
    private static final String SQL_INSERT = "insert into FEEDERSTATUS values(?,?,?,?)";
    private static final String SQL_DELETE = "delete from FEEDERSTATUS where ID = ?";
    private static final String SQL_UPDATE = "update FEEDERSTATUS set FEEDERHB = ?, TIMEUPDATED = ?, FEEDERID = ? where ID = ?";               
    
}
