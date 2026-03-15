package com.fightbooking.service;

import com.fightbooking.model.Event;
import com.fightbooking.model.Zone;

import java.util.ArrayList;
import java.util.List;

public class EventService {

    private List<Event> events = new ArrayList<>();
    private List<Zone> zones = new ArrayList<>();

    public EventService(){

        zones.add(new Zone("A1",20,20,1000,1200));
        zones.add(new Zone("A2",20,20,1000,1200));
        zones.add(new Zone("A3",20,20,1000,1200));
        zones.add(new Zone("A4",20,20,1000,1200));

        zones.add(new Zone("B1",40,40,800,1000));
        zones.add(new Zone("B2",40,40,800,1000));
        zones.add(new Zone("B3",40,40,800,1000));
        zones.add(new Zone("B4",40,40,800,1000));

        zones.add(new Zone("C1",50,50,500,850));
        zones.add(new Zone("C2",50,50,500,850));
        zones.add(new Zone("C3",50,50,500,850));
        zones.add(new Zone("C4",50,50,500,850));
    }

    public List<Zone> getZones(){
        return zones;
    }

    public Zone getZoneByName(String name){

        for(Zone z : zones){

            if(z.getZoneName().equals(name)){
                return z;
            }

        }

        return null;
    }
}