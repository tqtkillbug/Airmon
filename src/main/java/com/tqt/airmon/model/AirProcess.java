package com.tqt.airmon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tqt.airmon.model.dto.AirProcessDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "air_process")
@Data
public class AirProcess {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Address address;
    @Column(columnDefinition = "LONGTEXT")
    private String info;
    private String status;

    @ManyToOne
    @JoinColumn(name = "air_project_id")
    @JsonIgnore
    private AirProject airProject;

    public static AirProcess fromDTO(AirProcessDTO dto){
        AirProcess process = new AirProcess();
        process.setInfo(dto.getInfo());
        process.setStatus(dto.getStatus());
        process.setAddress(dto.getAddress());
        process.setAirProject(dto.getAirProject());
        return process;
    }
}
