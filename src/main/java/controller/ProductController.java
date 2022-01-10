package controller;

import model.LagerAktualisierung;
import model.Product;
import repository.ICrudRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductController extends Controller<Product>{
    private LagerController lagerController;

    protected ProductController(ICrudRepository<Product> repository, LagerController lagerController) {
        super(repository);
        this.lagerController = lagerController;
    }

    public List<Product> updateLager() {
        /*for(Product product : getAll()) {
            for(LagerAktualisierung aktualisierung: lagerController.getAll()) {
                for(Map.Entry<String, Integer> entry : aktualisierung.getListeProdukte()) {
                    if (product.getName().equals(entry.getKey())) {
                        product.setAnzahl(product.getAnzahl() + entry.getValue());
                    }
                }
            }
        }
        return getAll();*/

        return this.getAll().stream().map(product -> {
            for (LagerAktualisierung aktualisierung : lagerController.getAll()) {
                for (Map.Entry<String, Integer> entry : aktualisierung.getListeProdukte()) {
                    if (product.getName().equals(entry.getKey())) {
                        product.setAnzahl(product.getAnzahl() + entry.getValue());
                    }
                }
            }
            return product;
        }).collect(Collectors.toList());
    }
}
