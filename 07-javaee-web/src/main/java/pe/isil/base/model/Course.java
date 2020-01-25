package pe.isil.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Course {

    private Integer id;
    private String name;
    private Integer teacherId;
}
