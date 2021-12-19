package com.example.proveedor.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pieza")
public class Pieza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="precio")
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "fk_idCategoria")
    @NonNull
    private Categoria categoria;

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

    @NonNull
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(@NonNull Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pieza)) return false;
        Pieza pieza = (Pieza) o;
        return getId().equals(pieza.getId()) && getNombre().equals(pieza.getNombre()) && getPrecio().equals(pieza.getPrecio()) && getCategoria().equals(pieza.getCategoria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getPrecio(), getCategoria());
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                '}';
    }
}