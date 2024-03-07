/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.mycompany.proyecto1.Usuario;
/**
 *
 * @author Yorch
 */
public class Registro extends JFrame implements ActionListener{
    private JTextField nameT;
    private JTextField lastNameT;
    private JPasswordField passwordT;
    private JComboBox genB;
    private JTextField ageT;
    private JButton signB;
    
    public Registro(){
        this.setTitle("Registro de Paciente");
        this.setSize(400, 450);
        
        JPanel registroPanel = new JPanel();
        registroPanel.setLayout(null);
        registroPanel.setSize(400,400);
        
        JLabel name = new JLabel("Nombre: ");
        name.setBounds(80, 50, 80, 40);
        this.add(name);
        
        JLabel lastName = new JLabel("Apellido: ");
        lastName.setBounds(80, 100, 80, 40);
        this.add(lastName);
        
        JLabel password = new JLabel("Password: ");
        password.setBounds(80, 150, 80, 40);
        this.add(password);
                
        JLabel gen = new JLabel("Género: ");
        gen.setBounds(80, 200, 80, 40);
        this.add(gen);
        
        JLabel age = new JLabel("Edad: ");
        age.setBounds(80, 250, 80, 40);
        this.add(age);
        
        nameT = new JTextField(15);
        nameT.setBounds(155, 55, 180, 30);
        this.add(nameT);
        
        lastNameT = new JTextField(15);
        lastNameT.setBounds(155, 105, 180, 30);
        this.add(lastNameT);
        
        passwordT = new JPasswordField(15);
        passwordT.setBounds(155, 155, 180, 30);
        this.add(passwordT);
        
        genB = new JComboBox();
        genB.addItem("");
        genB.addItem("Masculino");
        genB.addItem("Femenino");
        genB.setBounds(155, 205, 100, 30);
        this.add(genB);
        
        ageT = new JTextField(15);
        ageT.setBounds(155, 255, 180, 30);
        this.add(ageT);
         
        signB = new JButton("Sign Up");
        signB.setBounds(260, 330, 90, 40);
        this.add(signB);
        signB.addActionListener(this);

        this.add(registroPanel);
        this.setVisible(true);   
       
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = nameT.getText();
        String apellido = lastNameT.getText();
        char[] contra = passwordT.getPassword();
        Object gen = genB.getSelectedItem();
        String edad = ageT.getText();
        
        if (e.getActionCommand().equals("Sign Up")){      
            if (nombre.isEmpty() || apellido.isEmpty() || contra.length == 0 || gen == null || edad.isEmpty()){
                JOptionPane.showMessageDialog(null, "Hay campos vacíos, por favor llenarlos.");
            }else{
                Usuario nuevoUsuario = new Usuario(nombre, edad, contra, gen, edad,"");
                nuevoUsuario.setName(nombre);
                nuevoUsuario.setLastname(apellido);
                nuevoUsuario.setPassword(contra);
                nuevoUsuario.setGender(gen);
                nuevoUsuario.setAge(edad);    
                JOptionPane.showMessageDialog(null, "Se registró el Usuario de manera exitosa, su código es: " + nuevoUsuario.getUserCode() );          
                System.out.println(nuevoUsuario);
                this.setVisible(false);
            }            
        }
    }
    
}
