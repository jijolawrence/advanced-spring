package com.jijo.bank.testsupport;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.TimeZone;

public class TestScenarioSupport {

    private final JdbcTemplate template;
    private final DataSource dataSource;

    public TestScenarioSupport(String dbName) {
        dataSource = TestDataSourceFactory.create(dbName);
        template = new JdbcTemplate(dataSource);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void clearAllDatabases() {
        clearTables("onboarding_test", "customer");
    }

    private static void clearTables(String dbName, String... tableNames) {
        JdbcTemplate template = new JdbcTemplate(TestDataSourceFactory.create(dbName));

        for (String tableName : tableNames) {
            template.execute("delete from " + tableName);
        }
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
