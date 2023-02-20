/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazGrafica;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Retiro;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDireccionesClientesDAO;
import interfaces.IRetirosDAO;
import interfaces.ITransferenciasDAO;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author march
 */
public class FrmRetiros extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(FrmRetiros.class.getName());
    private final IClientesDAO clientesDAO;
    private final IDireccionesClientesDAO direccionesClientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IRetirosDAO retirosDAO;
    private final ITransferenciasDAO transferenciasDAO;
    private final Cliente clienteSesion;
    private final Cuenta cuentaIniciada;
    private boolean operacion;
    private float cantidadAgregada;

    public FrmRetiros(Cuenta cuentaIniciada, Cliente clienteSesion, IClientesDAO clientesDAO, IDireccionesClientesDAO direccionesClientesDAO, ICuentasDAO cuentasDAO, IRetirosDAO retirosDAO, ITransferenciasDAO transferenciasDAO) {
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
        this.operacion = true;
        this.cantidadAgregada = 0f;
        initComponents();
        this.imprimirDatos();
        this.txtCantidad.setText(String.valueOf(cantidadAgregada));
    }

    public void imprimirDatos() {
        this.txtFolio.setText(numFolioAleatorio());
        this.txtContraseña.setText(contraseñaAleatoria());
        this.txtNumTarjeta.setText(this.cuentaIniciada.getNumeroCuenta());
    }

    public Retiro consultarFormulario() {
        String folio = this.txtFolio.getText();
        String contraseña = this.txtContraseña.getText();
        float cantidad = Float.parseFloat(this.txtCantidad.getText());
        String numCuentaOrigen = this.txtNumTarjeta.getText();
        Retiro retiro = new Retiro(folio, contraseña, cantidad, numCuentaOrigen);
        return retiro;
    }

    public void registrarRetiro() {
        try {
            Retiro retiro = this.consultarFormulario();
            this.retirosDAO.insertar(retiro);
            mostrarMensajeRetiroRealizado();
            FrmBanco frmBanco = new FrmBanco(cuentaIniciada, clienteSesion, clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
            frmBanco.setVisible(true);
            this.dispose();
        } catch (PersistenciaException e) {
            mostrarMensajeErrorAlRetirar();
        }
    }

    public static String numFolioAleatorio() {
        // El banco de caracteres
        String banco = "1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < 12; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    public static String contraseñaAleatoria() {
        // El banco de caracteres
        String banco = "1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < 8; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    private void mostrarMensajeRetiroRealizado() {
        JOptionPane.showMessageDialog(
                this,
                "Retiro realizado de manera exitosa",
                "INFORMACIÓN",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeErrorAlRetirar() {
        JOptionPane.showMessageDialog(
                this,
                "No fue posible realizar el retiro",
                "ERROR",
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtNumTarjeta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn500 = new javax.swing.JButton();
        btn1000 = new javax.swing.JButton();
        btn2000 = new javax.swing.JButton();
        btn200 = new javax.swing.JButton();
        btn100 = new javax.swing.JButton();
        btn50 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCancelar1 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnSumar = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Folio:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tarjeta de Origen:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtFolio.setEditable(false);
        txtFolio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 140, -1));

        txtContraseña.setEditable(false);
        txtContraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 140, -1));

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 100, -1));

        txtNumTarjeta.setEditable(false);
        txtNumTarjeta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtNumTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Retirar Saldo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 30));

        btn500.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn500.setForeground(new java.awt.Color(0, 102, 255));
        btn500.setText("$ 500");
        btn500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500ActionPerformed(evt);
            }
        });
        jPanel1.add(btn500, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 90, 50));

        btn1000.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn1000.setForeground(new java.awt.Color(0, 102, 255));
        btn1000.setText("$ 1000");
        btn1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1000ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1000, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 90, 50));

        btn2000.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn2000.setForeground(new java.awt.Color(0, 102, 255));
        btn2000.setText("$ 2000");
        btn2000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2000ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2000, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 90, 50));

        btn200.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn200.setForeground(new java.awt.Color(0, 102, 255));
        btn200.setText("$ 200");
        btn200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn200ActionPerformed(evt);
            }
        });
        jPanel1.add(btn200, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 90, 50));

        btn100.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn100.setForeground(new java.awt.Color(0, 102, 255));
        btn100.setText("$ 100");
        btn100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn100ActionPerformed(evt);
            }
        });
        jPanel1.add(btn100, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 90, 50));

        btn50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn50.setForeground(new java.awt.Color(0, 102, 255));
        btn50.setText("$ 50");
        btn50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn50ActionPerformed(evt);
            }
        });
        jPanel1.add(btn50, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 90, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/potros-itson-chico.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btnCancelar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 100, 30));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 100, 30));

        btnSumar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSumar.setText("Sumar");
        btnSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSumar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 100, 30));

        btnRestar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRestar.setText("Restar");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cancelar el retiro?", "CANCELAR", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            FrmInicio inicio = new FrmInicio(clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
            inicio.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (Float.parseFloat(this.txtCantidad.getText()) > 0) {
            this.registrarRetiro();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Tiene que agregar una cantidad de dinero",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarActionPerformed
        this.operacion = true;
    }//GEN-LAST:event_btnSumarActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        this.operacion = false;
    }//GEN-LAST:event_btnRestarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn100;
    private javax.swing.JButton btn1000;
    private javax.swing.JButton btn200;
    private javax.swing.JButton btn2000;
    private javax.swing.JButton btn50;
    private javax.swing.JButton btn500;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRestar;
    private javax.swing.JButton btnSumar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtNumTarjeta;
    // End of variables declaration//GEN-END:variables
}
