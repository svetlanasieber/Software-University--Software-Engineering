package fairyShop.models;

import fairyShop.models.Helper;
import fairyShop.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<Helper> {
    private Collection<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }


    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers);
    }

    @Override
    public void add(Helper helper) {
        this.helpers.add(helper);

    }

    @Override
    public boolean remove(Helper helper) {
        return this.helpers.remove(helper);
    }

    @Override
    public Helper findByName(String name) {
        return this.helpers.stream().filter(helper -> helper.getName().equals(name)).findFirst().orElse(null);
    }
}
