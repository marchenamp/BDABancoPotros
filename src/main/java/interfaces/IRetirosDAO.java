/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cuenta;
import dominio.Retiro;
import excepciones.PersistenciaException;

/**
 *
 * @author march
 */
public interface IRetirosDAO {
    Retiro consultar(String folio, String contraseña); 
    Retiro insertar(Retiro retiro) throws PersistenciaException;
    void retirarDinero(float cantidad, String numCuenta) throws PersistenciaException;
}
