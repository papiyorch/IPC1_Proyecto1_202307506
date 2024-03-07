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
public class EliminarProducto extends JFrame implements ActionListener{
     private JTextField codigoEliminar;
    private JButton botonEliminarProd;
    private JButton botonCancelarEliminarProd;
    
    public EliminarProducto(){
        this.setSize(500, 280);
        
        JPanel panelEliminarProducto = new JPanel();
        panelEliminarProducto.setSize(500,300);
        panelEliminarProducto.setLayout(null);
        
        JLabel eliminar1 = new JLabel("Ingrese el codigo del");
        JLabel eliminar2 = new JLabel("Producto a eliminar:");
        eliminar1.setBounds(180, 10, 200, 80);
        eliminar2.setBounds(190, 40, 200, 80);
        panelEliminarProducto.add(eliminar1);
        panelEliminarProducto.add(eliminar2);
        
        codigoEliminar = new JTextField();
        codigoEliminar.setBounds(140, 100, 200, 40);
        panelEliminarProducto.add(codigoEliminar);
        
        botonEliminarProd = new JButton("Aceptar");
        botonEliminarProd.setBounds(260, 165, 100, 45);
        panelEliminarProducto.add(botonEliminarProd);
        botonEliminarProd.addActionListener(this);
        
        botonCancelarEliminarProd = new JButton("Cancelar");
        botonCancelarEliminarProd.setBounds(110, 165, 100, 45);
        panelEliminarProducto.add(botonCancelarEliminarProd);
        botonCancelarEliminarProd.addActionListener(this);
        
        this.add(panelEliminarProducto);
        this.setVisible(true);
        this.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String codigoE = codigoEliminar.getText();
        if (e.getActionCommand().equals("Aceptar")) {
            NuevoProducto.eliminarProducto(Integer.parseInt(codigoE));
            this.setVisible(false);
            VistaAdmin ventanaAdmin = new VistaAdmin();
        }else if (e.getActionCommand().equals("Cancelar")){
            this.setVisible(false);
            VistaAdmin ventanaAdmin = new VistaAdmin();
        }
    }

    
}
