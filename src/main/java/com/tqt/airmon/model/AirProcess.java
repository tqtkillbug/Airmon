package com.tqt.airmon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "air_process")
@Data
public class AirProcess {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JsonIgnore
    private Address address;

    private String info;
    private String status;

    @ManyToOne
    @JoinColumn(name = "air_project_id")
    @JsonIgnore
    private AirProject airProject;
}
