/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Substation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author StudentAdmin
 */
public class SubstationAccesor {

    private static final String SQL_SELECT_ALL = "select * from SUBSTATION";
    private static final String SQL_INSERT = "insert into SUBSTATION values(?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from SUBSTATION where ID = ?";
    private static final String SQL_UPDATE = "update SUBSTATION set MAXLOAD = ?, LATITUDE = ?, LONGITUDE = ?, PLANT = ? where ID = ?";          

    public SubstationAccesor() {
    }
    
    public static List<Substation> findSubstations(String query) {
        List<Substation> res = new ArrayList<Substation>();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next() == true) {
                int id = rs.getInt("ID");
                double maxLoad = rs.getInt("MAXLOAD");
                String latitude = rs.getString("LATITUDE");
                String longitude = rs.getString("LONGITUDE");
                int plant = rs.getInt("PLANT");
                Substation item = new Substation(id, maxLoad,latitude,longitude,plant);
                res.add(item);
            }

        } catch (SQLException e) {
            res = new ArrayList<Substation>();
            System.err.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Could not close resources!\n" + ex);
            }

        }
        return res;
    } // end find

    public static Substation findSubstationByID(int id) {
        Substation res = null;
        List<Substation> substation = findSubstations("select * from Substation where ID=" + id);
        if (!substation.isEmpty()) {
            res = substation.get(0);
        }
        return res;
    }

    private static boolean substationExists(Substation substation) {
        return findSubstationByID(substation.getId()) != null;
    }

    public static boolean deleteSubstation(Substation item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!substationExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getId());

            ps.execute();
            res = true;
        } catch (SQLException e) {
            res = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Could not close resources!\n" + ex);
            }

        }
        return res;
    }

    public static boolean insertSubstation(Substation item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (substationExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);

            int id = item.getId();
            double maxLoad = item.getMaxLoad();
            String latitude = item.getLatitude();
            String longitude = item.getLongitude();
            int plant = item.getPlant();

            ps.setInt(1, id);
            ps.setDouble(2, maxLoad);
            ps.setString(3, latitude);
            ps.setString(4, longitude);
            ps.setInt(5, plant);

            ps.execute();
            res = true;
        } catch (SQLException e) {
            res = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Could not close resources!\n" + ex);
            }

        }
        return res;
    } // end insert  

    public static boolean updateSubstation(Substation item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!substationExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);

            double maxLoad = item.getMaxLoad();
            String latitude = item.getLatitude();
            String longitude = item.getLongitude();
            int plant = item.getPlant();
            int id = item.getId();

            ps.setDouble(1, maxLoad);
            ps.setString(2, latitude);
            ps.setString(3, longitude);
            ps.setInt(4, plant);
            ps.setInt(5, id);

            ps.execute();
            res = true;
        } catch (SQLException e) {
            res = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Could not close resources!\n" + ex);
            }

        }
        return res;
    } // end update
}
