/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
package Includes;

import java.sql.*;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class Sugessions {

    private static Connection con;
    private static ResultSet rs1, rs2, rs3, rs4, rs5;

    public static String startEnd(String userText) throws SQLException, ClassNotFoundException {
        String query, haltList = "";

        con = Database.getConnected();
        query = "SELECT * FROM bus_turns";
        rs1 = Database.executeQuery(con, query);
        int count;
        for (count = 0; rs1.next(); count++) {
        }

        String[] routs = new String[count];
        rs1 = Database.executeQuery(con, query);

        for (int i = 0; rs1.next(); i++) {
            routs[i] = rs1.getString(3);
        }

        for (int i = 0; i < routs.length; i++) {
            String checkingRout = routs[i];
            if (!checkingRout.equals("")) {
                for (int j = i + 1; j < routs.length; j++) {
                    if (checkingRout.equals(routs[j])) {
                        routs[j] = "";
                    }
                }
            }
        }
        for (String routNumber : routs) {
            if (!routNumber.equals("")) {
                query = "SELECT * FROM `" + routNumber + "`";
                rs2 = Database.executeQuery(con, query);
                while (rs2.next()) {
                    String halt = rs2.getString(1);
                    String subString = null;
                    try {
                        subString = halt.substring(0, userText.length());
                    } catch (Exception ex) {
                    }
                    if (userText.equalsIgnoreCase(subString)) {
                        haltList += (halt + " / ");
                    }
                }
            }
        }
        Database.disconnect(con);
        return haltList;
    }

    public static String[] busList(String start, String end, String date)
            throws SQLException, ClassNotFoundException {

        String query, startingPointMatchetdRouts = "", matchingRouts = "",
                returnValueOfBusTimeAndSourcce = "", returnValueOfBusTurnId = "";

        con = Database.getConnected();
        query = "SELECT * FROM bus_turns WHERE date='" + date + "'";
        rs1 = Database.executeQuery(con, query);

        while (rs1.next()) {
            String routNumber = rs1.getString(3);
            query = "SELECT * FROM `" + routNumber + "`";
            rs2 = Database.executeQuery(con, query);
            while (rs2.next()) {
                String halt = rs2.getString(1);
                if (halt.equalsIgnoreCase(start)) {
                    startingPointMatchetdRouts += (routNumber + " / ");
                }
            }
        }

        String[] matchedRouts = startingPointMatchetdRouts.split(" / ");
        for (int i = 0; i < matchedRouts.length; i++) {
            String search = matchedRouts[i];
            if (!"".equals(search)) {
                for (int j = i + 1; j < matchedRouts.length; j++) {
                    if (search.equals(matchedRouts[j])) {
                        matchedRouts[j] = "";
                    }
                }
            }
        }

        for (String routNumber : matchedRouts) {
            if (!"".equals(routNumber)) {
                query = "SELECT * FROM `" + routNumber + "`";
                rs3 = Database.executeQuery(con, query);
                while (rs3.next()) {
                    String halt = rs3.getString(1);
                    if (halt.equalsIgnoreCase(end)) {
                        matchingRouts += (routNumber + " / ");
                    }
                }
            }
        }

        String[] finalizedRouts = matchingRouts.split(" / ");
        for (String routNumber : finalizedRouts) {
            query = "SELECT * FROM bus_turns WHERE date='" + date + "'";
            rs4 = Database.executeQuery(con, query);
            while (rs4.next()) {
                String rout = rs4.getString(3);
                if (rout.equalsIgnoreCase(routNumber)) {
                    query = "SELECT * FROM `" + routNumber + "`";
                    rs5 = Database.executeQuery(con, query);

                    String orderedHaltsList = "";
                    while (rs5.next()) {
                        orderedHaltsList += rs5.getString(1) + " / ";
                    }
                    String[] orderedHaltsArray = orderedHaltsList.split(" / ");
                    int numOfHalts = orderedHaltsArray.length;

                    int busStart = numOfHalts, busEnd = numOfHalts,
                            passengerStart = numOfHalts, passengerEnd = numOfHalts;
                    for (int i = 0; i < numOfHalts; i++) {

                        if (orderedHaltsArray[i].equalsIgnoreCase(rs4.getString(4))) {
                            busStart = i;
                        }
                        if (orderedHaltsArray[i].equalsIgnoreCase(rs4.getString(5))) {
                            busEnd = i;
                        }
                        if (orderedHaltsArray[i].equalsIgnoreCase(start)) {
                            passengerStart = i;
                        }
                        if (orderedHaltsArray[i].equalsIgnoreCase(end)) {
                            passengerEnd = i;
                        }
                    }

                    if (((busStart >= passengerStart)
                            && (passengerStart > passengerEnd)
                            && (passengerEnd >= busEnd))
                            || ((busStart <= passengerStart)
                            && (passengerStart < passengerEnd)
                            && (passengerEnd <= busEnd))) {
                        returnValueOfBusTimeAndSourcce += (rs4.getString(2)
                                + " from " + rs4.getString(4) + " / ");
                        returnValueOfBusTurnId += rs4.getString(7) + " / ";
                    }
                }
            }
        }
        Database.disconnect(con);

        String[] returnValue = {returnValueOfBusTimeAndSourcce, returnValueOfBusTurnId};
        return returnValue;
    }
}
