package com.example.crudmelaku;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Deporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNombre;
    private String nombre;

    public Deporte(int idNombre, String nombre) {
        this.idNombre = idNombre;
        this.nombre = nombre;
    }

    public Deporte() {
    }

    public void setId(int idNombre) {
        this.idNombre = idNombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return idNombre;
    }

    public String getNombre() {
        return nombre;
    }
}
