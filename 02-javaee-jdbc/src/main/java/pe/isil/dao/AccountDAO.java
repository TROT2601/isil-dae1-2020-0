package pe.isil.dao;

import pe.isil.util.DataBaseUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class AccountDAO {

    public static boolean transfer( Integer idFrom, Integer idTo, Double amount){

        try(Connection conn = DataBaseUtil.getConnection()) {
            String SQL = "{ ? = call transfer(?,?,?) }";
            try (CallableStatement cs = conn.prepareCall(SQL)) {
                cs.registerOutParameter(1, Types.BOOLEAN);
                cs.setInt(2, idFrom);
                cs.setInt(3, idTo);
                cs.setDouble(4, amount);
                cs.execute();
                return cs.getBoolean(1);
            }
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

}
