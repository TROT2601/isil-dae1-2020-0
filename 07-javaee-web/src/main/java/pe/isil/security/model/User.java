package pe.isil.security.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {

    private Integer id;
    private String login;
    private String password;
    private String name;
    private boolean isActive;
    private LocalDate expirationDate;

}
