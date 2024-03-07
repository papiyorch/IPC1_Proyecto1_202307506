/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.mycompany.proyecto1.CrearDoc;
import com.mycompany.proyecto1.ActualizarDoc;
import com.mycompany.proyecto1.NuevoDoctor;
import com.mycompany.proyecto1.EliminarDoctor;
import com.mycompany.proyecto1.CrearPaciente;
import com.mycompany.proyecto1.ActualizarPaciente;
import com.mycompany.proyecto1.EliminarPaciente;
import com.mycompany.proyecto1.CrearProducto;
import com.mycompany.proyecto1.ActualizarProducto;
import com.mycompany.proyecto1.EliminarProducto;
/**
 *
 * @author Yorch
 */
public class VistaAdmin extends JFrame implements ActionListener{
    private JButton botonCrear;
    private JButton botonActualizar;
    private JButton botonEliminar;
    private JTable tablaDoc;
    private JButton botonCrearPaciente;
    private JButton botonActualizarPaciente;
    private JButton botonEliminarPaciente;
    private JTable tablaPaciente;
    private JButton botonCrearProducto;
    private JButton botonActualizarProducto;
    private JButton botonEliminarProducto;
    private JButton botonReporteProducto;
    private JTable tablaProducto;
    public VistaAdmin(){
        this.setSize(800,500);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        //Pestaña 1
        JPanel pestaña1 = new JPanel(null);
        tabbedPane.addTab("Doctores", pestaña1);  
        
        botonCrear = new JButton("Crear Doc.");
        botonCrear.setBounds(600, 50, 120, 60);
        botonCrear.addActionListener(this);
        pestaña1.add(botonCrear);
        
        botonActualizar = new JButton("Actualizar Doc.");
        botonActualizar.setBounds(600, 160, 120, 60);
        botonActualizar.addActionListener(this);
        pestaña1.add(botonActualizar);
        
        botonEliminar = new JButton("Eliminar Doc.");
        botonEliminar.setBounds(600, 270, 120, 60);
        botonEliminar.addActionListener(this);
        pestaña1.add(botonEliminar);
        
        JLabel listadoDoc = new JLabel();
        listadoDoc.setText("Listado de Doctores");
        listadoDoc.setBounds(30, 15, 150, 50);
        pestaña1.add(listadoDoc);
        
        String [] columnas = {"Código", "Nombre", "Apellido", "Género", "Edad", "Especialidad",  "Teléfono"};
        tablaDoc = new JTable(NuevoDoctor.convertirDatosDoctores(),columnas);
        JScrollPane scrollPane = new JScrollPane(tablaDoc);
        scrollPane.setBounds(30, 75, 500, 320);
        pestaña1.add(scrollPane);
        
        //Pestaña 2
        JPanel pestaña2 = new JPanel(null);
        tabbedPane.addTab("Pacientes",pestaña2);    
       
        
        botonCrearPaciente = new JButton("Crear Paciente");
        botonCrearPaciente.setBounds(600, 50, 120, 60);
        botonCrearPaciente.addActionListener(this);
        pestaña2.add(botonCrearPaciente);
        
        botonActualizarPaciente = new JButton("Actualizar Paciente");
        botonActualizarPaciente.setBounds(600, 160, 120, 60);
        botonActualizarPaciente.addActionListener(this);
        pestaña2.add(botonActualizarPaciente);
        
        botonEliminarPaciente = new JButton("Eliminar Paciente");
        botonEliminarPaciente.setBounds(600, 270, 120, 60);
        botonEliminarPaciente.addActionListener(this);
        pestaña2.add(botonEliminarPaciente);
        
        JLabel listadoPaciente = new JLabel();
        listadoPaciente.setText("Listado de Pacientes");
        listadoPaciente.setBounds(30, 15, 150, 50);
        pestaña2.add(listadoPaciente);
        
        String [] columnasPaciente = {"Código", "Nombre", "Apellido", "Género", "Edad"};
        tablaPaciente = new JTable(NuevoPaciente.convertirDatosPacientes(),columnasPaciente);
        JScrollPane scrollPane2 = new JScrollPane(tablaPaciente);
        scrollPane2.setBounds(30, 75, 500, 320);
        pestaña2.add(scrollPane2);
        
        //Pestaña 3
        JPanel pestaña3 = new JPanel(null);
        tabbedPane.addTab("Productos",pestaña3);
        
        botonCrearProducto = new JButton("Crear Producto");
        botonCrearProducto.setBounds(600, 50, 120, 60);
        botonCrearProducto.addActionListener(this);
        pestaña3.add(botonCrearProducto);
        
        botonActualizarProducto = new JButton("Actualizar Producto");
        botonActualizarProducto.setBounds(600, 150, 120, 60);
        botonActualizarProducto.addActionListener(this);
        pestaña3.add(botonActualizarProducto);
        
        botonEliminarProducto = new JButton("Eliminar Producto");
        botonEliminarProducto.setBounds(600, 250, 120, 60);
        botonEliminarProducto.addActionListener(this);
        pestaña3.add(botonEliminarProducto);
        
        JLabel listadoProducto = new JLabel();
        listadoProducto.setText("Listado de Productos");
        listadoProducto.setBounds(30, 15, 150, 50);
        pestaña3.add(listadoProducto);
        
        String [] columnasProdcuto = {"Código", "Nombre", "Cantidad", "Descripcion", "Precio"};
        tablaProducto = new JTable(NuevoProducto.convertirDatosProductos(),columnasProdcuto);
        JScrollPane scrollPane3 = new JScrollPane(tablaProducto);
        scrollPane3.setBounds(30, 75, 500, 320);
        pestaña3.add(scrollPane3);
        
        getContentPane().add(tabbedPane);
        this.setVisible(true);
       // this.add(tabbedPane);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Crear Doc.")) {
            CrearDoc ventanaCrearDoc = new CrearDoc();
            this.setVisible(false);
        }else if (e.getActionCommand().equals("Actualizar Doc.")){
            ActualizarDoc ventanaActualizarDoc = new ActualizarDoc();
            //VistaPaciente ventana = new VistaPaciente();
            this.setVisible(false);
        }else if(e.getActionCommand().equals("Eliminar Doc.")){
            EliminarDoctor ventanaEliminarDoctor = new EliminarDoctor();
             this.setVisible(false);
        }else if(e.getActionCommand().equals("Crear Paciente")){
            CrearPaciente ventanaCrearPaciente = new CrearPaciente();
            this.setVisible(false);
        }else if(e.getActionCommand().equals("Actualizar Paciente")){
            ActualizarPaciente ventanaActualizarPaciente = new ActualizarPaciente();
            this.setVisible(false);
        }else if(e.getActionCommand().equals("Eliminar Paciente")){
            EliminarPaciente venEliminarPaciente = new EliminarPaciente();
             this.setVisible(false);
        }else if(e.getActionCommand().equals("Crear Producto")){
            CrearProducto ventanaCrearProducto = new CrearProducto();
            this.setVisible(false);
        }else if(e.getActionCommand().equals("Actualizar Producto")){
            ActualizarProducto ventanaActualizarProducto = new ActualizarProducto();
            this.setVisible(false);
        }else if(e.getActionCommand().equals("Eliminar Producto")){
            EliminarProducto ventEliminarProducto = new EliminarProducto();
             this.setVisible(false);
     }  
    }
}