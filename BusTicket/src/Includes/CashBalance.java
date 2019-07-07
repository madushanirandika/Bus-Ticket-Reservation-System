/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
package Includes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class CashBalance {

    private static void initToday(String date) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnected();
        String query = "SELECT * FROM `daily_transactions` WHERE `date`='" + date + "'";
        ResultSet rs = Database.executeQuery(con, query);

        if (!rs.next()) {
            query = "INSERT INTO `daily_transactions` (`date`, `credit`, `debit`,"
                    + " `balance`) VALUES ('" + date + "',0,0,0)";
            Database.updateQuery(con, query);

            query = "CREATE TABLE `" + date + "` "
                    + "(bus_turn_id VARCHAR(50), seat_number INT(2), "
                    + "booking_number VARCHAR(20), booking_cost DECIMAL(10,2), "
                    + "email VARCHAR(100))";
            Database.updateQuery(con, query);
        }
        Database.disconnect(con);
    }

    public static void deleteATicket(int refund,
            String email, String bookedDate, String bookingNumber) {
        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        double refundCost = 0;

        try {
            initToday(today);
            Connection con = Database.getConnected();
            String query = "SELECT * FROM `" + bookedDate + "` WHERE `booking_number`='"
                    + bookingNumber + "' AND `email`='" + email + "'";
            ResultSet rs = Database.executeQuery(con, query);
            rs.next();

            double ticketCost = rs.getDouble(4);
            refundCost = (-1) * ticketCost * refund / 100;

            String busTurnId = rs.getString(1);
            int seat = rs.getInt(2) * -1;
            String bookingId = rs.getString(3);

            query = "INSERT INTO `" + today
                    + "` (`bus_turn_id`, `seat_number`, `booking_number`, `booking_cost`, `email`) "
                    + "VALUES ('"
                    + busTurnId + "',"
                    + seat + ",'R-"
                    + bookingId + "',"
                    + refundCost + ",'"
                    + email + "')";
            Database.updateQuery(con, query);
            printDeleteRisit(bookingNumber, bookedDate, ticketCost, refund, refundCost);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            refundCost *= -1;
            Connection con = Database.getConnected();
            String query = "SELECT * FROM `daily_transactions` WHERE `date`='"
                    + today + "'";
            ResultSet rs = Database.executeQuery(con, query);
            rs.next();
            refundCost += rs.getDouble(3);

            query = "UPDATE `daily_transactions` SET `debit`="
                    + refundCost + " WHERE `date`='" + today + "'";
            Database.updateQuery(con, query);
            balance(today);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void bookATicket(String email, String busTurnId,
            String bookingIdList, String seatList, String costString) {
        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

        try {
            initToday(today);
        } catch (SQLException | ClassNotFoundException ex) {
        }

        String[] bookingIds = bookingIdList.split(" / ");
        String[] seats = seatList.split(" / ");
        double totalCost = Double.parseDouble(costString.substring(4));
        double ticketCost = totalCost / seats.length;

        for (int i = 0; i < seats.length; i++) {
            try {
                Connection con = Database.getConnected();
                String query = "INSERT INTO `" + today
                        + "` (`bus_turn_id`, `seat_number`, `booking_number`, `booking_cost`, `email`) "
                        + "VALUES ('"
                        + busTurnId + "',"
                        + seats[i] + ",'"
                        + bookingIds[i] + "',"
                        + ticketCost + ",'"
                        + email + "')";
                Database.updateQuery(con, query);
                Database.disconnect(con);
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        try {
            Connection con = Database.getConnected();
            String query = "SELECT * FROM `daily_transactions` WHERE `date`='"
                    + today + "'";
            ResultSet rs = Database.executeQuery(con, query);
            rs.next();
            totalCost += rs.getDouble(2);

            query = "UPDATE `daily_transactions` SET `credit`="
                    + totalCost + " WHERE `date`='" + today + "'";
            Database.updateQuery(con, query);
            balance(today);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private static void balance(String date) {
        try {
            Connection con = Database.getConnected();
            String query = "SELECT * FROM daily_transactions WHERE date='" + date + "'";
            ResultSet rs = Database.executeQuery(con, query);
            rs.next();
            double credit = rs.getDouble(2);
            double debit = rs.getDouble(3);
            double balance = credit - debit;

            query = "UPDATE `daily_transactions` SET `balance`="
                    + balance + " WHERE `date`='" + date + "'";
            Database.updateQuery(con, query);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    private static void printDeleteRisit(String bookingNumber, String bookedDate,
            double ticketCost, int refund, double refundCost) {

        String ticketCostString = String.format("%.2f", ticketCost);
        String refundCostString = String.format("%.2f", refundCost);
        String line01 = (" Identification Number  :" + bookingNumber + " ");
        String line02 = (" Booked Date               :" + bookedDate + "");
        String line03 = ("                                       ");
        String line04 = (" Attention !!!");
        String line05 = (" Pay Amount Rs." + ticketCostString);
        String line06 = (" Refund Persantage " + refund + "%");
        String line07 = (" Refund Amount Rs." + refundCostString);
        String line08 = (" You can take your refund from admin");
        String[] bodyLine = {line01, line02, line03, line04, line05,
            line06, line07, line08};

        Includes.CreatePDF.printTicket(bodyLine,
                "C:\\Bus Ticket System\\Booking_deletes\\R-" + bookingNumber);
    }
}
