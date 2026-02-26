package com.bolota.SysSentinelClient.Entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProcessEntity {
    private String  name;
    private int     pid;
    private double  residentMem; // em MBs
    private double  virtualMem;  // em GBs
    private double  cpuLoad;
}
