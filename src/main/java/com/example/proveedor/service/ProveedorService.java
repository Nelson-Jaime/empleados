package com.example.proveedor.service;

import com.example.proveedor.dto.ProveedorDTO;
import com.example.proveedor.entity.Proveedor;
import com.example.proveedor.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Transactional
    public ProveedorDTO altaProveedor(ProveedorDTO proveedorDTO){

        Proveedor proveedor = proveedorRepository.save(dto_a_entidad(proveedorDTO));

        return entidad_a_dto(proveedor);
    }

    @Transactional
    public ProveedorDTO entidad_a_dto(Proveedor proveedor){

        ProveedorDTO dto = new ProveedorDTO();

        dto.setId(proveedor.getId());
        dto.setNombre(proveedor.getNombre());
        dto.setDireccion(proveedor.getDireccion());
        dto.setCiudad(proveedor.getCiudad());
        dto.setProvincia(proveedor.getProvincia());
        dto.setTelefono(proveedor.getTelefono());

        return dto;
    }

    @Transactional
    public Proveedor dto_a_entidad(ProveedorDTO dto){

        Proveedor proveedor = new Proveedor();

        proveedor.setId(dto.getId());
        proveedor.setNombre(dto.getNombre());
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setCiudad(dto.getCiudad());
        proveedor.setProvincia(dto.getProvincia());
        proveedor.setTelefono(dto.getTelefono());

        return proveedor;
    }
}