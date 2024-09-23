package com.zoch.recipe_sharing.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
public class user {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String password;
    private String email;
    private String fullName;

}
