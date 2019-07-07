/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
package Admin;

import Includes.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class FullReview extends javax.swing.JFrame {

    private String adminUsername;
    private String busName, busNumber, numberOfSeats, transportLicenseNumber, hotline, seats;
    private Connection con;
    private ResultSet rs;
    private JToggleButton[][] busSeats;
    private boolean newBus = false;

    /**
     * Creates new form ViewBusForBooking
     *
     * @param args
     */
    public FullReview(String username, String[] args) {
        adminUsername = username;
        initWindow();
        if (args.length == 6) {
            busName = args[0];
            busNumber = args[1];
            numberOfSeats = args[2];
            transportLicenseNumber = args[3];
            hotline = args[4];
            seats = args[5];
            initTextFields(null);
            newBus = true;
        } else if (args.length == 3) {
            busNumber = args[0];
            numberOfSeats = args[1];
            seats = args[2];
            initTextFields(busNumber);
            newBus = false;
        }
        initBusSeats();
    }

    private void initWindow() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(890, 570);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void initBusSeats() {
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
                busSeats[i][j].setEnabled(false);
            }
        }

        String seatConfig[] = null;
        seatConfig = seats.split("/");
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
    }

    private void initTextFields(String busNumber) {
        if (busNumber != null) {
            try {
                con = Database.getConnected();
                String query = "SELECT * FROM `bus_data` WHERE bus_number='" + busNumber + "'";
                rs = Database.executeQuery(con, query);
                while (rs.next()) {
                    busNameGUI.setText(rs.getString(1));
                    busNumberGUI.setText(busNumber);
                    numberOfSeatsGUI.setText(numberOfSeats);
                    transpoerLicenseNumberGUI.setText(rs.getString(4));
                    hotlineGUI.setText(rs.getString(5));
                }
                Database.disconnect(con);
            } catch (SQLException | ClassNotFoundException ex) {
            }
        } else {
            busNameGUI.setText(this.busName);
            busNumberGUI.setText(this.busNumber);
            numberOfSeatsGUI.setText(this.numberOfSeats);
            transpoerLicenseNumberGUI.setText(this.transportLicenseNumber);
            hotlineGUI.setText(this.hotline);
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

        busNameGUI = new javax.swing.JTextField();
        busNumberGUI = new javax.swing.JTextField();
        numberOfSeatsGUI = new javax.swing.JTextField();
        transpoerLicenseNumberGUI = new javax.swing.JTextField();
        hotlineGUI = new javax.swing.JTextField();
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
        ok = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        busNameGUI.setEditable(false);
        busNameGUI.setBackground(new java.awt.Color(0, 255, 255));
        busNameGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busNameGUIActionPerformed(evt);
            }
        });
        getContentPane().add(busNameGUI);
        busNameGUI.setBounds(180, 20, 680, 33);

        busNumberGUI.setEditable(false);
        busNumberGUI.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(busNumberGUI);
        busNumberGUI.setBounds(180, 60, 680, 31);

        numberOfSeatsGUI.setEditable(false);
        numberOfSeatsGUI.setBackground(new java.awt.Color(0, 255, 255));
        getContentPane().add(numberOfSeatsGUI);
        numberOfSeatsGUI.setBounds(180, 100, 680, 30);

        transpoerLicenseNumberGUI.setEditable(false);
        transpoerLicenseNumberGUI.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(transpoerLicenseNumberGUI);
        transpoerLicenseNumberGUI.setBounds(180, 140, 680, 31);

        hotlineGUI.setEditable(false);
        hotlineGUI.setBackground(new java.awt.Color(0, 255, 255));
        getContentPane().add(hotlineGUI);
        hotlineGUI.setBounds(180, 180, 680, 33);

        jToggleButton7.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton7.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton7.setText("?");
        jToggleButton7.setToolTipText("");
        jToggleButton7.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton7);
        jToggleButton7.setBounds(110, 440, 50, 35);

        jToggleButton8.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton8.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton8.setText("?");
        jToggleButton8.setToolTipText("");
        jToggleButton8.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton8);
        jToggleButton8.setBounds(110, 400, 50, 35);

        jToggleButton9.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton9.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton9.setText("?");
        jToggleButton9.setToolTipText("");
        jToggleButton9.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton9);
        jToggleButton9.setBounds(110, 360, 50, 35);

        jToggleButton10.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton10.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton10.setText("?");
        jToggleButton10.setToolTipText("");
        jToggleButton10.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton10);
        jToggleButton10.setBounds(110, 320, 50, 35);

        jToggleButton11.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton11.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton11.setText("?");
        jToggleButton11.setToolTipText("");
        jToggleButton11.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton11);
        jToggleButton11.setBounds(110, 280, 50, 35);

        jToggleButton12.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton12.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton12.setText("?");
        jToggleButton12.setToolTipText("");
        jToggleButton12.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton12);
        jToggleButton12.setBounds(110, 240, 50, 35);

        jToggleButton13.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton13.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton13.setText("?");
        jToggleButton13.setToolTipText("");
        jToggleButton13.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton13);
        jToggleButton13.setBounds(180, 440, 50, 35);

        jToggleButton14.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton14.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton14.setText("?");
        jToggleButton14.setToolTipText("");
        jToggleButton14.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton14);
        jToggleButton14.setBounds(180, 400, 50, 35);

        jToggleButton15.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton15.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton15.setText("?");
        jToggleButton15.setToolTipText("");
        jToggleButton15.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton15);
        jToggleButton15.setBounds(180, 360, 50, 35);

        jToggleButton16.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton16.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton16.setText("?");
        jToggleButton16.setToolTipText("");
        jToggleButton16.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton16);
        jToggleButton16.setBounds(180, 320, 50, 35);

        jToggleButton17.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton17.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton17.setText("?");
        jToggleButton17.setToolTipText("");
        jToggleButton17.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton17);
        jToggleButton17.setBounds(180, 280, 50, 35);

        jToggleButton18.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton18.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton18.setText("?");
        jToggleButton18.setToolTipText("");
        jToggleButton18.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton18);
        jToggleButton18.setBounds(180, 240, 50, 35);

        jToggleButton19.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton19.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton19.setText("?");
        jToggleButton19.setToolTipText("");
        jToggleButton19.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton19);
        jToggleButton19.setBounds(250, 440, 50, 35);

        jToggleButton20.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton20.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton20.setText("?");
        jToggleButton20.setToolTipText("");
        jToggleButton20.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton20);
        jToggleButton20.setBounds(250, 400, 50, 35);

        jToggleButton21.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton21.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton21.setText("?");
        jToggleButton21.setToolTipText("");
        jToggleButton21.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton21);
        jToggleButton21.setBounds(250, 360, 50, 35);

        jToggleButton22.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton22.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton22.setText("?");
        jToggleButton22.setToolTipText("");
        jToggleButton22.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton22);
        jToggleButton22.setBounds(250, 320, 50, 35);

        jToggleButton23.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton23.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton23.setText("?");
        jToggleButton23.setToolTipText("");
        jToggleButton23.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton23);
        jToggleButton23.setBounds(250, 280, 50, 35);

        jToggleButton24.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton24.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton24.setText("?");
        jToggleButton24.setToolTipText("");
        jToggleButton24.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton24);
        jToggleButton24.setBounds(250, 240, 50, 35);

        jToggleButton25.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton25.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton25.setText("?");
        jToggleButton25.setToolTipText("");
        jToggleButton25.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton25);
        jToggleButton25.setBounds(320, 440, 50, 35);

        jToggleButton26.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton26.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton26.setText("?");
        jToggleButton26.setToolTipText("");
        jToggleButton26.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton26);
        jToggleButton26.setBounds(320, 400, 50, 35);

        jToggleButton27.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton27.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton27.setText("?");
        jToggleButton27.setToolTipText("");
        jToggleButton27.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton27);
        jToggleButton27.setBounds(320, 360, 50, 35);

        jToggleButton28.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton28.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton28.setText("?");
        jToggleButton28.setToolTipText("");
        jToggleButton28.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton28);
        jToggleButton28.setBounds(320, 320, 50, 35);

        jToggleButton29.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton29.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton29.setText("?");
        jToggleButton29.setToolTipText("");
        jToggleButton29.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton29);
        jToggleButton29.setBounds(320, 280, 50, 35);

        jToggleButton30.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton30.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton30.setText("?");
        jToggleButton30.setToolTipText("");
        jToggleButton30.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton30);
        jToggleButton30.setBounds(320, 240, 50, 35);

        jToggleButton31.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton31.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton31.setText("?");
        jToggleButton31.setToolTipText("");
        jToggleButton31.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton31);
        jToggleButton31.setBounds(390, 440, 50, 35);

        jToggleButton32.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton32.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton32.setText("?");
        jToggleButton32.setToolTipText("");
        jToggleButton32.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton32);
        jToggleButton32.setBounds(390, 400, 50, 35);

        jToggleButton33.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton33.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton33.setText("?");
        jToggleButton33.setToolTipText("");
        jToggleButton33.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton33);
        jToggleButton33.setBounds(390, 360, 50, 35);

        jToggleButton34.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton34.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton34.setText("?");
        jToggleButton34.setToolTipText("");
        jToggleButton34.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton34);
        jToggleButton34.setBounds(390, 320, 50, 35);

        jToggleButton35.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton35.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton35.setText("?");
        jToggleButton35.setToolTipText("");
        jToggleButton35.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton35);
        jToggleButton35.setBounds(390, 280, 50, 35);

        jToggleButton36.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton36.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton36.setText("?");
        jToggleButton36.setToolTipText("");
        jToggleButton36.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton36);
        jToggleButton36.setBounds(390, 240, 50, 35);

        jToggleButton37.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton37.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton37.setText("?");
        jToggleButton37.setToolTipText("");
        jToggleButton37.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton37);
        jToggleButton37.setBounds(460, 440, 50, 35);

        jToggleButton38.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton38.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton38.setText("?");
        jToggleButton38.setToolTipText("");
        jToggleButton38.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton38);
        jToggleButton38.setBounds(460, 400, 50, 35);

        jToggleButton39.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton39.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton39.setText("?");
        jToggleButton39.setToolTipText("");
        jToggleButton39.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton39);
        jToggleButton39.setBounds(460, 360, 50, 35);

        jToggleButton40.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton40.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton40.setText("?");
        jToggleButton40.setToolTipText("");
        jToggleButton40.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton40);
        jToggleButton40.setBounds(460, 320, 50, 35);

        jToggleButton41.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton41.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton41.setText("?");
        jToggleButton41.setToolTipText("");
        jToggleButton41.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton41);
        jToggleButton41.setBounds(460, 280, 50, 35);

        jToggleButton42.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton42.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton42.setText("?");
        jToggleButton42.setToolTipText("");
        jToggleButton42.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton42);
        jToggleButton42.setBounds(460, 240, 50, 35);

        jToggleButton43.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton43.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton43.setText("?");
        jToggleButton43.setToolTipText("");
        jToggleButton43.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton43);
        jToggleButton43.setBounds(530, 440, 50, 35);

        jToggleButton44.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton44.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton44.setText("?");
        jToggleButton44.setToolTipText("");
        jToggleButton44.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton44);
        jToggleButton44.setBounds(530, 400, 50, 35);

        jToggleButton45.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton45.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton45.setText("?");
        jToggleButton45.setToolTipText("");
        jToggleButton45.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton45);
        jToggleButton45.setBounds(530, 360, 50, 35);

        jToggleButton46.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton46.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton46.setText("?");
        jToggleButton46.setToolTipText("");
        jToggleButton46.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton46);
        jToggleButton46.setBounds(530, 320, 50, 35);

        jToggleButton47.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton47.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton47.setText("?");
        jToggleButton47.setToolTipText("");
        jToggleButton47.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton47);
        jToggleButton47.setBounds(530, 280, 50, 35);

        jToggleButton48.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton48.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton48.setText("?");
        jToggleButton48.setToolTipText("");
        jToggleButton48.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton48);
        jToggleButton48.setBounds(530, 240, 50, 35);

        jToggleButton49.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton49.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton49.setText("?");
        jToggleButton49.setToolTipText("");
        jToggleButton49.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton49);
        jToggleButton49.setBounds(600, 440, 50, 35);

        jToggleButton50.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton50.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton50.setText("?");
        jToggleButton50.setToolTipText("");
        jToggleButton50.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton50);
        jToggleButton50.setBounds(600, 400, 50, 35);

        jToggleButton51.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton51.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton51.setText("?");
        jToggleButton51.setToolTipText("");
        jToggleButton51.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton51);
        jToggleButton51.setBounds(600, 360, 50, 35);

        jToggleButton52.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton52.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton52.setText("?");
        jToggleButton52.setToolTipText("");
        jToggleButton52.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton52);
        jToggleButton52.setBounds(600, 320, 50, 35);

        jToggleButton53.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton53.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton53.setText("?");
        jToggleButton53.setToolTipText("");
        jToggleButton53.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton53);
        jToggleButton53.setBounds(600, 280, 50, 35);

        jToggleButton54.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton54.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton54.setText("?");
        jToggleButton54.setToolTipText("");
        jToggleButton54.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton54);
        jToggleButton54.setBounds(600, 240, 50, 35);

        jToggleButton55.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton55.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton55.setText("?");
        jToggleButton55.setToolTipText("");
        jToggleButton55.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton55);
        jToggleButton55.setBounds(670, 440, 50, 35);

        jToggleButton56.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton56.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton56.setText("?");
        jToggleButton56.setToolTipText("");
        jToggleButton56.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton56);
        jToggleButton56.setBounds(670, 400, 50, 35);

        jToggleButton57.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton57.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton57.setText("?");
        jToggleButton57.setToolTipText("");
        jToggleButton57.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton57);
        jToggleButton57.setBounds(670, 360, 50, 35);

        jToggleButton58.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton58.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton58.setText("?");
        jToggleButton58.setToolTipText("");
        jToggleButton58.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton58);
        jToggleButton58.setBounds(670, 320, 50, 35);

        jToggleButton59.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton59.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton59.setText("?");
        jToggleButton59.setToolTipText("");
        jToggleButton59.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton59);
        jToggleButton59.setBounds(670, 280, 50, 35);

        jToggleButton60.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton60.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton60.setText("?");
        jToggleButton60.setToolTipText("");
        jToggleButton60.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton60);
        jToggleButton60.setBounds(670, 240, 50, 35);

        jToggleButton61.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton61.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton61.setText("?");
        jToggleButton61.setToolTipText("");
        jToggleButton61.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton61);
        jToggleButton61.setBounds(740, 440, 50, 35);

        jToggleButton62.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton62.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton62.setText("?");
        jToggleButton62.setToolTipText("");
        jToggleButton62.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton62);
        jToggleButton62.setBounds(740, 400, 50, 35);

        jToggleButton63.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton63.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton63.setText("?");
        jToggleButton63.setToolTipText("");
        jToggleButton63.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton63);
        jToggleButton63.setBounds(740, 360, 50, 35);

        jToggleButton64.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton64.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton64.setText("?");
        jToggleButton64.setToolTipText("");
        jToggleButton64.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton64);
        jToggleButton64.setBounds(740, 320, 50, 35);

        jToggleButton65.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton65.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton65.setText("?");
        jToggleButton65.setToolTipText("");
        jToggleButton65.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton65);
        jToggleButton65.setBounds(740, 280, 50, 35);

        jToggleButton66.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton66.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton66.setText("?");
        jToggleButton66.setToolTipText("");
        jToggleButton66.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton66);
        jToggleButton66.setBounds(740, 240, 50, 35);

        jToggleButton67.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton67.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton67.setText("?");
        jToggleButton67.setToolTipText("");
        jToggleButton67.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton67);
        jToggleButton67.setBounds(810, 440, 50, 35);

        jToggleButton68.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton68.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton68.setText("?");
        jToggleButton68.setToolTipText("");
        jToggleButton68.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton68);
        jToggleButton68.setBounds(810, 400, 50, 35);

        jToggleButton69.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton69.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton69.setText("?");
        jToggleButton69.setToolTipText("");
        jToggleButton69.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton69);
        jToggleButton69.setBounds(810, 360, 50, 35);

        jToggleButton70.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton70.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton70.setText("?");
        jToggleButton70.setToolTipText("");
        jToggleButton70.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton70);
        jToggleButton70.setBounds(810, 320, 50, 35);

        jToggleButton71.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton71.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton71.setText("?");
        jToggleButton71.setToolTipText("");
        jToggleButton71.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton71);
        jToggleButton71.setBounds(810, 280, 50, 35);

        jToggleButton72.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton72.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton72.setText("?");
        jToggleButton72.setToolTipText("");
        jToggleButton72.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton72);
        jToggleButton72.setBounds(810, 240, 50, 35);

        jToggleButton1.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton1.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton1.setText("?");
        jToggleButton1.setToolTipText("");
        jToggleButton1.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(40, 440, 50, 35);

        jToggleButton2.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton2.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton2.setText("?");
        jToggleButton2.setToolTipText("");
        jToggleButton2.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton2);
        jToggleButton2.setBounds(40, 400, 50, 35);

        jToggleButton3.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton3.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton3.setText("?");
        jToggleButton3.setToolTipText("");
        jToggleButton3.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton3);
        jToggleButton3.setBounds(40, 360, 50, 35);

        jToggleButton4.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton4.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton4.setText("?");
        jToggleButton4.setToolTipText("");
        jToggleButton4.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton4);
        jToggleButton4.setBounds(40, 320, 50, 35);

        jToggleButton5.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton5.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton5.setText("?");
        jToggleButton5.setToolTipText("");
        jToggleButton5.setPreferredSize(new java.awt.Dimension(50, 35));
        getContentPane().add(jToggleButton5);
        jToggleButton5.setBounds(40, 280, 50, 35);

        jToggleButton6.setBackground(new java.awt.Color(0, 51, 153));
        jToggleButton6.setForeground(new java.awt.Color(0, 255, 255));
        jToggleButton6.setText("?");
        jToggleButton6.setToolTipText("");
        jToggleButton6.setPreferredSize(new java.awt.Dimension(50, 35));
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton6);
        jToggleButton6.setBounds(40, 240, 50, 35);

        ok.setBackground(new java.awt.Color(0, 51, 153));
        ok.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ok.setForeground(new java.awt.Color(0, 255, 255));
        ok.setText("OK");
        ok.setToolTipText("");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok);
        ok.setBounds(760, 500, 100, 30);

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
        back.setBounds(40, 490, 100, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bus Name               :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 20, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bus Number            :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 60, 140, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seats                      :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 100, 140, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("License Number      :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 140, 140, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hotline                    :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 180, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/125.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 890, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        if (newBus) {
            String[] args = {busName, busNumber, numberOfSeats, transportLicenseNumber, hotline, seats};
            Seat x = new Seat(adminUsername, args);
            x.setVisible(true);
            x.setSize(this.getSize());
            this.setVisible(false);
        } else {
            String[] args = {busNumber, seats};
            Seat x = new Seat(adminUsername, args);
            x.setVisible(true);
            x.setSize(this.getSize());
            this.setVisible(false);
        }
    }//GEN-LAST:event_backActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        if (newBus) {
            int numberOfSeatsInt = Integer.parseInt(numberOfSeats);
            int hotlineInt = Integer.parseInt(hotline);
            try {
                addNewBus(busName, busNumber, numberOfSeatsInt, transportLicenseNumber,
                        hotlineInt, seats);
            } catch (SQLException | ClassNotFoundException ex) {
            }
            JOptionPane.showMessageDialog(this, "Your new bus was added succesfully");
        } else {
            int numberOfSeatsInt = Integer.parseInt(numberOfSeats);
            try {
                editBusSeats(busNumber, numberOfSeatsInt, seats);
            } catch (SQLException | ClassNotFoundException ex) {
            }
            JOptionPane.showMessageDialog(this, "Edit data on " + busNumber + " was succesfull");
        }
        Services x = new Services(adminUsername);
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_okActionPerformed

    private void busNameGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busNameGUIActionPerformed

    }//GEN-LAST:event_busNameGUIActionPerformed

    private void addNewBus(String busName, String busNumber, int numberOfSeats,
            String transportLicenseNumber, int hotline, String seatList)
            throws SQLException, ClassNotFoundException {

        Connection con;
        con = Database.getConnected();
        String query = "INSERT INTO bus_data "
                + "(bus_name, bus_number, number_of_seats, transport_license_number, hotlint, seat_configuration) "
                + "VALUES ("
                + "'" + busName + "'" + ", "
                + "'" + busNumber.toUpperCase() + "'" + ", "
                + numberOfSeats + ", "
                + "'" + transportLicenseNumber + "'" + ", "
                + hotline + ", "
                + "'" + seatList + "'"
                + ")";
        Database.updateQuery(con, query);
        Database.disconnect(con);
    }

    private void editBusSeats(String busNumber, int numberOfSeats, String seatList)
            throws SQLException, ClassNotFoundException {
        con = Database.getConnected();
        String query = "UPDATE `bus_data` SET `seat_configuration`='" + seatList
                + "', `number_of_seats`=" + numberOfSeats + " WHERE bus_number='" + busNumber + "'";
        Database.updateQuery(con, query);
        Database.disconnect(con);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField busNameGUI;
    private javax.swing.JTextField busNumberGUI;
    private javax.swing.JTextField hotlineGUI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTextField numberOfSeatsGUI;
    private javax.swing.JButton ok;
    private javax.swing.JTextField transpoerLicenseNumberGUI;
    // End of variables declaration//GEN-END:variables

}
