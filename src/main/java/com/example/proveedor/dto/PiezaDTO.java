package com.example.proveedor.dto;

import java.util.Objects;

public class PiezaDTO {

    private Long id;
    private String nombre;
    private Float precio;
    private Long fk_idCategoria;

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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Long getFk_idCategoria() {
        return fk_idCategoria;
    }

    public void setFk_idCategoria(Long fk_idCategoria) {
        this.fk_idCategoria = fk_idCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PiezaDTO)) return false;
        PiezaDTO piezaDTO = (PiezaDTO) o;
        return getId().equals(piezaDTO.getId()) && getNombre().equals(piezaDTO.getNombre()) && getPrecio().equals(piezaDTO.getPrecio()) && getFk_idCategoria().equals(piezaDTO.getFk_idCategoria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getPrecio(), getFk_idCategoria());
    }

    @Override
    public String toString() {
        return "PiezaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", fk_idCategoria=" + fk_idCategoria +
                '}';
    }
}