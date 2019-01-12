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
public class PlantStatusAccesor {

    private static final String SQL_SELECT_ALL = "select * from PLANTSTATUS";
    private static final String SQL_INSERT = "insert into PLANTSTATUS values(?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from PLANTSTATUS where ID = ?";
    private static final String SQL_UPDATE = "update PLANTSTATUS set PLANTHB = ?, POWERPRODUCED = ?, TIMEUPDATED = ?, PLANTID = ? where ID = ?";       

    public PlantStatusAccesor() {
    }

    



}
