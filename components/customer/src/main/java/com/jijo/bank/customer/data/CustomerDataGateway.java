package com.jijo.bank.customer.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@Repository
public class CustomerDataGateway {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDataGateway(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public CustomerRecord create(String name) {
        KeyHolder keyholder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into customer (name) values (?)", RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            return ps;
        }, keyholder);

        return find(keyholder.getKey().longValue());
    }

    public CustomerRecord find(long id) {
        List<CustomerRecord> list = jdbcTemplate.query("select id, name from customer where id = ? limit 1", rowMapper, id);

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }


    private RowMapper<CustomerRecord> rowMapper =
        (rs, num) -> new CustomerRecord(rs.getLong("id"), rs.getString("name"));
}
