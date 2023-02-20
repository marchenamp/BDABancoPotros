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
public class Transferencia {

    private Integer idTransferencia;
    private float cantidad;
    private Date fechaHoraRealizacion;
    private String numCuentaOrigen;
    private String numCuentaDestino;

    /**
     * Método que establece los parámetros de la clase Transferencia a excepción
     * de idTransferencia.
     *
     * @param cantidad Número decimal con la cantidad a transferir.
     * @param fechaHoraRealizacion Fecha y hora de la realización de la
     * transferencia con los formatos yyyy-MM-dd hh:mm.
     * @param numCuentaOrigen Cadena de texto con el ID de la cuenta origen de la
     * transferencia.
     * @param numCuentaDestino Cadena de texto con el ID de la cuenta destino de la
     * transferencia.
     */
    public Transferencia(float cantidad, Date fechaHoraRealizacion, String numCuentaOrigen, String numCuentaDestino) {
        this.cantidad = cantidad;
        this.fechaHoraRealizacion = fechaHoraRealizacion;
        this.numCuentaOrigen = numCuentaOrigen;
        this.numCuentaDestino = numCuentaDestino;
    }

    /**
     * Método que establece los parámetros de la clase Transferencia a excepción
     * de idTransferencia y fechaHoraRealizacion.
     *
     * @param cantidad Número decimal con la cantidad a transferir.
     * @param numCuentaOrigen Cadena de texto con el ID de la cuenta origen de la
     * transferencia.
     * @param numCuentaDestino Cadena de texto con el ID de la cuenta destino de la
     * transferencia.
     */
    public Transferencia(float cantidad, String numCuentaOrigen, String numCuentaDestino) {
        this.cantidad = cantidad;
        this.numCuentaOrigen = numCuentaOrigen;
        this.numCuentaDestino = numCuentaDestino;
    }

    /**
     * Método que obtiene idTransferencia.
     *
     * @return idTransferencia Número entero con el ID de la transferencia.
     */
    public Integer getIdTransferencia() {
        return idTransferencia;
    }

    /**
     * Método que establece idTransferencia.
     *
     * @param idTransferencia Número entero con el ID de la transferencia.
     */
    public void setIdTransferencia(Integer idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    /**
     * Método que obtiene cantidad.
     *
     * @return cantidad Número decimal con la cantidad a transferir.
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Método que establece cantidad.
     *
     * @param cantidad Número decimal con la cantidad a transferir.
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método que obtiene fechaHoraRealizacion.
     *
     * @return fechaHoraRealizacion Fecha y hora de la realización de la
     * transferencia con los formatos yyyy-MM-dd hh:mm.
     */
    public Date getFechaHoraRealizacion() {
        return fechaHoraRealizacion;
    }

    /**
     * Método que establece fechaHoraRealizacion.
     *
     * @param fechaHoraRealizacion Fecha y hora de la realización de la
     * transferencia con los formatos yyyy-MM-dd hh:mm.
     */
    public void setFechaHoraRealizacion(Date fechaHoraRealizacion) {
        this.fechaHoraRealizacion = fechaHoraRealizacion;
    }

    /**
     * Método que obtiene numCuentaOrigen.
     *
     * @return numCuentaOrigen Cadena de texto con el ID de la cuenta origen de la
     * transferencia.
     */
    public String getNumCuentaOrigen() {
        return numCuentaOrigen;
    }

    /**
     * Método que establece numCuentaOrigen.
     *
     * @param numCuentaOrigen Cadena de texto con el ID de la cuenta origen de la
     * transferencia.
     */
    public void setNumCuentaOrigen(String numCuentaOrigen) {
        this.numCuentaOrigen = numCuentaOrigen;
    }

    /**
     * Método que obtiene numCuentaDestino.
     *
     * @return numCuentaDestino Cadena de texto con el ID de la cuenta destino de
     * la transferencia.
     */
    public String getnumCuentaDestino() {
        return numCuentaDestino;
    }

    /**
     * Método que establece numCuentaDestino.
     *
     * @param numCuentaDestino Cadena de texto con el ID de la cuenta destino de la
     * transferencia.
     */
    public void setNumCuentaDestino(String numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }

    /**
     * Método que regresa el código Hash de idTransferencia.
     *
     * @return código Hash de idTransferencia.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idTransferencia);
        return hash;
    }

    /**
     * Compara transferencia con el objeto del parámetro.
     *
     * @param obj Objeto a comparar.
     * @return Verdadero si el objeto del parámetro es de la clase Transferencia
     * y ambos tienen el mismo idTransferencia, Falso en caso contrario.
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
        final Transferencia other = (Transferencia) obj;
        if (!Objects.equals(this.idTransferencia, other.idTransferencia)) {
            return false;
        }
        return true;
    }

}
