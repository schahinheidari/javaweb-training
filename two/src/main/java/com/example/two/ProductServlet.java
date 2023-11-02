package com.example.two;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class ProductServlet extends HttpServlet {

    Connection connection;

    @Override
    public void init() throws ServletException {
        String dbUrl = getInitParameter("db-url");
        String dbUser = getInitParameter("db-username");
        String dbPass = getInitParameter("db-password");
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("**********************************************");
        System.out.println(resp);
        System.out.println("**********************************************");
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM product");
            resp.getWriter().print("<HTML><BODY><TABLE>");
//            resp.getWriter().print("<BODY>");
//            resp.getWriter().print("<TABLE>");

            while (rs.next()) {

                String pname = rs.getString("pname");
                String pproducer = rs.getString("pproducer");

                resp.getWriter().print("<TR>");
                resp.getWriter().print("<TD>");
                resp.getWriter().print(pname);
                resp.getWriter().print("</TD>");

                resp.getWriter().print("<TD>");
                resp.getWriter().print(pproducer);
                resp.getWriter().print("</TD>");
                resp.getWriter().print("</TR>");

            }
            rs.close();
            statement.close();
//            resp.getWriter().print("</TABLE>");
//            resp.getWriter().print("</BODY>");
            resp.getWriter().print("</TABLE></BODY></HTML>");
        }catch (Exception e){
            throw new IOException(e);
        }
    }
}
