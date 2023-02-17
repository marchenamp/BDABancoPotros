/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import interfaces.IClientesDAO;
import interfaces.IDireccionesClientesDAO;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author march
 */
public class FrmInicio extends javax.swing.JFrame {
    
    private static final Logger LOG = Logger.getLogger(FrmInicio.class.getName());
    private final IClientesDAO clientesDAO;
    private final IDireccionesClientesDAO direccionesClientesDAO;
    
    /**
     * Creates new form frmPrincipal
     */
    public FrmInicio(IClientesDAO clientesDAO, IDireccionesClientesDAO direccionesClientesDAO) {
//        ImageIcon icon = new ImageIcon(getClass().getResource("/multimedia/iconCaballoPerfil.png"));
//        this.setIconImage(icon.getImage());
        this.setTitle("INICIO");
        this.clientesDAO = clientesDAO;
        this.direccionesClientesDAO = direccionesClientesDAO;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(470, 605));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(470, 605));
        jPanel1.setPreferredSize(new java.awt.Dimension(470, 605));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 130, -1));
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 130, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Entrar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 100, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jButton2.setText("Hacer retiro sin cuenta");
        jButton2.setBorderPainted(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 170, 30));

        btnRegistrarse.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnRegistrarse.setText("Regístrate");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 110, 30));

        jLabel4.setText("¿No estás registrado?");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        FrmRegistroCliente registro = new FrmRegistroCliente(clientesDAO, direccionesClientesDAO);
        registro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
