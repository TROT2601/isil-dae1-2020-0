package pe.isil.security.service;

import pe.isil.security.dao.UserDao;
import pe.isil.security.model.User;

import java.time.LocalDate;

public class UserService {

    UserDao userDao = new UserDao();

    public void userValidation(User user) {

        userDao.loadUserByLoginAndPassword(user);

        if(user.getId() == null){
            throw new RuntimeException("user or password invalid");
        }else{

            if( !user.isActive()){
                throw new RuntimeException("Your account is inactive");
            }
            if(LocalDate.now().isAfter(user.getExpirationDate())){
                throw new RuntimeException("Your account is expired");
            }

        }

    }
}
