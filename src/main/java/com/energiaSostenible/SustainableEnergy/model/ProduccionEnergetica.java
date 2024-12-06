
package com.energiaSostenible.SustainableEnergy.model;

import jakarta.persistence.*;

@Entity
public class ProduccionEnergetica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String pais;
    private String year;
    private Double produccion;
    
    @ManyToOne
    @JoinColumn(name = "fuente_de_energia_id")
    private FuenteDeEnergia fuenteDeEnergia;

    public ProduccionEnergetica() {
    }

    public ProduccionEnergetica(Long id, String pais, String year, Double produccion, FuenteDeEnergia fuenteDeEnergia) {
        this.id = id;
        this.pais = pais;
        this.year = year;
        this.produccion = produccion;
        this.fuenteDeEnergia = fuenteDeEnergia;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getProduccion() {
        return produccion;
    }

    public void setProduccion(Double produccion) {
        this.produccion = produccion;
    }

    public FuenteDeEnergia getFuenteDeEnergia() {
        return fuenteDeEnergia;
    }

    public void setFuenteDeEnergia(FuenteDeEnergia fuenteDeEnergia) {
        this.fuenteDeEnergia = fuenteDeEnergia;
    }
    
    
}
