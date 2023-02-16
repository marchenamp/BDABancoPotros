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
 * @author march
 */
public class ConexionBD implements IConexionBD{
    private final String cadenaConexion;
    private final String usuario;
    private final String password;

    public ConexionBD(String CadenaConexion, String usuario, String password) {
        this.cadenaConexion = CadenaConexion;
        this.usuario = usuario;
        this.password = password;
    }
    
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
        return conexion;
    }
}
