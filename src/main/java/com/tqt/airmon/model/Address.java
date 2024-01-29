package com.tqt.airmon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Profile profile;
    @Column(name = "public_key")
    private String publicKey;
    @Column(name = "private_key")
    private String privateKey;
    @Column(name = "account_name")
    private String accountName;
    private String type;


}
