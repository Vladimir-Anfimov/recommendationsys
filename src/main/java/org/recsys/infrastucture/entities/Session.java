package org.recsys.infrastucture.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.*;
import java.util.UUID;

@Data
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String token;


    private Date createdAt;

    @ManyToOne
    private User user;

    public Session() {
    }

    public Session(User user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
    }

}
