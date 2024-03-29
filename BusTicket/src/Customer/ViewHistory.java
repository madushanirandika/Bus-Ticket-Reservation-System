/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
package Customer;

import Admin.SearchCustomer;
import Includes.*;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class ViewHistory extends javax.swing.JFrame {

    private String customerEmail, adminUsername;

    /**
     * Creates new form View
     */
    public ViewHistory(String email) {
        this.setUndecorated(true);
        initWindow();
        customerEmail = email;
        this.adminBack.setVisible(false);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/02.jpg")));
        setResultTable(email);
    }

    public ViewHistory(String username, String email) {
        adminUsername = username;
        this.setUndecorated(true);
        initWindow();
        this.customerBack.setVisible(false);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/125.jpg")));
        setResultTable(email);
    }

    private void initWindow() {
        initComponents();
        this.setSize(890, 570);
        this.setAlwaysOnTop(true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        customerBack = new javax.swing.JButton();
        adminBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        historyTable.setBackground(new java.awt.Color(153, 255, 0));
        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking Number", "Bus Number", "Date", "Time", "Start", "End", "Seat Number", "Email"
            }
        ));
        jScrollPane1.setViewportView(historyTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 840, 30);

        customerBack.setBackground(new java.awt.Color(0, 0, 0));
        customerBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        customerBack.setForeground(new java.awt.Color(102, 255, 0));
        customerBack.setText("Back");
        customerBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBackActionPerformed(evt);
            }
        });
        getContentPane().add(customerBack);
        customerBack.setBounds(30, 480, 100, 30);

        adminBack.setBackground(new java.awt.Color(0, 51, 153));
        adminBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        adminBack.setForeground(new java.awt.Color(0, 255, 255));
        adminBack.setText("Back");
        adminBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBackActionPerformed(evt);
            }
        });
        getContentPane().add(adminBack);
        adminBack.setBounds(30, 40, 100, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/03.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 890, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBackActionPerformed
        StartBooking x = new StartBooking(customerEmail);
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customerBackActionPerformed

    private void adminBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBackActionPerformed
        SearchCustomer x = new SearchCustomer(adminUsername);
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_adminBackActionPerformed

    private void setResultTable(String searchKey) {

        String[] header = {"Booking Number", "Bus Number",
            "Date", "Time", "Start", "End", "Seat Number"};
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCelEditable(int row, int coll) {
                return coll != 1;
            }
        };
        dtm.setColumnIdentifiers(header);
        historyTable.setModel(dtm);

        try {
            String[][] results = collectData(searchKey);
            if (searchKey != null && results != null) {
                if (results.length < 1) {
                    JOptionPane.showMessageDialog(this, "No past journies found");
                }
            }
            for (String[] result : results) {
                dtm.addRow(result);
                historyTable.setModel(dtm);
            }
            Dimension dim = historyTable.getSize();
            int height = (historyTable.getRowCount() * 16) + 24;
            if (height > 344) {
                height = 344;
            }
            jScrollPane1.setSize(dim.width, height);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static String[][] collectData(String email)
            throws SQLException, ClassNotFoundException {
        Connection con;
        ResultSet rs;
        String query;
        String[][] results = null;

        con = Database.getConnected();
        query = "SELECT * FROM `booking_data` WHERE `email`='" + email + "'";
        rs = Database.executeQuery(con, query);
        if (rs != null) {
            int count;
            for (count = 0; rs.next(); count++) {
            }
            rs = Database.executeQuery(con, query);
            results = new String[count][7];
            for (int i = 0; rs.next(); i++) {
                results[i][0] = rs.getString(1);
                results[i][1] = rs.getString(2);
                results[i][2] = rs.getString(3);
                results[i][3] = rs.getString(4);
                results[i][4] = rs.getString(5);
                results[i][5] = rs.getString(6);
                results[i][6] = rs.getString(7);
            }
        }
        Database.disconnect(con);
        return results;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminBack;
    private javax.swing.JButton customerBack;
    private javax.swing.JTable historyTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
