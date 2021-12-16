package com.example.proveedor.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProveedorDTO  implements Serializable {

    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String telefono;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProveedorDTO)) return false;
        ProveedorDTO that = (ProveedorDTO) o;
        return getId().equals(that.getId()) && getNombre().equals(that.getNombre()) && getDireccion().equals(that.getDireccion()) && getCiudad().equals(that.getCiudad()) && getProvincia().equals(that.getProvincia()) && getTelefono().equals(that.getTelefono());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getDireccion(), getCiudad(), getProvincia(), getTelefono());
    }

    @Override
    public String toString() {
        return "ProveedorDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}