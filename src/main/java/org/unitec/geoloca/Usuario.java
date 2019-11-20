/*
 Este modelo llamado Usuario se le conoce en MVC como ENTIDADES
y como regla de MVC las entidades deben estar encapsuladas, en caso de Spring: NO ES OPCIONAL 
*/
package org.unitec.geoloca;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import org.springframework.data.annotation.Id;

/**
 *
 * @author SE
 */
//Omite las columnas que no se saben
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private Double lat;
    private Double lon;
    private List<Materia> materias;
    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", lat=" + lat + ", lon=" + lon + '}';
    }
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    
    
}
