package controller;

import model.Product;
import repository.ICrudRepository;

public class ProductController extends Controller<Product>{
    protected ProductController(ICrudRepository<Product> repository) {
        super(repository);
    }
}
