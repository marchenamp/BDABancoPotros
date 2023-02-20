/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import interfaces.IConexionBD;
import interfaces.ITransferenciasDAO;
import java.util.logging.Logger;

/**
 *
 * @author Misael Marchena - 233418 Magda Ramírez - 233523
 */
public class TransferenciasDAO implements ITransferenciasDAO {

    private static final Logger LOG = Logger.getLogger(TransferenciasDAO.class.getName());
    private final IConexionBD generadorConexiones;

    /**
     * Método constructor que crea la conexión con la base de datos.
     *
     * @param generadorConexiones Parámetro que genera la base de datos.
     */
    public TransferenciasDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

}
