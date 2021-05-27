package cpt202.bughunter.eflea.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin {
    private String username;
    private Long staffNumber;
    private String adminMail;
    private String password;

}
