/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Consumer;
import entity.ConsumerException;

/**
 *
 * @author StudentAdmin
 */
public class ConsumerAccesor {

    private static final String SQL_SELECT_ALL = "select * from CONSUMER";
    private static final String SQL_INSERT = "insert into CONSUMER values(?,?,?)";
    private static final String SQL_DELETE = "delete from CONSUMER where ID = ?";
    private static final String SQL_UPDATE = "update CONSUMER set CONSUMERTYPE, FEEDER = ? where ID = ?";

    public ConsumerAccesor() {
    }

    public static List<Consumer> findConsumers(String query) {
        List<Consumer> res = new ArrayList<Consumer>();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next() == true) {
                int id = rs.getInt("ID");
                String consumerType = rs.getString("CONSUMERTYPE");
                int feeder = rs.getInt("FEEDER");
                Consumer item = new Consumer(id,consumerType,feeder);
                res.add(item);
            }

        } catch (SQLException e) {
            res = new ArrayList<Consumer>();
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

    public static Consumer findConsumerByID(int id) {
        Consumer res = null;
        List<Consumer> consumers = findConsumers("select * from CONSUMER where ID=" + id);
        if (!consumers.isEmpty()) {
            res = consumers.get(0);
        }
        return res;
    }

    private static boolean consumerExists(Consumer consumer) {
        return findConsumerByID(consumer.getId()) != null;
    }

    public static boolean deleteConsumer(Consumer item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!consumerExists(item)) {
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

    public static boolean insertConsumer(Consumer item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (consumerExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);

            int id = item.getId();
            String consumerType = item.getConsumerType();
            int feeder = item.getFeederId();

            ps.setInt(1, id);
            ps.setString(2, consumerType);
            ps.setInt(3, feeder);

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

    public static boolean updateQuestion(Consumer item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!consumerExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            
            String consumerType = item.getConsumerType();
            int feeder = item.getFeederId();
            int id = item.getId();

            
            ps.setString(1, consumerType);
            ps.setInt(2, feeder);
            ps.setInt(3, id);

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
