package com.javaweb.dao;

import com.javaweb.entity.Product;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    String saveSQL = "INSERT INTO product(name, model,factory) values (?,?,?)";
    String updateSQL = "UPDATE product set name=?, model=?,factory=? WHERE id=?";
    String deleteSQL = "DELETE FROM product WHERE id=?";
    String selectAllSQL = "SELECT * FROM product";
    String findSQL = "SELECT * FROM product WHERE id=?";

    PreparedStatement ps = null;
    Connection cn = null;
    public void save(Product product){
        try {
            cn = ConnectionUtility.getConnection();
            ps = cn.prepareStatement(saveSQL);
            ps.setString(1, product.getName());
            ps.setString(2, product.getModel());
            ps.setString(3, product.getFactory());
            ps.executeUpdate();
            cn.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException(e);
        }
    }
    public void update(Product product){
        try {
            cn = ConnectionUtility.getConnection();
            ps = cn.prepareStatement(updateSQL);
            ps.setString(1, product.getName());
            ps.setString(2, product.getModel());
            ps.setString(3, product.getFactory());
            ps.setInt(4, product.getId());
            ps.executeUpdate();
            cn.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException(e);
        }
    }
    public void delete(Product product){
        try {
            cn = ConnectionUtility.getConnection();
            ps = cn.prepareStatement(deleteSQL);
            ps.setInt(1, product.getId());
            ps.executeUpdate();
            cn.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException(e);
        }
    }
    public List<Product> selectAll(){
        List<Product> result = new ArrayList<Product>();
        try {
            cn = ConnectionUtility.getConnection();
            ps = cn.prepareStatement(selectAllSQL);
            ResultSet rs = ps.executeQuery();
            cn.commit();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                String factory = rs.getString("factory");
                result.add(new Product(id, name, model, factory));
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException(e);
        }
        return result;
    }

    public Product find(Integer id) {
        Product product = null;
        try {
            cn = ConnectionUtility.getConnection();
            ps = cn.prepareStatement(findSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            cn.commit();
            while (rs.next()){
                String name = rs.getString("name");
                String model = rs.getString("model");
                String factory = rs.getString("factory");
                product = new Product(id, name, model, factory);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException(e);
        }
        return product;
    }
}
