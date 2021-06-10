/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.sql.ResultSet;

/**
 *
 * @author meaf7
 */
public class Product {

    public String Almacen;
    public String Nombre;
    public String Referencia;
    public String Color;
    public String Dimensiones;
    public float Precio;
    public String Tipo;

    public Product(ResultSet queryResult, boolean isVideogame) {
        try {
            Almacen = queryResult.getString("Almacen");
            Nombre = queryResult.getString("Nombre");
            Referencia = queryResult.getString("Referencia");
            Precio = queryResult.getFloat("Precio");
            
            if(isVideogame)
                Tipo = queryResult.getString("Tipo");
            
            if(!isVideogame){
                Color = queryResult.getString("Color");
                Dimensiones = queryResult.getString("Dimensiones");
            }
            
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar analizar el resultado de la consulta.");
        }
    }
}
