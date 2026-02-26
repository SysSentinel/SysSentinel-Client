package com.bolota.SysSentinelClient.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class SystemVolatileInfoEntity {



    private HashMap<String, Double> internetCurrentUsage;
    private HashMap<String, String> internetAdapters;
    private ArrayList<ProcessEntity> processes;
    public SystemVolatileInfoEntity(SystemEntity se){
        try {
            this.internetAdapters = se.getInternetAdapters();
            this.processes = se.getProcesses();
            this.internetCurrentUsage = se.getInternetCurrentUsage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateVolatileInfo(SystemEntity se){
        try{
            this.internetCurrentUsage = se.getInternetCurrentUsage();
            this.internetAdapters = se.getInternetAdapters();
            this.processes = se.getProcesses();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
