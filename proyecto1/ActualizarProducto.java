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
public class ActualizarProducto extends JFrame implements ActionListener{
    private JTextField codigoProductoTxtA;
    private JTextField nombreProductoTxtA;
    private JTextField precioProductoTxtA;
    private JTextField descProductoTxtA;
    private JTextField cantidadProductoTxtA;
    private JButton actualizarProductoBtn;
    
    public ActualizarProducto(){
        this.setTitle("Crear Producto");
        this.setSize(700,300);
        
        JPanel crearProductoPanel = new JPanel();
        crearProductoPanel.setSize(800,350);
        crearProductoPanel.setLayout(null);
        
        JLabel actualizarProdcuto = new JLabel("Actualizar Producto");
        actualizarProdcuto.setBounds(30, 10, 180, 50);
        this.add(actualizarProdcuto);
        
        JLabel codigoProductoA = new JLabel("Código");
        codigoProductoA.setBounds(30, 45, 80, 50);
        codigoProductoTxtA = new JTextField();
        codigoProductoTxtA.setBounds(110, 55, 180, 30);
        this.add(codigoProductoA);
        this.add(codigoProductoTxtA);
        
        JLabel nombreProdcutoA = new JLabel("Nombre");
        nombreProdcutoA.setBounds(30, 90, 80, 50);
        nombreProductoTxtA = new JTextField();
        nombreProductoTxtA.setBounds(110, 100, 180, 30);
        this.add(nombreProdcutoA);
        this.add(nombreProductoTxtA);
        
        JLabel precioProdcutoA = new JLabel("Precio");
        precioProdcutoA.setBounds(30, 135, 80, 50);
        precioProductoTxtA = new JTextField();
        precioProductoTxtA.setBounds(110, 145, 180, 30);
        this.add(precioProdcutoA);
        this.add(precioProductoTxtA);
         
        JLabel descProductoA = new JLabel("Descripcion");
        descProductoA.setBounds(380, 135, 80, 50);
        descProductoTxtA = new JTextField();
        descProductoTxtA.setBounds(480, 145, 180, 30);
        this.add(descProductoA);
        this.add(descProductoTxtA);
        
        JLabel cantidadProductoA = new JLabel("Cantidad");
        cantidadProductoA.setBounds(380, 90, 80, 50);
        cantidadProductoTxtA = new JTextField();
        cantidadProductoTxtA.setBounds(480 , 100, 180, 30);
        this.add(cantidadProductoA);
        this.add(cantidadProductoTxtA);
        
        actualizarProductoBtn = new JButton("Actualizar");
        actualizarProductoBtn.setBounds(260, 200, 130, 45);
        this.add(actualizarProductoBtn);
        actualizarProductoBtn.addActionListener(this);
        
        this.add(crearProductoPanel);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String codigoA = codigoProductoTxtA.getText();
        String nombreA = nombreProductoTxtA.getText();
        String precioA = precioProductoTxtA.getText();
        String descripcionA = descProductoTxtA.getText();
        String cantidadA = cantidadProductoTxtA.getText();
        if(e.getActionCommand().equals("Actualizar")){
           if(!nombreA.isEmpty() && !precioA.isEmpty() && !descripcionA.isEmpty() && !cantidadA.isEmpty()){
            for(NuevoProducto prodcutoActualizado : NuevoProducto.Productos){
                if(codigoA.equals(String.valueOf(prodcutoActualizado.getProdCode()))){
                    prodcutoActualizado.setNombrePro(nombreA);
                    prodcutoActualizado.setPrecioPro(precioA);
                    prodcutoActualizado.setDescripcionPro(descripcionA);
                    prodcutoActualizado.setCantidadPro(cantidadA);      
                    JOptionPane.showMessageDialog(null, "Se actualizó el producto correctamente");
                    VistaAdmin ventanaAdmin = new VistaAdmin();
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encuentra o no existe el producto");
                }
            }
            }else{
               JOptionPane.showMessageDialog(null, "Hay campos vacíos, favor de llenarlos.");
           }
        }   
    }
}
