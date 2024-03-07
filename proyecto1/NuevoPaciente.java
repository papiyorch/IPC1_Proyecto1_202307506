/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Yorch
 */
public class NuevoPaciente {
    private String namePatient;
    private String lastNamePatient;
    private String agePatient;
    private Object genderPatient;
    private char [] passwordPatient;
    private int codePatient;
     
     
    public NuevoPaciente(int codePatient,String namePatient, String lastNamePatient, String agePatient, Object genderPatient, char[] passwordPatient){
        this.namePatient = namePatient;
        this.lastNamePatient = lastNamePatient;
        this.agePatient = agePatient;
        this.genderPatient = genderPatient;
        this.passwordPatient = passwordPatient;
        this.codePatient = codePatient;
    }

    public int getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(int codePatient) {
        this.codePatient = codePatient;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getLastNamePatient() {
        return lastNamePatient;
    }

    public void setLastNamePatient(String lastNamePatient) {
        this.lastNamePatient = lastNamePatient;
    }

    public String getAgePatient() {
        return agePatient;
    }

    public void setAgePatient(String agePatient) {
        this.agePatient = agePatient;
    }

    public Object getGenderPatient() {
        return genderPatient;
    }

    public void setGenderPatient(Object genderPatient) {
        this.genderPatient = genderPatient;
    }

    public char[] getPasswordPatient() {
        return passwordPatient;
    }

    public void setPasswordPatient(char[] passwordPatient) {
        this.passwordPatient = passwordPatient;
    }
   
    public static ArrayList<NuevoPaciente> Pacientes = new ArrayList<>();
    
    public static int codigo = 100;
      public static void registrarPciente(int codePatient, String namePatient, String lastNamePatient, String agePatient, Object genderPatient, char[] passwordPatient ){
        NuevoPaciente paciente = new NuevoPaciente(codigo, namePatient, lastNamePatient, agePatient, genderPatient, passwordPatient);
        Pacientes.add(paciente);
    }
    public static Object[][] convertirDatosPacientes(){
       int filasP = Pacientes.size();
       Object [][] arregloPaciente = new Object[filasP][5];
       
       for (int i = 0; i < filasP; i++){
           NuevoPaciente nuevoPaciente = Pacientes.get(i);
           arregloPaciente[i][0] = nuevoPaciente.getCodePatient();
           arregloPaciente[i][1] = nuevoPaciente.getNamePatient();
           arregloPaciente[i][2] = nuevoPaciente.getLastNamePatient();
           arregloPaciente[i][3] = nuevoPaciente.getGenderPatient();
           arregloPaciente[i][4] = nuevoPaciente.getAgePatient();
           
       }
        return arregloPaciente;
   }
   public static void eliminarPaciente(int codigo){
        NuevoPaciente pacienteEliminar = null;
        for(NuevoPaciente paciente: Pacientes){
            if(paciente.getCodePatient()== codigo){
                pacienteEliminar = paciente;
                break;
            }
        }
        if(pacienteEliminar !=null){
            Pacientes.remove(pacienteEliminar);
            JOptionPane.showMessageDialog(null, "Se eliminó el paciente de manera correcta");
        }else{
            JOptionPane.showMessageDialog(null, "El paciente no existe o el código es incorrecto.");
        }
    }
      
}
