/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
package Customer;

import Includes.Database;
import java.sql.*;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class BookTicket {

    private static Connection con;
    public static void deleteBooking(String busTurnId, String bookingId)
            throws SQLException, ClassNotFoundException {

        con = Database.getConnected();
        String query = "DELETE FROM " + busTurnId
                + " WHERE booking_number='" + bookingId + "'";
        Database.updateQuery(con, query);
        Database.disconnect(con);
    }
}
