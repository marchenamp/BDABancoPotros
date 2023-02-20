/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Misael Marchena - 233418 Magda Ramírez - 233523
 */
public class Cliente {

    private Integer idCliente;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private Integer edad;
    private Integer idDireccion;

    /**
     * Método que establece los atributos de la clase Cliente a excepción de
     * idCliente.
     *
     * @param usuario Cadena de texto con el usuario del cliente.
     * @param contraseña Cadena de texto con la contraseña del cliente.
     * @param nombre Cadena de texto con el nombre del cliente.
     * @param apellidoPaterno Cadena de texto con el apellido paterno del
     * cliente.
     * @param apellidoMaterno Cadena de texto con el apellido materno del
     * cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente con el formato
     * yyyy-MM-dd.
     * @param edad Número entero con la edad del cliente.
     * @param idDireccion Número entero con el ID de la dirección del cliente.
     */
    public Cliente(String usuario, String contraseña, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, Integer edad, Integer idDireccion) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.idDireccion = idDireccion;
    }

    /**
     * Método que establece los atributos de la clase Cliente.
     *
     * @param idCliente Número entero con el ID del cliente.
     * @param usuario Cadena de texto con el usuario del cliente.
     * @param contraseña Cadena de texto con la contraseña del cliente.
     * @param nombre Cadena de texto con el nombre del cliente.
     * @param apellidoPaterno Cadena de texto con el apellido paterno del
     * cliente.
     * @param apellidoMaterno Cadena de texto con el apellido materno del
     * cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente con el formato
     * yyyy-MM-dd.
     * @param edad Número entero con la edad del cliente.
     * @param idDireccion Número entero con el ID de la dirección del cliente.
     */
    public Cliente(Integer idCliente, String usuario, String contraseña, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, Integer edad, Integer idDireccion) {
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.idDireccion = idDireccion;
    }

    /**
     * Método que obtiene idCliente.
     *
     * @return idCliente Número entero con el ID del cliente.
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Método que establece IdCliente.
     *
     * @param idCliente Número entero con el ID del cliente.
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Método que obtiene usuario.
     *
     * @return usuario Cadena de texto con el usuario del cliente.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método que establece usuario.
     *
     * @param usuario Cadena de texto con el usuario del texto.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que obtiene nombre.
     *
     * @return nombre Cadena de texto con el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece nombre.
     *
     * @param nombre Cadena de texto con el nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que obtiene apellidoPaterno.
     *
     * @return apellidoPaterno Cadena de texto con el apellido paterno del
     * cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método que establece apellidoPaterno.
     *
     * @param apellidoPaterno Cadena de texto con el apellido paterno del
     * cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método que obtiene apellidoMaterno.
     *
     * @return apellidoMaterno Cadena de texto con el apellido materno del
     * cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método que establece apellidoMaterno.
     *
     * @param apellidoMaterno Cadena de texto con el apellido materno del
     * cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que obtiene fechaNacimiento.
     *
     * @return fechaNacimiento Fecha de nacimiento del cliente con el formato
     * yyyy-MM-dd.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método que establece fechaNacimiento.
     *
     * @param fechaNacimiento Fecha de nacimiento del cliente con el formato
     * yyyy-MM-dd.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método que obtiene edad.
     *
     * @return edad Número entero con la edad del cliente.
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Método que establece edad.
     *
     * @param edad Número entero con la edad del cliente.
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Método que obtiene idDireccion.
     *
     * @return idDireccion Número entero con el ID de la dirección del cliente.
     */
    public Integer getIdDireccion() {
        return idDireccion;
    }

    /**
     * Método que establece idDireccion.
     *
     * @param idDireccion Número entero con el ID de la dirección del cliente.
     */
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Método que obtiene contraseña.
     *
     * @return contraseña Cadena de texto con la contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Método que establece contraseña.
     *
     * @param contraseña Cadena de texto con la contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Método que regresa el código Hash de idCliente.
     *
     * @return código Hash de idCliente.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idCliente);
        return hash;
    }

    /**
     * Compara cliente con el objeto del parámetro.
     *
     * @param obj Objeto a comparar.
     * @return Verdadero si el objeto del parámetro es de la clase Cliente y
     * ambos tienen el mismo idCliente, Falso en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        return true;
    }

}
