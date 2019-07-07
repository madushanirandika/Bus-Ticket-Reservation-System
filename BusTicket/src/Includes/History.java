package Includes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Includes.Database;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Madu Randi
 */
public class History {

    public static void expire() {
        Date yy = new Date();
        Connection con;
        String query;
        ResultSet rs;
        try {
            con = Database.getConnected();
            query = "SELECT * FROM `bus_turns` WHERE `is_filled`='2'";
            rs = Database.executeQuery(con, query);

            int count;
            for (count = 0; rs.next(); count++) {
            }

            String[][] turnsData = new String[count][3];
            rs = Database.executeQuery(con, query);
            for (int i = 0; rs.next(); i++) {
                turnsData[i][0] = rs.getString(1);
                turnsData[i][1] = rs.getString(2);
                turnsData[i][2] = rs.getString(7);
            }

            for (String[] turnData : turnsData) {
                String dateInString = turnData[0] + " " + turnData[1];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss");
                Date turnDate = sdf.parse(dateInString);

                if (turnDate.compareTo(yy) < 0) {
                    query = "DELETE FROM bus_turns WHERE bus_turn_id='" + turnData[2] + "'";
                    Database.updateQuery(con, query);
                }
            }
        } catch (SQLException | ClassNotFoundException | ParseException ex) {
        }
    }
}
