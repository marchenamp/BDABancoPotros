/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author Misael Marchena - 233418 Magda Ramírez - 233523
 */
public class DireccionesClientes {

    private Integer idDireccion;
    private String calle;
    private String numero;
    private String colonia;

    /**
     * Método que establece los atributos de la clase DireccionesCliente a
     * excepción de idDireccion.
     *
     * @param calle Cadena de texto con la calle de la dirección del cliente.
     * @param numero Cadena de texto con el número de la dirección del cliente.
     * @param colonia Cadena de texto con la colonia de la dirección del
     * cliente.
     */
    public DireccionesClientes(String calle, String numero, String colonia) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }

    /**
     * Método que establece los atributos de la clase DireccionesCliente.
     *
     * @param idDireccion Número entero con el ID de la dirección del cliente.
     * @param calle Cadena de texto con la calle de la dirección del cliente.
     * @param numero Cadena de texto con el número de la dirección del cliente.
     * @param colonia Cadena de texto con la colonia de la dirección del
     * cliente.
     */
    public DireccionesClientes(Integer idDireccion, String calle, String numero, String colonia) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
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
     * Método que obtiene calle.
     *
     * @return calle Cadena de texto con la calle de la dirección del cliente.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Método que establece calle.
     *
     * @param calle Cadena de texto con la calle de la dirección del cliente.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Método que obtiene numero.
     *
     * @return numero Cadena de texto con el número de la dirección del cliente.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Método que establece numero.
     *
     * @param numero Cadena de texto con el número de la dirección del cliente.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Método que obtiene colonia.
     *
     * @return Cadena de texto con la colonia de la dirección del cliente.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Método que establece colonia.
     *
     * @param colonia Cadena de texto con la colonia de la dirección del
     * cliente.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Método que regresa el código Hash de idDireccion.
     *
     * @return código Hash de idDireccion.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idDireccion);
        return hash;
    }

    /**
     * Compara DireccionesClientes con el objeto del parámetro.
     *
     * @param obj Objeto a comparar.
     * @return Verdadero si el objeto del parámetro es de la clase
     * DireccionesClientes y ambos tienen el mismo idDireccion, Falso en caso
     * contrario.
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
        final DireccionesClientes other = (DireccionesClientes) obj;
        if (!Objects.equals(this.idDireccion, other.idDireccion)) {
            return false;
        }
        return true;
    }

}
