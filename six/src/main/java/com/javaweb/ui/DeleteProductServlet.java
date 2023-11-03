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

@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/deleteProduct"})
public class DeleteProductServlet extends HttpServlet {

    ProductDao productDao = new ProductDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productDao.find(Integer.parseInt(id));
        req.setAttribute("product", product);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/delete.jsp");
        rd.forward(req, resp);
    }

 /*   private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        Product product = productDao.find(Integer.parseInt(id));
        req.setAttribute("product", product);
        RequestDispatcher rd = req.getRequestDispatcher("/edit.jsp");
        rd.forward(req, resp);
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("Submit") != null) {
            String id = req.getParameter("id");
            Product product = new Product(Integer.parseInt(id));
            productDao.delete(product);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/viewProduct");
        rd.forward(req, resp);

    }
}
