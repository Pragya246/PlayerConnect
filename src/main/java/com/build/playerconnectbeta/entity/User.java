package com.build.playerconnectbeta.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity

@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeq")
    @SequenceGenerator(name = "UserSeq", allocationSize = 1)
    private int id;

    private String name;
    private String password;
    private String email;

    @ElementCollection
    private List<String> games;
    private String phone;
    private String address;
}
