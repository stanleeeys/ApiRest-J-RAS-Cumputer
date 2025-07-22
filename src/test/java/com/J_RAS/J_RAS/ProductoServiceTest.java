package com.J_RAS.J_RAS;

import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.repository.ProductoRepository;
import com.J_RAS.J_RAS.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ProductoServiceTest {
    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;
    @Test
    public void testGuardarProducto_Exitoso() {
        // Arrange
        ProductosModel producto = new ProductosModel();
        producto.setNombre("Laptop");
        producto.setDescripcion("Gaming");
        producto.setPrecio(BigDecimal.valueOf(999.99));
        producto.setImagen_url("img/laptop.jpg");

        ProductosModel productoGuardado = new ProductosModel();
        productoGuardado.setId(1L); // Simulamos que ya fue guardado
        productoGuardado.setNombre("Laptop");
        productoGuardado.setDescripcion("Gaming");
        productoGuardado.setPrecio(BigDecimal.valueOf(999.99));
        productoGuardado.setImagen_url("img/laptop.jpg");

        when(productoRepository.save(producto)).thenReturn(productoGuardado);

        // Act
        ProductosModel resultado = productoService.guardarProducto(producto);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Laptop", resultado.getNombre());
    }
    @Test
    public void testGuardarProducto_Nulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            productoService.guardarProducto(null);
        });
    }

}

