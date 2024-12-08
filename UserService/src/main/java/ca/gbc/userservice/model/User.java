package ca.gbc.userservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "app_user") // Use a different table name
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String userType;
}
