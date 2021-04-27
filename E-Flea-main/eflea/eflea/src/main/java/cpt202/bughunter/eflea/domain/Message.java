package cpt202.bughunter.eflea.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class Message {
    private Long messageId;
    private String sender;
    private String receiver;
    private String content;
    private Date sendTime;
}
