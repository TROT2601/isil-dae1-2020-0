package pe.isil.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Enrollment {

    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private LocalDate createdDate;
    private Integer credit;
}
