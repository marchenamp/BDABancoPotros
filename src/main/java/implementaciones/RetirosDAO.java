/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import interfaces.IConexionBD;
import interfaces.IRetirosDAO;
import java.util.logging.Logger;

/**
 *
 * @author march
 */
public class RetirosDAO implements IRetirosDAO{

    private static final Logger LOG = Logger.getLogger(RetirosDAO.class.getName());
    private final IConexionBD generadorConexiones;

    public RetirosDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }
    
    
}
