package com.J_RAS.J_RAS.service;

import com.J_RAS.J_RAS.model.CarritoModel;
import com.J_RAS.J_RAS.model.ProductosModel;
import com.J_RAS.J_RAS.model.Usuarios;
import com.J_RAS.J_RAS.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public CarritoModel agregarAlCarrito(Usuarios usuario, ProductosModel producto, Integer cantidad) {
        CarritoModel item = new CarritoModel();
        item.setUsuario(usuario);
        item.setProducto(producto);
        item.setCantidad(cantidad);
        item.setFecha_agregado(LocalDateTime.now());

        return carritoRepository.save(item);
    }

    public List<CarritoModel> obtenerCarritoUsuario(Usuarios usuario) {
        return carritoRepository.findByUsuario(usuario);
    }

    public void eliminarItem(Long id) {
        carritoRepository.deleteById(id);
    }

    public void vaciarCarrito(Usuarios usuario) {
        List<CarritoModel> items = carritoRepository.findByUsuario(usuario);
        carritoRepository.deleteAll(items);
    }
}
