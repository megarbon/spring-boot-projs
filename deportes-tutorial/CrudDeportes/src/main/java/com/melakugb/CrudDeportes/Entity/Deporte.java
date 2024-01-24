package com.melakugb.CrudDeportes.Entity;

import jakarta.persistence.*;

//Esto significa que esta clase representará una entidad de la bbdd, también debe estar en el paquete entity
@Entity
//Este tag significa que la tabla a la que representa esta clase se llama deporte (en la bbdd)
@Table(name = "deporte")
public class Deporte {

    //Con los tag id y generated value indicamos que el siguiente atributo es una clave primaria y se genera automáticamente
    //debido a que es un campo auto increment en la bd por lo que cuando se inserte un nuevo registro se genera el id nuevo solo.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nombre")
    private int idNombre;
    @Column(name = "nombre")
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
