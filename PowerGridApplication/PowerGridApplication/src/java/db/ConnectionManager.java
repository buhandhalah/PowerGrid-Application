package db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDataSource;

/**
 * Manage connections to the PowerGridDB database.
 *
 * 
 */
public class ConnectionManager {

    private static ClientDataSource dataSource = null;
    private static final String SERVER = "localhost";
    private static final int PORT = 1527;
    private static final String DBNAME = "PowerGridDB";
    private static final String USERNAME = "APP";
    private static final String PASSWORD = "APP";

    // no instantiation allowed - use static methods
    private ConnectionManager() {
    }

    /**
     * Gets a connection to the PowerGridDB database.
     *
     * @return a connection to the database
     * @throws SQLException if the connection fails
     */
    public static Connection getConnection() throws SQLException {
        initDataSource();
        Connection conn = dataSource.getConnection();
        return conn;
    }

    private static void initDataSource() {
        if (isNewSource()) {
            dataSource = new ClientDataSource();
            dataSource.setServerName(SERVER);
            dataSource.setPortNumber(PORT);
            dataSource.setDatabaseName(DBNAME);
            dataSource.setUser(USERNAME);
            dataSource.setPassword(PASSWORD);
        }
    }

    private static boolean isNewSource() {
        return (dataSource == null)
                || (!SERVER.equals(dataSource.getServerName()))
                || (PORT != dataSource.getPortNumber())
                || (!DBNAME.equals(dataSource.getDatabaseName()))
                || (!USERNAME.equals(dataSource.getUser()))
                || (!PASSWORD.equals(dataSource.getPassword()));
    }

} // end class ConnectionManager
