package cpt202.bughunter.eflea.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String dateOfBirth;
    private Boolean sex;

    public User(String username, String password, String dateOfBirth,Boolean sex) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

}
