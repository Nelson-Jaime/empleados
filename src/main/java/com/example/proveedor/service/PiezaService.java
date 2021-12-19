package com.example.proveedor.service;

import com.example.proveedor.dto.PiezaDTO;
import com.example.proveedor.entity.Categoria;
import com.example.proveedor.entity.Pieza;
import com.example.proveedor.repository.CategoriaRepository;
import com.example.proveedor.repository.PiezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PiezaService {

    // Inyeccion del Repository
    @Autowired
    private PiezaRepository piezaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    //
    //Creacion de los metodos del CRUD
    //

    //Metodo que se encarga de crear una pieza
    @Transactional
    public PiezaDTO createPieza(PiezaDTO piezaDTO) throws Exception {

        Pieza pieza = piezaRepository.save(dto_a_entidad(piezaDTO));
        return entidad_a_dto(pieza);
    }

    //
    // Metodo que se encarga de obtener todas las piezas
    //
    @Transactional
    public List<PiezaDTO> getAllPieza(){

        List<Pieza> lista = piezaRepository.findAll();
        List<PiezaDTO> lista_a_dto = new ArrayList<>();

        for(Pieza p : lista){
            lista_a_dto.add(entidad_a_dto(p));
        }

        return lista_a_dto;
    }

    //
    // Metodo que se encarga de modificar al proveedor segun el ID
    //
    @Transactional
    public PiezaDTO updatePieza(Long id, PiezaDTO dto) throws Exception {

        Pieza pieza = piezaRepository.findById(id)
                .orElseThrow(() -> new Exception ("No se ha encontrado ninguna pieza"));

        pieza.setNombre(dto.getNombre());
        pieza.setPrecio(dto.getPrecio());
        piezaRepository.save(pieza);

        return entidad_a_dto(pieza);
    }

    //
    // Metodo que se encarga de eliminar una categoria segun su ID
    //
    @Transactional
    public void deletePieza(Long id) throws Exception {

        Pieza pieza = piezaRepository.findById(id)
                .orElseThrow(() -> new Exception ("No se ha encontrado ninguna pieza"));

        if (pieza != null){
            piezaRepository.delete(pieza);
        }
    }

    //
    // Metodos para convertir de una Entidad a Dto
    // y de Dto a una Entidad
    //

    public Pieza dto_a_entidad(PiezaDTO dto) throws Exception {

        Pieza pieza = new Pieza();
        //pieza.setId(dto.getId());
        pieza.setNombre(dto.getNombre());
        pieza.setPrecio(dto.getPrecio());

        Categoria categoria = categoriaRepository.findById(dto.getFk_idCategoria())
                .orElseThrow(() -> new Exception ("No se ha encontrado ninguna categoria >> dto_a_entidad"));

        pieza.setCategoria(categoria);

        return pieza;
    }

    public PiezaDTO entidad_a_dto(Pieza pieza) {

        PiezaDTO dto = new PiezaDTO();
        //dto.setId(pieza.getId());
        dto.setNombre(pieza.getNombre());
        dto.setPrecio(pieza.getPrecio());
        dto.setFk_idCategoria(pieza.getCategoria().getId());

        return dto;
    }
}