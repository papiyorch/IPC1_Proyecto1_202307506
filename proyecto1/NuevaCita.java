/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;
import java.util.*;
/**
 *
 * @author Yorch
 */
public class NuevaCita {
    private String descripcionCita;
    private Object especialidadDoc;
    private Object nombreDoc;
    private Object horaCita;
    private Object fechaCita;
    private int numeroCita;

    public NuevaCita(int numeroCita,String descripcionCita, Object especialidadDoc, Object nombreDoc, Object horaCita, Object fechaCita) {
        this.descripcionCita = descripcionCita;
        this.especialidadDoc = especialidadDoc;
        this.nombreDoc = nombreDoc;
        this.horaCita = horaCita;
        this.fechaCita = fechaCita;
        this.numeroCita = numeroCita;
    }

    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }
    
    public String getDescripcionCita() {
        return descripcionCita;
    }

    public void setDescripcionCita(String descripcionCita) {
        this.descripcionCita = descripcionCita;
    }

    public Object getEspecialidadDoc() {
        return especialidadDoc;
    }

    public void setEspecialidadDoc(Object especialidadDoc) {
        this.especialidadDoc = especialidadDoc;
    }

    public Object getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(Object nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public Object getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Object horaCita) {
        this.horaCita = horaCita;
    }

    public Object getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Object fechaCita) {
        this.fechaCita = fechaCita;
    }
    
    public static int numCita = 1;
    public static ArrayList<NuevaCita> Citas = new ArrayList<>();
    
    public static void registrarCita(int numeroCita, String descripcionCita, Object especialidadDoc, Object nombreDoc, Object horaCita, Object fechaCita){
        NuevaCita cita = new NuevaCita(numCita,descripcionCita, especialidadDoc, nombreDoc, horaCita, fechaCita);
        Citas.add(cita);
    }
    public static Object[][] convertirDatosCita(){
       int filasCita = Citas.size();
       Object [][] arregloCitas = new Object[filasCita][4];
       
       for (int i = 0; i < filasCita; i++){
           NuevaCita nuevaCita = Citas.get(i);
           arregloCitas[i][0] = nuevaCita.getNumeroCita();
           arregloCitas[i][1] = nuevaCita.getDescripcionCita();
           arregloCitas[i][2] = nuevaCita.getFechaCita();
           arregloCitas[i][3] = nuevaCita.getHoraCita();

           
       }
        return arregloCitas;
   }
}
