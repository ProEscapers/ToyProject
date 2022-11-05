package asd.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
}
