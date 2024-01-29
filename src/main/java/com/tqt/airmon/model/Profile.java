package com.tqt.airmon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "profiles")
@Data
public class Profile {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String backup;
    private String description;
    @OneToMany
    private List<Address> addressList;

}