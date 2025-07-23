package com.J_RAS.J_RAS.controller;

import com.J_RAS.J_RAS.dto.CarritoRequest;
import com.J_RAS.J_RAS.dto.CarritoRequestDTO;
import com.J_RAS.J_RAS.model.CarritoModel;
import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.model.UsuariosModel;
import com.J_RAS.J_RAS.repository.ProductoRepository;
import com.J_RAS.J_RAS.repository.UsuarioRepository;
import com.J_RAS.J_RAS.service.CarritoService;
import com.J_RAS.J_RAS.service.DTOMapper;
import com.J_RAS.J_RAS.service.ProductoService;
import com.J_RAS.J_RAS.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "http://localhost:4200")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productosRepository;

    @PostMapping("/agregar")
    public CarritoRequestDTO agregarProducto(@RequestBody CarritoRequest request) {
        System.out.println("usuarioId: " + request.getUsuarioId()); // para comprobar
        System.out.println("productoId: " + request.getProductoId());

        UsuariosModel usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        ProductosModel producto = productosRepository.findById(request.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        CarritoModel guardado = carritoService.agregarAlCarrito(usuario, producto, request.getCantidad());

        return DTOMapper.toCarritoDTO(guardado);
    }


    @GetMapping("/{usuarioId}")
    public List<CarritoRequestDTO> obtenerCarrito(@PathVariable Long usuarioId) {
        UsuariosModel usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        List<CarritoModel> carritoItems = carritoService.obtenerCarritoUsuario(usuario);

        return carritoItems.stream()
                .map(DTOMapper::toCarritoDTO)
                .collect(Collectors.toList());
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminarItem(@PathVariable Long id) {
        carritoService.eliminarItem(id);
    }

    @DeleteMapping("/vaciar/{usuarioId}")
    public void vaciarCarrito(@PathVariable Long usuarioId) {
        UsuariosModel usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        carritoService.vaciarCarrito(usuario);
    }
}
