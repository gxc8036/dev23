package com.gus.dev23.init;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@Component
public class JdbcStartupRunner implements CommandLineRunner {

    public final HikariDataSource hikariDataSource;
    public static Map<String, Object> hikariCPStatusMap = new HashMap<>();

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(jdbcTemplate.queryForList(Sql.EMP_QUERY));
        initHCPPool();

    }

    private void initHCPPool() {
        if (hikariDataSource.getHikariPoolMXBean() != null) {
            hikariCPStatusMap.put("Total Connections", hikariDataSource.getHikariPoolMXBean().getTotalConnections());
            hikariCPStatusMap.put("Idle Connections", hikariDataSource.getHikariPoolMXBean().getIdleConnections());
            hikariCPStatusMap.put("Active Connections", hikariDataSource.getHikariPoolMXBean().getActiveConnections());
            hikariCPStatusMap.put("Threads Awaiting Connection", hikariDataSource.getHikariPoolMXBean().getThreadsAwaitingConnection());
        } else {
            hikariCPStatusMap.put("HikariCP Connection Pool Status", "HikariPoolMXBean is not yet available.");
        }
    }
}

