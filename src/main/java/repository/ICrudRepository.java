package repository;

import java.util.List;

/**
 * CRUD operations repository interface
 */
public interface ICrudRepository<E> {

    /**
     * returns the entity with the given id
     * @param id Integer, representing the ID of the entity to be returned
     * @return the entity with the given id
     */
    E findById(Integer id);

    /**
     * @return all entities
     */
    List<E> getAll();

    /**
     * saves given entity
     * @param entity entity must be not null
     * @return the entity - if the given entity was created successfully, otherwise returns null (if the entity already exists)
     */
    E save(E entity);

    /**
     * removes the entity with the specified id
     * @param entity entity must not be null
     * @return the removed entity or null if there is no such entity
     *
     */
    E delete(E entity);

    /**
     * removes the entity with the specified id
     * @param id id of the entity must not be null
     */
    void deleteById(Integer id);

    /**
     * updates given entity
     * @param entity entity must not be null
     * @return the entity - if the entity is updated, otherwise returns null (if this entity does not exist)
     */
    E update(E entity);
}

