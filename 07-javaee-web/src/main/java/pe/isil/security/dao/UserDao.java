package pe.isil.security.dao;

import pe.isil.security.model.User;
import pe.isil.uti.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void loadUserByLoginAndPassword(User user) {

        try (Connection connection = DataBaseHelper.getConnection()) {
            String SQL = "SELECT id, login, password, name, is_active, expiration_date FROM tbl_dae1_users WHERE login = ? AND password = ?";
            try(PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPassword());
                try(ResultSet rs = ps.executeQuery()) {
                    if(rs.next()){
                        user.setId(rs.getInt(1));
                        user.setName(rs.getString(4));
                        user.setActive(rs.getBoolean(5));
                        user.setExpirationDate(rs.getDate(6).toLocalDate());
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
