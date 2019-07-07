package Includes;

/*
**Insert new data into a table
$query_variable = "INSERT INTO table_name (col1, col2, col3, etc.)
        values (val1, val2, val3, etc.)";

**Create a new table
$query_variable = "CREATE TABLE table_name (field_name DATATYPE(SIZE)...);"

**Delete a table
$query_variable = "DROP TABLE table_name";

**Read data from a table
$query_variable = "SELECT * FROM booking_data WHERE email=ghjs"
*/


import java.sql.*;

public class Database {

// init database constants
    private static final String DATABASE_DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/busticketreservationsystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

// Connect database
    public static Connection getConnected() throws SQLException, ClassNotFoundException {
        Connection con;
        Class.forName(DATABASE_DRIVER);
        con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return con;
    }

// Read from databse
    public static ResultSet executeQuery(Connection con, String query) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }

// Update  a table
    public static int updateQuery(Connection con, String query) throws SQLException{
        Statement st = con.createStatement();
        int x = st.executeUpdate(query);
        return x;
    }
    
// Disconnect databse
    public static void disconnect(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
