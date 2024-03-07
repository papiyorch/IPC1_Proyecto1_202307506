/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Yorch
 */
public class NuevoDoctor {
    private String nameDoc;
    private String lastnameDoc;
    private char [] passwordDoc;
    private Object genderDoc;
    private String especialidadDoc;
    private String phoneDoc;
    private String  ageDoc;
    private int codigoDoc;
    public NuevoDoctor(int codigoDoc ,String nameDoc,String lastnameDoc,char [] passwordDoc, Object genderDoc, String especialidadDoc, String phoneDoc, String  ageDoc ){
        this.codigoDoc = codigoDoc;
        this.nameDoc = nameDoc;
        this.lastnameDoc = lastnameDoc;
        this.passwordDoc = passwordDoc;
        this.genderDoc = genderDoc;
        this.especialidadDoc = especialidadDoc;
        this.phoneDoc = phoneDoc;
        this.ageDoc = ageDoc;   
    }
    
    public int getCodigoDoc() {
        return codigoDoc;
    }

    public void setCodigoDoc(int codigoDoc) {
        this.codigoDoc = codigoDoc;
    }
    public String getNameDoc() {
        return nameDoc;
    }

    public void setNameDoc(String nameDoc) {
        this.nameDoc = nameDoc;
    }

    public String getLastnameDoc() {
        return lastnameDoc;
    }

    public void setLastnameDoc(String lastnameDoc) {
        this.lastnameDoc = lastnameDoc;
    }

    public char[] getPasswordDoc() {
        return passwordDoc;
    }

    public void setPasswordDoc(char[] passwordDoc) {
        this.passwordDoc = passwordDoc;
    }

    public Object getGenderDoc() {
        return genderDoc;
    }

    public void setGenderDoc(Object genderDoc) {
        this.genderDoc = genderDoc;
    }

    public String getEspecialidadDoc() {
        return especialidadDoc;
    }

    public void setEspecialidadDoc(String especialidadDoc) {
        this.especialidadDoc = especialidadDoc;
    }

    public String getPhoneDoc() {
        return phoneDoc;
    }

    public void setPhoneDoc(String phoneDoc) {
        this.phoneDoc = phoneDoc;
    }

    public String getAgeDoc() {
        return ageDoc;
    }

    public void setAgeDoc(String ageDoc) {
        this.ageDoc = ageDoc;
    }

    
    public static int codigo =1;
    public static ArrayList<NuevoDoctor> Doctores = new ArrayList<>();
     
     public static void registrarDoctor(int codigoDoc ,String nameDoc,String lastnameDoc,char [] passwordDoc, Object genderDoc, String especialidadDoc, String phoneDoc, String  ageDoc ){
        NuevoDoctor doc = new NuevoDoctor(codigo, nameDoc, lastnameDoc, passwordDoc, genderDoc, especialidadDoc, phoneDoc, ageDoc );
        Doctores.add(doc);
    }
    public static Object[][] convertirDatosDoctores(){
       int filas = Doctores.size();
       Object [][] arregloDoc = new Object[filas][7];
       
       for (int i = 0; i < filas; i++){
           NuevoDoctor nuevoDoc = Doctores.get(i);
           arregloDoc[i][0] = nuevoDoc.getCodigoDoc();
           arregloDoc[i][1] = nuevoDoc.getNameDoc();
           arregloDoc[i][2] = nuevoDoc.getLastnameDoc();
           arregloDoc[i][3] = nuevoDoc.getGenderDoc();
           arregloDoc[i][4] = nuevoDoc.getAgeDoc();
           arregloDoc[i][5] = nuevoDoc.getEspecialidadDoc();
           arregloDoc[i][6] = nuevoDoc.getPhoneDoc();
           
       }
        return arregloDoc;
   }
    public static HashSet<String> obtenerEspecialidad(){
    HashSet<String> especialidades = new HashSet<>();
    
    for(NuevoDoctor doctor : Doctores){
        especialidades.add(doctor.getEspecialidadDoc());
    }
    return especialidades;
    }
    public static ArrayList<NuevoDoctor> filtrarPorEspecialidad(String especialidadDoc){
        ArrayList<NuevoDoctor> doctoresFiltrados = new ArrayList<>();
        for(NuevoDoctor doctor: Doctores){
            if(doctor.getEspecialidadDoc().equalsIgnoreCase(especialidadDoc)){
                doctoresFiltrados.add(doctor);
            }   
        }
        return doctoresFiltrados;
    }
    public static void eliminarDoc(int codigo){
        NuevoDoctor doctorEliminar = null;
        for(NuevoDoctor doctor: Doctores){
            if(doctor.getCodigoDoc() == codigo){
                doctorEliminar = doctor;
                break;
            }
        }
        if(doctorEliminar !=null){
            Doctores.remove(doctorEliminar);
            JOptionPane.showMessageDialog(null, "Se eliminó el doctor de manera correcta");
        }else{
            JOptionPane.showMessageDialog(null, "El doctor no existe o el código es incorrecto.");
        }
    }
}
