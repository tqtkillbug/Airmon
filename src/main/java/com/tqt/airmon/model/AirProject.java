package com.tqt.airmon.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "air_project")
@Data
public class AirProject {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @Column(columnDefinition = "LONGTEXT")
    private String note;
    private String status;
    @Column(name = "link_source")
    private String linkSource;
    @ManyToOne
    private Source source;
    @OneToMany(mappedBy = "airProject", cascade = CascadeType.ALL)
    private List<AirProcess> process = new ArrayList<>();

    private String sourceName;
    private String sourceLink;
    private String sourceChanelLink;

}
