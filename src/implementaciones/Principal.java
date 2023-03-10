/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import interfaces.IClientesDAO;
import interfaces.IConexionBD;
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
        IConexionBD generadorConexiones = new ConexionBD("jdbc:mysql://localhost/banco_potros", "root", "jordan02MAR");
        IClientesDAO clientesDAO = new ClientesDAO(generadorConexiones);
        
        new FrmInicio(clientesDAO).setVisible(true);
    }
    
}
