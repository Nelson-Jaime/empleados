package com.example.proveedor.service;

import com.example.proveedor.dto.ProveedorDTO;
import com.example.proveedor.entity.Proveedor;
import com.example.proveedor.repository.ProveedorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ProveedorServiceTest {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorService service;

    @Test
    void altaProveedor() {

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
        ProveedorDTO dto = service.altaProveedor(service.entidad_a_dto(repo));

        //Afirma
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(proveedor.getNombre(), dto.getNombre());
    }
}