package controller;

import repository.ICrudRepository;


import java.util.List;


public abstract class Controller<E> {
    protected final ICrudRepository<E> repository;

    protected Controller(ICrudRepository<E> repository) {
        this.repository = repository;
    }

    /**
     * adds given entity
     * @param entity entity must be not null
     */
    public void add(E entity) {
        repository.save(entity);
    }

    /**
     * removes the entity with the specified id
     * @param entity entity must not be null
     */
    public void delete(E entity) {
        repository.delete(entity);
    }

    /**
     * removes the entity with the specified id
     * @param id id of the entity must not be null
     */
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    /**
     * updates given entity
     * @param entity entity must not be null
     */
    public void update(E entity) {
        repository.update(entity);
    }

    /**
     * returns the entity with the given id
     * @param id Integer, representing the ID of the entity to be returned
     * @return the entity with the given id
     */
    public E findById(Integer id) {
        return repository.findById(id);
    }

    /**
     * @return all entities
     */
    public List<E> getAll() {
        return repository.getAll();
    }


}

