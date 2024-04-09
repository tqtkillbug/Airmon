package com.tqt.airmon.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
public class Remind {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "air_project_id")
    private AirProject airProject;
    private int type; //0: one time; 1 repeat
    private Date date;
    private String title;
    @Column(name = "repeat_type")
    private String repeatType; // 1_DAY
    private int hour;
    private int min;

}
