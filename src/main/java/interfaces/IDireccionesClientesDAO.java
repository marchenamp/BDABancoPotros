/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.DireccionesClientes;
import excepciones.PersistenciaException;

/**
 *
 * @author march
 */
public interface IDireccionesClientesDAO {
    DireccionesClientes consultar(Integer idDireccionCliente);
    Integer insertar(DireccionesClientes direccionCliente) throws PersistenciaException;
}
