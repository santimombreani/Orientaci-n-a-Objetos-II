package TP4EJERCICIO1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class AgregarParticipante extends JFrame {
    private ParticipanteService service;
    private JTextField nombre, telefono, region;

    public AgregarParticipante(ParticipanteService service) {
        this.service = service;
        setupUIComponents();
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nombre   = new JTextField(10);
        telefono = new JTextField(10);
        region   = new JTextField(10);
        region.setText("China");

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
        panel.add(new JLabel("Nombre: "));   panel.add(nombre);
        panel.add(new JLabel("Telefono: ")); panel.add(telefono);
        panel.add(new JLabel("Region: "));   panel.add(region);

        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(e -> onBotonCargar());
        panel.add(botonCargar);

        setContentPane(panel);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() {
        try {
            service.agregarParticipante(
                    nombre.getText(), telefono.getText(), region.getText()
            );
            dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage());
        }
    }
}