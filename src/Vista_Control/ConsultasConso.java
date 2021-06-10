/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista_Control;

import Servicios.CarritoDeCompras;
import Servicios.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Servicios.ConexionBD;
import Servicios.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Laura Londoño
 */
public class ConsultasConso extends javax.swing.JFrame {

    static ArrayList<Product> products = new ArrayList<>();
    
    
    
    /**
     * Creates new form ConsultasConso
     */
    public ConsultasConso() {
        this.setLocationRelativeTo(null);
        conexion = new ConexionBD();
        conexion.usarBD("proyecto_final");
        conexion.conectar();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(tblConsultas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 410, 350));

        jButton2.setFont(new java.awt.Font("Zilla Slab", 1, 18)); // NOI18N
        jButton2.setText("Añadir al carrito");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
                OnPressAddToShoppingCart(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 180, 80));

        jButton3.setFont(new java.awt.Font("Zilla Slab", 1, 18)); // NOI18N
        jButton3.setText("CONSULTAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnPressConsultar(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 150, 40));

        jLabel2.setFont(new java.awt.Font("Zilla Slab", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consultas Consolas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 240, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\meaf7\\Downloads\\WhatsApp Image 2021-06-09 at 7.37.43 PM.jpeg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 560));

        jButton1.setFont(new java.awt.Font("Zilla Slab", 1, 18)); // NOI18N
        jButton1.setText("SALIR");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JOptionPane.showMessageDialog(null, "Se ha terminado con la ejecución" , "Conexion Terminada", JOptionPane.INFORMATION_MESSAGE);
       System.exit(0);                                     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void OnPressConsultar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnPressConsultar
        ResultSet resultado = null;

        jButton3.setVisible(false);
        
        DefaultTableModel tabla = new DefaultTableModel();
        tblConsultas.setModel(tabla);

        tabla.addColumn("Almacen");
        tabla.addColumn("Nombre");
        tabla.addColumn("Referencia");
        tabla.addColumn("Color");
        tabla.addColumn("Dimensiones");
        tabla.addColumn("Precio");

        resultado = conexion.consultarBD("select * from consolas;");

        String fila[] = new String[6];
        try {
            while (resultado.next()) {

                Product product = new Product(resultado,false);
                products.add(product);
                
                fila[0] = product.Almacen;
                fila[1] = product.Nombre;
                fila[2] = product.Referencia;
                fila[3] = product.Color;
                fila[4] = product.Dimensiones;
                fila[5] = product.Precio + "";
                
                tabla.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gamestore.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexion.cerrar();        
    }//GEN-LAST:event_OnPressConsultar

    private void OnPressAddToShoppingCart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnPressAddToShoppingCart
        // TODO add your handling code here:
        int productIdx = tblConsultas.getSelectedRow();
        
        if(productIdx == -1){
            JOptionPane.showMessageDialog(this, "You must select one product","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        Product product = products.get(productIdx);
        CarritoDeCompras.AddProduct(product);
        Factura.DrawTable();
        
        JOptionPane.showMessageDialog(this, "Producto añadido");
    }//GEN-LAST:event_OnPressAddToShoppingCart
  
  ConexionBD conexion = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables
}
