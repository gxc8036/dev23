package com.gus.dev23.init;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;


@RequiredArgsConstructor
@Component
public class JdbcStartupRunner implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    private final HikariDataSource hikariDataSource;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(jdbcTemplate.queryForList(Sql.EMP_QUERY));
    }

    @Scheduled(fixedRate = 1000)
    private void printHikariCPStatus() {
        if (hikariDataSource.getHikariPoolMXBean() != null) {
            System.out.println("\n--------------------------------");
            System.out.println("HikariCP Connection Pool Status");
            System.out.println("Total Connections: " + hikariDataSource.getHikariPoolMXBean().getTotalConnections());
            System.out.println("Idle Connections: " + hikariDataSource.getHikariPoolMXBean().getIdleConnections());
            System.out.println("Active Connections: " + hikariDataSource.getHikariPoolMXBean().getActiveConnections());
            System.out.println("Threads Awaiting Connection: " + hikariDataSource.getHikariPoolMXBean().getThreadsAwaitingConnection());
            System.out.println("--------------------------------\n");
        } else {
            System.out.println("HikariPoolMXBean is not yet available.");
        }
    }
}
