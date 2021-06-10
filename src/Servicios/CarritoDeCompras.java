/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.ArrayList;

/**
 *
 * @author meaf7
 */
public class CarritoDeCompras {
    public static ArrayList<Product> products = new ArrayList<>();

    
    public static void AddProduct(Product product){
        products.add(product);
        
        System.out.println("Product added: "+product.Referencia);
    }
}
