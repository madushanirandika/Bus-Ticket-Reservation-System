/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
package Admin;

import Includes.Database;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class ViewForFinalize extends javax.swing.JFrame {

    private String adminUsername;
    private String busNumber, busTurnId;
    private String[][] turnBookings;

    /**
     * Creates new form View
     */
    public ViewForFinalize(String username, String[] args) {
        initWindow();
        busNumber = args[1];
        busTurnId = args[0];
        adminUsername = username;
        setResultTable(busTurnId);
    }

    private void initWindow() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(890, 570);
        this.setAlwaysOnTop(false);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        busTable = new javax.swing.JTable();
        help = new javax.swing.JButton();
        back = new javax.swing.JButton();
        finalize = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        busTable.setBackground(new java.awt.Color(204, 255, 255));
        busTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seat", "From", "To", "By"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        busTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        busTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                busTableMouseClicked(evt);
            }
        });
        busTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                busTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(busTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 824, 28);

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/help-icon.png"))); // NOI18N
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        getContentPane().add(help);
        help.setBounds(750, 10, 60, 60);

        back.setBackground(new java.awt.Color(0, 51, 153));
        back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        back.setForeground(new java.awt.Color(0, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(50, 490, 100, 30);

        finalize.setBackground(new java.awt.Color(0, 51, 153));
        finalize.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        finalize.setForeground(new java.awt.Color(0, 255, 255));
        finalize.setText("Finalize bus turn");
        finalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizeActionPerformed(evt);
            }
        });
        getContentPane().add(finalize);
        finalize.setBounds(680, 490, 180, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/125.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 890, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busTableKeyPressed
    }//GEN-LAST:event_busTableKeyPressed
    private void busTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_busTableMouseClicked

    }//GEN-LAST:event_busTableMouseClicked

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        String helpMsg;
        helpMsg = "Here you can Finalize your bus turn.\n\n";
        helpMsg += "If you finalized a bus turn, It will be still displayed to\n";
        helpMsg += "customers, and but they cant either book or edit seats in\n";
        helpMsg += "this turn.";
        JOptionPane.showMessageDialog(this, helpMsg);
    }//GEN-LAST:event_helpActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        FinalizeBus x = new FinalizeBus(adminUsername, busNumber);
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    @SuppressWarnings("empty-statement")
    private void finalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizeActionPerformed
        try {
            Connection con = Database.getConnected();
            String query = "SELECT * FROM `" + busTurnId + "`";
            ResultSet rs = Database.executeQuery(con, query);

            String[] busTurnData = busTurnData(busTurnId);
            int count;
            for (count = 0; rs.next(); count++) {
            }

            rs = Database.executeQuery(con, query);
            String[] lines = new String[count + 2];
            lines[0] = "\nSeat" + " | " + "Booking Number" + " | " + "Contact Number";
            double bookingTotal = 0;

            for (int i = 0; rs.next(); i++) {
                String bookingNumber, busNumber, date,
                        time, start, end, seatNumber, email, bookedDate;
                bookingNumber = rs.getString(1);
                busNumber = rs.getString(2);
                date = rs.getString(3);
                time = rs.getString(4);
                start = rs.getString(5);
                end = rs.getString(6);
                seatNumber = rs.getString(7);
                email = rs.getString(8);
                bookedDate = rs.getString(9);

                query = "INSERT INTO `booking_data` "
                        + "(`booking_number`, `bus_number`, `date`, "
                        + "`time`, `start`, `end`, `seat_number`, `email`, `booked_in`) "
                        + "VALUES ('"
                        + bookingNumber + "','"
                        + busNumber + "','"
                        + date + "','"
                        + time + "','"
                        + start + "','"
                        + end + "',"
                        + seatNumber + ",'"
                        + email + "','"
                        + bookedDate + "')";
                Database.updateQuery(con, query);
                query = "SELECT phone FROM customer_login WHERE email = '" + email + "'";
                ResultSet rs1 = Database.executeQuery(con, query);
                rs1.next();

                if (Integer.parseInt(seatNumber) < 10) {
                    seatNumber = "0" + seatNumber;
                    lines[i + 1] = " " + seatNumber + "   | " + bookingNumber + "    | " + rs1.getString(1);
                } else {
                    lines[i + 1] = " " + seatNumber + "   | " + bookingNumber + "  | " + rs1.getString(1);
                }

                query = "SELECT * FROM `" + bookedDate
                        + "` WHERE `booking_number`='" + bookingNumber + "'";
                ResultSet rs2 = Database.executeQuery(con, query);
                rs2.next();
                bookingTotal += rs2.getDouble(4);
            }

            for (int i = 1; i < lines.length - 2; i++) {
                for (int j = 1; j < lines.length - 2; j++) {
                    if (lines[i].substring(0, 2).compareTo(lines[i + 1].substring(0, 2)) > 0) {
                        String temp = lines[i];
                        lines[i] = lines[i + 1];
                        lines[i + 1] = temp;
                    }
                }
            }
            lines[lines.length - 1] = "\nTotal booking cost of tickets = Rs."
                    + String.format("%.2f", bookingTotal);

            String[] returnArray = new String[lines.length + busTurnData.length];
            System.arraycopy(busTurnData, 0, returnArray, 0, busTurnData.length);
            for (int i = busTurnData.length; i < returnArray.length; i++) {
                returnArray[i] = lines[i - busTurnData.length];
            }
            Includes.CreatePDF.printTicket(returnArray,
                    "C:\\Bus Ticket System\\Finalize_reports\\"
                    + busTurnId.replace("/", "-").replace(".", "-"));
            query = "UPDATE `bus_turns` SET `is_filled` = '2' WHERE `bus_turn_id` = '"
                    + busTurnId + "'";
            Database.updateQuery(con, query);
            query = "DROP TABLE `" + busTurnId + "`";
            Database.updateQuery(con, query);
            Database.disconnect(con);

            FinalizeBus x = new FinalizeBus(adminUsername, null);
            x.setVisible(true);
            this.dispose();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_finalizeActionPerformed

    private String[] busTurnData(String busTurnId) {
        String[] busTurnData =  new String[5];
        try {
            Connection con = Database.getConnected();
            String query = "SELECT * FROM `bus_turns` WHERE `bus_turn_id`='" + busTurnId + "'";
            ResultSet rs = Database.executeQuery(con, query);
            rs.next();

            busTurnData[0] = "Bus Number  : " + rs.getString(6);
            busTurnData[1] = "Travel Date    : " + rs.getString(1);
            busTurnData[2] = "Travel Time   : " + rs.getString(2);
            busTurnData[3] = "Turn from      : " + rs.getString(4);
            busTurnData[4] = "Turn to          : " + rs.getString(5) + "\n";
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return busTurnData;
    }

    private void setResultTable(String searchKey) {
        String[] header = {"Seat", "From", "To", "By"};
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCelEditable(int row, int coll) {
                return coll != 1;
            }
        };
        dtm.setColumnIdentifiers(header);
        busTable.setModel(dtm);

        try {
            turnBookings = viewBusTurns(searchKey);

            for (int i = 0; i < turnBookings.length - 1; i++) {
                for (int j = 0; j < turnBookings.length - 1; j++) {
                    int num1 = Integer.parseInt(turnBookings[j][0]);
                    int num2 = Integer.parseInt(turnBookings[j + 1][0]);
                    if (num1 > num2) {
                        String[] temp = turnBookings[j + 1];
                        turnBookings[j + 1] = turnBookings[j];
                        turnBookings[j] = temp;
                    }
                }
            }

            for (String[] result : turnBookings) {
                dtm.addRow(result);
                busTable.setModel(dtm);
            }
        } catch (SQLException | ClassNotFoundException ex) {
        }

        Dimension dim = busTable.getSize();
        int height = (busTable.getRowCount() * 16) + 26;
        if (height > 420) {
            height = 420;
        }
        jScrollPane1.setSize(dim.width, height);
    }

    private String[][] viewBusTurns(String busTurnId)
            throws SQLException, ClassNotFoundException {
        Connection con;
        ResultSet rs = null;
        String query;
        String[][] results = null;

        con = Database.getConnected();
        query = "SELECT * FROM `" + busTurnId + "`";
        rs = Database.executeQuery(con, query);
        int count;
        for (count = 0; rs.next(); count++) {
        }
        rs = Database.executeQuery(con, query);
        results = new String[count][4];
        for (int i = 0; rs.next(); i++) {
            results[i][0] = rs.getString(7);
            results[i][1] = rs.getString(5);
            results[i][2] = rs.getString(6);
            results[i][3] = rs.getString(8);
        }
        Database.disconnect(con);
        return results;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTable busTable;
    private javax.swing.JButton finalize;
    private javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
