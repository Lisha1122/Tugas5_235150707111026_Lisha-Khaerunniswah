/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guipemlan;

/**
 *
 * @author Lisha Khaerunniswah
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.io.*;
import java.util.*;

public class GUIPemlan {
    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("Form Pendataan Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Form Pendataan Mahasiswa"); // Set the title here
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout(10, 10));
        
         // Add title label
        JLabel titleLabel = new JLabel("DATA MAHASISWA", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);
        
        // Main panel with padding
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        // GridBagConstraints for layout control
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Components creation
        JLabel nameLabel = new JLabel("Nama Lengkap:");
        JTextField nameField = new JTextField(20);
        JLabel dateLabel = new JLabel("Tanggal Lahir:");
        JTextField dateField = new JTextField(20);
        JLabel nopendaftaranLabel = new JLabel("No. Pendaftaran:");
        JTextField nopendaftaranField = new JTextField(20);
        JLabel notelpLabel = new JLabel("No. Telpon:");
        JTextField notelpField = new JTextField(20);
        JLabel alamatLabel = new JLabel("Alamat:");
        JTextField alamatField = new JTextField(20);
        JLabel emailLabel = new JLabel("E-mail:");
        JTextField emailField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        
        // Set font
        Font font = new Font("Arial", Font.PLAIN, 14);
        nameLabel.setFont(font);
        dateLabel.setFont(font);
        nopendaftaranLabel.setFont(font);
        notelpLabel.setFont(font);
        alamatLabel.setFont(font);
        emailLabel.setFont(font);
        submitButton.setFont(font);

        // Adding components to main panel
        gbc.gridx = 0; gbc.gridy = 0; mainPanel.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; mainPanel.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; mainPanel.add(dateLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; mainPanel.add(dateField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; mainPanel.add(nopendaftaranLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; mainPanel.add(nopendaftaranField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; mainPanel.add(notelpLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; mainPanel.add(notelpField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; mainPanel.add(alamatLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; mainPanel.add(alamatField, gbc);
        gbc.gridx = 0; gbc.gridy = 5; mainPanel.add(emailLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5; mainPanel.add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 6; mainPanel.add(submitButton, gbc);

        // Add main panel to frame
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);

        // Submit button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if all fields are filled
                if (nameField.getText().isEmpty() || dateField.getText().isEmpty() || 
                    nopendaftaranField.getText().isEmpty() || notelpField.getText().isEmpty() || 
                    alamatField.getText().isEmpty() || emailField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Semua kolom harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    int response = JOptionPane.showConfirmDialog(frame, "Apakah anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
                    if (response == JOptionPane.OK_OPTION) {
                        JFrame resultFrame = new JFrame("Data Mahasiswa");
                        resultFrame.setSize(400, 400);
                        resultFrame.setLayout(new GridBagLayout());
                        
                                            
                        GridBagConstraints resultGbc = new GridBagConstraints();
                        resultGbc.insets = new Insets(5, 5, 5, 5);
                        resultGbc.fill = GridBagConstraints.HORIZONTAL;
                        
                      resultGbc.gridx = 0;
                        resultGbc.gridy = 0;
                        resultGbc.gridwidth = 2;
                        resultGbc.anchor = GridBagConstraints.CENTER;
                        resultFrame.add(new JLabel("DATA MAHASISWA", SwingConstants.CENTER), resultGbc);
                        
                        resultGbc.gridwidth = 1; 
                        resultGbc.anchor = GridBagConstraints.WEST; 

                        resultGbc.gridx = 0;
                        resultGbc.gridy = 1;
                        resultFrame.add(new JLabel("Nama Lengkap: " + nameField.getText()), resultGbc);
                        resultGbc.gridx = 0;
                        resultGbc.gridy = 2;
                        resultFrame.add(new JLabel("Tanggal Lahir: " + dateField.getText()), resultGbc);
                        resultGbc.gridx = 0;
                        resultGbc.gridy = 3;
                        resultFrame.add(new JLabel("No. Pendaftaran: " + nopendaftaranField.getText()), resultGbc);
                        resultGbc.gridx = 0;
                        resultGbc.gridy = 4;
                        resultFrame.add(new JLabel("No. Telp: " + notelpField.getText()), resultGbc);
                        resultGbc.gridx = 0;
                        resultGbc.gridy = 5;
                        resultFrame.add(new JLabel("Alamat: " + alamatField.getText()), resultGbc);
                        resultGbc.gridx = 0;
                        resultGbc.gridy = 6;
                        resultFrame.add(new JLabel("Email: " + emailField.getText()), resultGbc);
                        
                        // Menambahkan tombol OK
                        JButton okButton = new JButton("OK");
                        okButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                resultFrame.dispose();
                            }
                        });

                        resultGbc.gridx = 0; resultGbc.gridy = 7; resultGbc.gridwidth = 2; resultGbc.anchor = GridBagConstraints.CENTER;
                        resultFrame.add(okButton, resultGbc);

                        resultFrame.setLocationRelativeTo(frame);                        
                        resultFrame.setVisible(true);
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}

