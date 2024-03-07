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
public class NuevoProducto {
    private String nombrePro;
    private String precioPro;
    private String descripcionPro;
    private String cantidadPro;
    private int prodCode;
    public NuevoProducto(int prodCode ,String nombrePro, String precioPro,String descripcionPro,String cantidadPro){
        this.nombrePro = nombrePro;
        this.precioPro = precioPro;
        this.descripcionPro = descripcionPro;
        this.cantidadPro = cantidadPro;
        this.prodCode = prodCode;
    }

    public int getProdCode() {
        return prodCode;
    }

    public void setProdCode(int prodCode) {
        this.prodCode = prodCode;
    }
    
    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getPrecioPro() {
        return precioPro;
    }

    public void setPrecioPro(String precioPro) {
        this.precioPro = precioPro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getCantidadPro() {
        return cantidadPro;
    }

    public void setCantidadPro(String cantidadPro) {
        this.cantidadPro = cantidadPro;
    }
    
    public static int codigo = 1000;
    public static ArrayList<NuevoProducto> Productos = new ArrayList<>();
     
     public static void registrarProducto(int prodCode, String nombrePro, String precioPro,String descripcionPro,String cantidadPro ){
        NuevoProducto producto = new NuevoProducto(codigo, nombrePro, precioPro, descripcionPro, cantidadPro );
        Productos.add(producto);
    }
    public static Object[][] convertirDatosProductos(){
       int filasProd = Productos.size();
       Object [][] arregloProducto = new Object[filasProd][5];
       
       for (int i = 0; i < filasProd; i++){
           NuevoProducto nuevoProducto = Productos.get(i);
           arregloProducto[i][0] = nuevoProducto.getProdCode();
           arregloProducto[i][1] = nuevoProducto.getNombrePro();
           arregloProducto[i][2] = nuevoProducto.getCantidadPro();
           arregloProducto[i][3] = nuevoProducto.getDescripcionPro();
           arregloProducto[i][4] = nuevoProducto.getPrecioPro();
       }
        return arregloProducto;
   }
    public static void eliminarProducto(int codigo){
        NuevoProducto productoEliminar = null;
        for(NuevoProducto producto: Productos){
            if(producto.getProdCode()== codigo){
                productoEliminar = producto;
                break;
            }
        }
        if(productoEliminar !=null){
            Productos.remove(productoEliminar);
            JOptionPane.showMessageDialog(null, "Se eliminó el producto de manera correcta");
        }else{
            JOptionPane.showMessageDialog(null, "El producto no existe o el código es incorrecto.");
        }
    }
    
}
