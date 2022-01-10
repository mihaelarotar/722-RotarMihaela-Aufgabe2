package repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<E> implements ICrudRepository<E>{
    protected List<E> repoList;

    protected InMemoryRepository() {
        this.repoList = new ArrayList<>();
    }


    /**
     * removes the entity with the specified id
     * @param entity entity must not be null
     * @return the removed entity or null if there is no such entity
     */
    @Override
    public E delete(E entity) {
        if(!this.repoList.contains(entity))
            return null;
        this.repoList.remove(entity);
        return entity;
    }

    /**
     * @return all entities
     */
    @Override
    public List<E> getAll() {
        return this.repoList;
    }

    /**
     * saves given entity
     * @param entity entity must be not null
     * @return the entity - if the given entity was created successfully, otherwise returns null (if the entity already exists)
     */
    @Override
    public E save(E entity) {
        if(this.repoList.contains(entity))
            return null;
        this.repoList.add(entity);
        return entity;
    }
}

