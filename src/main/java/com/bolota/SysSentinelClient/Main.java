package com.bolota.SysSentinelClient;
import java.io.*;
import java.math.BigDecimal;

import com.bolota.SysSentinelClient.Entities.SystemEntity;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

import static com.bolota.SysSentinelClient.Controller.SysSentinelClientController.*;
import static com.bolota.SysSentinelClient.Security.SysSentinelClientSecurity.*;
import static com.bolota.SysSentinelClient.Service.SysSentinelClientService.*;

public class Main {
    static public boolean debug = false;
    public static void main(String[] args) throws IOException{
        if(!debug){
            File cache = new File("sysSentinel.config");
            String urlAndPort = "192.168.0.12:8080";
            String fileString = "";
            if (!cache.createNewFile()) {
                assertAuthToken();
                fileExists(cache);
            } else {
                assertAuthToken();
                fileNotExists(cache);
            }
            System.out.println(getUUID());
            runClient(urlAndPort);
        }
        else {
            SystemInfo si = new SystemInfo();
            GlobalMemory memory = si.getHardware().getMemory();

            long total = memory.getTotal();
            long available = memory.getAvailable();

            long used = total - available;
            System.out.println(si.getHardware().getNetworkIFs());
            System.out.println(used/Math.pow(1024,3));
        }
    }
}
