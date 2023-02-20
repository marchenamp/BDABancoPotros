/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.DireccionesClientes;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDireccionesClientesDAO;
import java.sql.Connection;
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
public class DireccionesClientesDAO implements IDireccionesClientesDAO {

    private static final Logger LOG = Logger.getLogger(DireccionesClientesDAO.class.getName());
    private final IConexionBD generadorConexiones;

    /**
     * Método constructor que crea la conexión con la base de datos.
     *
     * @param generadorConexiones Parámetro que genera la base de datos.
     */
    public DireccionesClientesDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    /**
     * Método que consulta el ID de la dirección de un en la base de datos.
     *
     * @param idDireccionCliente Número entero con el ID de la dirección del
     * cliente.
     * @return direccionCliente consultada, null si ocurre un error.
     */
    @Override
    public DireccionesClientes consultar(Integer idDireccionCliente) {
        String codigoSQL = "SELECT "
                + "IDdireccion, "
                + "calle, "
                + "numero, "
                + "colonia "
                + "FROM direccionesclientes WHERE IDdireccion = ?";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, idDireccionCliente);
            ResultSet resultado = comando.executeQuery();
            //Si se encontró el cliente...
            DireccionesClientes direccionCliente = null;
            if (resultado.next()) {
                String calle = resultado.getString("calle");
                String numero = resultado.getString("numero");
                String colonia = resultado.getString("colonia");

                direccionCliente = new DireccionesClientes(idDireccionCliente, calle, numero, colonia);
            }
            return direccionCliente;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    /**
     * Método que inserta direccionCliente a la base de datos.
     *
     * @param direccionCliente Objeto de la clase DireccionesClientes que
     * contiene calle, número y colonia.
     * @return direccionCliente insertado, null si ocurre un error.
     * @throws PersistenciaException Lanza una excepción si hay un error en la
     * ejecución del método.
     */
    @Override
    public Integer insertar(DireccionesClientes direccionCliente) throws PersistenciaException {
        String codigoSQL = "INSERT INTO direccionesclientes("
                + "calle, "
                + "numero, "
                + "colonia "
                + ")values ( "
                + "?, "
                + "?, "
                + "?)";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, direccionCliente.getCalle());
            comando.setString(2, direccionCliente.getNumero());
            comando.setString(3, direccionCliente.getColonia());
            comando.executeUpdate();

            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                direccionCliente.setIdDireccion(llavePrimaria);
                return direccionCliente.getIdDireccion();
            }
            LOG.log(Level.WARNING, "ERROR: ID no generado");
            System.out.println("Cliente insertado correctamente");
            throw new PersistenciaException("ERROR: ID no generado.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new PersistenciaException("ERROR: Cliente no registrado");
        }
    }
}
