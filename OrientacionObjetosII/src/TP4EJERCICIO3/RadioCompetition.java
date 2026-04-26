package TP4EJERCICIO3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RadioCompetition {
    private JPanel contentPane;
    private JLabel lblName, lblLastName, lblId, lblPhone, lblEmail, lblCompetition;
    private JTextField txtName, txtLastName, txtId, txtPhone, txtEmail;
    private JComboBox<String> comboBox;
    private JButton btnOk;
    private ConcursoService service;
    private List<Concurso> concursos;

    public RadioCompetition(ConcursoService service) {
        this.service = service;
        var frame = new JFrame("Inscription to Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements();
        layout();
        frame.setVisible(true);
    }

    private void formElements() {
        lblName = new JLabel("Nombre:");
        txtName = new JTextField();
        txtName.setColumns(10);
        lblLastName = new JLabel("Apellido:");
        txtLastName = new JTextField();
        txtLastName.setColumns(10);
        lblId = new JLabel("Dni:");
        txtId = new JTextField();
        txtId.setColumns(10);
        lblPhone = new JLabel("Telefono:");
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOk.setEnabled(false);
                saveInscription();
                btnOk.setEnabled(true);
            }
        });
        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<String>();
        todosLosConcursos();
    }

    private void todosLosConcursos() {
        try {
            concursos = service.obtenerConcursosAbiertos();
            comboBox.addItem("Seleccione un concurso");
            for (Concurso c : concursos) {
                comboBox.addItem(c.getNombre());
            }
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(contentPane, "Error al cargar concursos");
        }
    }

    private void saveInscription() {
        if (validations()) {
            try {
                int indice = comboBox.getSelectedIndex() - 1;
                int idConcurso = concursos.get(indice).getId();
                service.inscribir(
                        txtName.getText(),
                        txtLastName.getText(),
                        txtPhone.getText(),
                        txtEmail.getText(),
                        idConcurso
                );
                JOptionPane.showMessageDialog(contentPane, "Inscripcion exitosa!");
            } catch (IOException | SQLException e) {
                JOptionPane.showMessageDialog(contentPane, "Error al guardar inscripcion");
            }
        }
    }

    private boolean validations() {
        if ("".equals(txtName.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Nombre no puede ser vacio");
            return false;
        }
        if ("".equals(txtLastName.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Apellido no puede ser vacio");
            return false;
        }
        if ("".equals(txtId.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Dni no puede ser vacio");
            return false;
        }
        if (!checkEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Email debe ser valido");
            return false;
        }
        if (!checkPhone(txtPhone.getText())) {
            JOptionPane.showMessageDialog(contentPane, "El telefono debe ser: NNNN-NNNNNN");
            return false;
        }
        if (comboBox.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(contentPane, "Debe elegir un Concurso");
            return false;
        }
        return true;
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    private void layout() {
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane
                .createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(lblLastName).addComponent(lblId)
                                                .addComponent(lblPhone).addComponent(lblEmail)
                                                .addComponent(lblName).addComponent(lblCompetition))
                                        .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtEmail, Alignment.TRAILING)
                                                .addComponent(txtPhone, Alignment.TRAILING)
                                                .addComponent(txtId, Alignment.TRAILING)
                                                .addComponent(txtLastName, Alignment.TRAILING)
                                                .addComponent(txtName, Alignment.TRAILING,
                                                        GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                .addComponent(btnOk, Alignment.TRAILING,
                                        GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblLastName).addComponent(txtLastName,
                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                .addComponent(lblId).addComponent(txtId,
                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addComponent(lblPhone)
                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                        .addComponent(lblEmail))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCompetition))))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(btnOk)
                        .addContainerGap(67, Short.MAX_VALUE)));
        contentPane.setLayout(gl_contentPane);
    }
}