package com.gus.dev23.service;

import com.gus.dev23.init.Sql;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestService {
    private final JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> TestService01() {
        return jdbcTemplate.queryForList(Sql.EMP_QUERY);
    }
}
