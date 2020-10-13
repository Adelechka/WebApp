package dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int course = 1;
    private Timestamp createDateTime;
    private String password;
}
