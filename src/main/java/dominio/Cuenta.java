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
public class Cuenta {

    private String numeroCuenta;
    private Date fechaApertura;
    private float saldo;
    private Integer idCliente;

    /**
     * Método que establece los atributos de la clase Cuenta.
     *
     * @param numeroCuenta Cadena de texto con el número de cuenta.
     * @param fechaApertura Fecha de apertura de la cuenta con el formato
     * yyyy-MM-dd.
     * @param saldo Número decimal con el saldo de la cuenta.
     * @param idCliente Número entero con el ID del cliente propietario de la
     * cuenta.
     */
    public Cuenta(String numeroCuenta, Date fechaApertura, float saldo, Integer idCliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    /**
     * Método que obtiene numeroCuenta.
     *
     * @return numeroCuenta Cadena de texto con el número de cuenta.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Método que establece numeroCuenta.
     *
     * @param numeroCuenta Cadena de texto con el número de cuenta.
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Método que obtiene fechaApertura.
     *
     * @return fechaApertura Fecha de apertura de la cuenta con el formato
     * yyyy-MM-dd.
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Método que obtiene saldo.
     *
     * @return saldo Número decimal con el saldo de la cuenta.
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Método que establece saldo.
     *
     * @param saldo Número decimal con el saldo de la cuenta.
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Método que obtiene idCliente.
     *
     * @return idCliente Número entero con el ID del cliente propietario de la
     * cuenta.
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Método que establece idCliente.
     *
     * @param idCliente Número entero con el ID del cliente propietario de la
     * cuenta.
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Método que regresa el código Hash de numeroCuenta.
     *
     * @return código Hash de numeroCuenta.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numeroCuenta);
        return hash;
    }

    /**
     * Compara cuenta con el objeto del parámetro.
     *
     * @param obj Objeto a comparar.
     * @return Verdadero si el objeto del parámetro es de la clase Cuenta y
     * ambos tienen el mismo numeroCuenta, Falso en caso contrario.
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
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.numeroCuenta, other.numeroCuenta)) {
            return false;
        }
        return true;
    }

}
