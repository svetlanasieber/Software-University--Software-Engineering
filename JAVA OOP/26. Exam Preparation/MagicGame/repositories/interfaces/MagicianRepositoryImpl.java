package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;

import static magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl implements  MagicianRepository<Magician>{
    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return data;
    }

    @Override
    public void addMagician(Magician magician) {
        if (magician == null){
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        this.data.add(magician);

    }

    @Override
    public boolean removeMagician(Magician magician) {
        return this.data.remove(magician);
    }

    @Override
    public Magician findByUsername(String name) {
        return this.data.stream().filter(magician -> magician.getUsername().equals(name)).findAny().orElse(null);
    }
}
