package ar.com.jalvarez.webapp.jsf3.services;

import ar.com.jalvarez.webapp.jsf3.models.Categoria;
import ar.com.jalvarez.webapp.jsf3.models.Producto;
import ar.com.jalvarez.webapp.jsf3.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductoServiceImpl implements ProductoService {
    @Inject
    private CrudRepository<Producto> productoRepository;

    @Inject
    private CrudRepository<Categoria> categoriaRepository;
    @Override
    public List<Producto> listar() {
        return productoRepository.listar();
    }
    @Override
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(productoRepository.porId(id));
    }

    @Override
    public void guardar(Producto producto) {
        productoRepository.guardar(producto);
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.eliminar(id);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.listar();
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.ofNullable(categoriaRepository.porId(id));
    }
}
