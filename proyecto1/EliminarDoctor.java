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
public class EliminarDoctor extends JFrame implements ActionListener {
    private JTextField codigoEliminar;
    private JButton botonEliminarDoc;
    private JButton botonCancelarEliminarDoc;
    
    public EliminarDoctor(){
        this.setSize(500, 280);
        
        JPanel panelEliminarDoc = new JPanel();
        panelEliminarDoc.setSize(500,300);
        panelEliminarDoc.setLayout(null);
        
        JLabel eliminar1 = new JLabel("Ingrese el codigo del");
        JLabel eliminar2 = new JLabel("Doctor a eliminar:");
        eliminar1.setBounds(180, 10, 200, 80);
        eliminar2.setBounds(190, 40, 200, 80);
        panelEliminarDoc.add(eliminar1);
        panelEliminarDoc.add(eliminar2);
        
        codigoEliminar = new JTextField();
        codigoEliminar.setBounds(140, 100, 200, 40);
        panelEliminarDoc.add(codigoEliminar);
        
        botonEliminarDoc = new JButton("Aceptar");
        botonEliminarDoc.setBounds(260, 165, 100, 45);
        panelEliminarDoc.add(botonEliminarDoc);
        botonEliminarDoc.addActionListener(this);
        
        botonCancelarEliminarDoc = new JButton("Cancelar");
        botonCancelarEliminarDoc.setBounds(110, 165, 100, 45);
        panelEliminarDoc.add(botonCancelarEliminarDoc);
        botonCancelarEliminarDoc.addActionListener(this);
        
        this.add(panelEliminarDoc);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String codigoE = codigoEliminar.getText();
        if (e.getActionCommand().equals("Aceptar")) {
            NuevoDoctor.eliminarDoc(Integer.parseInt(codigoE));
            this.setVisible(false);
            VistaAdmin ventanaAdmin = new VistaAdmin();
        }else if (e.getActionCommand().equals("Cancelar")){
            this.setVisible(false);
            VistaAdmin ventanaAdmin = new VistaAdmin();
        }
    }
    
}
