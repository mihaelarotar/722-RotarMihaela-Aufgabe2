package controller;

import model.LagerAktualisierung;
import repository.ICrudRepository;

public class LagerController extends Controller<LagerAktualisierung> {

    protected LagerController(ICrudRepository<LagerAktualisierung> repository) {
        super(repository);

    }

}
