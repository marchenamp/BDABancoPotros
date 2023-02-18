/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfazGrafica;

import dominio.Cliente;
import dominio.Cuenta;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDireccionesClientesDAO;
import interfaces.IRetirosDAO;
import interfaces.ITransferenciasDAO;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author lv1013
 */
public class FrmCuentas extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(FrmCuentas.class.getName());
    private final IClientesDAO clientesDAO;
    private final IDireccionesClientesDAO direccionesClientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IRetirosDAO retirosDAO;
    private final ITransferenciasDAO transferenciasDAO;
    private final Cliente clienteSesion;
    private Cuenta cuentaIniciada;

    public FrmCuentas(Cliente clienteSesion, IClientesDAO clientesDAO, IDireccionesClientesDAO direccionesClientesDAO, ICuentasDAO cuentasDAO, IRetirosDAO retirosDAO, ITransferenciasDAO transferenciasDAO) {
//        ImageIcon icon = new ImageIcon(getClass().getResource("/multimedia/iconCaballoPerfil.png"));
//        this.setIconImage(icon.getImage());
        this.setTitle("CUENTAS");
        this.clientesDAO = clientesDAO;
        this.direccionesClientesDAO = direccionesClientesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
        this.transferenciasDAO = transferenciasDAO;
        this.clienteSesion = clienteSesion;
        initComponents();
        this.cuentasDAO.rellenarComboCuentas("numeroCuenta", cbxCuentas);
    }
    
    public void consultarCuenta(){
        String numCuenta = (String) this.cbxCuentas.getSelectedItem();
        this.cuentaIniciada = this.cuentasDAO.consultar(numCuenta);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxCuentas = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregarCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("Nombre del Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("¡BIENVENIDO!");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        cbxCuentas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(cbxCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 130, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Seleccione cuenta");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        btnContinuar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/potros-itson-chico.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tarjeta.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        btnAgregarCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAgregarCuenta.setText("   Agregar cuenta");
        btnAgregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentaActionPerformed
        FrmAgregarCuenta agregarCuenta = new FrmAgregarCuenta(clienteSesion, clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
        agregarCuenta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarCuentaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        this.consultarCuenta();
        if (cuentaIniciada != null){
            FrmBanco frmBanco = new FrmBanco(cuentaIniciada, clienteSesion, clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
            frmBanco.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(
                        this,
                        "No hay cuentas registradas.",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnContinuarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCuenta;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
