/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Yorch
 */
public class Usuario {
    private String name;
    private String lastname;
    private char [] password;
    private Object gender;
    private String  age;
    private String userCode;

    public Usuario(String name, String lastname, char [] password, Object gender, String age, String userCode){
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.userCode = GeneradorCodigo();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
 public String GeneradorCodigo(){
        for (int i = 2023000; i < 100; i++){
            String codigo = String.valueOf(i);
            return (codigo);
    
        }
        return userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
      
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public static void registrarUsuario(String nombre, String apellido, char[] contraseña, Object genero, String edad, String userCode){
        Usuario user = new Usuario(nombre, apellido, contraseña, genero, edad, userCode);
        usuarios.add(user);
    }   
}
