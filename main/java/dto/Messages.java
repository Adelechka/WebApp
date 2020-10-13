package dto;

import lombok.Data;

@Data
public class Messages {
    private int id;
    private String text;
    private String title;
    private Student student;
}
