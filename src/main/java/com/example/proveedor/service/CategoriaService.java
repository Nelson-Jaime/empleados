package com.example.proveedor.service;

import com.example.proveedor.dto.CategoriaDto;
import com.example.proveedor.entity.Categoria;
import com.example.proveedor.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    // Inyeccion del Repository
    @Autowired
    private CategoriaRepository categoriaRepository;

    //
    //Creacion de los metodos del CRUD
    //

    //Metodo que se encarga de crear una categoria
    @Transactional
    public CategoriaDto createCategoria(CategoriaDto categoriaDto){

        Categoria categoria = categoriaRepository.save(dto_a_entidad(categoriaDto));

        return entidad_a_dto(categoria);
    }

    //
    // Metodo que se encarga de obtener todas las categorias
    //
    @Transactional
    public List<CategoriaDto> getAllCategoria(){

        List<Categoria> lista = categoriaRepository.findAll();
        List<CategoriaDto> lista_a_dto = new ArrayList<>();

        for (Categoria c : lista){
            lista_a_dto.add(entidad_a_dto(c));
        }

        return lista_a_dto;
    }

    //
    // Metodo que se encarga de modificar al proveedor segun el ID
    //
    @Transactional
    public CategoriaDto updateCategoria(Long id, CategoriaDto dto) throws Exception {

        Categoria categoria = categoriaRepository.findById(id)
                                        .orElseThrow(() -> new Exception ("No se ha encontrado ninguna categoria"));

        categoria.setNombre(dto.getNombre());

        categoriaRepository.save(categoria);
        return entidad_a_dto(categoria);
    }

    //
    // Metodo que se encarga de eliminar una categoria segun su ID
    //
    @Transactional
    public void deleteCategoria(Long id) throws Exception {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new Exception ("No se ha encontrado ninguna categoria"));

        if (categoria != null){
            categoriaRepository.delete(categoria);
        }

    }

    //
    // Metodos para convertir de una Entidad a Dto
    // y de Dto a una Entidad
    //

    @Transactional
    public CategoriaDto entidad_a_dto(Categoria categoria){

        CategoriaDto dto = new CategoriaDto();

        dto.setId(categoria.getId());
        dto.setNombre(categoria.getNombre());

        return dto;
    }

    @Transactional
    public Categoria dto_a_entidad(CategoriaDto dto){

        Categoria categoria = new Categoria();

        categoria.setId(dto.getId());
        categoria.setNombre(dto.getNombre());

        return categoria;
    }
}