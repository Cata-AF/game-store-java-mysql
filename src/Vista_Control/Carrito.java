package Vista_Control;

import Servicios.CarritoDeCompras;
import Servicios.Product;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Carrito extends javax.swing.JFrame {

    static float finalValue = 0;

    public Carrito() {
        initComponents();
        DrawTable();
    }
    
    public static void DrawTable(){
        
        if(TablaT == null)
            return;
        
        DefaultTableModel model = (DefaultTableModel) TablaT.getModel();
        model.setRowCount(0);  // Limpio la tabla
        String fila[] = new String[2];
        
        finalValue = 0;
        
        for (int i = 0; i < CarritoDeCompras.products.size(); i++) {
            
            Product product = CarritoDeCompras.products.get(i);
            
            fila[0] = product.Nombre;
            fila[1] = product.Precio + "";
            
            finalValue += product.Precio;
            
            model.addRow(fila);
        }
        
        precioL.setText("Precio total: " + finalValue);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloL = new javax.swing.JLabel();
        TablaSP = new javax.swing.JScrollPane();
        TablaT = new javax.swing.JTable();
        precioL = new javax.swing.JLabel();
        EliminarB = new javax.swing.JButton();
        PagoB = new javax.swing.JButton();
        NombresL = new javax.swing.JLabel();
        VersionL = new javax.swing.JLabel();
        JavaVersionL = new javax.swing.JLabel();
        FondoL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carrito de Compras");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(400, 457));
        setName("Factura"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(400, 457));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloL.setBackground(new java.awt.Color(255, 255, 255));
        TituloL.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        TituloL.setForeground(new java.awt.Color(255, 255, 255));
        TituloL.setText("CARRITO DE COMPRAS");
        TituloL.setToolTipText("");
        getContentPane().add(TituloL, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 290, 50));

        TablaSP.setBackground(new java.awt.Color(204, 204, 255));

        TablaT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio(COP)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaSP.setViewportView(TablaT);
        if (TablaT.getColumnModel().getColumnCount() > 0) {
            TablaT.getColumnModel().getColumn(0).setResizable(false);
            TablaT.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(TablaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 360, 190));

        precioL.setBackground(new java.awt.Color(255, 255, 255));
        precioL.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        precioL.setForeground(new java.awt.Color(255, 255, 255));
        precioL.setText("Precio:");
        getContentPane().add(precioL, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 250, 50));

        EliminarB.setBackground(new java.awt.Color(255, 153, 153));
        EliminarB.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        EliminarB.setForeground(new java.awt.Color(0, 0, 102));
        EliminarB.setText("Eliminar");
        EliminarB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EliminarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onPressDelete(evt);
            }
        });
        getContentPane().add(EliminarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 120, 50));

        PagoB.setBackground(new java.awt.Color(204, 255, 204));
        PagoB.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        PagoB.setForeground(new java.awt.Color(0, 0, 102));
        PagoB.setText("Realizar Pago");
        PagoB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PagoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onPressBuy(evt);
            }
        });
        getContentPane().add(PagoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 130, 50));

        NombresL.setForeground(new java.awt.Color(255, 255, 255));
        NombresL.setText("Andrés Charria / Catalina Alba / Sergio Pulido / Laura Londoño  ");
        getContentPane().add(NombresL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        VersionL.setForeground(new java.awt.Color(255, 255, 255));
        VersionL.setText("Product Version: Apache NetBeans IDE 12.2");
        VersionL.setToolTipText("");
        getContentPane().add(VersionL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        JavaVersionL.setForeground(new java.awt.Color(255, 255, 255));
        JavaVersionL.setText("Java: 1.8.0_111; Java HotSpot(TM) 64-Bit Server VM 25.111-b14");
        JavaVersionL.setToolTipText("");
        getContentPane().add(JavaVersionL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        FondoL.setIcon(new javax.swing.ImageIcon("C:\\Users\\meaf7\\Downloads\\WhatsApp Image 2021-06-09 at 7.37.43 PM.jpeg")); // NOI18N
        getContentPane().add(FondoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onPressBuy(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onPressBuy

        if(finalValue <= 0){
            JOptionPane.showMessageDialog(this, "No hay productos en el carrito","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Compra exitosa","Compra",JOptionPane.INFORMATION_MESSAGE);
        
        Factura Factu = new Factura(); 
        Factu.setVisible(true);
    }//GEN-LAST:event_onPressBuy

    private void onPressDelete(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onPressDelete

        int productIdx = TablaT.getSelectedRow();
        
        if(productIdx == -1){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un producto","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int op = JOptionPane.showConfirmDialog(this, "Seguro quieres borrar este producto?");
        
        if(op == JOptionPane.CANCEL_OPTION)
            return;
        
        if(op == JOptionPane.NO_OPTION)
            return;
        
        Product product = CarritoDeCompras.products.get(productIdx);
        finalValue -= product.Precio;
        
        precioL.setText("Precio total: "+finalValue);
        
        CarritoDeCompras.products.remove(productIdx);
        ((DefaultTableModel)TablaT.getModel()).removeRow(productIdx);
    }//GEN-LAST:event_onPressDelete

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarB;
    private javax.swing.JLabel FondoL;
    private javax.swing.JLabel JavaVersionL;
    private javax.swing.JLabel NombresL;
    private javax.swing.JButton PagoB;
    private javax.swing.JScrollPane TablaSP;
    private static javax.swing.JTable TablaT;
    private static javax.swing.JLabel TituloL;
    private javax.swing.JLabel VersionL;
    private static javax.swing.JLabel precioL;
    // End of variables declaration//GEN-END:variables
}
