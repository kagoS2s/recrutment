package com.source2sea.recruitment;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
class MovieService {

    private final JdbcTemplate jdbcTemplate;

    MovieService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    double getPrice(String name){
        return jdbcTemplate.queryForList("SELECT price from movies where name=?", Double.class, name).get(0);
    }
}
