package com.codegym.dao.product;

import com.codegym.dao.DBConnection;
import com.codegym.model.Product;
import com.codegym.model.ProductView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    public static final String SQL_SELECT_ALL_PRODUCT = "SELECT * FROM products;";
    public static final String SQL_FIND_PRODUCT_BY_ID = "SELECT * FROM products WHERE id = ?;";
    public static final String SQL_ADD_NEW_PRODUCT = "INSERT INTO products (name, price, quantity, color, description, category_id) VALUES (?,?,?,?,?,?);";
    public static final String SQL_UPDATE_PRODUCT = "UPDATE products SET name = ?, price= ?, quantity = ?, color = ?, description = ?, category_id = ? WHERE id = ?;";
    public static final String SQL_DELETE_PRODUCT = "DELETE FROM products WHERE id = ?;";
    public static final String SQL_FIND_PRODUCT_BY_NAME = "SELECT p.id,p.name,p.price,p.quantity,p.color,p.quantity,p.description,c.name FROM products p join category c on p.category_id = c.id Where p.name like ?;";
    public static final String SQL_ALL_PRODUCTVIEW = "SELECT p.id,p.name,p.price,p.quantity,p.color,p.quantity,p.description,c.name FROM products p join category c on p.category_id = c.id;";
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double quantity = resultSet.getDouble("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");
                Product product = new Product(id, name, price, quantity, color, description, category_id);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double quantity = resultSet.getDouble("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");
                product = new Product(id, name, price, quantity, color, description, category_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean create(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_NEW_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategory_id());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateById(int id, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategory_id());
            preparedStatement.setInt(7, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ProductView> findAllByName(String q) {
        List<ProductView> productsViews = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_PRODUCT_BY_NAME);
            preparedStatement.setString(1, q);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("p.name");
                double price = resultSet.getDouble("p.price");
                double quantity = resultSet.getDouble("p.quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("p.description");
                String category_name = resultSet.getString("c.name");
                ProductView productView = new ProductView(id, name, price, quantity, color, description, category_name);
                productsViews.add(productView);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productsViews;
    }

    @Override
    public List<ProductView> findAllProductView() {
        List<ProductView> productsViews = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ALL_PRODUCTVIEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("p.name");
                double price = resultSet.getDouble("p.price");
                double quantity = resultSet.getDouble("p.quantity");
                String color = resultSet.getString("p.color");
                String description = resultSet.getString("p.description");
                String category_name = resultSet.getString("c.name");
                ProductView productview = new ProductView(id, name, price, quantity, color, description, category_name);
                productsViews.add(productview);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsViews;
    }
}
