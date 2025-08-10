package harvesters.repository;

import harvesters.entity.field.Field;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class FieldRepository implements Repository<Field> {

    private Map<String, Field> fields;

    public FieldRepository() {
        this.fields = new LinkedHashMap<>();
    }

    @Override
    public Collection<Field> getCollection() {
        return Collections.unmodifiableCollection(this.fields.values());
    }

    @Override
    public void add(Field field) {
        this.fields.put(field.getName(), field);
    }

    @Override
    public Field byName(String name) {
        return this.fields.get(name);
    }
}