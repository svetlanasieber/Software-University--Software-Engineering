package harvesters.repository;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getCollection();

    void add(T entity);

    T byName(String name);
}
