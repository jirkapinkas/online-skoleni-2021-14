package cz.gopas.skoleni.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcItemRepository implements ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from item", Long.class);
    }

}
