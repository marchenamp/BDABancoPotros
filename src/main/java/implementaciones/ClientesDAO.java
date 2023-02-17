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
 * @author march
 */
public class ClientesDAO implements IClientesDAO{
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD generadorConexiones;
    
    public ClientesDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }
    
    @Override
    public Cliente consultar(Integer idCliente) {
        String codigoSQL = "select usuario,contraseña,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,edad,IDdireccion "
                + "from clientes "
                + "where IDcliente = ?";
        try (Connection conexion = generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
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
    
    @Override
    public Cliente consultarExistencia(String usuario) {
        String codigoSQL = "select IDcliente,usuario,contraseña,nombre,apellidopaterno,apellidomaterno,fechanacimiento,edad,IDdireccion "
                + "from clientes "
                + "where usuario = ?";
        try (Connection conexion = generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
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
    
    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "insert into clientes(usuario,contraseña,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,edad,IDdireccion) "
                + "values(?,?,?,?,?,?,?,?)";
        try (Connection conexion = generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(
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

    @Override
    public Cliente eliminar(Integer idCliente) {
        String codigoSQL = "delete from clientes "
                + "where IDcliente = ?";
        try (Connection conexion = generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
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
