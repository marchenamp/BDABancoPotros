/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
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
public class ClientesDAO implements IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD generadorConexiones;

    /**
     * Método constructor que crea la conexión con la base de datos.
     *
     * @param generadorConexiones Parámetro que genera la base de datos.
     */
    public ClientesDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    /**
     * Método que consulta un cliente en la base de datos.
     *
     * @param idCliente Número entero con el ID del cliente.
     * @return Cliente consultado, null si ocurre un error.
     */
    @Override
    public Cliente consultar(Integer idCliente) {
        String codigoSQL = "SELECT "
                + "usuario, "
                + "contraseña, "
                + "nombre, "
                + "apellidoPaterno, "
                + "apellidoMaterno, "
                + "fechaNacimiento, "
                + "edad, "
                + "IDdireccion "
                + "FROM clientes WHERE IDcliente = ?";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, idCliente);
            ResultSet resultado = comando.executeQuery();

            Cliente cliente = null;
            //Si se encontró el cliente...
            if (resultado.next()) {
                String usuario = resultado.getString("usuario");
                String contraseña = resultado.getString("contraseña");
                String nombre = resultado.getString("nombre");
                String apellidoPaterno = resultado.getString("apellidoPaterno");
                String apellidoMaterno = resultado.getString("apellidoMaterno");
                Date fechaNacimiento = resultado.getDate("fechaNacimiento");
                Integer edad = resultado.getInt("edad");
                Integer idDireccion = resultado.getInt("IDdireccion");
                cliente = new Cliente(idCliente, usuario, contraseña, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, edad, idDireccion);
            }
            return cliente;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    /**
     * Método que consulta la existencia de un usuario en la base de datos.
     *
     * @param usuario Cadena de texto con el usuario del cliente.
     * @return Cliente cuya existencia fue consultada, null si ocurre un error.
     */
    @Override
    public Cliente consultarExistencia(String usuario) {
        String codigoSQL = "SELECT "
                + "IDcliente, "
                + "usuario, "
                + "contraseña, "
                + "nombre, "
                + "apellidopaterno, "
                + "apellidomaterno, "
                + "fechanacimiento, "
                + "edad, "
                + "IDdireccion "
                + "FROM clientes WHERE usuario = ?";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, usuario);
            ResultSet resultado = comando.executeQuery();

            Cliente cliente = null;
            //Si se encontró el cliente...
            if (resultado.next()) {
                Integer idCliente = resultado.getInt("IDcliente");
                String contraseña = resultado.getString("contraseña");
                String nombre = resultado.getString("nombre");
                String apellidoPaterno = resultado.getString("apellidoPaterno");
                String apellidoMaterno = resultado.getString("apellidoMaterno");
                Date fechaNacimiento = resultado.getDate("fechaNacimiento");
                Integer edad = resultado.getInt("edad");
                Integer idDireccion = resultado.getInt("IDdireccion");
                cliente = new Cliente(idCliente, usuario, contraseña, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, edad, idDireccion);
            }
            return cliente;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    /**
     * Método que inserta un cliente a la base de datos.
     *
     * @param cliente Objeto de la clase Cliente, con usuario, contraseña,
     * nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, edad,
     * IDdireccion.
     * @return cliente insertado, null si ocurre un error.
     * @throws PersistenciaException Lanza una excepción si hay un error en la
     * ejecución del método.
     */
    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "INSERT INTO clientes( "
                + "usuario, "
                + "contraseña, "
                + "nombre, "
                + "apellidoPaterno, "
                + "apellidoMaterno, "
                + "fechaNacimiento, "
                + "edad, "
                + "IDdireccion "
                + ") VALUES ("
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?)";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cliente.getUsuario());
            comando.setString(2, cliente.getContraseña());
            comando.setString(3, cliente.getNombre());
            comando.setString(4, cliente.getApellidoPaterno());
            comando.setString(5, cliente.getApellidoMaterno());
            comando.setDate(6, cliente.getFechaNacimiento());
            comando.setInt(7, cliente.getEdad());
            comando.setInt(8, cliente.getIdDireccion());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                int posicionLlavePrimaria = 1;
                Integer llavePrimaria = llavesGeneradas.getInt(posicionLlavePrimaria);
                cliente.setIdCliente(llavePrimaria);
                return cliente;
            }
            throw new PersistenciaException("Cliente registrado, pero id no generado");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");
        }
    }

    /**
     * Método que elimina un cliente de la base de datos.
     *
     * @param idCliente Número entero con el ID del cliente.
     * @return Cliente eliminado si la cantidad de clientes es mayor a 0, null
     * en caso contrario o si ocurre un error.
     */
    @Override
    public Cliente eliminar(Integer idCliente) {
        String codigoSQL = "DELETE FROM clientes WHERE IDcliente = ?";
        try (Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, idCliente);
            Cliente cliente = consultar(idCliente);
            int numClientesEliminados = comando.executeUpdate();
            conexion.close();
            return numClientesEliminados > 0 ? cliente : null;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
