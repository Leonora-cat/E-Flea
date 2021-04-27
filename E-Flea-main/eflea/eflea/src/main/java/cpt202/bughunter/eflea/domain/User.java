package cpt202.bughunter.eflea.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class User {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String major;
    private Date dateOfBirth;
    private Boolean sex;

    public User(String username, String password, String email, String major, Date dateOfBirth, Boolean sex) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.major = major;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

}
