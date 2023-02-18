/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazGrafica;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDireccionesClientesDAO;
import interfaces.IRetirosDAO;
import interfaces.ITransferenciasDAO;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author march
 */
public class FrmAgregarDinero extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(FrmAgregarDinero.class.getName());
    private final IClientesDAO clientesDAO;
    private final IDireccionesClientesDAO direccionesClientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IRetirosDAO retirosDAO;
    private final ITransferenciasDAO transferenciasDAO;
    private final Cliente clienteSesion;
    private final Cuenta cuentaIniciada;
    private float cantidadAgregada;
    private boolean operacion;

    public FrmAgregarDinero(Cuenta cuentaIniciada, Cliente clienteSesion, IClientesDAO clientesDAO, IDireccionesClientesDAO direccionesClientesDAO, ICuentasDAO cuentasDAO, IRetirosDAO retirosDAO, ITransferenciasDAO transferenciasDAO) {
//        ImageIcon icon = new ImageIcon(getClass().getResource("/multimedia/iconCaballoPerfil.png"));
//        this.setIconImage(icon.getImage());
        this.setTitle("BANCO POTROS");
        this.clientesDAO = clientesDAO;
        this.direccionesClientesDAO = direccionesClientesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
        this.transferenciasDAO = transferenciasDAO;
        this.clienteSesion = clienteSesion;
        this.cuentaIniciada = cuentaIniciada;
        this.cantidadAgregada = 0f;
        this.operacion = true;
        initComponents();
        this.txtCantidad.setText(String.valueOf(cantidadAgregada));
    }

    public void agregarDinero() {
        try {
            this.cuentasDAO.sumarSaldo(this.cuentaIniciada.getNumeroCuenta(), cantidadAgregada);
            this.cuentaIniciada.setSaldo(this.cuentaIniciada.getSaldo() + this.cantidadAgregada);
            this.mostrarMensajeDineroAgregado();
        } catch (PersistenciaException e) {
            this.mostrarMensajeErrorAlAgregar();
        }
    }

    private void mostrarMensajeDineroAgregado() {
        JOptionPane.showMessageDialog(
                this,
                "Cantidad agregada exitosamente",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeErrorAlAgregar() {
        JOptionPane.showMessageDialog(
                this,
                "No fue posible agregar la cantidad ingresada.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
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
        btn50 = new javax.swing.JButton();
        btn100 = new javax.swing.JButton();
        btn200 = new javax.swing.JButton();
        btn500 = new javax.swing.JButton();
        btn1000 = new javax.swing.JButton();
        btn2000 = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSumar = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn50.setText("50");
        btn50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn50ActionPerformed(evt);
            }
        });
        jPanel1.add(btn50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        btn100.setText("100");
        btn100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn100ActionPerformed(evt);
            }
        });
        jPanel1.add(btn100, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        btn200.setText("200");
        btn200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn200ActionPerformed(evt);
            }
        });
        jPanel1.add(btn200, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        btn500.setText("500");
        btn500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500ActionPerformed(evt);
            }
        });
        jPanel1.add(btn500, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        btn1000.setText("1000");
        btn1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1000ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1000, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        btn2000.setText("2000");
        btn2000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2000ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2000, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 100, -1));

        jLabel1.setText("Total:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, -1, -1));

        btnSumar.setText("Sumar");
        btnSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSumar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 80, 50));

        btnRestar.setText("Restar");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 80, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn50ActionPerformed
        if (operacion) {
            this.cantidadAgregada += 50;
            this.txtCantidad.setText(String.valueOf(cantidadAgregada));
        } else {
            if (this.cantidadAgregada >= 50) {
                this.cantidadAgregada -= 50;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            } else {
                this.cantidadAgregada = 0;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            }
        }
    }//GEN-LAST:event_btn50ActionPerformed

    private void btn100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn100ActionPerformed
        if (operacion) {
            this.cantidadAgregada += 100;
            this.txtCantidad.setText(String.valueOf(cantidadAgregada));
        } else {
            if (this.cantidadAgregada >= 100) {
                this.cantidadAgregada -= 100;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            } else {
                this.cantidadAgregada = 0;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            }
        }
    }//GEN-LAST:event_btn100ActionPerformed

    private void btn200ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn200ActionPerformed
        if (operacion) {
            this.cantidadAgregada += 200;
            this.txtCantidad.setText(String.valueOf(cantidadAgregada));
        } else {
            if (this.cantidadAgregada >= 200) {
                this.cantidadAgregada -= 200;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            } else {
                this.cantidadAgregada = 0;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            }
        }
    }//GEN-LAST:event_btn200ActionPerformed

    private void btn500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn500ActionPerformed
        if (operacion) {
            this.cantidadAgregada += 500;
            this.txtCantidad.setText(String.valueOf(cantidadAgregada));
        } else {
            if (this.cantidadAgregada >= 500) {
                this.cantidadAgregada -= 500;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            } else {
                this.cantidadAgregada = 0;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            }
        }
    }//GEN-LAST:event_btn500ActionPerformed

    private void btn1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1000ActionPerformed
        if (operacion) {
            this.cantidadAgregada += 1000;
            this.txtCantidad.setText(String.valueOf(cantidadAgregada));
        } else {
            if (this.cantidadAgregada >= 1000) {
                this.cantidadAgregada -= 1000;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            } else {
                this.cantidadAgregada = 0;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            }
        }
    }//GEN-LAST:event_btn1000ActionPerformed

    private void btn2000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2000ActionPerformed
        if (operacion) {
            this.cantidadAgregada += 2000;
            this.txtCantidad.setText(String.valueOf(cantidadAgregada));
        } else {
            if (this.cantidadAgregada >= 2000) {
                this.cantidadAgregada -= 2000;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            } else {
                this.cantidadAgregada = 0;
                this.txtCantidad.setText(String.valueOf(cantidadAgregada));
            }
        }
    }//GEN-LAST:event_btn2000ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea regresar?", "REGRESAR", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            FrmBanco banco = new FrmBanco(cuentaIniciada, clienteSesion, clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
            banco.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarActionPerformed
        this.operacion = true;
    }//GEN-LAST:event_btnSumarActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        this.operacion = false;
    }//GEN-LAST:event_btnRestarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.agregarDinero();
        FrmBanco banco = new FrmBanco(cuentaIniciada, clienteSesion, clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
        banco.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn100;
    private javax.swing.JButton btn1000;
    private javax.swing.JButton btn200;
    private javax.swing.JButton btn2000;
    private javax.swing.JButton btn50;
    private javax.swing.JButton btn500;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRestar;
    private javax.swing.JButton btnSumar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}