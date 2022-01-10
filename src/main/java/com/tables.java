/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com;

import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

/**
 * @author ahmad
 */
public class tables extends javax.swing.JFrame {

    /**
     * Creates new form tables
     */
    public tables() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public boolean displayhotel() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/hotel", "root", "");
            System.out.println("connection done");
            Statement s = c.createStatement();
            var rs = s.executeQuery("SELECT * FROM `hotel` ORDER BY `ID`");
            try {
                hotelTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "please try again letter because " + e.getMessage());
                return false;
            }
            c.close();
            rs.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean displayRoom() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/hotel", "root", "");
            System.out.println("connection done");
            Statement s = c.createStatement();
            var rs = s.executeQuery("SELECT * FROM `room` ORDER BY `HotelID`");
            try {
                hotelTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "please try again letter because " + e.getMessage());
                return false;
            }
            c.close();
            rs.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean displayeEmp() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/hotel", "root", "");
            System.out.println("connection done");
            Statement s = c.createStatement();
            var rs = s.executeQuery("SELECT * FROM `employee` ORDER BY `HotelID` , `ID`");
            try {
                hotelTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "please try again letter because " + e.getMessage());
                return false;
            }
            c.close();
            rs.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean displayeCus() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/hotel", "root", "");
            System.out.println("connection done");
            Statement s = c.createStatement();
            var rs = s.executeQuery("SELECT * FROM `customer` ORDER BY `hotelID` ,`ID`");
            try {
                hotelTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "please try again letter because " + e.getMessage());
                return false;
            }
            c.close();
            rs.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean displayeRole() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/hotel", "root", "");
            System.out.println("connection done");
            Statement s = c.createStatement();
            var rs = s.executeQuery("SELECT * FROM `role`");
            try {
                hotelTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "please try again letter because " + e.getMessage());
                return false;
            }
            c.close();
            rs.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean displayeWork() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/hotel", "root", "");
            System.out.println("connection done");
            Statement s = c.createStatement();
            var rs = s.executeQuery("SELECT * FROM `working as`");
            try {
                hotelTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "please try again letter because " + e.getMessage());
                return false;
            }
            c.close();
            rs.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        hotelTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(hotelTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable hotelTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
