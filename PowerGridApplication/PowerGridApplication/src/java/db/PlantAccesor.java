/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Plant;
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
public class PlantAccesor {

    private static final String SQL_SELECT_ALL = "select * from PLANT";
    private static final String SQL_INSERT = "insert into PLANT values(?,?,?,?)";
    private static final String SQL_DELETE = "delete from PLANT where ID = ?";
    private static final String SQL_UPDATE = "update PLANT set ENERGYSOURCE = ?, FUELLEVEL = ?, MAXCAPACITY = ?, LONGITUDE = ?, LATITUDE = ? where ID = ?";

    public PlantAccesor() {
    }

    public static List<Plant> findSubstations(String query) {
        List<Plant> res = new ArrayList<Plant>();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next() == true) {
                int id = rs.getInt("ID");
                int energySource = rs.getInt("ENERGYSOURCE");
                double fuelLevel = rs.getDouble("FUELLEVEL");
                double maxCapacity = rs.getDouble("MAXCAPACITY");
                String longitude = rs.getString("LONGITUDE");
                String latitude = rs.getString("LATITUDE");

                Plant item = new Plant(id, energySource, fuelLevel, maxCapacity, longitude, latitude);
                res.add(item);
            }

        } catch (SQLException e) {
            res = new ArrayList<Plant>();
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

    public static Plant findPlantByID(int id) {
        Plant res = null;
        List<Plant> plant = findSubstations("select * from Plant where ID=" + id);
        if (!plant.isEmpty()) {
            res = plant.get(0);
        }
        return res;
    }

    private static boolean plantExists(Plant plant) {
        return findPlantByID(plant.getId()) != null;
    }

    public static boolean deletePlant(Plant item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!plantExists(item)) {
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

    public static boolean insertPlant(Plant item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (plantExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);

            int id = item.getId();
            int energySource = item.getEnergySource();
            double fuelLevel = item.getFuelLevel();
            double maxCapacity = item.getMaxCapacity();
            String longitude = item.getLongitude();
            String latitude = item.getLatitude();

            ps.setInt(1, id);
            ps.setInt(2, energySource);
            ps.setDouble(3, fuelLevel);
            ps.setDouble(4, maxCapacity);
            ps.setString(5, longitude);
            ps.setString(5, latitude);

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

    public static boolean updatePlant(Plant item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!plantExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);

            int energySource = item.getEnergySource();
            double fuelLevel = item.getFuelLevel();
            double maxCapacity = item.getMaxCapacity();
            String longitude = item.getLongitude();
            String latitude = item.getLatitude();
            int id = item.getId();

            ps.setInt(1, energySource);
            ps.setDouble(2, fuelLevel);
            ps.setDouble(3, maxCapacity);
            ps.setString(4, longitude);
            ps.setString(5, latitude);
            ps.setInt(6, id);

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
