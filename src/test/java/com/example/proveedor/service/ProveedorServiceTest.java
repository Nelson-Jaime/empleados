package com.example.proveedor.service;

import com.example.proveedor.dto.ProveedorDTO;
import com.example.proveedor.entity.Proveedor;
import com.example.proveedor.repository.ProveedorRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ProveedorServiceTest {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorService proveedorService;

    @Test
    void createProveedor() {

        //Prepara
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1L);
        proveedor.setNombre("Nelson");
        proveedor.setDireccion("Calle Rafael");
        proveedor.setCiudad("Barcelona");
        proveedor.setProvincia("Barcelona");
        proveedor.setTelefono("123456789");

        Proveedor repo = proveedorRepository.save(proveedor);

        //Actua
        ProveedorDTO dto = proveedorService.createProveedor(proveedorService.entidad_a_dto(repo));

        //Afirma
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(proveedor.getNombre(), dto.getNombre());
        Assertions.assertNotEquals(proveedor.getProvincia(), "Madrid");
    }

    @Test
    void getAllProveedor() {

        //Prepara
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1L);
        proveedor.setNombre("Nelson");
        proveedor.setDireccion("Calle Rafael");
        proveedor.setCiudad("Barcelona");
        proveedor.setProvincia("Barcelona");
        proveedor.setTelefono("123456789");

        List<Proveedor> lista = new ArrayList<Proveedor>();
        lista.add(proveedor);

        List<Proveedor> proveedores = proveedorRepository.saveAll(lista);

        //Actua
        List<ProveedorDTO> guardados = proveedorService.getAllProveedor();

        //Afirma
        Assert.assertEquals(proveedores.size(), 1);
        Assert.assertTrue(guardados.size() > 0);
    }

    @Test
    void updateProveedor() throws Exception {

        //Prepara
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Nelson");
        proveedor.setDireccion("Calle Rafael");
        proveedor.setCiudad("Barcelona");
        proveedor.setProvincia("Barcelona");
        proveedor.setTelefono("123456789");
        proveedorRepository.save(proveedor);

        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setNombre(proveedor.getNombre());
        proveedorDTO.setDireccion("Calle San Carles");
        proveedorDTO.setCiudad("Barcelona");
        proveedorDTO.setProvincia(proveedor.getProvincia());
        proveedorDTO.setTelefono("987654321");
        proveedorRepository.save(proveedorService.dto_a_entidad(proveedorDTO));

        //Actua
        ProveedorDTO dtoModificado = proveedorService.updateProveedor(proveedor.getId(), proveedorDTO);

        //Afirma
        Assertions.assertEquals("Nelson", dtoModificado.getNombre());
        Assertions.assertEquals(proveedor.getDireccion(), "Calle San Carles");
    }

    @Test
    void updateProveedor_error(){

        // Prepara

        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Apple");

        // Actua
        Assert.assertThrows(Exception.class, () -> {

            // Afirma
            proveedorService.updateProveedor(25L, proveedorService.entidad_a_dto(proveedor));
        });
    }

    @Test
    void deleteProveedor() throws Exception {

        //Prepara
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Nelson");
        proveedor.setDireccion("Calle Rafael");
        proveedor.setCiudad("Barcelona");
        proveedor.setProvincia("Barcelona");
        proveedor.setTelefono("123456789");
        proveedorRepository.save(proveedor);

        //Actua
        proveedorService.deleteProveedor(proveedor.getId());
        boolean eliminado = proveedorRepository.findById(proveedor.getId()).isEmpty();

        //Afirma
        Assertions.assertTrue(eliminado);
    }
}