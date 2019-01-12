/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Feeder;
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
public class FeederAccesor {

    private static final String SQL_SELECT_ALL = "select * from FEEDER";
    private static final String SQL_INSERT = "insert into FEEDER values(?,?)";
    private static final String SQL_DELETE = "delete from FEEDER where ID = ?";
    private static final String SQL_UPDATE = "update FEEDER set STATIONID = ? where ID = ?";

    public FeederAccesor() {
    }

    public static List<Feeder> findFeeders(String query) {
        List<Feeder> res = new ArrayList<Feeder>();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next() == true) {
                int id = rs.getInt("ID");
                int stationId = rs.getInt("STATIONID");
                Feeder item = new Feeder(id, stationId);
                res.add(item);
            }

        } catch (SQLException e) {
            res = new ArrayList<Feeder>();
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

    public static Feeder findFeederByID(int id) {
        Feeder res = null;
        List<Feeder> feeders = findFeeders("select * from FEEDER where ID=" + id);
        if (!feeders.isEmpty()) {
            res = feeders.get(0);
        }
        return res;
    }

    private static boolean feederExists(Feeder feeder) {
        return findFeederByID(feeder.getId()) != null;
    }

    public static boolean deleteFeeder(Feeder item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!feederExists(item)) {
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

    public static boolean insertFeeder(Feeder item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (feederExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);

            int id = item.getId();
            int stationId = item.getStationId();

            ps.setInt(1, id);
            ps.setInt(2, stationId);

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

    public static boolean updateFeeder(Feeder item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!feederExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);

            int stationId = item.getStationId();
            int id = item.getId();

            ps.setInt(1, stationId);
            ps.setInt(2, id);

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
