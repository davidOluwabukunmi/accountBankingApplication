package com.example.accountApplication.Model;

import org.hibernate.annotations.Columns;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles implements GrantedAuthority {

}


