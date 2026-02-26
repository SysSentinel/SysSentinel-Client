package com.bolota.SysSentinelClient.DTOs;

import com.bolota.SysSentinelClient.Entities.SystemEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class SystemDTO {
    private String UUID;
    private String name;
    private String os;
    private String host;
    private String cpu;
    private List<String> gpu;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "0.00")
    private double memRamMax;
    public SystemDTO(SystemEntity se){
        this.name = se.getName();
        this.os = se.getOs();
        this.host = se.getHost();
        this.cpu = se.getCpu();
        this.gpu = se.getGpu();
        this.memRamMax = se.getMemRamMax();
    }
}
