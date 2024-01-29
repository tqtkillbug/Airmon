package com.tqt.airmon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sources")
@Data
public class Source {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String link;
}
