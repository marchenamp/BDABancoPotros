/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Cliente;
import dominio.DireccionesClientes;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDireccionesClientesDAO;
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
public class DireccionesClientesDAO implements IDireccionesClientesDAO{

    private static final Logger LOG = Logger.getLogger(DireccionesClientesDAO.class.getName());
    private final IConexionBD generadorConexiones;
    
    public DireccionesClientesDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }
    
    @Override
    public DireccionesClientes consultar(Integer idDireccionCliente) {
        String codigoSQL = "select IDdireccion,calle,numero,colonia "
                + "from direccionesclientes "
                + "where IDdireccion = ?";
        try (Connection conexion = generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, idDireccionCliente);
            ResultSet resultado = comando.executeQuery();
            
            DireccionesClientes direccionCliente = null;
            //Si se encontró el cliente...
            if (resultado.next()) {
                Integer idDireccion = resultado.getInt("IDdireccion");
                String calle = resultado.getString("calle");
                String numero = resultado.getString("numero");
                String colonia = resultado.getString("colonia");
                direccionCliente = new DireccionesClientes(idDireccion, calle, numero, colonia);
            }
            return direccionCliente;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
    
    @Override
    public Integer insertar(DireccionesClientes direccionCliente) throws PersistenciaException {
        String codigoSQL = "insert into direccionesclientes(calle,numero,colonia) "
                + "values(?,?,?)";
        try (Connection conexion = generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(
                        codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, direccionCliente.getCalle());
            comando.setString(2, direccionCliente.getNumero());
            comando.setString(3, direccionCliente.getColonia());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                int posicionLlavePrimaria = 1;
                Integer llavePrimaria = llavesGeneradas.getInt(posicionLlavePrimaria);
                direccionCliente.setIdDireccion(llavePrimaria);
                return direccionCliente.getIdDireccion();
            }
            throw new PersistenciaException("Direccion registrada, pero id no generado");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar la dirección");
        }
    }
}
