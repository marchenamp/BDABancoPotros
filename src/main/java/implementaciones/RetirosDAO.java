/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Cuenta;
import dominio.Retiro;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IRetirosDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Misael Marchena - 233418 Magda Ramírez - 233523
 */
public class RetirosDAO implements IRetirosDAO {

    private static final Logger LOG = Logger.getLogger(RetirosDAO.class.getName());
    private final IConexionBD generadorConexiones;

    /**
     * Método constructor que crea la conexión con la base de datos.
     *
     * @param generadorConexiones Parámetro que genera la base de datos.
     */
    public RetirosDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    /**
     * Método que consulta un retiro en la base de datos.
     *
     * @param folio Cadena de texto con el folio del retiro.
     * @param contraseña Cadena de texto con la contraseña del retiro.
     * @return retiro consultado, null si ocurre un error.
     */
    @Override
    public Retiro consultar(String folio, String contraseña) {
        String codigoSQL = "SELECT "
                + "cantidad, "
                + "fechaHoraRealizacion, "
                + "numCuentaOrigen "
                + "FROM retiros WHERE folio = ? AND contraseña = ?";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, folio);
            comando.setString(2, contraseña);
            ResultSet resultado = comando.executeQuery();

            Retiro retiro = null;
            //Si se encontró la cuenta...
            if (resultado.next()) {
                float cantidad = resultado.getFloat("cantidad");
                Date fechaHoraRealizacion = resultado.getDate("fechaHoraRealizacion");
                String numCuenta = resultado.getString("numCuentaOrigen");
                retiro = new Retiro(folio, contraseña, cantidad, fechaHoraRealizacion, numCuenta);
            }
            return retiro;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    /**
     * Método que inserta un retiro a la base de datos.
     *
     * @param retiro Objeto de la clase Retiro que cuenta con folio, contraseña,
     * cantidad y numCuentaOrigen.
     * @return retiro insertado si la cantidad de filasAgregadas es mayor a 0,
     * null en caso contrario o si ocurre un error.
     * @throws PersistenciaException Lanza una excepción si hay un error en la
     * ejecución del método.
     */
    @Override
    public Retiro insertar(Retiro retiro) throws PersistenciaException {
        String codigoSQL = "INSERT INTO retiros("
                + "folio, "
                + "contraseña, "
                + "cantidad, "
                + "numCuentaOrigen"
                + ") VALUES ( "
                + "?, "
                + "?, "
                + "?, "
                + "?)";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, retiro.getFolio());
            comando.setString(2, retiro.getContraseña());
            comando.setFloat(3, retiro.getCantidad());
            comando.setString(4, retiro.getNumCuentaOrigen());
            int filasAgregadas = comando.executeUpdate();

            if (filasAgregadas > 0) {
                return retiro;
            }
            throw new PersistenciaException("Retiro registrado, pero id no generado");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar el retiro");
        }
    }

    /**
     * Método que resta dinero de un numero de cuenta de la base de datos.
     *
     * @param cantidad Número decimal con la cantidad a retirar.
     * @param numCuenta Cadena de texto con el número de cuenta.
     * @throws PersistenciaException Lanza una excepción si hay un error en la
     * ejecución del método.
     */
    @Override
    public void retirarDinero(float cantidad, String numCuenta) throws PersistenciaException {
        String codigoSQL = "update cuentas "
                + "set saldo =  saldo - ? "
                + "where numerocuenta = ? ";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setFloat(1, cantidad);
            comando.setString(2, numCuenta);
            comando.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible hacer el retiro");
        }
    }
}
