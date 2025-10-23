//package softuni.exam.database;
////TestDbDealersTable
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceUtils;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@DataJpaTest
//public class TestDbDealersTable {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//    @Test
//    void testDealersTable() throws SQLException {
//        DatabaseMetaData metaData = getDatabaseMetaData();
//        List<String> expectedResult = new ArrayList<>();
//        expectedResult.add("ID,BIGINT,0,null,64");
//        expectedResult.add("AVERAGE_MONTHLY_TURNOVER,DOUBLE PRECISION,0,null,53");
//        expectedResult.add("BIRTHDAY,DATE,1,null,10");
//        expectedResult.add("FIRST_NAME,CHARACTER VARYING,0,null,255");
//        expectedResult.add("LAST_NAME,CHARACTER VARYING,0,null,255");
//        expectedResult.add("SALARY,DOUBLE PRECISION,0,null,53");
//        expectedResult.add("OFFERING_CAR_ID,BIGINT,1,null,64");
//
//
//        ResultSet columns = metaData.getColumns(null, "PUBLIC", "DEALERS", null);
//
//        final List<String> actualResult = new ArrayList<>();
//
//        while (columns.next()) {
//            actualResult.add(String.format("%s,%s,%s,%s,%s",
//                    columns.getString("COLUMN_NAME"),
//                    columns.getString("TYPE_NAME"),
//                    columns.getString("NULLABLE"),
//                    columns.getString("BUFFER_LENGTH"),
//                    columns.getString("COLUMN_SIZE")
//            ));
//        }
//
//        Assertions.assertArrayEquals(expectedResult.stream().sorted().toArray(), actualResult.stream().sorted().toArray());
//    }
//
//    private DatabaseMetaData getDatabaseMetaData() throws SQLException {
//        DataSource dataSource = getJdbcTemplate().getDataSource();
//        Connection connection = DataSourceUtils.getConnection(dataSource);
//        return connection.getMetaData();
//    }
//}