package pe.isil.dao;

import pe.isil.model.Product;
import pe.isil.util.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {


    public static List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "SELECT * FROM tbl_products";
            try (Statement statement = conn.createStatement()){
                ResultSet resultSet = statement.executeQuery(SQL);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String category = resultSet.getString("category");
                    Double price = resultSet.getDouble("price");

                    Product product = new Product(id, name, category, price);
                    products.add(product);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public static void create(Product product) {
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "INSERT INTO tbl_products(name, category, price) VALUES (?,?,?)";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setString(1, product.getName());
                statement.setString(2, product.getCategory());
                statement.setDouble(3, product.getPrice());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(Product product) {
        try (Connection conn = DataBaseHelper.getConnection()) {
            final String SQL = "DELETE FROM tbl_products  WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(SQL)){
                statement.setInt(1, product.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
