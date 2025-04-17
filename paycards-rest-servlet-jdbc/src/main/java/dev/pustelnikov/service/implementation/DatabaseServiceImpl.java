package dev.pustelnikov.service.implementation;

import dev.pustelnikov.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import javax.sql.DataSource;

@RequiredArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {
    private final DataSource dataSource;

    @Override
    public void migrate() {
        Flyway.configure()
                .dataSource(dataSource)
                .load()
                .migrate();
    }
}
