package com.example.restapi.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
/* spring security needs some UserDetails methods to be implemented */
public class User /* implements UserDetails */ {

    @Id
    /* GeneratedValue / Identity : autoincrement a number when id is missing */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // !!! why default constructor needed?
    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.password = password;
    }

    /*
     * @Override
     * public Collection<? extends GrantedAuthority> getAuthorities() {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'getAuthorities'");
     * }
     * 
     * @Override
     * public String getUsername() {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'getUsername'");
     * }
     * 
     * @Override
     * public boolean isAccountNonExpired() {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
     * }
     * 
     * @Override
     * public boolean isAccountNonLocked() {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
     * }
     * 
     * @Override
     * public boolean isCredentialsNonExpired() {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'"
     * );
     * }
     * 
     * @Override
     * public boolean isEnabled() {
     * // TODO Auto-generated method stub
     * throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
     * }
     */

    /* spring security needs those UserDetails methods to be implemented */

}
