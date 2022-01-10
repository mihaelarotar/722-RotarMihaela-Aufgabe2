package repository;

import model.LagerAktualisierung;

import java.util.Objects;

public class LagerRepository extends InMemoryRepository<LagerAktualisierung>{
    /**
     * returns the entity with the given id
     *
     * @param id Integer, representing the ID of the entity to be returned
     * @return the entity with the given id
     */
    @Override
    public LagerAktualisierung findById(Integer id) {
        return repoList.stream()
                .filter(entry -> Objects.equals(entry.getId(), id))
                .findFirst()
                .orElse(null);
    }

    /**
     * removes the entity with the specified id
     *
     * @param id id of the entity must not be null
     */
    @Override
    public void deleteById(Integer id) {
        repoList.removeIf(entry -> Objects.equals(entry.getId(), id));
    }

    /**
     * updates given entity
     *
     * @param entity entity must not be null
     * @return the entity - if the entity is updated, otherwise returns null (if this entity does not exist)
     */
    @Override
    public LagerAktualisierung update(LagerAktualisierung entity) {
        LagerAktualisierung entryToUpdate = findById(entity.getId());
        entryToUpdate.setDatum(entity.getDatum());
        entryToUpdate.setListeProdukte(entity.getListeProdukte());

        return entryToUpdate;
    }
}
