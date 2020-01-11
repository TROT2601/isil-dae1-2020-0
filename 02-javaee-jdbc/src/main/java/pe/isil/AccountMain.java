package pe.isil;

import pe.isil.dao.AccountDAO;

public class AccountMain {

    public static void main(String[] args) {

        boolean transfer = AccountDAO.transfer(1, 2, 150.0);
        System.out.println("transferSuccess = " + transfer);

    }

}
