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
import com.mycompany.proyecto1.NuevoDoctor;
import com.mycompany.proyecto1.ActualizarPaciente;
/**
 *
 * @author Yorch
 */
public class VistaPaciente extends JFrame implements ActionListener{
    private JTextField motivoCitaTxt;
    private JComboBox<String> especialidadDocBox;
    private JComboBox nombreDocBox;
     private JComboBox fechaBox;
    private JComboBox horaBox;
    private JButton editarPerfilButton;
    private JButton generarCitaButton;
    private JTable tablaCitas;

        
    public VistaPaciente(){
        this.setSize(680,400);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setSize(680, 400);
        
        //Pestaña 1
        JPanel pestaña1 = new JPanel(null);
        tabbedPane.addTab("Solicitar Cita", pestaña1);  
        
        editarPerfilButton = new JButton("Editar Perfil");
        editarPerfilButton.setBounds(500, 10, 140, 35);
        pestaña1.add(editarPerfilButton);
        
        JLabel motivoCita = new JLabel("Motivo de la cita:");
        motivoCita.setBounds(35, 45, 200, 30);
        pestaña1.add(motivoCita);
        motivoCitaTxt = new JTextField();
        motivoCitaTxt.setBounds(35, 75, 600, 60);
        pestaña1.add(motivoCitaTxt);
        
        JLabel especialidad = new JLabel("Especialidad:");
        especialidad.setBounds(45, 145, 120, 30);
        pestaña1.add(especialidad);
        especialidadDocBox = new JComboBox();
        especialidadDocBox.setBounds(130, 148, 160, 25);
        pestaña1.add(especialidadDocBox);
        
        //Obtener especialidades y agregarlas al ComboBox
        HashSet<String> especialidadedDoctor = NuevoDoctor.obtenerEspecialidad();
        for(String especialidadString: especialidadedDoctor){
            especialidadDocBox.addItem(especialidadString);
        }
        JLabel doctor = new JLabel("Doctor:");
        doctor.setBounds(45, 190, 120, 30);
        pestaña1.add(doctor);
        nombreDocBox = new JComboBox();
        nombreDocBox.setBounds(130, 190, 160, 25);
        pestaña1.add(nombreDocBox);
        
        //Obtener los doctores por especialidad y agregarlos al ComboBox
         especialidadDocBox.addActionListener(e -> {
            String especialidadSeleccionada = (String) especialidadDocBox.getSelectedItem();
            ArrayList<NuevoDoctor> doctoresFiltrados = NuevoDoctor.filtrarPorEspecialidad(especialidadSeleccionada);
            nombreDocBox.removeAllItems();
            for (NuevoDoctor doctorF : doctoresFiltrados){
                nombreDocBox.addItem(doctorF.getNameDoc() + " " + doctorF.getLastnameDoc());
            }   
        });
         
        
        JLabel horario = new JLabel("Horario de citas disponibles");
        horario.setBounds(35, 225, 200, 30);
        pestaña1.add(horario);
        
        JLabel fecha = new JLabel("Fecha:");
        fecha.setBounds(40, 260, 80, 30);
        pestaña1.add(fecha);
        fechaBox = new JComboBox();
        fechaBox.addItem("Hoy");
        fechaBox.setBounds(85, 263, 130, 25);
        pestaña1.add(fechaBox);
        
        JLabel hora = new JLabel("Hora:");
        hora.setBounds(240, 260, 80, 30);
        pestaña1.add(hora);
        horaBox = new JComboBox();
        horaBox.addItem("12:00");
        horaBox.setBounds(280, 263, 130, 25);
        pestaña1.add(horaBox);
        
        generarCitaButton = new JButton("Generar Cita");
        generarCitaButton.setBounds(520, 265, 130, 45);
        pestaña1.add(generarCitaButton);
        generarCitaButton.addActionListener(this);
        
        //Pestaña 2
        JPanel pestaña2 = new JPanel(null);
        tabbedPane.addTab("Pacientes",pestaña2);    
        
        editarPerfilButton = new JButton("Editar Perfil");
        editarPerfilButton.setBounds(500, 10, 140, 35);
        pestaña2.add(editarPerfilButton);
        
        JLabel historial = new JLabel("Historial de Citas:");
        historial.setBounds(10, 10, 200, 60);
        pestaña2.add(historial);
       
        String [] columnasCitas = {"Código", "Estado", "Fecha", "Hora"};
        tablaCitas = new JTable(NuevaCita.convertirDatosCita(),columnasCitas);
        JScrollPane scrollPane = new JScrollPane(tablaCitas);
        scrollPane.setBounds(80, 70, 500, 230);
        pestaña2.add(scrollPane);
       
        //Pestaña 3
        JPanel pestaña3 = new JPanel(null);
        tabbedPane.addTab("Productos",pestaña3)
                ;
        editarPerfilButton = new JButton("Editar Perfil");
        editarPerfilButton.setBounds(500, 10, 140, 35);
        pestaña3.add(editarPerfilButton);
        editarPerfilButton.addActionListener(this);
        
        JLabel farmacia = new JLabel("Mira nuestro productos y visita nuestra farmacia para comprarlos");
        farmacia.setBounds(50, 10, 300, 50);
        pestaña3.add(farmacia);
        
        getContentPane().add(tabbedPane);
        this.setVisible(true);
       // this.add(tabbedPane);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String motivo = motivoCitaTxt.getText();
        Object especialidad = especialidadDocBox.getSelectedItem();
        Object doctor = nombreDocBox.getSelectedItem();
        Object fecha = fechaBox.getSelectedItem();
        Object hora = horaBox.getSelectedItem();
        if(e.getActionCommand().equals("Generar Cita") ){
            if(motivo.isEmpty() && especialidad == null && doctor == null && hora == null && fecha == null){
                JOptionPane.showMessageDialog(null, "Hay campos vacios, por favor llenarlos");
            }else{
                NuevaCita.registrarCita(NuevaCita.numCita, motivo, especialidad, hora, hora, fecha);
                NuevaCita.numCita++;
                JOptionPane.showMessageDialog(null, "La cita se registró de manera correcta");
                generarCitaButton.setEnabled(false);
            }
        }else if(e.getActionCommand().equals("Editar Perfil")){
            ActualizarPaciente ventanaEditarPerfil = new ActualizarPaciente();
        }
    }
    
}
