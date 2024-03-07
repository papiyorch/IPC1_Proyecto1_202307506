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
public class ActualizarDoc extends JFrame implements ActionListener{
    private JTextField cogidoDocTxtA;
    private JTextField nombreDocTxtA;
    private JTextField apellidoDocTxtA;
    private JPasswordField passwordDocPasA;
    private JComboBox generoDocBoxA;
    private JTextField especialidadDocTxtA;
    private JTextField telefonoDocTxtA;
    private JTextField edadDocTxtA;
    private JButton actualizarDocBtn;
        
    public ActualizarDoc(){
        this.setTitle("Actualizar Doctor");
        this.setSize(800,350);
        
        JPanel ActualizarDocPanel = new JPanel();
        ActualizarDocPanel.setSize(800,350);
        ActualizarDocPanel.setLayout(null);
        
        JLabel ActualizarDoc = new JLabel("Actualizar Doctor");
        ActualizarDoc.setBounds(30, 10, 100, 50);
        this.add(ActualizarDoc);
        
        JLabel codigoDocA = new JLabel("Código");
        codigoDocA.setBounds(30, 45, 80, 50);
        cogidoDocTxtA = new JTextField();
        cogidoDocTxtA.setBounds(110, 55, 180, 30);
        this.add(codigoDocA);
        this.add(cogidoDocTxtA);
        
        JLabel nombreDoc = new JLabel("Nombres");
        nombreDoc.setBounds(30, 90, 80, 50);
        nombreDocTxtA = new JTextField();
        nombreDocTxtA.setBounds(110, 100, 180, 30);
        this.add(nombreDoc);
        this.add(nombreDocTxtA);
        
        JLabel apellidoDoc = new JLabel("Apellidos");
        apellidoDoc.setBounds(30, 135, 80, 50);
        apellidoDocTxtA = new JTextField();
        apellidoDocTxtA.setBounds(110, 145, 180, 30);
        this.add(apellidoDoc);
        this.add(apellidoDocTxtA);
         
        JLabel passwordDoc = new JLabel("Password");
        passwordDoc.setBounds(30, 180, 80, 50);
        passwordDocPasA = new JPasswordField();
        passwordDocPasA.setBounds(110, 190, 180, 30);
        this.add(passwordDoc);
        this.add(passwordDocPasA);
        
        JLabel generoDoc = new JLabel("Género");
        generoDoc.setBounds(30, 225, 80, 50);
        generoDocBoxA = new JComboBox();
        generoDocBoxA.addItem("");
        generoDocBoxA.addItem("Masculino");
        generoDocBoxA.addItem("Femenino");
        generoDocBoxA.setBounds(135, 235, 153, 30);
        this.add(generoDoc);
        this.add(generoDocBoxA);
         
        JLabel especialidadDoc = new JLabel("Especialidad");
        especialidadDoc.setBounds(380, 90, 80, 50);
        especialidadDocTxtA = new JTextField();
        especialidadDocTxtA.setBounds(480 , 100, 180, 30);
        this.add(especialidadDoc);
        this.add(especialidadDocTxtA);
         
        JLabel telefonoDoc = new JLabel("Teléfono");
        telefonoDoc.setBounds(380, 135, 80, 50);
        telefonoDocTxtA = new JTextField();
        telefonoDocTxtA.setBounds(480, 145, 180, 30);
        this.add(telefonoDoc);
        this.add(telefonoDocTxtA);
         
        JLabel edadDoc = new JLabel("Edad");
        edadDoc.setBounds(380, 180, 80, 50);
        edadDocTxtA = new JPasswordField();
        edadDocTxtA.setBounds(480, 190, 180, 30);
        this.add(edadDoc);
        this.add(edadDocTxtA);
        
        actualizarDocBtn = new JButton("Actualizar");
        actualizarDocBtn.setBounds(500, 245, 130, 45);
        this.add(actualizarDocBtn);
        actualizarDocBtn.addActionListener(this);
        
        this.add(ActualizarDocPanel);
        this.setResizable(false);
        this.setVisible(true);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            String codigoA = cogidoDocTxtA.getText();
            String nombreA = nombreDocTxtA.getText();
            String apellidoA = apellidoDocTxtA.getText();
            char[] passwordA = passwordDocPasA.getPassword();
            Object generoA = generoDocBoxA.getSelectedItem();
            String especialidadA = especialidadDocTxtA.getText();
            String telefonoA = telefonoDocTxtA.getText();
            String edadA = edadDocTxtA.getText();
            if(e.getActionCommand().equals("Actualizar")){
                if(!nombreA.isEmpty() && !apellidoA.isEmpty() && passwordA.length != 0 && generoA != null && !especialidadA.isEmpty() && !telefonoA.isEmpty() && !edadA.isEmpty()){
                for(NuevoDoctor docActualizado : NuevoDoctor.Doctores){
                 if(codigoA.equals(String.valueOf(docActualizado.getCodigoDoc()))){
                    docActualizado.setNameDoc(nombreA);
                    docActualizado.setLastnameDoc(apellidoA);
                    docActualizado.setPasswordDoc(passwordA);
                    docActualizado.setGenderDoc(generoA);
                    docActualizado.setEspecialidadDoc(especialidadA);
                    docActualizado.setPhoneDoc(telefonoA);
                    docActualizado.setAgeDoc(edadA);
                    JOptionPane.showMessageDialog(null, "Se actualizó el doctor correctamente");
                    VistaAdmin ventanaAdmin = new VistaAdmin();
                }else{
                    JOptionPane.showMessageDialog(null, "No se encuentra o no existe el doctor");
                }
            }
                }else{
                     JOptionPane.showMessageDialog(null, "Hay campos vacíos, favor de llenarlos.");
                }   
            }
        }
    }
    /* NuevoDoctor docActualizado = new NuevoDoctor(0, nombreA, apellidoA, passwordA, generoA, especialidadA, apellidoA, edadA);
                    ;*/