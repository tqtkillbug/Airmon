package com.tqt.airmon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "air_project")
@Data
public class AirProject {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String note;
    private String status;
    @Column(name = "link_source")
    private String linkSource;

    @OneToOne
    private Source source;

}
