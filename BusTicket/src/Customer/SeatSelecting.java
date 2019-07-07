/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
package Customer;

import Includes.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class SeatSelecting extends javax.swing.JFrame {

    private String customerEmail, customerFrom, customerTo, customerOn, selectedDate;
    private JToggleButton[][] busSeats;

    /**
     * Creates new form ViewBusForBooking
     *
     * @param args
     */
    public SeatSelecting(String[] args) {
        if (args != null) {
            this.setUndecorated(true);
            initComponents();
            customerEmail = args[0];
            customerFrom = args[1];
            customerTo = args[2];
            customerOn = args[3];
            selectedDate = args[4];
            initTextFields();
            initBusSeats();
            initWindow();
        }
    }

    private void initWindow() {
        this.setSize(890, 570);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void initBusSeats() {
        try {
            busSeats = new JToggleButton[][]{
                {jToggleButton1, jToggleButton2, jToggleButton3, jToggleButton4, jToggleButton5, jToggleButton6},
                {jToggleButton7, jToggleButton8, jToggleButton9, jToggleButton10, jToggleButton11, jToggleButton12},
                {jToggleButton13, jToggleButton14, jToggleButton15, jToggleButton16, jToggleButton17, jToggleButton18},
                {jToggleButton19, jToggleButton20, jToggleButton21, jToggleButton22, jToggleButton23, jToggleButton24},
                {jToggleButton25, jToggleButton26, jToggleButton27, jToggleButton28, jToggleButton29, jToggleButton30},
                {jToggleButton31, jToggleButton32, jToggleButton33, jToggleButton34, jToggleButton35, jToggleButton36},
                {jToggleButton37, jToggleButton38, jToggleButton39, jToggleButton40, jToggleButton41, jToggleButton42},
                {jToggleButton43, jToggleButton44, jToggleButton45, jToggleButton46, jToggleButton47, jToggleButton48},
                {jToggleButton49, jToggleButton50, jToggleButton51, jToggleButton52, jToggleButton53, jToggleButton54},
                {jToggleButton55, jToggleButton56, jToggleButton57, jToggleButton58, jToggleButton59, jToggleButton60},
                {jToggleButton61, jToggleButton62, jToggleButton63, jToggleButton64, jToggleButton65, jToggleButton66},
                {jToggleButton67, jToggleButton68, jToggleButton69, jToggleButton70, jToggleButton71, jToggleButton72},};

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    busSeats[i][j].setVisible(false);
                }
            }

            Connection con = Database.getConnected();
            String query = "SELECT * FROM bus_turns WHERE bus_turn_id='" + customerOn + "'";
            ResultSet rs = Database.executeQuery(con, query);
            String busNumber = null;
            rs.next();
            busNumber = rs.getString(6);
            query = "SELECT * FROM bus_data WHERE bus_number='" + busNumber + "'";
            rs = Database.executeQuery(con, query);
            String seatConfig[] = null;
            while (rs.next()) {
                seatConfig = rs.getString(6).split("/");
            }
            for (int i = 0; i < seatConfig.length && i < 12; i++) {
                String[] seatRow = seatConfig[i].split("-");
                int[] seatNumbersOfARow = new int[6];
                for (int j = 0; j < 6; j++) {
                    try {
                        seatNumbersOfARow[j] = Integer.parseInt(seatRow[j]);
                    } catch (Exception e) {
                        seatNumbersOfARow[j] = 0;
                    }

                    if (seatNumbersOfARow[j] != 0) {
                        busSeats[i][j].setVisible(true);
                        busSeats[i][j].setText(((seatNumbersOfARow[j]) < 10) ? "0" + seatNumbersOfARow[j] : "" + seatNumbersOfARow[j]);
                    }
                }
            }
            query = "SELECT * FROM `" + customerOn + "`";
            rs = Database.executeQuery(con, query);
            while (rs.next()) {
                int bkdSt = rs.getInt(7);
                String bookedSeat;
                if (bkdSt < 10) {
                    bookedSeat = "0" + bkdSt;
                } else {
                    bookedSeat = rs.getString(7);
                }
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (bookedSeat.equalsIgnoreCase(busSeats[i][j].getText())) {
                            busSeats[i][j].setEnabled(false);
                            busSeats[i][j].setText("");
                        }
                    }
                }
            }
            Database.disconnect(con);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void initTextFields() {
        try {
            Connection con = Database.getConnected();
            String query = "SELECT * FROM `customer_login` WHERE email='" + customerEmail + "'";
            ResultSet rs = Database.executeQuery(con, query);
            while (rs.next()) {
                customerName.setText(rs.getString(1));
            }
            from.setText(customerFrom);
            to.setText(customerTo);
            query = "SELECT * FROM `bus_turns` WHERE bus_turn_id='" + customerOn + "'";
            rs = Database.executeQuery(con, query);
            while (rs.next()) {
                date.setText(rs.getString(1));
                time.setText(rs.getString(2));
            }
            Database.disconnect(con);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerName = new javax.swing.JTextField();
        from = new javax.swing.JTextField();
        to = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton12 = new javax.swing.JToggleButton();
        jToggleButton13 = new javax.swing.JToggleButton();
        jToggleButton14 = new javax.swing.JToggleButton();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton16 = new javax.swing.JToggleButton();
        jToggleButton17 = new javax.swing.JToggleButton();
        jToggleButton18 = new javax.swing.JToggleButton();
        jToggleButton19 = new javax.swing.JToggleButton();
        jToggleButton20 = new javax.swing.JToggleButton();
        jToggleButton21 = new javax.swing.JToggleButton();
        jToggleButton22 = new javax.swing.JToggleButton();
        jToggleButton23 = new javax.swing.JToggleButton();
        jToggleButton24 = new javax.swing.JToggleButton();
        jToggleButton25 = new javax.swing.JToggleButton();
        jToggleButton26 = new javax.swing.JToggleButton();
        jToggleButton27 = new javax.swing.JToggleButton();
        jToggleButton28 = new javax.swing.JToggleButton();
        jToggleButton29 = new javax.swing.JToggleButton();
        jToggleButton30 = new javax.swing.JToggleButton();
        jToggleButton31 = new javax.swing.JToggleButton();
        jToggleButton32 = new javax.swing.JToggleButton();
        jToggleButton33 = new javax.swing.JToggleButton();
        jToggleButton34 = new javax.swing.JToggleButton();
        jToggleButton35 = new javax.swing.JToggleButton();
        jToggleButton36 = new javax.swing.JToggleButton();
        jToggleButton37 = new javax.swing.JToggleButton();
        jToggleButton38 = new javax.swing.JToggleButton();
        jToggleButton39 = new javax.swing.JToggleButton();
        jToggleButton40 = new javax.swing.JToggleButton();
        jToggleButton41 = new javax.swing.JToggleButton();
        jToggleButton42 = new javax.swing.JToggleButton();
        jToggleButton43 = new javax.swing.JToggleButton();
        jToggleButton44 = new javax.swing.JToggleButton();
        jToggleButton45 = new javax.swing.JToggleButton();
        jToggleButton46 = new javax.swing.JToggleButton();
        jToggleButton47 = new javax.swing.JToggleButton();
        jToggleButton48 = new javax.swing.JToggleButton();
        jToggleButton49 = new javax.swing.JToggleButton();
        jToggleButton50 = new javax.swing.JToggleButton();
        jToggleButton51 = new javax.swing.JToggleButton();
        jToggleButton52 = new javax.swing.JToggleButton();
        jToggleButton53 = new javax.swing.JToggleButton();
        jToggleButton54 = new javax.swing.JToggleButton();
        jToggleButton55 = new javax.swing.JToggleButton();
        jToggleButton56 = new javax.swing.JToggleButton();
        jToggleButton57 = new javax.swing.JToggleButton();
        jToggleButton58 = new javax.swing.JToggleButton();
        jToggleButton59 = new javax.swing.JToggleButton();
        jToggleButton60 = new javax.swing.JToggleButton();
        jToggleButton61 = new javax.swing.JToggleButton();
        jToggleButton62 = new javax.swing.JToggleButton();
        jToggleButton63 = new javax.swing.JToggleButton();
        jToggleButton64 = new javax.swing.JToggleButton();
        jToggleButton65 = new javax.swing.JToggleButton();
        jToggleButton66 = new javax.swing.JToggleButton();
        jToggleButton67 = new javax.swing.JToggleButton();
        jToggleButton68 = new javax.swing.JToggleButton();
        jToggleButton69 = new javax.swing.JToggleButton();
        jToggleButton70 = new javax.swing.JToggleButton();
        jToggleButton71 = new javax.swing.JToggleButton();
        jToggleButton72 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        customerName.setEditable(false);
        customerName.setBackground(new java.awt.Color(153, 255, 0));
        customerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameActionPerformed(evt);
            }
        });
        getContentPane().add(customerName);
        customerName.setBounds(150, 50, 700, 33);

        from.setEditable(false);
        from.setBackground(new java.awt.Color(153, 255, 102));
        getContentPane().add(from);
        from.setBounds(150, 90, 700, 31);

        to.setEditable(false);
        to.setBackground(new java.awt.Color(153, 255, 0));
        getContentPane().add(to);
        to.setBounds(150, 130, 700, 30);

        date.setEditable(false);
        date.setBackground(new java.awt.Color(153, 255, 102));
        getContentPane().add(date);
        date.setBounds(150, 170, 700, 31);

        time.setEditable(false);
        time.setBackground(new java.awt.Color(153, 255, 0));
        getContentPane().add(time);
        time.setBounds(150, 210, 700, 33);

        jToggleButton7.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton7.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton7.setText("?");
        jToggleButton7.setToolTipText("");
        jToggleButton7.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton7);
        jToggleButton7.setBounds(100, 470, 50, 35);

        jToggleButton8.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton8.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton8.setText("?");
        jToggleButton8.setToolTipText("");
        jToggleButton8.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton8);
        jToggleButton8.setBounds(100, 430, 50, 35);

        jToggleButton9.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton9.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton9.setText("?");
        jToggleButton9.setToolTipText("");
        jToggleButton9.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton9);
        jToggleButton9.setBounds(100, 390, 50, 35);

        jToggleButton10.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton10.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton10.setText("?");
        jToggleButton10.setToolTipText("");
        jToggleButton10.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton10);
        jToggleButton10.setBounds(100, 350, 50, 35);

        jToggleButton11.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton11.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton11.setText("?");
        jToggleButton11.setToolTipText("");
        jToggleButton11.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton11);
        jToggleButton11.setBounds(100, 310, 50, 35);

        jToggleButton12.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton12.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton12.setText("?");
        jToggleButton12.setToolTipText("");
        jToggleButton12.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton12);
        jToggleButton12.setBounds(100, 270, 50, 35);

        jToggleButton13.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton13.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton13.setText("?");
        jToggleButton13.setToolTipText("");
        jToggleButton13.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton13);
        jToggleButton13.setBounds(170, 470, 50, 35);

        jToggleButton14.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton14.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton14.setText("?");
        jToggleButton14.setToolTipText("");
        jToggleButton14.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton14);
        jToggleButton14.setBounds(170, 430, 50, 35);

        jToggleButton15.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton15.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton15.setText("?");
        jToggleButton15.setToolTipText("");
        jToggleButton15.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton15);
        jToggleButton15.setBounds(170, 390, 50, 35);

        jToggleButton16.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton16.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton16.setText("?");
        jToggleButton16.setToolTipText("");
        jToggleButton16.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton16);
        jToggleButton16.setBounds(170, 350, 50, 35);

        jToggleButton17.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton17.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton17.setText("?");
        jToggleButton17.setToolTipText("");
        jToggleButton17.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton17);
        jToggleButton17.setBounds(170, 310, 50, 35);

        jToggleButton18.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton18.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton18.setText("?");
        jToggleButton18.setToolTipText("");
        jToggleButton18.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton18);
        jToggleButton18.setBounds(170, 270, 50, 35);

        jToggleButton19.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton19.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton19.setText("?");
        jToggleButton19.setToolTipText("");
        jToggleButton19.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton19);
        jToggleButton19.setBounds(240, 470, 50, 35);

        jToggleButton20.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton20.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton20.setText("?");
        jToggleButton20.setToolTipText("");
        jToggleButton20.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton20);
        jToggleButton20.setBounds(240, 430, 50, 35);

        jToggleButton21.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton21.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton21.setText("?");
        jToggleButton21.setToolTipText("");
        jToggleButton21.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton21);
        jToggleButton21.setBounds(240, 390, 50, 35);

        jToggleButton22.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton22.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton22.setText("?");
        jToggleButton22.setToolTipText("");
        jToggleButton22.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton22);
        jToggleButton22.setBounds(240, 350, 50, 35);

        jToggleButton23.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton23.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton23.setText("?");
        jToggleButton23.setToolTipText("");
        jToggleButton23.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton23);
        jToggleButton23.setBounds(240, 310, 50, 35);

        jToggleButton24.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton24.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton24.setText("?");
        jToggleButton24.setToolTipText("");
        jToggleButton24.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton24);
        jToggleButton24.setBounds(240, 270, 50, 35);

        jToggleButton25.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton25.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton25.setText("?");
        jToggleButton25.setToolTipText("");
        jToggleButton25.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton25);
        jToggleButton25.setBounds(310, 470, 50, 35);

        jToggleButton26.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton26.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton26.setText("?");
        jToggleButton26.setToolTipText("");
        jToggleButton26.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton26);
        jToggleButton26.setBounds(310, 430, 50, 35);

        jToggleButton27.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton27.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton27.setText("?");
        jToggleButton27.setToolTipText("");
        jToggleButton27.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton27);
        jToggleButton27.setBounds(310, 390, 50, 35);

        jToggleButton28.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton28.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton28.setText("?");
        jToggleButton28.setToolTipText("");
        jToggleButton28.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton28);
        jToggleButton28.setBounds(310, 350, 50, 35);

        jToggleButton29.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton29.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton29.setText("?");
        jToggleButton29.setToolTipText("");
        jToggleButton29.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton29);
        jToggleButton29.setBounds(310, 310, 50, 35);

        jToggleButton30.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton30.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton30.setText("?");
        jToggleButton30.setToolTipText("");
        jToggleButton30.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton30);
        jToggleButton30.setBounds(310, 270, 50, 35);

        jToggleButton31.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton31.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton31.setText("?");
        jToggleButton31.setToolTipText("");
        jToggleButton31.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton31);
        jToggleButton31.setBounds(380, 470, 50, 35);

        jToggleButton32.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton32.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton32.setText("?");
        jToggleButton32.setToolTipText("");
        jToggleButton32.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton32);
        jToggleButton32.setBounds(380, 430, 50, 35);

        jToggleButton33.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton33.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton33.setText("?");
        jToggleButton33.setToolTipText("");
        jToggleButton33.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton33);
        jToggleButton33.setBounds(380, 390, 50, 35);

        jToggleButton34.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton34.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton34.setText("?");
        jToggleButton34.setToolTipText("");
        jToggleButton34.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton34);
        jToggleButton34.setBounds(380, 350, 50, 35);

        jToggleButton35.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton35.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton35.setText("?");
        jToggleButton35.setToolTipText("");
        jToggleButton35.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton35);
        jToggleButton35.setBounds(380, 310, 50, 35);

        jToggleButton36.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton36.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton36.setText("?");
        jToggleButton36.setToolTipText("");
        jToggleButton36.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton36);
        jToggleButton36.setBounds(380, 270, 50, 35);

        jToggleButton37.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton37.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton37.setText("?");
        jToggleButton37.setToolTipText("");
        jToggleButton37.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton37);
        jToggleButton37.setBounds(450, 470, 50, 35);

        jToggleButton38.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton38.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton38.setText("?");
        jToggleButton38.setToolTipText("");
        jToggleButton38.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton38);
        jToggleButton38.setBounds(450, 430, 50, 35);

        jToggleButton39.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton39.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton39.setText("?");
        jToggleButton39.setToolTipText("");
        jToggleButton39.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton39);
        jToggleButton39.setBounds(450, 390, 50, 35);

        jToggleButton40.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton40.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton40.setText("?");
        jToggleButton40.setToolTipText("");
        jToggleButton40.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton40);
        jToggleButton40.setBounds(450, 350, 50, 35);

        jToggleButton41.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton41.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton41.setText("?");
        jToggleButton41.setToolTipText("");
        jToggleButton41.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton41);
        jToggleButton41.setBounds(450, 310, 50, 35);

        jToggleButton42.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton42.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton42.setText("?");
        jToggleButton42.setToolTipText("");
        jToggleButton42.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton42);
        jToggleButton42.setBounds(450, 270, 50, 35);

        jToggleButton43.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton43.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton43.setText("?");
        jToggleButton43.setToolTipText("");
        jToggleButton43.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton43);
        jToggleButton43.setBounds(520, 470, 50, 35);

        jToggleButton44.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton44.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton44.setText("?");
        jToggleButton44.setToolTipText("");
        jToggleButton44.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton44);
        jToggleButton44.setBounds(520, 430, 50, 35);

        jToggleButton45.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton45.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton45.setText("?");
        jToggleButton45.setToolTipText("");
        jToggleButton45.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton45);
        jToggleButton45.setBounds(520, 390, 50, 35);

        jToggleButton46.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton46.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton46.setText("?");
        jToggleButton46.setToolTipText("");
        jToggleButton46.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton46);
        jToggleButton46.setBounds(520, 350, 50, 35);

        jToggleButton47.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton47.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton47.setText("?");
        jToggleButton47.setToolTipText("");
        jToggleButton47.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton47);
        jToggleButton47.setBounds(520, 310, 50, 35);

        jToggleButton48.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton48.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton48.setText("?");
        jToggleButton48.setToolTipText("");
        jToggleButton48.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton48);
        jToggleButton48.setBounds(520, 270, 50, 35);

        jToggleButton49.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton49.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton49.setText("?");
        jToggleButton49.setToolTipText("");
        jToggleButton49.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton49);
        jToggleButton49.setBounds(590, 470, 50, 35);

        jToggleButton50.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton50.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton50.setText("?");
        jToggleButton50.setToolTipText("");
        jToggleButton50.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton50);
        jToggleButton50.setBounds(590, 430, 50, 35);

        jToggleButton51.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton51.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton51.setText("?");
        jToggleButton51.setToolTipText("");
        jToggleButton51.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton51);
        jToggleButton51.setBounds(590, 390, 50, 35);

        jToggleButton52.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton52.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton52.setText("?");
        jToggleButton52.setToolTipText("");
        jToggleButton52.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton52);
        jToggleButton52.setBounds(590, 350, 50, 35);

        jToggleButton53.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton53.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton53.setText("?");
        jToggleButton53.setToolTipText("");
        jToggleButton53.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton53);
        jToggleButton53.setBounds(590, 310, 50, 35);

        jToggleButton54.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton54.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton54.setText("?");
        jToggleButton54.setToolTipText("");
        jToggleButton54.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton54);
        jToggleButton54.setBounds(590, 270, 50, 35);

        jToggleButton55.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton55.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton55.setText("?");
        jToggleButton55.setToolTipText("");
        jToggleButton55.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton55);
        jToggleButton55.setBounds(660, 470, 50, 35);

        jToggleButton56.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton56.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton56.setText("?");
        jToggleButton56.setToolTipText("");
        jToggleButton56.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton56);
        jToggleButton56.setBounds(660, 430, 50, 35);

        jToggleButton57.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton57.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton57.setText("?");
        jToggleButton57.setToolTipText("");
        jToggleButton57.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton57);
        jToggleButton57.setBounds(660, 390, 50, 35);

        jToggleButton58.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton58.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton58.setText("?");
        jToggleButton58.setToolTipText("");
        jToggleButton58.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton58);
        jToggleButton58.setBounds(660, 350, 50, 35);

        jToggleButton59.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton59.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton59.setText("?");
        jToggleButton59.setToolTipText("");
        jToggleButton59.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton59);
        jToggleButton59.setBounds(660, 310, 50, 35);

        jToggleButton60.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton60.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton60.setText("?");
        jToggleButton60.setToolTipText("");
        jToggleButton60.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton60);
        jToggleButton60.setBounds(660, 270, 50, 35);

        jToggleButton61.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton61.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton61.setText("?");
        jToggleButton61.setToolTipText("");
        jToggleButton61.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton61);
        jToggleButton61.setBounds(730, 470, 50, 35);

        jToggleButton62.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton62.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton62.setText("?");
        jToggleButton62.setToolTipText("");
        jToggleButton62.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton62);
        jToggleButton62.setBounds(730, 430, 50, 35);

        jToggleButton63.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton63.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton63.setText("?");
        jToggleButton63.setToolTipText("");
        jToggleButton63.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton63);
        jToggleButton63.setBounds(730, 390, 50, 35);

        jToggleButton64.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton64.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton64.setText("?");
        jToggleButton64.setToolTipText("");
        jToggleButton64.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton64);
        jToggleButton64.setBounds(730, 350, 50, 35);

        jToggleButton65.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton65.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton65.setText("?");
        jToggleButton65.setToolTipText("");
        jToggleButton65.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton65);
        jToggleButton65.setBounds(730, 310, 50, 35);

        jToggleButton66.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton66.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton66.setText("?");
        jToggleButton66.setToolTipText("");
        jToggleButton66.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton66);
        jToggleButton66.setBounds(730, 270, 50, 35);

        jToggleButton67.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton67.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton67.setText("?");
        jToggleButton67.setToolTipText("");
        jToggleButton67.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton67);
        jToggleButton67.setBounds(800, 470, 50, 35);

        jToggleButton68.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton68.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton68.setText("?");
        jToggleButton68.setToolTipText("");
        jToggleButton68.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton68);
        jToggleButton68.setBounds(800, 430, 50, 35);

        jToggleButton69.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton69.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton69.setText("?");
        jToggleButton69.setToolTipText("");
        jToggleButton69.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton69);
        jToggleButton69.setBounds(800, 390, 50, 35);

        jToggleButton70.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton70.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton70.setText("?");
        jToggleButton70.setToolTipText("");
        jToggleButton70.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton70);
        jToggleButton70.setBounds(800, 350, 50, 35);

        jToggleButton71.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton71.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton71.setText("?");
        jToggleButton71.setToolTipText("");
        jToggleButton71.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton71);
        jToggleButton71.setBounds(800, 310, 50, 35);

        jToggleButton72.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton72.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton72.setText("?");
        jToggleButton72.setToolTipText("");
        jToggleButton72.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton72);
        jToggleButton72.setBounds(800, 270, 50, 35);

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("?");
        jToggleButton1.setToolTipText("");
        jToggleButton1.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(30, 470, 50, 35);

        jToggleButton2.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("?");
        jToggleButton2.setToolTipText("");
        jToggleButton2.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton2);
        jToggleButton2.setBounds(30, 430, 50, 35);

        jToggleButton3.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton3.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setText("?");
        jToggleButton3.setToolTipText("");
        jToggleButton3.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton3);
        jToggleButton3.setBounds(30, 390, 50, 35);

        jToggleButton4.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton4.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setText("?");
        jToggleButton4.setToolTipText("");
        jToggleButton4.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton4);
        jToggleButton4.setBounds(30, 350, 50, 35);

        jToggleButton5.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton5.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton5.setText("?");
        jToggleButton5.setToolTipText("");
        jToggleButton5.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton5);
        jToggleButton5.setBounds(30, 310, 50, 35);

        jToggleButton6.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton6.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton6.setText("?");
        jToggleButton6.setToolTipText("");
        jToggleButton6.setPreferredSize(new java.awt.Dimension(50, 35));
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton6);
        jToggleButton6.setBounds(30, 270, 50, 35);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select seats you want and press OK");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 240, 254, 23);

        ok.setBackground(new java.awt.Color(0, 0, 0));
        ok.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ok.setForeground(new java.awt.Color(102, 255, 0));
        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok);
        ok.setBounds(750, 520, 100, 30);

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        back.setForeground(new java.awt.Color(102, 255, 0));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(30, 520, 100, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name      :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 50, 90, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("From      :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 90, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("To          :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 130, 90, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date      :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 160, 90, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Time      :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 200, 90, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/03.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 910, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        String[] args = {customerEmail, customerFrom, customerTo, selectedDate};
        StartBooking x = new StartBooking(args);
        x.setVisible(true);
        x.setSize(this.getSize());
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        String seatListTemp = "";
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (busSeats[i][j].isSelected()) {
                    seatListTemp += busSeats[i][j].getText() + " / ";
                }
            }
        }
        String[] selectedSeatsArray = seatListTemp.split(" / ");
        String seatList = "";
        for (int i = 0; i < selectedSeatsArray.length; i++) {
            seatList += selectedSeatsArray[i];
            if (i < (selectedSeatsArray.length - 1)) {
                seatList += " / ";
            }
        }
        if (seatList.equals("")) {
            JOptionPane.showMessageDialog(this, "Select seats and then press Ok");
        } else {
            String name = null;
            try {
                Connection con = Database.getConnected();
                String query = "SELECT * FROM `customer_login` WHERE email='" + customerEmail + "'";
                ResultSet rs = Database.executeQuery(con, query);
                rs.next();
                name = rs.getString(1);
                Database.disconnect(con);

                String[] args = {customerEmail, name, customerFrom, customerTo, customerOn, seatList};
                String[] calculatedData = seatBookingDataCalculator(args);

                ConfirmBooking x = new ConfirmBooking(calculatedData);
                x.setVisible(true);
                this.dispose();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_okActionPerformed

    private String[] seatBookingDataCalculator(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnected();
        String query;

        String[] dateTimeBusNumber = busTurnDetails(args[4]);
        String[] seatNumbers = args[5].split(" / ");

        query = "SELECT * FROM `" + (args[4].substring(5, 8)) + "`";
        ResultSet rs = Database.executeQuery(con, query);
        String haltList = "";
        String distanceList = "";
        while (rs.next()) {
            haltList += rs.getString(1) + " / ";
            distanceList += rs.getString(2) + " / ";
        }
        String[] halts = haltList.split(" / ");
        String[] distancesTemp = distanceList.split(" / ");
        int[] distances = new int[distancesTemp.length];
        for (int i = 0; i < distancesTemp.length; i++) {
            distances[i] = Integer.parseInt(distancesTemp[i]);
        }

        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < halts.length; i++) {
            if (args[2].equalsIgnoreCase(halts[i])) {
                startIndex = i;
            }
            if (args[3].equalsIgnoreCase(halts[i])) {
                endIndex = i;
            }
        }

        int traveledDistance = 0, distanceToStartFromBusStand = 0;
        if (startIndex < endIndex) {
            for (int i = (startIndex + 1); i < (endIndex + 1); i++) {
                traveledDistance += distances[i];
            }
            for (int i = 0; i < (startIndex + 1); i++) {
                distanceToStartFromBusStand += distances[i];
            }
        } else if (startIndex > endIndex) {
            for (int i = (endIndex + 1); i < (startIndex + 1); i++) {
                traveledDistance += distances[i];
            }
            for (int i = startIndex + 1; i < distances.length; i++) {
                try {
                    distanceToStartFromBusStand += distances[i];
                } catch (Exception e) {
                    distanceToStartFromBusStand = 0;
                }
            }
        }

        query = "SELECT * FROM rout_data WHERE rout_number='" + (args[4].substring(5, 8)) + "'";
        rs = Database.executeQuery(con, query);
        rs.next();
        int cost = (int) Math.round(((rs.getInt(4) * 1.0) / rs.getInt(3))
                * traveledDistance * seatNumbers.length);
        String passengerTime = busRunningTimeCalculator(dateTimeBusNumber[1],
                rs.getInt(3), distanceToStartFromBusStand, rs.getInt(5));

        int journyTime = (int) Math.round(rs.getInt(5) * 1.0 / rs.getInt(3) * traveledDistance);
        String[] returnValue = {args[0], args[1], args[2], args[3], args[4], args[5],
            dateTimeBusNumber[0], passengerTime, args[4].substring(5, 8),
            dateTimeBusNumber[2], "" + traveledDistance, "" + cost,
            "" + journyTime + " minutes"};
        Database.disconnect(con);
        return returnValue;
    }

    private String[] busTurnDetails(String busTurnId) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnected();
        String query = "SELECT * FROM bus_turns WHERE bus_turn_id='" + busTurnId + "'";
        ResultSet rs = Database.executeQuery(con, query);
        rs.next();
        String[] returnValue = {rs.getString(1) + " at " + rs.getString(2)
            + " from " + rs.getString(4), rs.getString(2), rs.getString(6)};
        Database.disconnect(con);

        return returnValue;
    }

    private String busRunningTimeCalculator(String startTime, int totalDistanceOfRout,
            int distanceToStartFromBusStand, int totalTravelTime) {

        int hh, mm, total, travelTimeFromStand;
        String[] timeParts = startTime.split("\\.");

        hh = Integer.parseInt(timeParts[0]);
        mm = Integer.parseInt(timeParts[1]);

        total = hh * 60 + mm;
        travelTimeFromStand = (int) (totalTravelTime * 1.0 / totalDistanceOfRout
                * distanceToStartFromBusStand);
        total += travelTimeFromStand;
        hh = total / 60;
        mm = total % 60;
        if (hh > 23) {
            hh -= 24;
        }
        String hhhh;
        String passengerTime;
        if (hh < 10) {
            hhhh = "0" + hh;
        } else {
            hhhh = "" + hh;
        }
        if (mm < 10) {
            passengerTime = hhhh + ".0" + mm + ".00";
        } else {
            passengerTime = hhhh + "." + mm + ".00";
        }
        return passengerTime;
    }
    private void customerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameActionPerformed

    }//GEN-LAST:event_customerNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField customerName;
    private javax.swing.JTextField date;
    private javax.swing.JTextField from;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton13;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton18;
    private javax.swing.JToggleButton jToggleButton19;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton20;
    private javax.swing.JToggleButton jToggleButton21;
    private javax.swing.JToggleButton jToggleButton22;
    private javax.swing.JToggleButton jToggleButton23;
    private javax.swing.JToggleButton jToggleButton24;
    private javax.swing.JToggleButton jToggleButton25;
    private javax.swing.JToggleButton jToggleButton26;
    private javax.swing.JToggleButton jToggleButton27;
    private javax.swing.JToggleButton jToggleButton28;
    private javax.swing.JToggleButton jToggleButton29;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton30;
    private javax.swing.JToggleButton jToggleButton31;
    private javax.swing.JToggleButton jToggleButton32;
    private javax.swing.JToggleButton jToggleButton33;
    private javax.swing.JToggleButton jToggleButton34;
    private javax.swing.JToggleButton jToggleButton35;
    private javax.swing.JToggleButton jToggleButton36;
    private javax.swing.JToggleButton jToggleButton37;
    private javax.swing.JToggleButton jToggleButton38;
    private javax.swing.JToggleButton jToggleButton39;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton40;
    private javax.swing.JToggleButton jToggleButton41;
    private javax.swing.JToggleButton jToggleButton42;
    private javax.swing.JToggleButton jToggleButton43;
    private javax.swing.JToggleButton jToggleButton44;
    private javax.swing.JToggleButton jToggleButton45;
    private javax.swing.JToggleButton jToggleButton46;
    private javax.swing.JToggleButton jToggleButton47;
    private javax.swing.JToggleButton jToggleButton48;
    private javax.swing.JToggleButton jToggleButton49;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton50;
    private javax.swing.JToggleButton jToggleButton51;
    private javax.swing.JToggleButton jToggleButton52;
    private javax.swing.JToggleButton jToggleButton53;
    private javax.swing.JToggleButton jToggleButton54;
    private javax.swing.JToggleButton jToggleButton55;
    private javax.swing.JToggleButton jToggleButton56;
    private javax.swing.JToggleButton jToggleButton57;
    private javax.swing.JToggleButton jToggleButton58;
    private javax.swing.JToggleButton jToggleButton59;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton60;
    private javax.swing.JToggleButton jToggleButton61;
    private javax.swing.JToggleButton jToggleButton62;
    private javax.swing.JToggleButton jToggleButton63;
    private javax.swing.JToggleButton jToggleButton64;
    private javax.swing.JToggleButton jToggleButton65;
    private javax.swing.JToggleButton jToggleButton66;
    private javax.swing.JToggleButton jToggleButton67;
    private javax.swing.JToggleButton jToggleButton68;
    private javax.swing.JToggleButton jToggleButton69;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton70;
    private javax.swing.JToggleButton jToggleButton71;
    private javax.swing.JToggleButton jToggleButton72;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    private javax.swing.JButton ok;
    private javax.swing.JTextField time;
    private javax.swing.JTextField to;
    // End of variables declaration//GEN-END:variables

}
