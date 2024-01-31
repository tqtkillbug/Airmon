package com.tqt.airmon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tqt.airmon.model.dto.AirProcessDTO;
import jakarta.persistence.Column;
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
