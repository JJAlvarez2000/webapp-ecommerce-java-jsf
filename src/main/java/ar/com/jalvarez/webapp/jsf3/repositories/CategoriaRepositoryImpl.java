package ar.com.jalvarez.webapp.jsf3.repositories;

import ar.com.jalvarez.webapp.jsf3.models.Categoria;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class CategoriaRepositoryImpl implements CrudRepository<Categoria> {
    @Inject
    private EntityManager em;
    @Override
    public List<Categoria> listar() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    @Override
    public Categoria porId(Long id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public void guardar(Categoria categoria) {
        if(categoria.getId() == null) {
            em.persist(categoria);
        } else {
            em.merge(categoria);
        }
    }

    @Override
    public void eliminar(Long id) {
        em.remove(porId(id));
    }
}
