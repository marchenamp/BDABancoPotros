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
public class Retiro {
    private String folio;
    private String contraseña;
    private float cantidad;
    private Date fechaHoraRealizacion;
    private String numCuentaOrigen;

    public Retiro(String folio, String contraseña, float cantidad, Date fechaHoraRealizacion, String numCuentaOrigen) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.cantidad = cantidad;
        this.fechaHoraRealizacion = fechaHoraRealizacion;
        this.numCuentaOrigen = numCuentaOrigen;
        
    }
    
    public Retiro(String folio, String contraseña, float cantidad, String numCuentaOrigen) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.cantidad = cantidad;
        this.numCuentaOrigen = numCuentaOrigen;
        
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaHoraRealizacion() {
        return fechaHoraRealizacion;
    }

    public void setFechaHoraRealizacion(Date fechaHoraRealizacion) {
        this.fechaHoraRealizacion = fechaHoraRealizacion;
    }

    public String getNumCuentaOrigen() {
        return numCuentaOrigen;
    }

    public void setIdCuentaOrigen(String numCuentaOrigen) {
        this.numCuentaOrigen = numCuentaOrigen;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.folio);
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
        final Retiro other = (Retiro) obj;
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        return true;
    }
    
    
}
