package com.mycompany.proyecto1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.mycompany.proyecto1.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.proyecto1.VistaAdmin;
import com.mycompany.proyecto1.VistaDoctor;
import com.mycompany.proyecto1.VistaPaciente;
import com.mycompany.proyecto1.CrearPaciente;
/**
 *
 * @author Yorch
 */
public class InicioSesion extends JFrame implements ActionListener {
    private JTextField codeT;
    private JPasswordField passT;
    private JButton newA;
    private JButton logIn; 
    
    public InicioSesion(){
       this.setTitle("Inicio de Sesion");
       this.setSize(500, 350);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panelIS = new JPanel();
        panelIS.setSize(500,300);
        panelIS.setLayout(null);
        
        JLabel code = new JLabel("Código: ");
        code.setBounds(100, 80, 80, 30);
        this.add(code);
        
        codeT = new JTextField();
        codeT.setBounds(200, 80, 180, 30);
        this.add(codeT);
        
        JLabel pass = new JLabel("Password: ");
        pass.setBounds(100, 140, 80, 30);
        this.add(pass);
        
        passT = new JPasswordField();
        passT.setBounds(200, 140, 180, 30);
        this.add(passT);
        
        newA = new JButton("Sign In");
        newA.setBounds(110, 220, 100, 40);
        this.add(newA);
        newA.addActionListener(this);
        
        logIn = new JButton("Login");
        logIn.setBounds(270, 220, 100, 40);
        this.add(logIn); 
        logIn.addActionListener(this);
  
        this.add(panelIS);
        this.setResizable(false);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            String codigo = codeT.getText();
            char[] password = passT.getPassword();
            String contra = new String(password);          
            if (codigo.equals("123")&& contra.equals("123")){
                //JOptionPane.showMessageDialog(this, "Bienvenido");
                VistaAdmin ventanaAdmin = new VistaAdmin();
            }else{
                JOptionPane.showMessageDialog(null, "Código o Contraseña incorrecta");
            }
        }else if (e.getActionCommand().equals("Sign In")){
           // Registro ventanaRegistro = new Registro();
           CrearPaciente ventanaPaciente = new CrearPaciente();
        }
        
    }
}
