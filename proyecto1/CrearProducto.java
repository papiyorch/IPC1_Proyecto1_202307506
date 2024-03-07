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
public class CrearProducto extends JFrame implements ActionListener{
    private JTextField nombreProductoTxt;
    private JTextField precioProductoTxt;
    private JTextField descProductoTxt;
    private JTextField cantidadProductoTxt;
    private JButton registrarProductoBtn;
    public CrearProducto(){
        this.setTitle("Crear Producto");
        this.setSize(700,300);
        
        JPanel crearProductoPanel = new JPanel();
        crearProductoPanel.setSize(800,350);
        crearProductoPanel.setLayout(null);
        
        JLabel registroProdcuto = new JLabel("Registro Producto");
        registroProdcuto.setBounds(30, 25, 180, 50);
        this.add(registroProdcuto);
        
        JLabel nombreProdcuto = new JLabel("Nombre");
        nombreProdcuto.setBounds(30, 90, 80, 50);
        nombreProductoTxt = new JTextField();
        nombreProductoTxt.setBounds(110, 100, 180, 30);
        this.add(nombreProdcuto);
        this.add(nombreProductoTxt);
        
        JLabel precioProdcuto = new JLabel("Precio");
        precioProdcuto.setBounds(30, 135, 80, 50);
        precioProductoTxt = new JTextField();
        precioProductoTxt.setBounds(110, 145, 180, 30);
        this.add(precioProdcuto);
        this.add(precioProductoTxt);
         
        JLabel descProducto = new JLabel("Descripcion");
        descProducto.setBounds(380, 135, 80, 50);
        descProductoTxt = new JTextField();
        descProductoTxt.setBounds(480, 145, 180, 30);
        this.add(descProducto);
        this.add(descProductoTxt);
        
        JLabel cantidadProducto = new JLabel("Cantidad");
        cantidadProducto.setBounds(380, 90, 80, 50);
        cantidadProductoTxt = new JTextField();
        cantidadProductoTxt.setBounds(480 , 100, 180, 30);
        this.add(cantidadProducto);
        this.add(cantidadProductoTxt);
        
        registrarProductoBtn = new JButton("Registrar");
        registrarProductoBtn.setBounds(260, 200, 130, 45);
        this.add(registrarProductoBtn);
        registrarProductoBtn.addActionListener(this);
        
        this.add(crearProductoPanel);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreP = nombreProductoTxt.getText();
        String precioP = precioProductoTxt.getText();
        String descripcionP = descProductoTxt.getText();
        String cantidadP = cantidadProductoTxt.getText();       
        
          if (e.getActionCommand().equals("Registrar")){      
            if (!nombreP.isEmpty() && !precioP.isEmpty() && !descripcionP.isEmpty() && !cantidadP.isEmpty()){
               NuevoProducto.registrarProducto(NuevoProducto.codigo, nombreP, precioP, descripcionP, cantidadP);
               NuevoProducto.codigo++;
               JOptionPane.showMessageDialog(null, "Se registró el Producto de manera exitosa, su código es:  " +NuevoProducto.codigo);
               this.setVisible(false);
               VistaAdmin ventanaAdmin = new VistaAdmin();
            }else{
               JOptionPane.showMessageDialog(null, "Hay campos vacíos, por favor llenarlos.");
             
            }            
        }
    }
    
}
