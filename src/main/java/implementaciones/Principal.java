/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.DireccionesClientes;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import interfaces.IDireccionesClientesDAO;
import interfaces.IRetirosDAO;
import interfaces.ITransferenciasDAO;
import java.util.logging.Logger;
import interfazGrafica.FrmInicio;
/**
 *
 * @author march
 */
public class Principal {
    
    private static final Logger LOG = Logger.getLogger(Principal.class.getName());
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionBD generadorConexiones = new ConexionBD("jdbc:mysql://localhost/banco_potros", "root", /*"magditabonita2003."*/"jordan02MAR");
        IClientesDAO clientesDAO = new ClientesDAO(generadorConexiones);
        IDireccionesClientesDAO direccionesClientesDAO = new DireccionesClientesDAO(generadorConexiones);
        ICuentasDAO cuentasDAO = new CuentasDAO(generadorConexiones);
        IRetirosDAO retirosDAO = new RetirosDAO(generadorConexiones);
        ITransferenciasDAO transferenciasDAO = new TransferenciasDAO(generadorConexiones);
        
        FrmInicio inicio = new FrmInicio(clientesDAO, direccionesClientesDAO, cuentasDAO, retirosDAO, transferenciasDAO);
        inicio.setVisible(true);

    }
    
}
