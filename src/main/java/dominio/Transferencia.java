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
 * @author march
 */
public class Transferencia {
    private Integer idTransferencia;
    private float cantidad;
    private Date fechaHoraRealizacion;
    private Integer idCuentaOrigen;
    private Integer idCuentaDestino;

    public Transferencia(float cantidad, Date fechaHoraRealizacion, Integer idCuentaOrigen, Integer idCuentaDestino) {
        this.cantidad = cantidad;
        this.fechaHoraRealizacion = fechaHoraRealizacion;
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
    }

    public Integer getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(Integer idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaHoraRealizacion() {
        return fechaHoraRealizacion;
    }

    public void setFechaHoraRealizacion(Date fechaHoraRealizacion) {
        this.fechaHoraRealizacion = fechaHoraRealizacion;
    }

    public Integer getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    public void setIdCuentaOrigen(Integer idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }

    public Integer getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(Integer idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idTransferencia);
        return hash;
    }

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
