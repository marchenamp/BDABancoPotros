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
import interfaces.IDireccionesClientesDAO;
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
        IConexionBD generadorConexiones = new ConexionBD("jdbc:mysql://localhost/banco_potros", "root", "magditabonita2003."/*"jordan02MAR"*/ );
//        IClientesDAO clientesDAO = new ClientesDAO(generadorConexiones);
        IDireccionesClientesDAO direccionesClientesDAO = new DireccionesClientesDAO(generadorConexiones);
//        
//        FrmInicio inicio = new FrmInicio(clientesDAO, direccionesClientesDAO);
//        inicio.setVisible(true);
        try{
        DireccionesClientes direccion = new DireccionesClientes("leuze","1032","Cedros 2");
        direccionesClientesDAO.insertar(direccion);
        } catch (PersistenciaException e){
            
        }
    }
    
}
