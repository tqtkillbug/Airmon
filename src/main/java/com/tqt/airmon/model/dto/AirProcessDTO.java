package com.tqt.airmon.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tqt.airmon.model.Address;
import com.tqt.airmon.model.AirProject;
import lombok.Data;

@Data
public class AirProcessDTO {
    private Address address;
    private String info;
    private String status;
    private AirProject airProject;


}


