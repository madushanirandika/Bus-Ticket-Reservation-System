/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Includes.Database;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Madu Randi
 */
public class ViewForDeleteTurn extends javax.swing.JFrame {

    private String adminUsername;

    /**
     * Creates new form DeleteRout
     */
    public ViewForDeleteTurn(String username) {
        adminUsername = username;
        initWindow();
        searchDeleteRout();
    }

    private void initWindow() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(890, 570);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        initFields();
    }

    private void initFields() {

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
        deletableRoutsTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        deletableRoutsTable.setBackground(new java.awt.Color(204, 255, 255));
        deletableRoutsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Rout Number", "From", "To", "Bus Number", "Bus ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(deletableRoutsTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 850, 30);

        jButton1.setBackground(new java.awt.Color(255, 153, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(740, 490, 130, 30);

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
        back.setBounds(50, 490, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/125.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 890, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String input;
        try {
            String busTurn = deletableRoutsTable.getValueAt(deletableRoutsTable.getSelectedRow(), 6).toString();
            try {
                do {
                    input = JOptionPane.showInputDialog(this, "Do you really want to delete this bus turn (Y/N) ?");
                } while (!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")));
            } catch (NullPointerException ex) {
                input = "n";
            }

            if (input.equalsIgnoreCase("y")) {
                try {
                    deleteTurn(busTurn);
                    JOptionPane.showMessageDialog(this, "Selected bus turn " + busTurn
                            + " was deletede succesfully");
                    ViewForDeleteTurn x = new ViewForDeleteTurn(adminUsername);
                    this.dispose();
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Click on the table to select the bus turn which you want to delete");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Services x = new Services(adminUsername);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    public static void deleteTurn(String busTurnId)
            throws SQLException, ClassNotFoundException {

        Connection con = Database.getConnected();
        String query = "DELETE FROM bus_turns WHERE bus_turn_id='" + busTurnId + "'";
        Database.updateQuery(con, query);
        query = "DROP TABLE `" + busTurnId + "`";
        Database.updateQuery(con, query);
        Database.disconnect(con);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTable deletableRoutsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void searchDeleteRout() {

        String[] header = {"Date", "Time", "Rout Number", "From",
            "To", "Bus Number", "Bus ID"};

        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCelEditable(int row, int coll) {
                return coll != 1;
            }
        };
        dtm.setColumnIdentifiers(header);

        deletableRoutsTable.setModel(dtm);

        try {
            String[][] results = viewTurns();

            for (String[] result : results) {
                String busTurnId = result[6];

                Connection con = Database.getConnected();
                String query = "SELECT * FROM `" + busTurnId + "`";
                ResultSet rs = Database.executeQuery(con, query);
                if (!rs.next()) {
                    dtm.addRow(result);
                    deletableRoutsTable.setModel(dtm);
                }
            }
            Dimension dim = jScrollPane1.getSize();
            int height = (deletableRoutsTable.getRowCount() * 16) + 28;
            if (height > 420) {
                height = 420;
            }
            jScrollPane1.setSize(dim.width, height);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    private static String[][] viewTurns()
            throws SQLException, ClassNotFoundException {

        Connection con;
        ResultSet rs;
        String query;

        con = Database.getConnected();
        query = "SELECT * FROM bus_turns WHERE is_filled=0";
        rs = Database.executeQuery(con, query);

        int count;
        for (count = 0; rs.next(); count++) {
        }
        String[][] busTurns = new String[count][7];
        rs = Database.executeQuery(con, query);

        for (int i = 0; rs.next(); i++) {
            busTurns[i][0] = rs.getString(1);
            busTurns[i][1] = rs.getString(2);
            busTurns[i][2] = rs.getString(3);
            busTurns[i][3] = rs.getString(4);
            busTurns[i][4] = rs.getString(5);
            busTurns[i][5] = rs.getString(6);
            busTurns[i][6] = rs.getString(7);
        }
        Database.disconnect(con);
        return busTurns;
    }
}
