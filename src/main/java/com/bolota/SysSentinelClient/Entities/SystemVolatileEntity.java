package com.bolota.SysSentinelClient.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class SystemVolatileEntity {
    private String UUID;
    private HashMap<String, Double> internetCurrentUsage;
    private HashMap<String, String> internetAdapters;
    private ArrayList<SystemProcessEntity> systemProcessEntities;
    public SystemVolatileEntity(SystemEntity se){
        try {
            this.internetAdapters = se.getInternetAdapters();
            this.systemProcessEntities = se.getProcesses();
            this.internetCurrentUsage = se.getInternetCurrentUsage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateVolatileInfo(SystemEntity se){
        try{
            this.internetCurrentUsage = se.getInternetCurrentUsage();
            this.internetAdapters = se.getInternetAdapters();
            this.systemProcessEntities = se.getProcesses();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
