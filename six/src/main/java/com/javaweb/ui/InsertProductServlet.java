package com.javaweb.ui;

import com.javaweb.dao.ProductDao;
import com.javaweb.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "InsertProductServlet", urlPatterns = {"/insertProduct"})
public class InsertProductServlet extends HttpServlet {

    ProductDao productDao = new ProductDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/insert.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("Submit") != null) {
            String name = req.getParameter("name");
            String model = req.getParameter("model");
            String factory = req.getParameter("factory");
            productDao.save(new Product(name, model, factory));
        }
    }
}
