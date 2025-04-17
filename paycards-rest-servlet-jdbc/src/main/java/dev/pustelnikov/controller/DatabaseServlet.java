package dev.pustelnikov.controller;

import dev.pustelnikov.datasource.implementation.DataSourceImpl;
import dev.pustelnikov.service.DatabaseService;
import dev.pustelnikov.service.implementation.DatabaseServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/db")
public class DatabaseServlet extends HttpServlet {
    private final DataSource dataSource = DataSourceImpl.getInstance();
    private final DatabaseService databaseService = new DatabaseServiceImpl(dataSource);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        databaseService.migrate();
    }
}
