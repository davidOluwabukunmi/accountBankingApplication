package com.example.accountApplication.Model;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_junction",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )

    private Set<Roles> authorities;

    public Users {
        super();
        authorities = new HashSet<>();
    }

    public Users (Integer userId, String username, String password, Set<Roles> authorities){
        super();
        this.user_id =userId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }


}
