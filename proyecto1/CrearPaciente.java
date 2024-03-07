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
public class CrearPaciente extends JFrame implements ActionListener {
    private JTextField nombrePacienteTxt;
    private JTextField apellidoPacienteTxt;
    private JTextField edadPacienteTxt;
    private JPasswordField passwordPacienteTxt;
    private JComboBox generoPacienteBox;
    private JButton registrarPacienteBtn;
    
    public CrearPaciente(){
        this.setTitle("Crear Doctor");
        this.setSize(800,350);
        
        JPanel crearPacientePanel = new JPanel();
        crearPacientePanel.setSize(800,350);
        crearPacientePanel.setLayout(null);
        
        JLabel registroPaciente = new JLabel("Registro Paciente");
        registroPaciente.setBounds(30, 25, 180, 50);
        this.add(registroPaciente);
        
        JLabel nombrePaciente = new JLabel("Nombres");
        nombrePaciente.setBounds(30, 90, 80, 50);
        nombrePacienteTxt = new JTextField();
        nombrePacienteTxt.setBounds(110, 100, 180, 30);
        this.add(nombrePaciente);
        this.add(nombrePacienteTxt);
        
        JLabel apellidoPaciente = new JLabel("Apellidos");
        apellidoPaciente.setBounds(30, 135, 80, 50);
        apellidoPacienteTxt = new JTextField();
        apellidoPacienteTxt.setBounds(110, 145, 180, 30);
        this.add(apellidoPaciente);
        this.add(apellidoPacienteTxt);
         
        JLabel passwordPaciente = new JLabel("Password");
        passwordPaciente.setBounds(30, 180, 80, 50);
        passwordPacienteTxt = new JPasswordField();
        passwordPacienteTxt.setBounds(110, 190, 180, 30);
        this.add(passwordPaciente);
        this.add(passwordPacienteTxt);
        
        JLabel generoPaciente = new JLabel("Género");
        generoPaciente.setBounds(380, 90, 80, 50);
        generoPacienteBox = new JComboBox();
        generoPacienteBox.addItem("");
        generoPacienteBox.addItem("Masculino");
        generoPacienteBox.addItem("Femenino");
        generoPacienteBox.setBounds(480 , 100, 180, 30);
        this.add(generoPaciente);
        this.add(generoPacienteBox);
         
        JLabel edadPaciente = new JLabel("Edad");
        edadPaciente.setBounds(380, 135, 80, 50);
        edadPacienteTxt = new JTextField();
        edadPacienteTxt.setBounds(480, 145, 180, 30);
        this.add(edadPaciente);
        this.add(edadPacienteTxt);
        
        registrarPacienteBtn = new JButton("Registrar");
        registrarPacienteBtn.setBounds(480, 190, 180, 30);
        this.add(registrarPacienteBtn);
        registrarPacienteBtn.addActionListener(this);
        
        this.add(crearPacientePanel);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombrePaciente = nombrePacienteTxt.getText();
        String apellidoPaciente = apellidoPacienteTxt.getText();
        char [] contraseñaPaciente = passwordPacienteTxt.getPassword();
        Object generoPaciente = generoPacienteBox.getSelectedItem();
        String edadPaciente = edadPacienteTxt.getText();
        
          if (e.getActionCommand().equals("Registrar")){      
            if (!nombrePaciente.isEmpty() && !apellidoPaciente.isEmpty() && contraseñaPaciente.length != 0 && generoPaciente != null && !edadPaciente.isEmpty()){
                NuevoPaciente.registrarPciente(NuevoPaciente.codigo,nombrePaciente, apellidoPaciente, edadPaciente, generoPaciente, contraseñaPaciente);
                NuevoPaciente.codigo++;
                JOptionPane.showMessageDialog(null, "Se registró el Paciente de manera exitosa, su código es:  " + NuevoPaciente.codigo);          
                //System.out.println(nuevoPaciente);
                VistaAdmin ventanaAdmin = new VistaAdmin();
                this.setVisible(false);
            }else{ 
                JOptionPane.showMessageDialog(null, "Hay campos vacíos, por favor llenarlos.");
                
            }            
        }
    }
    
}
