/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author geral
 */
public class ConexionBD {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private String url; 
    private String usuario = "root";
    private String pwd = "";
    private String bd;  
    Connection conexion = null;
    
    public void usarBD(String bd){
        url = "jdbc:mysql://localhost:3306/" + bd;
    }
 
    public void conectar(){
        
        if (conexion == null){
            try {
                Class.forName(driver);
                conexion = DriverManager.getConnection(url, usuario, pwd);
                if(conexion != null){
                    System.out.println("Conexión exitosa");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cerrar(){
        if(conexion != null){
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void modificarBD(String sql){ 
        try {
            Statement comando = conexion.createStatement();
            comando.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Su instrucción generó este error...", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet consultarBD(String sql){
        Statement comando = null;
        ResultSet resultado = null;
        try {
            comando = conexion.createStatement();
            resultado = comando.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    } 
    
    public void borrarBD(String sql){
        try {
            PreparedStatement comando = conexion.prepareStatement(sql);
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}