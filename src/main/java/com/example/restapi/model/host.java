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
@Table(name = "hosts")
public class host {

    /*
     * L’attribut id correspond à la clé primaire de la table, et est donc
     * annoté @Id. D’autre part, comme l’id est auto-incrémenté, j’ai ajouté
     * l’annotation @GeneratedValue(strategy = GenerationType.IDENTITY).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * @Column pour faire le lien avec le nom du champ de la table.
     */
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "picture")
    private String picture;
}
