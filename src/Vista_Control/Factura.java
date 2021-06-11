package Vista_Control;

import Servicios.CarritoDeCompras;
import Servicios.Product;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class Factura extends javax.swing.JFrame {
    
    static float finalValue = 0;   

    public Factura() {
        initComponents();
        DrawTable();
//        FechaTF.setText(FechaActual());
        FechaTF.setText(FechaHora());
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
        
        TotalL.setText("Precio total:                      " + finalValue);
    }
    /*
    public static String FechaActual(){
        Date fecha = new Date();
        SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        
        return FormatoFecha.format(fecha);
    }
    */
    public static String FechaHora(){
        Date fecha = new Date();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY  HH:mm:ss");
    
        return dtf.format(LocalDateTime.now());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloL = new javax.swing.JLabel();
        EmpresaL = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        AdressL = new javax.swing.JLabel();
        CelL = new javax.swing.JLabel();
        FechaL = new javax.swing.JLabel();
        FechaTF = new javax.swing.JTextField();
        ProvL = new javax.swing.JLabel();
        TablaSP = new javax.swing.JScrollPane();
        TablaT = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        TotalL = new javax.swing.JLabel();
        CodebarL = new javax.swing.JLabel();
        FondoL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Factura");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(248, 510));
        setName("Factura"); // NOI18N
        setPreferredSize(new java.awt.Dimension(248, 510));
        setResizable(false);
        setSize(new java.awt.Dimension(248, 510));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TituloL.setText("CASH RECEIPT");
        getContentPane().add(TituloL, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        EmpresaL.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        EmpresaL.setText("Game Store");
        getContentPane().add(EmpresaL, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, 10));

        AdressL.setText("Dirección:                   Cll 25C #41-32 N");
        getContentPane().add(AdressL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        CelL.setText("Teléfono:                           320 227 7463");
        getContentPane().add(CelL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        FechaL.setText("Fecha y Hora:");
        getContentPane().add(FechaL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        FechaTF.setEditable(false);
        FechaTF.setBorder(null);
        getContentPane().add(FechaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 120, 20));

        ProvL.setText("Proveedor:                   Alejandro Gaitán");
        getContentPane().add(ProvL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        TablaT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaT.setEnabled(false);
        TablaSP.setViewportView(TablaT);
        if (TablaT.getColumnModel().getColumnCount() > 0) {
            TablaT.getColumnModel().getColumn(0).setResizable(false);
            TablaT.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(TablaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 210, 190));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 210, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 210, 10));

        TotalL.setText("Total:");
        getContentPane().add(TotalL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 200, -1));

        CodebarL.setIcon(new javax.swing.ImageIcon("C:\\Users\\meaf7\\Pictures\\barcode.png")); // NOI18N
        getContentPane().add(CodebarL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 210, 30));

        FondoL.setBackground(new java.awt.Color(255, 255, 255));
        FondoL.setForeground(new java.awt.Color(255, 255, 255));
        FondoL.setIcon(new javax.swing.ImageIcon("C:\\Users\\meaf7\\Pictures\\93b5f9913d2e4316cd6e541c67b9aed0 (1).jpg")); // NOI18N
        getContentPane().add(FondoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdressL;
    private javax.swing.JLabel CelL;
    private javax.swing.JLabel CodebarL;
    private javax.swing.JLabel EmpresaL;
    private javax.swing.JLabel FechaL;
    private javax.swing.JTextField FechaTF;
    private javax.swing.JLabel FondoL;
    private javax.swing.JLabel ProvL;
    private javax.swing.JScrollPane TablaSP;
    private static javax.swing.JTable TablaT;
    private javax.swing.JLabel TituloL;
    private static javax.swing.JLabel TotalL;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
