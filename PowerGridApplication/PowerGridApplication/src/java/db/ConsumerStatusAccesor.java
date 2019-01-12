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
public class ConsumerStatusAccesor {

    private static final String SQL_SELECT_ALL = "select * from CONSUMERSTATUS";
    private static final String SQL_INSERT = "insert into CONSUMERSTATUS values(?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from CONSUMERSTATUS where ID = ?";
    private static final String SQL_UPDATE = "update CONSUMERSTATUS set CONSUMERHB = ?, POWERCONSUMED = ?, TIMEUPDATED = ?, CONSUMERID = ?  where ID = ?";    
}
