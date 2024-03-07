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
public class CrearDoc extends JFrame implements ActionListener{
    private JTextField nombreDocTxt;
    private JTextField apellidoDocTxt;
    private JPasswordField passwordDocPas;
    private JComboBox generoDocBox;
    private JTextField especialidadDocTxt;
    private JTextField telefonoDocTxt;
    private JTextField edadDocTxt;
    private JButton registrarDocBtn;
        
    public CrearDoc(){
        this.setTitle("Crear Doctor");
        this.setSize(800,350);
        
        JPanel crearDocPanel = new JPanel();
        crearDocPanel.setSize(800,350);
        crearDocPanel.setLayout(null);
        
        JLabel RegistroDoc = new JLabel("Registro Doctor");
        RegistroDoc.setBounds(30, 25, 100, 50);
        this.add(RegistroDoc);
        
        JLabel nombreDoc = new JLabel("Nombres");
        nombreDoc.setBounds(30, 90, 80, 50);
        nombreDocTxt = new JTextField();
        nombreDocTxt.setBounds(110, 100, 180, 30);
        this.add(nombreDoc);
        this.add(nombreDocTxt);
        
        JLabel apellidoDoc = new JLabel("Apellidos");
        apellidoDoc.setBounds(30, 135, 80, 50);
        apellidoDocTxt = new JTextField();
        apellidoDocTxt.setBounds(110, 145, 180, 30);
        this.add(apellidoDoc);
        this.add(apellidoDocTxt);
         
        JLabel passwordDoc = new JLabel("Password");
        passwordDoc.setBounds(30, 180, 80, 50);
        passwordDocPas = new JPasswordField();
        passwordDocPas.setBounds(110, 190, 180, 30);
        this.add(passwordDoc);
        this.add(passwordDocPas);
        
        JLabel generoDoc = new JLabel("Género");
        generoDoc.setBounds(30, 225, 80, 50);
        generoDocBox = new JComboBox();
        generoDocBox.addItem("");
        generoDocBox.addItem("Masculino");
        generoDocBox.addItem("Femenino");
        generoDocBox.setBounds(135, 235, 153, 30);
        this.add(generoDoc);
        this.add(generoDocBox);
         
        JLabel especialidadDoc = new JLabel("Especialidad");
        especialidadDoc.setBounds(380, 90, 80, 50);
        especialidadDocTxt = new JTextField();
        especialidadDocTxt.setBounds(480 , 100, 180, 30);
        this.add(especialidadDoc);
        this.add(especialidadDocTxt);
         
        JLabel telefonoDoc = new JLabel("Teléfono");
        telefonoDoc.setBounds(380, 135, 80, 50);
        telefonoDocTxt = new JTextField();
        telefonoDocTxt.setBounds(480, 145, 180, 30);
        this.add(telefonoDoc);
        this.add(telefonoDocTxt);
         
        JLabel edadDoc = new JLabel("Edad");
        edadDoc.setBounds(380, 180, 80, 50);
        edadDocTxt = new JTextField();
        edadDocTxt.setBounds(480, 190, 180, 30);
        this.add(edadDoc);
        this.add(edadDocTxt);
        
        registrarDocBtn = new JButton("Registrar");
        registrarDocBtn.setBounds(500, 245, 130, 45);
        this.add(registrarDocBtn);
        registrarDocBtn.addActionListener(this);
        
        this.add(crearDocPanel);
        this.setResizable(false);
        this.setVisible(true);
    }

        @Override
        public void actionPerformed(ActionEvent e) {   
        String nombreD = nombreDocTxt.getText();
        String apellidoD = apellidoDocTxt.getText();
        char [] contraseñaD = passwordDocPas.getPassword();
        Object generoD = generoDocBox.getSelectedItem();
        String especialidadD = especialidadDocTxt.getText();
        String telefonoD = telefonoDocTxt.getText();
        String edadD = edadDocTxt.getText();
        
          if (e.getActionCommand().equals("Registrar")){      
            if (!nombreD.isEmpty() && !apellidoD.isEmpty() && contraseñaD.length != 0 && generoD != null && !especialidadD.isEmpty() && !telefonoD.isEmpty() && !edadD.isEmpty()){
                NuevoDoctor.registrarDoctor(NuevoDoctor.codigo,nombreD, apellidoD, contraseñaD, generoD, especialidadD, telefonoD, edadD);
                NuevoDoctor.codigo++;
                JOptionPane.showMessageDialog(null, "Se registró el Doctor de manera exitosa, su código es:  " + NuevoDoctor.codigo);          
                //System.out.println(nuevoDoc);
                this.setVisible(false);
                VistaAdmin ventanaAdmin = new VistaAdmin();
            }else{     
                JOptionPane.showMessageDialog(null, "Hay campos vacíos, por favor llenarlos.");
                
            }            
        }
        
        }
        
    }