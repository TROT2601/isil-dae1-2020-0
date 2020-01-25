package pe.isil.base.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {

    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthDate;

}
