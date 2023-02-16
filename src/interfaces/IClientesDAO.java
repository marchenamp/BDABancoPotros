/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;

/**
 *
 * @author march
 */
public interface IClientesDAO {
    Cliente consultar(Integer idCliente);
    Cliente insertar(Cliente cliente) throws PersistenciaException;
    Cliente eliminar(Integer id);
}
