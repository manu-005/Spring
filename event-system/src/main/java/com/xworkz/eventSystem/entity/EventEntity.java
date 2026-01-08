package com.xworkz.eventSystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
@NamedQuery(name = "getByEventName",query = "select getEvent from EventEntity getEvent where getEvent.eventName=:name"),
@NamedQuery(name = "getByManager",query = "select getByManager from EventEntity getByManager where getByManager.manager=:man"),
@NamedQuery(name = "getManagerANdLocByEventName",query = "select entity.manager,entity.location from EventEntity entity where entity.eventName=:name"),
@NamedQuery(name = "getAll",query = "from EventEntity"),
@NamedQuery(name = "getLocationByTime",query = "select entity.location from EventEntity entity where entity.time=:t"),
@NamedQuery(name = "getEventByManager",query = "select entity.eventName from EventEntity entity where entity.manager=:manager"),
@NamedQuery(name = "editManagerBYEventNameAndTime",query = "update EventEntity event set event.manager=:man where event.eventName=:name and event.time=:time"),
@NamedQuery(name = "editTimeByEventName",query = "update EventEntity event set event.time=:time where event.eventName=:name"),
@NamedQuery(name = "deleteEventById",query = "delete EventEntity event where event.id=:id"),
@NamedQuery(name = "deleteEventByEventName",query = "delete EventEntity event where event.eventName=:eventName")})
public class EventEntity {

    @Id
    private  int id;
    private String eventName;
    private String location;
    private String time;
    private String manager;


}
