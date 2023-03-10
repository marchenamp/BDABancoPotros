/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Misael Marchena - 233418 Magda Ramírez - 233523
 */
public class CuentasDAO implements ICuentasDAO {

    private static final Logger LOG = Logger.getLogger(CuentasDAO.class.getName());
    private final IConexionBD generadorConexiones;

    /**
     * Método constructor que crea la conexión con la base de datos.
     *
     * @param generadorConexiones Parámetro que genera la base de datos.
     */
    public CuentasDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    /**
     * Método que consulta en la base de datos un número de cuenta.
     *
     * @param numCuenta Cadena de texto con el número de cuenta.
     * @return Cuenta consultada, null si ocurre un error.
     */
    @Override
    public Cuenta consultar(String numCuenta) {
        String codigoSQL = "SELECT "
                + "fechaapertura, "
                + "saldo, "
                + "idcliente "
                + "FROM cuentas WHERE numerocuenta = ?";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, numCuenta);
            ResultSet resultado = comando.executeQuery();

            Cuenta cuenta = null;
            //Si se encontró la cuenta...
            if (resultado.next()) {
                Date fechaApertura = resultado.getDate("fechaApertura");
                float saldo = resultado.getFloat("saldo");
                Integer idCliente = resultado.getInt("IDcliente");
                cuenta = new Cuenta(numCuenta, fechaApertura, saldo, idCliente);
            }
            return cuenta;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    /**
     * Método que inserta una cuenta a la base de datos.
     *
     * @param cuenta Objeto de la clase Cuenta con numeroCuenta, fechaApertura,
     * saldo y idCliente.
     * @return Cuenta insertada, null si ocurre un error.
     * @throws PersistenciaException Lanza una excepción si hay un error en la
     * ejecución del método.
     */
    @Override
    public Cuenta insertar(Cuenta cuenta) throws PersistenciaException {
        String codigoSQL = "INSERT INTO cuentas("
                + "numeroCuenta, "
                + "fechaApertura, "
                + "saldo, "
                + "IDcliente"
                + ") VALUES ( "
                + "?, "
                + "?, "
                + "?, "
                + "?)";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cuenta.getNumeroCuenta());
            comando.setDate(2, cuenta.getFechaApertura());
            comando.setFloat(3, cuenta.getSaldo());
            comando.setInt(4, cuenta.getIdCliente());
            int filasAgregadas = comando.executeUpdate();

            if (filasAgregadas > 0) {
                return cuenta;
            }
            throw new PersistenciaException("Cuenta registrada, pero id no generado");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");
        }
    }

    /**
     * Método que consulta un número de cuenta en la base de datos para
     * posteriormente insertarlo en el JComboBox de FrmCuentas.
     *
     * @param columna Cadena de texto con la columna a insertar.
     * @param combo JComboBox de FrmCuentas.
     */
    @Override
    public void rellenarComboCuentas(String columna, JComboBox combo) {
        String codigoSQL = "SELECT * FROM cuentas";
        try {
            Statement statement;
            Connection conexion = generadorConexiones.crearConexion();
            statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(codigoSQL);
            while (resultado.next()) {
                String numeroCuenta = resultado.getString(columna);
                combo.addItem(numeroCuenta);
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    /**
     * Método que suma el saldo del número de cuenta en la base de datos.
     *
     * @param numCuenta Cadena de texto con el número de cuenta.
     * @param cantidad Número decimal de la cantidad en la cuenta.
     * @throws PersistenciaException Lanza una excepción si hay un error en la
     * ejecución del método.
     */
    @Override
    public void sumarSaldo(String numCuenta, float cantidad) throws PersistenciaException {
        String codigoSQL = "UPDATE cuentas "
                + "SET saldo = saldo + ? "
                + "WHERE numeroCuenta = ?";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setFloat(1, cantidad);
            comando.setString(2, numCuenta);
            comando.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");
        }
    }

}
