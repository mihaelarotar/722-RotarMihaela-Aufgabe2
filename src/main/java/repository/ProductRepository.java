package repository;

import model.Product;

import java.util.Objects;

public class ProductRepository extends InMemoryRepository<Product>{
    /**
     * returns the entity with the given id
     *
     * @param id Integer, representing the ID of the entity to be returned
     * @return the entity with the given id
     */
    @Override
    public Product findById(Integer id) {
        return repoList.stream()
                .filter(product -> Objects.equals(product.getId(), id))
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
        repoList.removeIf(product -> Objects.equals(product.getId(), id));
    }

    /**
     * updates given entity
     *
     * @param entity entity must not be null
     * @return the entity - if the entity is updated, otherwise returns null (if this entity does not exist)
     */
    @Override
    public Product update(Product entity) {
        Product productToUpdate = findById(entity.getId());
        productToUpdate.setPreis(entity.getPreis());
        productToUpdate.setName(entity.getName());
        productToUpdate.setSku(entity.getSku());

        return productToUpdate;
    }
}
