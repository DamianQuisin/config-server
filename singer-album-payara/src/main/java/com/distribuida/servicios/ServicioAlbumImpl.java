package com.distribuida.servicios;

import com.distribuida.entidades.Album;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ServicioAlbumImpl implements ServicioAlbum {

    @Inject
    EntityManager entityManager;

    @Override
    public List<Album> listar() {
        List<Album> albums;
        albums = entityManager.createQuery("from Album").getResultList();
        return albums;
    }

    @Override
    public Album buscar(Integer id) {
        return entityManager.find(Album.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Album album = entityManager.find(Album.class, id);
        entityManager.remove(album);
        entityManager.getTransaction().commit();
    }

    @Override
    public void crear(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
    }

    @Override
    public void editar(Album album) {
        entityManager.getTransaction().begin();
        entityManager.merge(album);
        entityManager.getTransaction().commit();
    }
}
