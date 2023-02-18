/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import javax.swing.JComboBox;

/**
 *
 * @author march
 */
public interface ICuentasDAO {
    Cuenta consultar(String numCuenta);
    Cuenta insertar(Cuenta cuenta) throws PersistenciaException;
    void sumarSaldo(String numCuenta, float cantidad) throws PersistenciaException;
    void rellenarComboCuentas(String columna, JComboBox combo);
}
