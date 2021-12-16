package com.example.proveedor.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoriaDto implements Serializable {

    private  Long id;
    private  String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaDto)) return false;
        CategoriaDto that = (CategoriaDto) o;
        return getId().equals(that.getId()) && getNombre().equals(that.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre());
    }

    @Override
    public String toString() {
        return "CategoriaDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}