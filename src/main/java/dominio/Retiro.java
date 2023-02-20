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
public class Retiro {

    private String folio;
    private String contraseña;
    private float cantidad;
    private Date fechaHoraRealizacion;
    private String numCuentaOrigen;

    /**
     * Método que establece los parámetros de la clase Retiro.
     *
     * @param folio Cadena de texto con el folio del retiro.
     * @param contraseña Cadena de texto con la contraseña del retiro.
     * @param cantidad Número decimal con la cantidad a retirar.
     * @param fechaHoraRealizacion Fecha y hora de la realización del retiro con
     * los formatos yyyy-MM-dd hh:mm.
     * @param numCuentaOrigen Cadena de texto con el número de la cuenta de
     * origen del retiro.
     */
    public Retiro(String folio, String contraseña, float cantidad, Date fechaHoraRealizacion, String numCuentaOrigen) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.cantidad = cantidad;
        this.fechaHoraRealizacion = fechaHoraRealizacion;
        this.numCuentaOrigen = numCuentaOrigen;

    }

    /**
     * Método que establece los parámetros de la clase Retiro a excepción de
     * fechaHoraRealizacion.
     *
     * @param folio Cadena de texto con el folio del retiro.
     * @param contraseña Cadena de texto con la contraseña del retiro.
     * @param cantidad Número decimal con la cantidad a retirar.
     * @param numCuentaOrigen Cadena de texto con el número de la cuenta de
     * origen del retiro.
     */
    public Retiro(String folio, String contraseña, float cantidad, String numCuentaOrigen) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.cantidad = cantidad;
        this.numCuentaOrigen = numCuentaOrigen;

    }

    /**
     * Método que obtiene folio.
     *
     * @return folio Cadena de texto con el folio del retiro.
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Método que establece folio.
     *
     * @param folio Cadena de texto con el folio del retiro.
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Método que obtiene contraseña.
     *
     * @return contraseña Cadena de texto con la contraseña del retiro.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Método que establece contraseña.
     *
     * @param contraseña Cadena de texto con la contraseña del retiro.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Método que obtiene fechaHoraRealizacion.
     *
     * @return fechaHoraRealizacion Fecha y hora de la realización del retiro
     * con los formatos yyyy-MM-dd hh:mm.
     */
    public Date getFechaHoraRealizacion() {
        return fechaHoraRealizacion;
    }

    /**
     * Método que establece fechaHoraRealizacion.
     *
     * @param fechaHoraRealizacion Fecha y hora de la realización del retiro con
     * los formatos yyyy-MM-dd hh:mm.
     */
    public void setFechaHoraRealizacion(Date fechaHoraRealizacion) {
        this.fechaHoraRealizacion = fechaHoraRealizacion;
    }

    /**
     * Método que obtiene numCuentaOrigen.
     *
     * @return numCuentaOrigen Cadena de texto con el número de la cuenta de
     * origen del retiro.
     */
    public String getNumCuentaOrigen() {
        return numCuentaOrigen;
    }

    /**
     * Método que establece numCuentaOrigen.
     *
     * @param numCuentaOrigen Cadena de texto con el número de la cuenta de
     * origen del retiro.
     */
    public void setNumCuentaOrigen(String numCuentaOrigen) {
        this.numCuentaOrigen = numCuentaOrigen;
    }

    /**
     * Método que obtiene cantidad.
     *
     * @return cantidad Número decimal con la cantidad a retirar.
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Método que establece cantidad.
     *
     * @param cantidad Número decimal con la cantidad a retirar.
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método que regresa el código Hash de folio.
     *
     * @return código Hash de folio.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.folio);
        return hash;
    }

    /**
     * Compara retiro con el objeto del parámetro.
     *
     * @param obj Objeto a comparar.
     * @return Verdadero si el objeto del parámetro es de la clase Retiro y
     * ambos tienen el mismo folio, Falso en caso contrario.
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
        final Retiro other = (Retiro) obj;
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        return true;
    }

}
