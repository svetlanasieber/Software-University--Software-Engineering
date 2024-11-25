package bg.softuni.orm.context;

import bg.softuni.orm.core.Column;
import bg.softuni.orm.core.Entity;
import bg.softuni.orm.core.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityManager<E> implements DbContext<E> {
    public static final String INSERT_SQL = "INSERT INTO %s (%s) VALUES (%s)";
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        int idValue = getIdValue(entity);

        if (idValue == 0) {
            return doInsert(entity);
        }
        return doUpdate(entity, idValue);
    }

    // Find table name
    // Find column names
    // Find column values
    // Generate + Execute sql
    private boolean doInsert(E entity) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        List<String> columnNames = findEntityColumns(entity);
        List<String> columnValues = findEntityValues(entity);

        String insertSQL = String.format(INSERT_SQL,
                tableName,
                String.join(",", columnNames),
                String.join(",", columnValues)
        );

        int updateCount = connection.prepareStatement(insertSQL).executeUpdate();
        return updateCount == 1;
    }

    private boolean doUpdate(E entity, int idValue) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        List<String> columnNames = findEntityColumns(entity);
        List<String> columnValues = findEntityValues(entity);

        List<String> updateColumns = new ArrayList<>();
        for (int i = 0; i < columnNames.size(); i++) {
            String formatted = String.format("%s=%s",
                    columnNames.get(i),
                    columnValues.get(i));

            updateColumns.add(formatted);
        }

        String updateSQL = String.format("UPDATE %s SET %s WHERE id = %d",
                tableName,
                String.join(",", updateColumns),
                idValue);

        int updateCount = connection.prepareStatement(updateSQL).executeUpdate();
        return updateCount == 1;
    }

    private List<String> findEntityValues(E entity) throws IllegalAccessException {
        List<String> result = new ArrayList<>();

        for (Field field : entity.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            }

            field.setAccessible(true);
            Object value = field.get(entity).toString();
            result.add("'" + value + "'");
        }

        return result;
    }

    private List findEntityColumns(E entity) {
        return Arrays
                .stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> field.getAnnotation(Column.class))
                .map(ann -> ann.name())
                .toList();
    }

    @Override
    public Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return find(table, null);
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(table);

        String selectSingleSQL = String.format("SELECT * FROM %s %s",
                tableName,
                where == null ? "" : where);

        ResultSet resultSet = connection.prepareStatement(selectSingleSQL).executeQuery();

        List<E> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(mapEntity(table, resultSet));
        }

        return result;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, null);
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String withLimit = where == null ? "LIMIT 1" : where + " LIMIT 1";

        Iterable<E> es = find(table, withLimit);

        if (!es.iterator().hasNext()) {
            return null;
        }

        return es.iterator().next();
//
//        String tableName = getTableName(table);
//
//        String selectSingleSQL = String.format("SELECT * FROM %s %s %s",
//                tableName,
//                where == null ? "" : where,
//                "LIMIT 1");
//
//        ResultSet resultSet = connection.prepareStatement(selectSingleSQL).executeQuery();
//
//        if (resultSet.next()) {
//            return mapEntity(table, resultSet);
//        }
//
//        return null;
    }

    private E mapEntity(Class<E> type, ResultSet dbResult) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        E result = type.getDeclaredConstructor().newInstance();

        for (Field field : type.getDeclaredFields()) {
            if (!field.isAnnotationPresent(Id.class) &&
                !field.isAnnotationPresent(Column.class)) {
                continue;
            }

            result = mapField(result, field, dbResult);
        }

        return result;
    }

    private E mapField(E object, Field field, ResultSet dbResult) throws IllegalAccessException, SQLException {
        String column = "id";

        if (field.isAnnotationPresent(Column.class)) {
            column = field.getAnnotation(Column.class).name();
        }

        Object dbValue = mapValue(field, column, dbResult);

        field.setAccessible(true);
        field.set(object, dbValue);

        return object;
    }

    private Object mapValue(Field field, String column, ResultSet dbResult) throws SQLException {
        if (field.getType() == int.class || field.getType() == Integer.class) {
            return dbResult.getInt(column);
        } else if (field.getType() == String.class) {
            return dbResult.getString(column);
        } else if (field.getType() == LocalDate.class) {
            String date = dbResult.getString(column);

            return LocalDate.parse(date);
        }

        throw new IllegalArgumentException("Unsupported type " + field.getType());
    }

    private String getTableName(Class<?> clazz) {
        Entity annotation = clazz.getAnnotation(Entity.class);

        if (annotation == null) {
            throw new IllegalArgumentException("Entity annotation missing!");
        }

        return annotation.name();
    }

    // Get all fields
    // Find field with @Id
    // Get value from field
    private int getIdValue(E entity) throws IllegalAccessException {
        List<Field> idFields = Arrays
                .stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .toList();

        if (idFields.size() != 1) {
            throw new IllegalArgumentException("Entity must have 1 ID field");
        }

        Field idField = idFields.get(0);
        idField.setAccessible(true);
        return (int) idField.get(entity);
    }
}
