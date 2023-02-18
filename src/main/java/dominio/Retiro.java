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
    private Date fechaHoraRealizacion;
    private Integer idCuentaOrigen;

    public Retiro(String folio, String contraseña, Date fechaHoraRealizacion, Integer idCuentaOrigen) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.fechaHoraRealizacion = fechaHoraRealizacion;
        this.idCuentaOrigen = idCuentaOrigen;
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

    public Integer getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    public void setIdCuentaOrigen(Integer idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
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
