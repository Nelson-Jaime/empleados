package com.example.proveedor.service;

import com.example.proveedor.dto.CategoriaDto;
import com.example.proveedor.entity.Categoria;
import com.example.proveedor.repository.CategoriaRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class CategoriaServiceTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Test
    void createCategoria() {

        //Prepara
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Jamones");

        Categoria repository = categoriaRepository.save(categoria);

        //Actua
        CategoriaDto dto = categoriaService.createCategoria(categoriaService.entidad_a_dto(repository));

        //Afirma
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(dto.getNombre(), categoria.getNombre());
        Assertions.assertNotEquals("Tiendas", categoria.getNombre());
    }

    @Test
    void getAllCategoria() {

        //Prepara
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Admin");

        List<Categoria> lista = new ArrayList<>();
        lista.add(categoria);

        List<Categoria> categorias = categoriaRepository.saveAll(lista);

        //Actua
        List<CategoriaDto> guardados = categoriaService.getAllCategoria();

        //Afirma
        Assertions.assertEquals(categorias.size(), 1);
        Assertions.assertEquals(guardados.size(), 1);
        Assert.assertTrue(guardados.size() > 0);

    }

    @Test
    void updateCategoria() throws Exception {

        //Prepara
        Categoria categoria = new Categoria();
        categoria.setNombre("Admin");
        categoriaRepository.save(categoria);

        CategoriaDto dto = new CategoriaDto();
        dto.setNombre("User");
        categoriaRepository.save(categoriaService.dto_a_entidad(dto));

        //Actua
        CategoriaDto dtoModificado = categoriaService.updateCategoria(categoria.getId(),  dto);

        //Afirma
        Assertions.assertEquals("User", dtoModificado.getNombre());

    }

    @Test
    void updateCategoria_error()  {

        //Prepara
        Categoria categoria = new Categoria();
        categoria.setNombre("Sistemas");

        //Actua
        Assertions.assertThrows(Exception.class, () ->{

            //Afirma
            categoriaService.updateCategoria(5L, categoriaService.entidad_a_dto(categoria));
        });
    }

    @Test
    void deleteCategoria() throws Exception {

        //Prepara
        Categoria categoria = new Categoria();
        categoria.setNombre("Sistemas");
        categoriaRepository.save(categoria);

        //Actua
        categoriaService.deleteCategoria(categoria.getId());
        boolean eliminado = categoriaRepository.findById(categoria.getId()).isEmpty();

        //Afirma
        Assertions.assertTrue(eliminado);
    }
}