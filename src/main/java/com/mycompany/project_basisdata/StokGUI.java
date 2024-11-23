package com.mycompany.project_basisdata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class StokGUI extends JFrame {
    private JTextField textFieldNamaToko;
    private JTextField textFieldNoReg;
    private JButton buttonTampilkan;

    public StokGUI() {
        setTitle("Informasi Stok");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel labelNamaToko = new JLabel("Nama Toko:");
        textFieldNamaToko = new JTextField(20);
        JLabel labelNoReg = new JLabel("No Reg Obat:");
        textFieldNoReg = new JTextField(20);
        buttonTampilkan = new JButton("Tampilkan");

        panel.add(labelNamaToko);
        panel.add(textFieldNamaToko);
        panel.add(labelNoReg);
        panel.add(textFieldNoReg);
        panel.add(buttonTampilkan);
        add(panel);

        buttonTampilkan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String namaToko = textFieldNamaToko.getText();
                String noReg = textFieldNoReg.getText();
                tampilkanStok(namaToko, noReg);
            }
        });
    }

    public void tampilkanStok(String namaToko, String noReg) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT Stok FROM Memiliki WHERE ID_Apotek = ? AND No_reg = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, namaToko);
            preparedStatement.setString(2, noReg);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int stok = resultSet.getInt("Stok");
                JOptionPane.showMessageDialog(null, "Stok: " + stok);
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StokGUI().setVisible(true);
            }
        });
    }
}