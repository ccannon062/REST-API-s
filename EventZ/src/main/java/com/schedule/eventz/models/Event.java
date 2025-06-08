package com.schedule.eventz.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.*;

@Entity
@Table(name = "events")
@Access(AccessType.FIELD)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @Size(min = 0, max = 500)
    private String description;

    @Future
    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    @NotEmpty
    private String location;

    @PositiveOrZero
    private Long maxAttendees;

    private LocalDateTime createdAt;

    public Event() {}

    public Event(Long id, String name, String description, LocalDateTime startTime,
                 LocalDateTime endTime, String location, Long maxAttendees, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.maxAttendees = maxAttendees;
        this.createdAt = createdAt;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(Long maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}