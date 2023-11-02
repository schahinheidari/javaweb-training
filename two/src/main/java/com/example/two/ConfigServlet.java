package com.example.two;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConfigServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dbUser = getInitParameter("db-username");
        String dbPass = getInitParameter("db-password");
        resp.getWriter().print("database user: " + dbUser);
        resp.getWriter().print(" database password: " + dbPass);
    }

}
