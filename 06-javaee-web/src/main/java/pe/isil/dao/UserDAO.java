package pe.isil.dao;

import pe.isil.model.User;
import pe.isil.util.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {


    public static User isValidLogin(String txtLogin, String txtPassword) {
        try (Connection connection = DataBaseHelper.getConnection()) {
            String SQL = "SELECT * FROM tbl_users WHERE login=? AND password=?";
            try (PreparedStatement ps = connection.prepareStatement(SQL) ) {
                ps.setString(1, txtLogin);
                ps.setString(2, txtPassword);

                try (ResultSet rs = ps.executeQuery() ) {
                    if(rs.next()){

                        User user = new User(rs.getInt("id"),
                                                rs.getString("login"),
                                                rs.getString("password"));
                        return user;
                    }else{
                        return null;
                    }

                }

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
