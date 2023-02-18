/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import dominio.Cliente;
import dominio.DireccionesClientes;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDireccionesClientesDAO;
import interfaces.IRetirosDAO;
import interfaces.ITransferenciasDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author march
 */
public class FrmRegistroCliente extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(FrmRegistroCliente.class.getName());
    private final IClientesDAO clientesDAO;
    private final IDireccionesClientesDAO direccionesClientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IRetirosDAO retirosDAO;
    private final ITransferenciasDAO transferenciasDAO;

    /**
     * Creates new form FrmRegistroCliente
     */
    public FrmRegistroCliente(IClientesDAO clientesDAO, IDireccionesClientesDAO direccionesClientesDAO, ICuentasDAO cuentasDAO, IRetirosDAO retirosDAO, ITransferenciasDAO transferenciasDAO) {
//        ImageIcon icon = new ImageIcon(getClass().getResource("/multimedia/iconCaballoPerfil.png"));
//        this.setIconImage(icon.getImage());
        this.setTitle("REGISTRO");
        this.clientesDAO = clientesDAO;
        this.direccionesClientesDAO = direccionesClientesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
        this.transferenciasDAO = transferenciasDAO;
        initComponents();
        this.lblOcultar.setVisible(false);
    }

    private Cliente consultarFormularioCliente(Integer idDireccion) {
        String usuario = this.txtUsuario.getText();
        String contraseña = this.txtContraseña.getText();
        String nombre = this.txtNombre.getText();
        String apellidoPaterno = this.txtApellidoPaterno.getText();
        String apellidoMaterno = this.txtApellidoMaterno.getText();
        String fecha = ((JTextField) this.txtFechaNacimiento.getDateEditor().getUiComponent()).getText();
        Date fechaNacimiento = Date.valueOf(fecha);
        LocalDate nacimiento = fechaNacimiento.toLocalDate();
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaActual, nacimiento);
        Integer edad = Math.abs(periodo.getYears());
        Cliente cliente = new Cliente(usuario, contraseña, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, edad, idDireccion);
        return cliente;
    }

    private DireccionesClientes consultarFormularioDireccion() {
        String calle = this.txtCalle.getText();
        String numero = this.txtNumero.getText();
        String colonia = this.txtColonia.getText();
        DireccionesClientes direccionCliente = new DireccionesClientes(calle, numero, colonia);
        return direccionCliente;
    }

    private Integer guardarDireccion() {
        try {
            DireccionesClientes direccionCliente = this.consultarFormularioDireccion();
            Integer idDireccion = this.direccionesClientesDAO.insertar(direccionCliente);
            return idDireccion;
        } catch (PersistenciaException e) {
            this.mostrarMensajeErrorAlGuardado();
        }
        return null;
    }

    private void guardarCliente(Integer idDireccion) {
        try {
            Cliente cliente = this.consultarFormularioCliente(idDireccion);
            if (cliente.getEdad() > 12) {
                this.clientesDAO.insertar(cliente);
                this.mostrarMensajeClienteGuardado();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "¡Lo sentimos! No cuentas con la edad suficiente para contar con tarjeta Potros",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            FrmInicio inicio = new FrmInicio(clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
            inicio.setVisible(true);
            this.dispose();
        } catch (PersistenciaException e) {
            this.mostrarMensajeErrorAlGuardado();
        }
    }

    private void mostrarMensajeClienteGuardado() {
        JOptionPane.showMessageDialog(
                this,
                "Cliente agregado exitosamente",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeErrorAlGuardado() {
        JOptionPane.showMessageDialog(
                this,
                "No fue posible agregar al cliente",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void vaciarTextFields() {
        txtUsuario.setText(null);
        txtNombre.setText(null);
        txtApellidoPaterno.setText(null);
        txtApellidoMaterno.setText(null);
        txtCalle.setText(null);
        txtNumero.setText(null);
        txtColonia.setText(null);
        txtFechaNacimiento.setCalendar(null);
        txtContraseña.setText(null);
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
        lblNombres = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDatosPersonales = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        lblColonia = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        btnVaciar = new javax.swing.JButton();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        lblVer = new javax.swing.JLabel();
        lblOcultar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(470, 605));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(470, 605));
        jPanel1.setPreferredSize(new java.awt.Dimension(470, 605));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombres.setText("Nombre(s):");
        jPanel1.add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        lblApellidoPaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblApellidoPaterno.setText("Apellido Paterno:");
        jPanel1.add(lblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        lblApellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblApellidoMaterno.setText("Apellido Materno:");
        jPanel1.add(lblApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        lblFechaNacimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFechaNacimiento.setText("Fecha de Nacimiento:");
        jPanel1.add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(0, 102, 255));
        lblDireccion.setText("DIRECCIÓN");
        jPanel1.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 210, -1));

        txtApellidoPaterno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 210, -1));

        txtApellidoMaterno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 210, -1));

        btnRegistrarse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 120, 30));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 120, 30));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario:");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 210, -1));

        lblDatosPersonales.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDatosPersonales.setForeground(new java.awt.Color(0, 102, 255));
        lblDatosPersonales.setText("DATOS PERSONALES");
        jPanel1.add(lblDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        lblCalle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCalle.setText("Calle:");
        jPanel1.add(lblCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        lblColonia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblColonia.setText("Colonia:");
        jPanel1.add(lblColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        lblNumero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumero.setText("Número:");
        jPanel1.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        txtColonia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 210, -1));

        txtNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 210, -1));

        txtCalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 210, -1));

        btnVaciar.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        btnVaciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vaciar24.png"))); // NOI18N
        btnVaciar.setText("Vaciar");
        btnVaciar.setBorderPainted(false);
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        txtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 120, -1));

        lblContraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContraseña.setText("Contraseña:");
        jPanel1.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 210, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/potros-itson-chico.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ver.png"))); // NOI18N
        lblVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerMouseClicked(evt);
            }
        });
        jPanel1.add(lblVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, -1, -1));

        lblOcultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ocultar.png"))); // NOI18N
        lblOcultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOcultarMouseClicked(evt);
            }
        });
        jPanel1.add(lblOcultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        //   Integer idDireccion = guardarDireccion();
        guardarCliente(guardarDireccion());
        vaciarTextFields();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed
        // TODO add your handling code here:
        vaciarTextFields();
    }//GEN-LAST:event_btnVaciarActionPerformed

    private void lblVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerMouseClicked
        // TODO add your handling code here:
        lblVer.setVisible(false);
        lblOcultar.setVisible(true);
        txtContraseña.setEchoChar((char) 0);
    }//GEN-LAST:event_lblVerMouseClicked

    private void lblOcultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOcultarMouseClicked
        // TODO add your handling code here:
        lblVer.setVisible(true);
        lblOcultar.setVisible(false);
        txtContraseña.setEchoChar('•');
    }//GEN-LAST:event_lblOcultarMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea regresar a la pantalla de inicio?", "REGRESAR", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            FrmInicio inicio = new FrmInicio(clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
            inicio.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblDatosPersonales;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblOcultar;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVer;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JPasswordField txtContraseña;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
