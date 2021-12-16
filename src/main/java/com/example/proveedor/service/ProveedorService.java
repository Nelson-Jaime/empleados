package com.example.proveedor.service;

import com.example.proveedor.dto.ProveedorDTO;
import com.example.proveedor.entity.Proveedor;
import com.example.proveedor.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorService {

    // Inyeccion del Repository
    @Autowired
    private ProveedorRepository proveedorRepository;

    //
    //Creacion de los metodos del CRUD
    //

    //Metodo que se encarga de crear un proovedor
    @Transactional
    public ProveedorDTO createProveedor(ProveedorDTO proveedorDTO){

        Proveedor proveedor = proveedorRepository.save(dto_a_entidad(proveedorDTO));

        return entidad_a_dto(proveedor);
    }

    //
    // Metodo que se encarga de obtener todos los prveedores
    //
    @Transactional
    public List<ProveedorDTO> getAllProveedor(){

        List<Proveedor> lista = proveedorRepository.findAll();
        List<ProveedorDTO> resultado = new ArrayList<>();

        for (Proveedor p : lista){
            resultado.add(entidad_a_dto(p));
        }
        return resultado;
    }

    //
    // Metodo que se encarga de modificar al proveedor segun el ID
    //
    @Transactional
    public ProveedorDTO updateProveedor(Long id, ProveedorDTO dto) throws Exception {

        Proveedor proveedor = proveedorRepository.findById(id)
                                            .orElseThrow(() -> new Exception("No se ha encontrado ningun proveedor"));

        proveedor.setNombre(dto.getNombre());
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setCiudad(dto.getCiudad());
        proveedor.setProvincia(dto.getProvincia());
        proveedor.setTelefono(dto.getTelefono());

        proveedorRepository.save(proveedor);
        return entidad_a_dto(proveedor);
    }

    //
    // Metodo que se encarga de eliminar un proveedor segun su ID
    //
    @Transactional
    public void deleteProveedor(Long id) throws Exception {

        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new Exception("No se ha encontrado ningun proveedor"));

        if (proveedor != null) {
            proveedorRepository.delete(proveedor);
        }
    }

    //
    // Metodos para convertir de una Entidad a Dto
    // y de Dto a una Entidad
    //

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