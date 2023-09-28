package com.example.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "u_users")
public class User {
    @Id
    private String username;
    private String phoneNumber;
    private String homeAddress;
    @JsonIgnore
    private String password;
}