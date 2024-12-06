
package com.energiaSostenible.SustainableEnergy.model;

import jakarta.persistence.*;


@Entity
public class FuenteDeEnergia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false, unique = true)
    private String descripcion;

    protected FuenteDeEnergia() {}

    public FuenteDeEnergia(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
