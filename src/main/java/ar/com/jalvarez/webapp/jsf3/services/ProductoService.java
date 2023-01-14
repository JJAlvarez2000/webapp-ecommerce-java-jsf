package ar.com.jalvarez.webapp.jsf3.services;

import ar.com.jalvarez.webapp.jsf3.models.Categoria;
import ar.com.jalvarez.webapp.jsf3.models.Producto;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

// local ejb para que maneje transacciones
@Local
public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
    void guardar(Producto producto);
    void eliminar(Long id);

    List<Categoria> listarCategorias();
    Optional<Categoria> porIdCategoria(Long id);
}
