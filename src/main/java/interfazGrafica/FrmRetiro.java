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
import static interfazGrafica.FrmAgregarCuenta.cadenaAleatoria;
import java.sql.Date;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author march
 */
public class FrmRetiro extends javax.swing.JFrame {
    
    private static final Logger LOG = Logger.getLogger(FrmRetiro.class.getName());
    private final IClientesDAO clientesDAO;
    private final IDireccionesClientesDAO direccionesClientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IRetirosDAO retirosDAO;
    private final ITransferenciasDAO transferenciasDAO;
    private final Cliente clienteSesion;
    private final Cuenta cuentaIniciada;
    
    public FrmRetiro(Cuenta cuentaIniciada, Cliente clienteSesion, IClientesDAO clientesDAO, IDireccionesClientesDAO direccionesClientesDAO, ICuentasDAO cuentasDAO, IRetirosDAO retirosDAO, ITransferenciasDAO transferenciasDAO) {
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
        initComponents();
        this.imprimirDatos();
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
            this.mostrarMensajeCuentaGuardada();
            FrmBanco frmBanco = new FrmBanco(cuentaIniciada, clienteSesion, clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
            frmBanco.setVisible(true);
            this.dispose();
        } catch (PersistenciaException e) {
            this.mostrarMensajeErrorAlGuardado();
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
    
    private void mostrarMensajeCuentaGuardada() {
        JOptionPane.showMessageDialog(
                this,
                "Cuenta agregada exitosamente",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarMensajeErrorAlGuardado() {
        JOptionPane.showMessageDialog(
                this,
                "No fue posible agregar la cuenta",
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtNumTarjeta = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Folio:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel3.setText("Cantidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 188, -1, -1));

        jLabel4.setText("Número de Tarjeta de Origen:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 237, -1, -1));

        txtFolio.setEditable(false);
        jPanel1.add(txtFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 100, -1));

        txtContraseña.setEditable(false);
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 100, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 100, -1));

        txtNumTarjeta.setEditable(false);
        jPanel1.add(txtNumTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 100, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        btnCancelar.setText("Cancelar");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (Float.parseFloat(this.txtCantidad.getText()) > 0) {
            this.registrarRetiro();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Tiene que agregar una cantidad de dinero",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtNumTarjeta;
    // End of variables declaration//GEN-END:variables
}
