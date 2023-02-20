/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Misael Marchena - 233418 Magda Ramírez - 233523
 */
public class ConexionBD implements IConexionBD {

    private final String cadenaConexion;
    private final String usuario;
    private final String password;

    /**
     * Método que establece los atributos de la clase ConexionBD.
     *
     * @param CadenaConexion Cadena de texto que realiza la conexión a la base
     * de datos.
     * @param usuario Cadena de texto con el usuario que realiza la conexión a
     * la base de datos.
     * @param password Cadena de texto con la contraseña que se utiliza para
     * realizar la conexión a la base de datos.
     */
    public ConexionBD(String CadenaConexion, String usuario, String password) {
        this.cadenaConexion = CadenaConexion;
        this.usuario = usuario;
        this.password = password;
    }

    /**
     * Método que crea la conexión a la base de datos.
     *
     * @return conexion Conexión a la base de datos.
     * @throws SQLException Lanza una excepción si existe algún error a la hora
     * de crear la conexión a la base de datos.
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
        return conexion;
    }
}
