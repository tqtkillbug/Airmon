package com.tqt.airmon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "air_process")
@Data
public class AirProcess {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Address address;
    @OneToOne
    private AirProject airProject;
    private String info;
    private String status;
}
