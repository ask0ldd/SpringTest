package com.example.restapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
/*
 * @Data est une annotation Lombok. Nul besoin d’ajouter les getters et les
 * setters. La librairie Lombok s’en charge pour nous. Très utile pour alléger
 * le code.
 */
@Entity
/*
 * @Entity est une annotation qui indique que la classe correspond à une table
 * de la base de données.
 */
@Table(name = "admins")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
