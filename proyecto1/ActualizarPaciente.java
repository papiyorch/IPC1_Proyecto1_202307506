/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Yorch
 */
public class ActualizarPaciente extends JFrame implements ActionListener {
    private JTextField codigoPacienteTxt;
    private JTextField nombrePacienteTxtA;
    private JTextField apellidoPacienteTxtA;
    private JTextField edadPacienteTxtA;
    private JPasswordField passwordPacienteTxtA;
    private JComboBox generoPacienteBoxA;
    private JButton registrarPacienteBtnA;
    
    public ActualizarPaciente(){
          this.setTitle("Crear Doctor");
        this.setSize(800,350);
        
        JPanel actualizarPacientePanel = new JPanel();
        actualizarPacientePanel.setSize(800,350);
        actualizarPacientePanel.setLayout(null);
        
        JLabel actualizarPaciente = new JLabel("Actualizar Paciente");
        actualizarPaciente.setBounds(30, 10, 180, 50);
        this.add(actualizarPaciente);
        
        JLabel codigoPacienteA = new JLabel("Código");
        codigoPacienteA.setBounds(30, 45, 80, 50);
        codigoPacienteTxt = new JTextField();
        codigoPacienteTxt.setBounds(110, 55, 180, 30);
        this.add(codigoPacienteA);
        this.add(codigoPacienteTxt);
        
        JLabel nombrePacienteA = new JLabel("Nombres");
        nombrePacienteA.setBounds(30, 90, 80, 50);
        nombrePacienteTxtA = new JTextField();
        nombrePacienteTxtA.setBounds(110, 100, 180, 30);
        this.add(nombrePacienteA);
        this.add(nombrePacienteTxtA);
        
        JLabel apellidoPacienteA = new JLabel("Apellidos");
        apellidoPacienteA.setBounds(30, 135, 80, 50);
        apellidoPacienteTxtA = new JTextField();
        apellidoPacienteTxtA.setBounds(110, 145, 180, 30);
        this.add(apellidoPacienteA);
        this.add(apellidoPacienteTxtA);
         
        JLabel passwordPacienteA = new JLabel("Password");
        passwordPacienteA.setBounds(30, 180, 80, 50);
        passwordPacienteTxtA = new JPasswordField();
        passwordPacienteTxtA.setBounds(110, 190, 180, 30);
        this.add(passwordPacienteA);
        this.add(passwordPacienteTxtA);
        
        JLabel generoPacienteA = new JLabel("Género");
        generoPacienteA.setBounds(380, 90, 80, 50);
        generoPacienteBoxA = new JComboBox();
        generoPacienteBoxA.addItem("");
        generoPacienteBoxA.addItem("Masculino");
        generoPacienteBoxA.addItem("Femenino");
        generoPacienteBoxA.setBounds(480 , 100, 180, 30);
        this.add(generoPacienteA);
        this.add(generoPacienteBoxA);
         
        JLabel edadPacienteA = new JLabel("Edad");
        edadPacienteA.setBounds(380, 135, 80, 50);
        edadPacienteTxtA = new JTextField();
        edadPacienteTxtA.setBounds(480, 145, 180, 30);
        this.add(edadPacienteA);
        this.add(edadPacienteTxtA); 
        
        registrarPacienteBtnA = new JButton("Actualizar");
        registrarPacienteBtnA.setBounds(480, 190, 180, 30);
        this.add(registrarPacienteBtnA);
        registrarPacienteBtnA.addActionListener(this);
        
        this.add(actualizarPacientePanel);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String codigoA = codigoPacienteTxt.getText();
        String nombreA = nombrePacienteTxtA.getText();
        String apellidoA = apellidoPacienteTxtA.getText();
        char[] passwordA = passwordPacienteTxtA.getPassword();
        Object generoA = generoPacienteBoxA.getSelectedItem();
        String edadA = edadPacienteTxtA.getText();
        
        if(e.getActionCommand().equals("Actualizar")){
            if (!nombreA.isEmpty() && !apellidoA.isEmpty() && passwordA.length != 0 && generoA != null && !edadA.isEmpty()){
               for(NuevoPaciente pacienteActualizado : NuevoPaciente.Pacientes){
                if(codigoA.equals(String.valueOf(pacienteActualizado.getCodePatient()))){
                    pacienteActualizado.setNamePatient(nombreA);
                    pacienteActualizado.setLastNamePatient(apellidoA);
                    pacienteActualizado.setPasswordPatient(passwordA);
                    pacienteActualizado.setGenderPatient(generoA);
                    pacienteActualizado.setAgePatient(edadA); 
                    JOptionPane.showMessageDialog(null, "Se actualizó el paciente correctamente");
                    VistaAdmin ventanaAdmin = new VistaAdmin();
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encuentra o no existe el paciente");       
                }
                }
          }else{
            JOptionPane.showMessageDialog(null, "Hay campos vació, favor de llenarlos.");  
            }
        }
    }
}
