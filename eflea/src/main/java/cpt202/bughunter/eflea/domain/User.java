package cpt202.bughunter.eflea.domain;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private Date dateOfBirth;
    private Boolean sex;

    public User(String username, String password, Date dateOfBirth, Boolean sex) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

}
